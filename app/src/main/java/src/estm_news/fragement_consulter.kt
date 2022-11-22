package src.estm_news

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin.*
import kotlinx.android.synthetic.main.activity_admin.consulter
import kotlinx.android.synthetic.main.fragment_fragement_consulter.*
import kotlinx.android.synthetic.main.fragment_fragement_modifier.*
import kotlinx.android.synthetic.main.fragment_fragement_modifier.cne

class fragement_consulter : Fragment() {
    var PREFS_KEY = "prefs"
    var CNE_KEY = "cne"

    lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragement_consulter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        consulter.setOnClickListener {
            if (cne.text.toString().isNotEmpty()){
                sharedPreferences = this.requireActivity().getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)

                val editor: SharedPreferences.Editor = sharedPreferences.edit()

                editor.putString(CNE_KEY, cne.text.toString())

                editor.apply()
                val view = Intent(this.activity, ItemDetailHostActivity::class.java)
                startActivity(Intent(view))
            }else{
                Toast.makeText(requireContext(), "Veuilliez remplir le champs cne!!", Toast.LENGTH_SHORT).show();

            }

        }
    }


}