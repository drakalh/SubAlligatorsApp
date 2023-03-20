package fr.iutgon.suballigatorsapp

import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.getSystemService
import fr.iutgon.suballigatorsapp.ui.theme.SuballigatorsappTheme
import java.io.OutputStream
import java.net.URL

class MainPageActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
        val network = mgr?.activeNetwork

        val conn = network!!.openConnection(URL("http://dev-restandroid.users.info.unicaen.fr/REST/aptitude/"))
        conn.setRequestProperty("Content-Type", "application/json")

        val flow = conn.getInputStream();

        Text(text = "Test")
        Text(text = flow.toString())
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