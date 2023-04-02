package fr.iutgon.suballigatorsapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONException
import org.json.JSONObject

@Entity
class Level {
    companion object {
        fun getLevelFromJSON(json: JSONObject): Level? {
            return try {
                val level = Level()

                level.id = json.getInt("id")
                level.deleted = json.getBoolean("deleted")

                level
            } catch (e: JSONException) {
                null
            }
        }
    }

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var name: String = ""

    var deleted: Boolean = false
}