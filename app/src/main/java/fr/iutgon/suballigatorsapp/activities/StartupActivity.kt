package fr.iutgon.suballigatorsapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.iutgon.suballigatorsapp.R
import fr.iutgon.suballigatorsapp.data.AppBDD
import fr.iutgon.suballigatorsapp.data.LoggedInUser
import fr.iutgon.suballigatorsapp.views.DataLoaderViewModel

class StartupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bdd = AppBDD.getInstance(applicationContext)

        supportActionBar?.hide()
        setContentView(R.layout.activity_startup)

        DataLoaderViewModel(bdd).loadData("aptitude").observe(this) {
            if (it.isNotEmpty()) {
                if (!LoggedInUser.getInstance().set) {
                    startActivity(Intent(this, LoginActivity::class.java))
                } else {
                    startActivity(Intent(this, MainActivity::class.java))
                }
            } else {
                println("Error while loading data")
            }
        }
    }
}