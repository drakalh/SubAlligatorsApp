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
import androidx.compose.ui.text.TextStyle
import fr.iutgon.suballigatorsapp.data.AppBDD
import fr.iutgon.suballigatorsapp.data.LoggedInUser
import fr.iutgon.suballigatorsapp.views.DataLoaderViewModel

class ProfileActivity : ComponentActivity() {
    companion object {
        val user = LoggedInUser.getInstance()
        lateinit var modify: MutableState<Boolean>
        lateinit var name: MutableState<String>
        lateinit var email: MutableState<String>
        lateinit var password: MutableState<String>
        lateinit var password2: MutableState<String>
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val user = LoggedInUser.getInstance()

            modify = remember { mutableStateOf(false) }
            name = remember { mutableStateOf(user.initiator!!.name) }
            email = remember { mutableStateOf(user.initiator!!.email) }
            password = remember { mutableStateOf("") }
            password2 = remember { mutableStateOf("") }

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
            TextField(
                value = name.value,
                onValueChange = { value -> name.value = value },
                enabled = modify.value,
                textStyle = TextStyle(color = Color(0xffffffff))
            )

            Text("Email : ", color = Color.White)
            TextField(
                value = email.value,
                onValueChange = { value -> email.value = value },
                enabled = modify.value,
                textStyle = TextStyle(color = Color(0xffffffff))
            )

            Text("Mot de passe : ", color = Color.White)
            TextField(
                value = password.value,
                onValueChange = { value -> password.value = value },
                enabled = modify.value,
                textStyle = TextStyle(color = Color(0xffffffff))
            )

            Text("Mot de passe (2e fois) : ", color = Color.White)
            TextField(
                value = password2.value,
                onValueChange = { value -> password2.value = value },
                enabled = modify.value,
                textStyle = TextStyle(color = Color(0xffffffff))
            )

            Button(onClick = { modifyProfile() }, enabled = modify.value) {
                Text(text = "Modifier")
            }
        }
    }

    private fun modifyProfile() {
        if (password.value == password2.value && password.value.isNotEmpty()) {
            val viewModel = DataLoaderViewModel(AppBDD.getInstance(applicationContext))
            viewModel.modifyProfile(user.initiator!!.id, "email", email.value).observe(this) {
                if (it) {
                    Toast.makeText(
                        applicationContext,
                        "Email modifié.",
                        Toast.LENGTH_SHORT
                    ).show()

                    user.initiator!!.email = email.value
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Impossible de modifier l'email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            viewModel.modifyProfile(user.initiator!!.id, "name", name.value).observe(this) {
                if (it) {
                    Toast.makeText(
                        applicationContext,
                        "Nom modifié.",
                        Toast.LENGTH_SHORT
                    ).show()

                    user.initiator!!.name = name.value
                } else {
                    Toast.makeText(
                        applicationContext,
                        "Impossible de modifier l'nom.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        } else {
            Toast.makeText(
                applicationContext,
                "Les mots de passe ne correspondent pas.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}