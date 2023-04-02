package fr.iutgon.suballigatorsapp.activities

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import fr.iutgon.suballigatorsapp.data.LoggedInUser

class ProfileActivity : ComponentActivity() {
    companion object {
        lateinit var modify: MutableState<Boolean>
        lateinit var values: MutableList<String>
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val user = LoggedInUser.getInstance()!!
            modify = remember { mutableStateOf(false) }
            values = remember { mutableListOf(user.initiator.name, user.initiator.email, "", "") }

            Column() {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text("Mon profil", color = Color.White) },
                            backgroundColor = Color.Black,
                            navigationIcon = {
                                IconButton(onClick = {
                                    finish()
                                }) {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = "Back",
                                        tint = Color.White
                                    )
                                }
                                IconButton(onClick = {
                                    if (!modify.value) {
                                        modify.value = true
                                    }
                                }) {
                                    Icon(
                                        imageVector = Icons.Filled.Edit,
                                        contentDescription = "Modifier",
                                        tint = Color.White
                                    )
                                }
                            })
                    },
                    backgroundColor = Color.Transparent
                ) {
                    Page()
                }
            }

        }
    }

    @Composable
    fun Page() {
        Column() {
            Text("Nom : ", color = Color.White)
            TextField(value = values[0], onValueChange = { values[0] = it }, enabled = modify.value)

            Text("Email : ", color = Color.White)
            TextField(value = values[1], onValueChange = { values[1] = it }, enabled = modify.value)

            Text("Mot de passe : ", color = Color.White)
            TextField(value = values[2], onValueChange = { values[2] = it }, enabled = modify.value)

            Text("Mot de passe (2e fois) : ", color = Color.White)
            TextField(value = values[3], onValueChange = { values[3] = it }, enabled = modify.value)

            Button(onClick = { modifyProfile() }, enabled = modify.value) {
                Text(text = "Modifier")
            }
        }
    }

    private fun modifyProfile() {
        if (values[2] == values[3]) {

        } else {
            Toast.makeText(applicationContext, "Les mots de passe ne correspondent pas.", Toast.LENGTH_SHORT).show()
        }
    }
}