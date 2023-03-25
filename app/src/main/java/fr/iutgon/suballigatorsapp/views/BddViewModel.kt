package fr.iutgon.suballigatorsapp.views

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.iutgon.suballigatorsapp.MainPageActivity
import fr.iutgon.suballigatorsapp.data.AppBDD
import fr.iutgon.suballigatorsapp.data.entities.Aptitude
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BddViewModel(private val bdd: AppBDD) : ViewModel() {
    fun getAptitudes(ms: MutableList<Aptitude>) {
        viewModelScope.launch(Dispatchers.IO) {
            ms.addAll(bdd.aptitudeDAO().getAll())
        }
    }
}