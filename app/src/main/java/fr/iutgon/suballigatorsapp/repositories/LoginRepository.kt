package fr.iutgon.suballigatorsapp.repositories

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class LoginRepository {
    fun makeRequest(url: String): String {
        val urlObj = URL(url)
        val urlConnection = urlObj.openConnection() as? HttpURLConnection
        var c = "no"

        if (urlConnection != null) {
            urlConnection.connect()
            val reader = BufferedReader(InputStreamReader(urlConnection.inputStream))
            var line: String? = reader.readLine()

            val sb = java.lang.StringBuilder()

            while (line != null) {
                sb.append(line)
                line = reader.readLine()
            }

            c = sb.toString()
        } else {
            c = "null"
        }

        return c
    }
}