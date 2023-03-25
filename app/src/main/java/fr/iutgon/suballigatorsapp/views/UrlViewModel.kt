package fr.iutgon.suballigatorsapp.views

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.iutgon.suballigatorsapp.repositories.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UrlViewModel : ViewModel() {
    fun execURL(url: String, m: MutableState<String>) {
        val logi = LoginRepository()

        viewModelScope.launch(Dispatchers.IO) {
            m.value = logi.makeRequest(url)
        }
    }
}