package fr.iutgon.suballigatorsapp.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.iutgon.suballigatorsapp.data.AppBDD
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
        const val baseURL = "https://dev-restandroid.users.info.unicaen.fr/REST/"
        const val nullJSONString = "{\"id\":\"null\"}"
        val nullJSON = JSONObject(nullJSONString)
    }

    fun getDataFromTable(table: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val dataURL = "$baseURL$table/"
            val json = getJSONFromURL(dataURL)

            val jArray = JSONArray(json)
            for (i in 0 until jArray.length())
                bdd.insertDataFromJSON(table, jArray[i] as JSONObject)
        }
    }

    private fun getJSONFromURL(url: String): String {
        val urlObj = URL(url)
        val urlConnection = urlObj.openConnection() as? HttpURLConnection
        var json = nullJSONString

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

                json = sb.toString()
            }
        }

        return json
    }
}