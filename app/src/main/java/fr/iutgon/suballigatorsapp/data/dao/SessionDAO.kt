package fr.iutgon.suballigatorsapp.data.dao

import android.database.Cursor
import androidx.room.*
import fr.iutgon.suballigatorsapp.data.entities.Session

@Dao
interface SessionDAO {
    @Insert
    fun insert(vararg session: Session)

    @Delete
    fun delete(vararg session: Session)

    @Update
    fun update(vararg session: Session)

    @Query("SELECT * FROM Session")
    fun getAll(): List<Session>

    @Query("SELECT * FROM Session WHERE id = :id")
    fun getById(id: Int): Session

    @Query("SELECT * FROM Session WHERE formationid = :formationid")
    fun getByFormationId(formationid: Int): List<Session>

    @Query("SELECT * FROM Session WHERE date = :date")
    fun getByDate(date: String): List<Session>

    @Query("SELECT * FROM Session WHERE deleted = 0")
    fun getNotDeleted(): List<Session>

    @Query("SELECT * FROM Session WHERE deleted = 1")
    fun getDeleted(): List<Session>
}