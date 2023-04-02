package fr.iutgon.suballigatorsapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.iutgon.suballigatorsapp.data.dao.FormationDAO
import fr.iutgon.suballigatorsapp.data.dao.InitiatorDAO
import fr.iutgon.suballigatorsapp.data.dao.SessionDAO
import fr.iutgon.suballigatorsapp.data.dao.StudentDAO
import fr.iutgon.suballigatorsapp.data.dao.AptitudeDAO
import fr.iutgon.suballigatorsapp.data.dao.LevelDAO
import fr.iutgon.suballigatorsapp.data.dao.SkillDAO
import fr.iutgon.suballigatorsapp.data.dao.StatusDAO
import fr.iutgon.suballigatorsapp.data.entities.*
import org.json.JSONArray
import org.json.JSONObject

@Database(
    entities = [
        Student::class,
        Initiator::class,
        Formation::class,
        Session::class,
        Aptitude::class,
        Skill::class,
        Status::class,
        Level::class
    ],

    version = 1
)
abstract class AppBDD : RoomDatabase() {
    abstract fun aptitudeDAO(): AptitudeDAO
    abstract fun studentDAO(): StudentDAO
    abstract fun initiatorDAO(): InitiatorDAO
    abstract fun formationDAO(): FormationDAO
    abstract fun sessionDAO(): SessionDAO
    abstract fun skillDAO(): SkillDAO
    abstract fun statusDAO(): StatusDAO
    abstract fun levelDAO(): LevelDAO

    companion object {
        private var instance: AppBDD? = null

        fun getInstance(context: Context): AppBDD {
            if (instance == null)
                instance = Room.databaseBuilder(
                    context,
                    AppBDD::class.java, "modules.sqlite"
                ).build()
            return instance!!
        }

        fun getEntities(): Array<String> {
            return arrayOf(
                "aptitude",
                "student",
                "initiator",
                "formation",
                "session",
                "skill",
                "status",
                "level"
            )
        }
    }

    fun setDataFromJSON(dataName: String, JSONData: JSONArray) {
        if (getEntities().contains(dataName)) {
            for (i in 0 until JSONData.length()) {
                val jsonObj = JSONData.get(i) as JSONObject
                try {
                    when (dataName) {
                        "aptitude" -> {
                            aptitudeDAO().insert(Aptitude.getAptitudeFromJSON(jsonObj)!!)
                        }
                        "formation" -> {
                            formationDAO().insert(Formation.getFormationFromJSON(jsonObj)!!)
                        }
                        "initiator" -> {
                            initiatorDAO().insert(Initiator.getInitiatorFromJSON(jsonObj)!!)
                        }
                        "level" -> {
                            levelDAO().insert(Level.getLevelFromJSON(jsonObj)!!)
                        }
                        "session" -> {
                            sessionDAO().insert(Session.getSessionFromJSON(jsonObj)!!)
                        }
                        "skill" -> {
                            skillDAO().insert(Skill.getSkillFromJSON(jsonObj)!!)
                        }
                        "status" -> {
                            statusDAO().insert(Status.getStatusFromJSON(jsonObj)!!)
                        }
                        "student" -> {
                            studentDAO().insert(Student.getStudentFromJSON(jsonObj)!!)
                        }
                    }
                } catch (e: Exception) {
                    println(e)
                    when (dataName) {
                        "aptitude" -> {
                            aptitudeDAO().update(Aptitude.getAptitudeFromJSON(jsonObj)!!)
                        }
                        "formation" -> {
                            formationDAO().update(Formation.getFormationFromJSON(jsonObj)!!)
                        }
                        "initiator" -> {
                            initiatorDAO().update(Initiator.getInitiatorFromJSON(jsonObj)!!)
                        }
                        "level" -> {
                            levelDAO().update(Level.getLevelFromJSON(jsonObj)!!)
                        }
                        "session" -> {
                            sessionDAO().update(Session.getSessionFromJSON(jsonObj)!!)
                        }
                        "skill" -> {
                            skillDAO().update(Skill.getSkillFromJSON(jsonObj)!!)
                        }
                        "status" -> {
                            statusDAO().update(Status.getStatusFromJSON(jsonObj)!!)
                        }
                        "student" -> {
                            studentDAO().update(Student.getStudentFromJSON(jsonObj)!!)
                        }
                    }
                }
            }
        }
    }
}