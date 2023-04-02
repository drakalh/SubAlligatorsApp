package fr.iutgon.suballigatorsapp.views

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.iutgon.suballigatorsapp.data.AppBDD
import fr.iutgon.suballigatorsapp.data.LoggedInUser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.io.*
import java.lang.System.err
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

    fun loadData(appContext: Context): MutableLiveData<Boolean> {
        val data = MutableLiveData<Boolean>()

        viewModelScope.launch(Dispatchers.IO) {
            for (dataName in AppBDD.getEntities()) {
                val dataURL = "$baseURL/$dataName/"
                val json = getJSONFromURL(dataURL)

                if (json != null) {
                    val array = JSONArray(json)
                    bdd.setDataFromJSON(dataName, array)
                } else {
                    println("no data")
                }

                println("Chargement $dataName")
            }

            data.postValue(true)
        }

        return data
    }

    fun modifyProfile(id: Int, dataName: String, dataContent: String): MutableLiveData<Boolean> {
        val data = MutableLiveData<Boolean>()

        viewModelScope.launch(Dispatchers.IO) {
            val urlObj = URL("$baseURL/initiator/")

            try {
                val urlConnection = urlObj.openConnection() as? HttpURLConnection

                val jsonObj = JSONObject()
                jsonObj.put("id", id)
                jsonObj.put(dataName, dataContent)

                if (urlConnection != null) {
                    urlConnection.requestMethod = "PUT";
                    val out = BufferedOutputStream(urlConnection.outputStream);
                    val writer = BufferedWriter(OutputStreamWriter(out, "UTF-8"))

                    writer.write(jsonObj.toString())
                    writer.flush()
                    writer.close()
                    out.close()

                    urlConnection.connect()

                    if (urlConnection.responseCode == 200) {
                        data.postValue(true)
                    } else {
                        data.postValue(false)
                    }
                }
            } catch (e: Exception) {
                err.println(e)
            }
        }

        return data
    }

    fun login(email: String, password: String): MutableLiveData<Boolean> {
        val data = MutableLiveData<Boolean>()

        viewModelScope.launch(Dispatchers.IO) {
            var t = false

            val initiator = bdd.initiatorDAO().getByEmailAndPassword(email, password)

            if (initiator.email == email && initiator.password == password) {
                val user = LoggedInUser.getInstance()
                user.initiator = initiator
                t = true
            }

            if (!t) {
                data.postValue(false)
            } else {
                data.postValue(true)
            }
        }

        return data
    }
}