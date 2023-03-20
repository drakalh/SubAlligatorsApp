package fr.iutgon.suballigatorsapp.data.dao

import android.database.Cursor
import androidx.room.*
import fr.iutgon.suballigatorsapp.data.entities.Status

@Entity
interface StatusDAO
{

    @Insert
    fun insertStatus(vararg status: Status)

    @Delete
    fun deleteStatus(vararg status: Status)

    @Update
    fun updateStatus(vararg status: Status)

    @Query("SELECT * FROM Status")
    fun getAll(): Cursor

    @Query("SELECT * FROM Status WHERE id = :id")
    fun getById(id: Int): Cursor

    @Query("SELECT * FROM Status WHERE name = :name")
    fun getByName(name: String): Cursor

    @Query("SELECT * FROM Status WHERE levelid = :levelid")
    fun getByLevelId(levelid: Int): Cursor

    @Query("SELECT * FROM Status WHERE deleted = 0")
    fun getNotDeleted(): Cursor

    @Query("SELECT * FROM Status WHERE deleted = 1")
    fun getDeleted(): Cursor

}