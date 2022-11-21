package src.estm_news

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {
    companion object{
        lateinit var etudiantCourant : Etudiant
    }
    var personnel = Personnel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnConnect.setOnClickListener {
            if (password.text.toString().isNotEmpty() && login.text.toString().isNotEmpty()) {
                etudiantCourant = personnel.getEtudiant(login.text.toString(), password.text.toString())!!
                if (login.text.toString().equals(etudiantCourant.cne) && password.text.toString().equals(etudiantCourant.password)) {

                    val view = Intent(this, ItemDetailHostActivity::class.java)
                    startActivity(Intent(view))
                }else{
                    Toast.makeText(this, "CNE ou mot de passe incorrect !!", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "Veuilliez remplir les champs !!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private fun isAnAlpha(char: Char): Boolean {
        return char in 'a'..'z' || char in 'A'..'Z'
    }
}