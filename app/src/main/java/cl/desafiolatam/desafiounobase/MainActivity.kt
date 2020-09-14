package cl.desafiolatam.desafiounobase

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    lateinit var nameInput: TextInputEditText
    lateinit var advance: Button
    lateinit var container: ConstraintLayout
    //1.tener una variable
    lateinit var mSharedPreferences : SharedPreferences
    lateinit var mSetListString :MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameInput = findViewById(R.id.name_input)
        advance = findViewById(R.id.login_button)
        container = findViewById(R.id.container)
        setUpListeners()

        //2.tener una value para el nombre
        val mfileName =  "cl.desafiolatam.desafiounobase    "
        // 3.instanciar
        mSharedPreferences = getSharedPreferences(mfileName, Context.MODE_PRIVATE)
        mSetListString = mutableListOf()
        val setKey = "StringSet"
        mSharedPreferences.edit().putString(setKey, mSetListString.toString()).apply()

        setUpListeners()



    }

    private fun setUpListeners() {
        advance.setOnClickListener {
            if (nameInput.text!!.isNotEmpty()) {
                val intent: Intent
                if (hasSeenWelcome(nameInput.text.toString())) {
                    intent = Intent(this, HomeActivity::class.java)
                } else {

                    //  mSharedPreferences.edit().putString("user1",nameInput.text.toString()).apply() //aca deberia guardar lo que ingreso el usuario en el nameInput en mSharedPref
                    intent = Intent(this, WelcomeActivity::class.java)
                }
                startActivity(intent)
            } else {
                Snackbar.make(container, "El nombre no puede estar vacío", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun hasSeenWelcome(name: String): Boolean {
        var returnValue = false
        //var mUserRead = msharedPreferences.getString( ,"")
        if (mSetListString.contains(name)) {
            //implementar este método para saber si el usuario ya ha entrado a la aplicación y ha visto
            //la pantalla de bienvenida. Este método permite decidir que pantalla se muestra después de presionar Ingresar
            //recorra la lista de usuarios
            returnValue = true
        } else{

            mSetListString.add(name)
            // mSharedPreferences.edit().putStringSet("StringSet", mSetListString).apply()
            returnValue = false

        }

        return returnValue


    }


}
