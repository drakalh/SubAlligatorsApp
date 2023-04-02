package fr.iutgon.suballigatorsapp.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.tooling.preview.Preview
import fr.iutgon.suballigatorsapp.data.AppBDD
import fr.iutgon.suballigatorsapp.data.LoggedInUser

class FormationListActivity : ComponentActivity() {
    companion object {
        lateinit var bdd: MutableState<AppBDD>
        val user = LoggedInUser.getInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bdd = AppBDD.getInstance(this)
        setContent()
        {
            Page()
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Preview
    @Composable
    fun Page()
    {
        Column()
        {
            for(formation in user.initiator?.let { bdd.value.formationDAO().getByLevelId(it.id) }!!)
            {
                Row()
                {
                    Text(formation.name)
                    Text(formation.levelId.toString())
                    Button(onClick = { FormationProgressActivity(formation.id) }) {

                    }
                }
            }
        }
    }

}