package src.estm_news

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChoiceActivity : AppCompatActivity() {

    private lateinit var admin : Button
    private lateinit var etudiant : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choice)

        admin = findViewById<Button>(R.id.admin)

        admin.setOnClickListener {
            val view = Intent(this, LoginAdmin::class.java)
            startActivity(Intent(view))
        }

        etudiant = findViewById<Button>(R.id.etudiant)

        etudiant.setOnClickListener {
            val view = Intent(this, login::class.java)
            startActivity(Intent(view))
        }


    }
}