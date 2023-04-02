package fr.iutgon.suballigatorsapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.MutableState
import fr.iutgon.suballigatorsapp.data.AppBDD

class FormationListActivity : ComponentActivity() {
    companion object {
        lateinit var bdd: MutableState<AppBDD>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}