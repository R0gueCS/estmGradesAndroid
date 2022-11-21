package src.estm_news

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {

    var PREFS_KEY = "prefs"
    var CNE_KEY = "cne"
    var PWD_KEY = "pwd"

    lateinit var cne : String
    lateinit var pwd : String
    lateinit var sharedPreferences : SharedPreferences


    companion object{
        lateinit var etudiantCourant : Etudiant
        lateinit var pass : String
    }
    var personnel = Personnel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnConnect.setOnClickListener {
            if (password.text.toString().isNotEmpty() && login.text.toString().isNotEmpty()) {
                pass = personnel.getPasswordByCne(login.text.toString()).toString()
                etudiantCourant = personnel.getEtudiant(login.text.toString())!!
                if (login.text.toString().equals(etudiantCourant.cne) && password.text.toString().equals(etudiantCourant.password)) {

                    sharedPreferences = getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)

                    val editor: SharedPreferences.Editor = sharedPreferences.edit()

                    editor.putString(CNE_KEY, login.text.toString())
                    editor.putString(PWD_KEY, password.text.toString())

                    editor.apply()

                    val view = Intent(this, ItemDetailHostActivity::class.java)
                    startActivity(Intent(view))
                    finish()
                }else{
                    Toast.makeText(this, "CNE ou mot de passe incorrect !!", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "Veuilliez remplir les champs !!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    override fun onStart() {
        super.onStart()
    }

    private fun isAnAlpha(char: Char): Boolean {
        return char in 'a'..'z' || char in 'A'..'Z'
    }
}