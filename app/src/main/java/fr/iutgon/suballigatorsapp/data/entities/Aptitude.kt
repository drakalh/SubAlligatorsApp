package fr.iutgon.suballigatorsapp.data.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONException
import org.json.JSONObject

@Entity
class Aptitude
{
    companion object {
        fun getFromJSON(json: JSONObject): Aptitude? {
            val aptitude = Aptitude()

            return try {
                aptitude.id = json.getInt("id")
                aptitude.name = json.getString("name")
                aptitude.skillId = json.getInt("skillId")
                aptitude.deleted = json.getBoolean("deleted")

                aptitude
            } catch (e: JSONException) {
                null
            }
        }
    }

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var name: String = ""

    var skillId: Int = 0

    var deleted: Boolean = false
}