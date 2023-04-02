package fr.iutgon.suballigatorsapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONException
import org.json.JSONObject

@Entity
class Status {
    companion object {
        fun getStatusFromJSON(json: JSONObject): Status? {
            return try {
                val status = Status()

                status.id = json.getInt("id")
                status.name = json.getString("name")
                status.color = json.getString("color")

                status
            } catch (e: JSONException) {
                null
            }
        }
    }

    @PrimaryKey
    var id: Int = 0

    var name: String = ""

    var color: String = ""
}