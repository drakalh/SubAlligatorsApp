package fr.iutgon.suballigatorsapp.data.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity
class Initiator {
    companion object {
        fun getFromJSON(json: JSONObject): Initiator {
            val initiator = Initiator()

            initiator.id = json.getInt("id")
            initiator.name = json.getString("name")
            initiator.email = json.getString("email")
            initiator.password = json.getString("password")
            initiator.director = json.getBoolean("director")
            initiator.levelid = json.getInt("levelId")
            initiator.deleted = json.getBoolean("deleted")

            return initiator
        }
    }

    @PrimaryKey
    var id: Int = 0

    var name: String = ""

    var email: String = ""

    var password: String = ""

    var director: Boolean = false

    var levelid: Int = 0

    var deleted: Boolean = false
}