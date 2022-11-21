package src.estm_news

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*


class LoginAdmin : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_admin)

        btnConnect.setOnClickListener {
            if (password.text.toString().isNotEmpty() && login.text.toString().isNotEmpty()) {

                if (login.text.toString().equals("admin") && password.text.toString().equals("admin")) {

                    val view = Intent(this, activity_admin::class.java)
                    startActivity(Intent(view))
                    finish()
                }else{
                    Toast.makeText(this, "Vous n'êtes pas administrateur !!", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "Veuilliez remplir les champs !!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}