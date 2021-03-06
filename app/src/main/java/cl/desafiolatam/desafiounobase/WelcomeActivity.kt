package cl.desafiolatam.desafiounobase

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.view.*

class WelcomeActivity : AppCompatActivity() {
    lateinit var nameUser: TextView
    lateinit var advance: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        nameUser = findViewById(R.id.welcome_name)
        advance = findViewById(R.id.advance_button)
        setUpViewsAndListener()
    }

    private fun setUpViewsAndListener() {
        var userName = " " // obtener el nombre de usuario de alguna manera y mostrarlo en nameUser
        
        nameUser.text = userName
        advance.setOnClickListener {
            //Agregar los pasos necesarios para manejar la persistencia
            //de cuando un usuario ve la pantalla de bienvenida la primera vez
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
