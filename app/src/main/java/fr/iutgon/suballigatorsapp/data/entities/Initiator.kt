package fr.iutgon.suballigatorsapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONException
import org.json.JSONObject

@Entity
class Initiator {
    companion object {
        fun getInitiatorFromJSON(json: JSONObject): Initiator? {
            return try {
                val initiator = Initiator()

                initiator.id = json.getInt("id")
                initiator.name = json.getString("name")
                initiator.email = json.getString("email")
                initiator.password = json.getString("password")
                initiator.director = json.getBoolean("director")
                initiator.levelId = json.getInt("levelId")
                initiator.deleted = json.getBoolean("deleted")

                initiator
            } catch (e: JSONException) {
                null
            }
        }
    }

    @PrimaryKey
    var id: Int = 0

    var name: String = ""

    var email: String = ""

    var password: String = ""

    var director: Boolean = false

    var levelId: Int = 0

    var deleted: Boolean = false
}