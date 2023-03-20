package fr.iutgon.suballigatorsapp.data.dao

import android.database.Cursor
import androidx.room.*
import fr.iutgon.suballigatorsapp.entities.Aptitude

@Dao
interface AptitudeDAO
{

    @Insert
    fun insert(vararg aptitude: Aptitude)

    @Delete
    fun delete(vararg aptitude: Aptitude)

    @Update
    fun update(vararg aptitude: Aptitude)

    @Query("SELECT * FROM Aptitude")
    fun getAll(): Cursor

    @Query("SELECT * FROM Aptitude WHERE id = :id")
    fun getById(id: Int): Cursor

    @Query("SELECT * FROM Aptitude WHERE name = :name")
    fun getByName(name: String): Cursor

    @Query("SELECT * FROM Aptitude WHERE levelid = :levelid")
    fun getByLevelId(levelid: Int): Cursor

    @Query("SELECT * FROM Aptitude WHERE deleted = 0")
    fun getNotDeleted(): Cursor

    @Query("SELECT * FROM Aptitude WHERE deleted = 1")
    fun getDeleted(): Cursor

}