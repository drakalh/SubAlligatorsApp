package fr.iutgon.suballigatorsapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONException
import org.json.JSONObject

@Entity
class Student {
    companion object {
        fun getStudentFromJSON(json: JSONObject): Student? {
            return try {
                val student = Student()

                student.id = json.getInt("id")
                student.name = json.getString("name")
                student.formationId = json.getInt("formationId")
                student.phone = json.getString("phone")
                student.deleted = json.getBoolean("deleted")

                student
            } catch (e: JSONException) {
                null
            }
        }
    }

    @PrimaryKey
    var id: Int = 0

    var name: String = ""

    var formationId: Int = 0

    var phone: String = ""

    var deleted: Boolean = false
}