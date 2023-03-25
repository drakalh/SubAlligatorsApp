package fr.iutgon.suballigatorsapp

import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
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
import androidx.core.content.ContextCompat.getSystemService
import fr.iutgon.suballigatorsapp.ui.theme.SuballigatorsappTheme
import fr.iutgon.suballigatorsapp.views.UrlViewModel
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.URL

class MainPageActivity : ComponentActivity() {
    companion object {
        lateinit var test: MutableState<String>
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            test = remember {
                mutableStateOf("No data")
            }

            SuballigatorsappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    @Composable
    fun Greeting() {
        val mgr = getSystemService(this.applicationContext, ConnectivityManager::class.java)

        Column {
            Text(test.value)

            if (mgr != null) {
                Text("MGR ok")
                val network = mgr.activeNetwork

                if (network != null) {
                    val urlViewModel = UrlViewModel()
                    urlViewModel.execURL("https://dev-restandroid.users.info.unicaen.fr/REST/aptitude/", test)
                } else {
                    Text("Pas de network.")
                }

                //

                //conn.setRequestProperty("Accept", "application/json")
                //conn.connect()

                // val flow = conn.getInputStream();
            } else {
                Text("Pas de connection.")
            }
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