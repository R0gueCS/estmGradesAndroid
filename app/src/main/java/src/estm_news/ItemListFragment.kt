package src.estm_news

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*
import src.estm_news.placeholder.ModuleData
import src.estm_news.databinding.FragmentItemListBinding
import src.estm_news.databinding.ItemListContentBinding
import src.estm_news.login

class ItemListFragment : Fragment() {

    private var _binding: FragmentItemListBinding? = null
    private var personnel : Personnel = Personnel()
    lateinit var loginTxt : String
    lateinit var passwordTxt : String
    lateinit var sharedPreferences : SharedPreferences

    var PREFS_KEY = "prefs"
    var CNE_KEY = "cne"
    var PWD_KEY = "pwd"

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = activity?.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)!!

        loginTxt = sharedPreferences.getString(CNE_KEY, null)!!
        passwordTxt = sharedPreferences.getString(PWD_KEY, null)!!

        val recyclerView: RecyclerView = binding.itemList
        val itemDetailFragmentContainer: View? = view.findViewById(R.id.item_detail_nav_container)
        recyclerView.adapter =
            ModulesAdapter(personnel.getEtudiant(loginTxt,passwordTxt)!!.modulesList, itemDetailFragmentContainer)
    }



    class ModulesAdapter(
        private val values: List<ModuleData.Module>,
        private val itemDetailFragmentContainer: View?
    ) :
        RecyclerView.Adapter<ModulesAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val binding =
                ItemListContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)

        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = values[position]
            holder.contentView.text = item.nom_module

            with(holder.itemView) {
                tag = item
                setOnClickListener { itemView ->
                    val item = itemView.tag as ModuleData.Module
                    val bundle = Bundle()
                    bundle.putString(ItemDetailFragment.ARG_ITEM_ID, item.id)

                    if (itemDetailFragmentContainer != null) {
                        itemDetailFragmentContainer.findNavController()
                            .navigate(R.id.fragment_item_detail, bundle)
                    } else {
                        itemView.findNavController().navigate(R.id.show_item_detail, bundle)
                    }
                }
            }
        }

        override fun getItemCount() = values.size

        inner class ViewHolder(binding: ItemListContentBinding) :
            RecyclerView.ViewHolder(binding.root) {
            val contentView: TextView = binding.content
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}