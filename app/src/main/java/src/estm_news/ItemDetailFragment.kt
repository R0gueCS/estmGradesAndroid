package src.estm_news

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import src.estm_news.databinding.FragmentItemDetailBinding
import src.estm_news.placeholder.ModuleData

class ItemDetailFragment : Fragment() {

    lateinit var sharedPreferences : SharedPreferences

    var PREFS_KEY = "prefs"
    var CNE_KEY = "cne"
    var PWD_KEY = "pwd"
    lateinit var cne : String
    lateinit var password : String

    private var item: ModuleData.Module? = null
    lateinit var personnel : Personnel
    lateinit var nom_module: TextView
    lateinit var duree_module: TextView
    lateinit var desc_module: TextView
    lateinit var prof: TextView
    lateinit var note_cours: TextView
    lateinit var note_tp: TextView

    private var toolbarLayout: CollapsingToolbarLayout? = null
    private var _binding: FragmentItemDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val ARG_ITEM_ID = "item_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        personnel = Personnel()
        sharedPreferences = activity?.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)!!

        cne = sharedPreferences.getString(CNE_KEY, null)!!
        password = sharedPreferences.getString(PWD_KEY, null)!!


        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                item = personnel.getEtudiant(cne,password)!!.moduleList_map[it.getString(ARG_ITEM_ID)]
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        val rootView = binding.root
        toolbarLayout = binding.toolbarLayout
        nom_module = binding.nomModule!!
        desc_module = binding.descModule!!
        duree_module = binding.valeurDuree!!
        prof = binding.valeurProf!!
        note_cours = binding.noteCours!!
        note_tp = binding.noteTp!!

        updateContent()
        return rootView
    }

    private fun updateContent() {
        try {
            toolbarLayout?.title = item?.nom_module
            item?.let {
                nom_module.text = item!!.nom_module
                desc_module.text = item!!.description
                duree_module.text = item!!.duree.toString()+" semaines"
                prof.text = item!!.prof
                note_cours.text = item!!.note_cours.toString()
                note_tp.text = item!!.note_tp.toString()
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}