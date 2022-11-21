package src.estm_news

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_admin.*

class activity_admin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val fragmentConsulter = fragement_consulter()
        val fragmentModifier = fragement_modifier()


        consulter.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fragmentConsulter)
                addToBackStack(null)
                commit()
            }
        }
        modifier.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fragmentModifier)
                addToBackStack(null)
                commit()
            }
        }
    }
}