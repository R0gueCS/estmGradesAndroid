package src.estm_news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_item_list.*

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnConnect.setOnClickListener {
            if(login.text.length == 10 && isAnAlpha(login.text[0]) && !password.text.toString().equals("")){
                val view = Intent(this,ItemDetailHostActivity::class.java)
                startActivity(Intent(view))
            }else{
                Toast.makeText(this,"inputs empty", Toast.LENGTH_SHORT).show();
            }
        }
    }

    fun isAnAlpha(char:Char):Boolean{
        return char >= 'a' && char <= 'z' || char >= 'A' && char <= 'Z'
    }
}