package fr.iutgon.suballigatorsapp.dao

import android.database.Cursor
import androidx.room.*
import fr.iutgon.suballigatorsapp.entities.Session

@Dao
interface SessionDAO {
    @Insert
    fun insert(vararg session: Session)

    @Delete
    fun delete(vararg session: Session)

    @Update
    fun update(vararg session: Session)

    @Query("SELECT * FROM session")
    fun getAll(): Cursor

    @Query("SELECT * FROM session WHERE id = :id")
    fun getById(id: Int): Cursor

    @Query("SELECT * FROM session WHERE formationid = :formationid")
    fun getByFormationId(formationid: Int): Cursor

    @Query("SELECT * FROM session WHERE date = :date")
    fun getByDate(date: String): Cursor

    @Query("SELECT * FROM session WHERE deleted = 0")
    fun getNotDeleted(): Cursor

    @Query("SELECT * FROM session WHERE deleted = 1")
    fun getDeleted(): Cursor
}