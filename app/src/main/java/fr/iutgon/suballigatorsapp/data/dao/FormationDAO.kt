package fr.iutgon.suballigatorsapp.dao

import android.database.Cursor
import androidx.room.*
import fr.iutgon.suballigatorsapp.entities.Formation

@Dao
interface FormationDAO {
    @Insert
    fun insert(vararg formation: Formation)

    @Delete
    fun delete(vararg formation: Formation)

    @Update
    fun update(vararg formation: Formation)

    @Query("SELECT * FROM Formation")
    fun getAll(): Cursor

    @Query("SELECT * FROM Formation WHERE id = :id")
    fun getById(id: Int): Cursor

    @Query("SELECT * FROM Formation WHERE name = :name")
    fun getByName(name: String): Cursor

    @Query("SELECT * FROM Formation WHERE levelid = :levelid")
    fun getByLevelId(levelid: Int): Cursor

    @Query("SELECT * FROM Formation WHERE deleted = 0")
    fun getNotDeleted(): Cursor

    @Query("SELECT * FROM Formation WHERE deleted = 1")
    fun getDeleted(): Cursor

}