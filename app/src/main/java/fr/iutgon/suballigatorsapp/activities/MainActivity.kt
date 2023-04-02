package fr.iutgon.suballigatorsapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import fr.iutgon.suballigatorsapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startProfileActivity(view: View) {
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    fun startFormationListActivity(view: View) {
        startActivity(Intent(this, FormationListActivity::class.java))
    }

    fun startFormationProgressActivity(view: View) {
        startActivity(Intent(this, FormationProgressActivity::class.java))
    }

    fun startSessionEvaluationActivity(view: View) {
        startActivity(Intent(this, SessionEvaluationActivity::class.java))
    }
}