package fr.iutgon.suballigatorsapp.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.iutgon.suballigatorsapp.R
import fr.iutgon.suballigatorsapp.data.AppBDD
import fr.iutgon.suballigatorsapp.views.DataLoaderViewModel


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun connect(view: View) {
        val emailAddress = findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
        val password = findViewById<EditText>(R.id.editTextTextPassword).text.toString()

        DataLoaderViewModel(AppBDD.getInstance(applicationContext)).login(emailAddress, password).observe(this) {
            if (it) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(applicationContext, "Inconnus", Toast.LENGTH_SHORT).show()
            }
        }
    }
}