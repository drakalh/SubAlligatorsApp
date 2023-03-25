package fr.iutgon.suballigatorsapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity
class Session {
    companion object {
        fun getFromJSON(json: JSONObject): Session {
            val session = Session()

            session.id = json.getInt("id")
            session.date = json.getString("data")
            session.formationId = json.getInt("formationId")
            session.deleted = json.getBoolean("deleted")

            return session
        }
    }

    @PrimaryKey
    var id: Int = 0

    var date: String = ""

    var formationId: Int = 0

    var deleted: Boolean = false

}