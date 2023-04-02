package fr.iutgon.suballigatorsapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONException
import org.json.JSONObject

@Entity
class Session {
    companion object {
        fun getSessionFromJSON(json: JSONObject): Session? {
            return try {
                val session = Session()

                session.id = json.getInt("id")
                session.date = json.getString("date")
                session.formationId = json.getInt("formationId")
                session.deleted = json.getBoolean("deleted")

                session
            } catch (e: JSONException) {
                null
            }
        }
    }

    @PrimaryKey
    var id: Int = 0

    var date: String = ""

    var formationId: Int = 0

    var deleted: Boolean = false
}