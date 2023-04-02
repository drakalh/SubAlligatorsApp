package fr.iutgon.suballigatorsapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONException
import org.json.JSONObject

@Entity
class Formation {
    companion object {
        fun getFormationFromJSON(json: JSONObject): Formation? {
            return try {
                val formation = Formation()

                formation.id = json.getInt("id")
                formation.name = json.getString("name")
                formation.levelId = json.getInt("levelId")
                formation.deleted = json.getBoolean("deleted")

                formation
            } catch (e: JSONException) {
                null
            }
        }
    }

    @PrimaryKey
    var id: Int = 0

    var name: String = ""

    var levelId: Int = 0

    var deleted: Boolean = false
}