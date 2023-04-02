package fr.iutgon.suballigatorsapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONException
import org.json.JSONObject

@Entity
class Skill {
    companion object {
        fun getSkillFromJSON(json: JSONObject): Skill? {
            return try {
                val skill = Skill()

                skill.id = json.getInt("id")
                skill.name = json.getString("name")
                skill.levelId = json.getInt("levelId")
                skill.deleted = json.getBoolean("deleted")

                skill
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