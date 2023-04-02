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
                "student",
                "initiator",
                "formation",
                "session",
                "aptitude",
                "skill",
                "status",
                "level"
            )
        }
    }

    fun setDataFromJSON(dataName: String, JSONData: JSONArray) {
        if (getEntities().contains(dataName)) {

        }
    }
}