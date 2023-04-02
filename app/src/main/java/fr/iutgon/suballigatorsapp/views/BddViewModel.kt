package fr.iutgon.suballigatorsapp.views

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.iutgon.suballigatorsapp.data.AppBDD
import fr.iutgon.suballigatorsapp.data.entities.Aptitude
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BddViewModel(private val bdd: AppBDD) : ViewModel() {
    fun getAllAptitudes(): MutableLiveData<List<Aptitude>> {
        val data = MutableLiveData<List<Aptitude>>()

        viewModelScope.launch(Dispatchers.IO) {
            data.postValue(bdd.aptitudeDAO().getAll())
        }

        return data
    }
}