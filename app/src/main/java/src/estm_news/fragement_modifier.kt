package src.estm_news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_admin.*
import kotlinx.android.synthetic.main.fragment_fragement_modifier.*
import kotlinx.android.synthetic.main.fragment_fragement_modifier.noteCours
import kotlinx.android.synthetic.main.fragment_fragement_modifier.noteTp

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class fragement_modifier : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragement_modifier, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lateinit var etudiant: Etudiant

        super.onViewCreated(view, savedInstanceState)
        confirmModification.setOnClickListener {
            var cne = cne.text.toString()
            var noteTp = noteTp.text.toString()
            var noteCours = noteCours.text.toString()
            var moduletxt = nom_module.text.toString()

            if (cne.isNotEmpty() && moduletxt.isNotEmpty() &&
                noteTp.isNotEmpty() && noteCours.isNotEmpty()
            ) {
                var personnel = Personnel()
                etudiant = personnel.getEtudiant(cne)!!
                if (etudiant != null) {
                    for (module in etudiant.modulesList) {
                        if (module.nom_module.equals(moduletxt)) {
                            module.note_tp = noteTp.toInt()
                            module.note_cours = noteCours.toInt()
                        }
                    }

                }else{
                    Toast.makeText(requireContext(), "il n'éxiste aucun étudiant avec ce cne", Toast.LENGTH_SHORT)
                        .show();
            }
            Toast.makeText(requireContext(), "Note modifiée avec succèes", Toast.LENGTH_SHORT)
                .show();
        }else{
            Toast.makeText(
                requireContext(),
                "Veuilliez remplir les champs demandés!!",
                Toast.LENGTH_SHORT
            ).show();
        }

    }
}

companion object {
    @JvmStatic
    fun newInstance(param1: String, param2: String) =
        fragement_modifier().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
}
}