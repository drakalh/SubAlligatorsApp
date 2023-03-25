package fr.iutgon.suballigatorsapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.iutgon.suballigatorsapp.data.AppBDD
import fr.iutgon.suballigatorsapp.data.entities.Aptitude
import fr.iutgon.suballigatorsapp.ui.theme.SuballigatorsappTheme
import fr.iutgon.suballigatorsapp.views.BddViewModel
import fr.iutgon.suballigatorsapp.views.DataLoaderViewModel

class MainPageActivity : ComponentActivity() {
    companion object {
        lateinit var bdd: MutableState<AppBDD>
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val t = AppBDD.getInstance(applicationContext)

        val dataView = DataLoaderViewModel(t)
        /*for (s in AppBDD.getTable()) {
            dataView.getDataFromTable(s)
        }*/

        dataView.getDataFromTable("aptitude")

        setContent {
            bdd = remember { mutableStateOf(t) }

            SuballigatorsappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }

    @Composable
    fun AptitudeTab() {
        val test = remember { mutableListOf<Aptitude>() }

        BddViewModel(bdd.value).getAptitudes(test)

        Column() {
            Row() {
                Text("id")
                Text("nom")
                Text("skillId")
                Text("deleted")
            }
        }

        for (aptitude in test) {
            Column() {
                Row() {
                    Text(aptitude.id.toString())
                    Text(aptitude.name)
                    Text(aptitude.skillId.toString())
                    Text(aptitude.deleted.toString())
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @Composable
    fun Greeting() {
        Column {
            AptitudeTab()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        SuballigatorsappTheme {
            Greeting()
        }
    }
}