package fr.iutgon.suballigatorsapp.views

import androidx.lifecycle.*
import fr.iutgon.suballigatorsapp.data.AppBDD
import fr.iutgon.suballigatorsapp.data.LoggedInUser
import fr.iutgon.suballigatorsapp.data.entities.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class DataLoaderViewModel(private val bdd: AppBDD) : ViewModel() {
    companion object {
        const val baseURL = "https://dev-restandroid.users.info.unicaen.fr/REST"

        fun getJSONFromURL(url: String): String? {
            val urlObj = URL(url)
            val urlConnection = urlObj.openConnection() as? HttpURLConnection

            if (urlConnection != null) {

                urlConnection.connect()

                if (urlConnection.responseCode == 200) {
                    val reader = BufferedReader(InputStreamReader(urlConnection.inputStream))
                    var line: String? = reader.readLine()

                    val sb = java.lang.StringBuilder()

                    while (line != null) {
                        sb.append(line)
                        line = reader.readLine()
                    }

                    return sb.toString()
                }
            }

            return null
        }
    }

    fun loadData(dataName: String): MutableLiveData<List<JSONObject>> {
        val data = MutableLiveData<List<JSONObject>>()

        viewModelScope.launch(Dispatchers.IO) {
            val dataURL = "$baseURL/$dataName/"
            val json = getJSONFromURL(dataURL)
            val list = ArrayList<JSONObject>()

            if (json != null) {
                val array = JSONArray(json)

                for (i in 0 until array.length()) {
                    list.add(array.getJSONObject(i))
                }
            } else {
                println("no data")
            }

            data.postValue(list)
        }

        return data
    }

    fun login(email: String, password: String, owner: LifecycleOwner): MutableLiveData<Boolean> {
        val data = MutableLiveData<Boolean>()

        viewModelScope.launch {
            loadData("initiator").observe(owner) {
                var t = false

                for (i in it) {
                    val initiator = Initiator.getInitiatorFromJSON(i)
                    if (initiator != null) {
                        if (initiator.email == email && initiator.password == password) {
                            val user = LoggedInUser.getInstance()
                            user.initiator = initiator
                            user.set = true
                            t = true
                        }
                    }
                }

                if (!t) {
                    data.postValue(false)
                } else {
                    data.postValue(true)
                }
            }
        }

        return data
    }
}