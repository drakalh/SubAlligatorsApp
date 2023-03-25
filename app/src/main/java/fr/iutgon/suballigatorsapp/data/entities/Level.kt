package fr.iutgon.suballigatorsapp.data.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity
class Level
{
    companion object {
        fun getFromJSON(json: JSONObject): Level {
            val level = Level()

            level.id = json.getInt("id")
            level.name = json.getString("name")
            level.deleted = json.getBoolean("deleted")

            return level
        }
    }

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var name: String = ""

    var deleted: Boolean = false
}