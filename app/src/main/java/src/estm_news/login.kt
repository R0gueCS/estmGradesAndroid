package src.estm_news

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnConnect.setOnClickListener {
            if (password.text.toString().isNotEmpty() && login.text.toString().isNotEmpty()) {
                if (login.text.length == 10 && isAnAlpha(login.text[0])) {
                    val view = Intent(this, ItemDetailHostActivity::class.java)
                    startActivity(Intent(view))
                } else {
                    Toast.makeText(this, "inputs empty", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private fun isAnAlpha(char: Char): Boolean {
        return char in 'a'..'z' || char in 'A'..'Z'
    }
}