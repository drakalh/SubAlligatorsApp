package fr.iutgon.suballigatorsapp.dao

import android.database.Cursor
import androidx.room.*
import fr.iutgon.suballigatorsapp.entities.Initiator

@Dao
interface InitiatorDAO {
    @Insert
    fun insert(vararg initiator: Initiator)

    @Delete
    fun delete(vararg initiator: Initiator)

    @Update
    fun update(vararg initiator: Initiator)

    @Query("SELECT * FROM Initiator")
    fun getAll(): Cursor

    @Query("SELECT * FROM Initiator WHERE id = :id")
    fun getById(id: Int): Cursor

    @Query("SELECT * FROM Initiator WHERE name = :name")
    fun getByName(name: String): Cursor

    @Query("SELECT * FROM Initiator WHERE mail = :mail and password = :password")
    fun getByMailAndPassword(mail: String, password: String): Cursor

    @Query("SELECT * FROM Initiator WHERE levelid = :levelid")
    fun getByLevelId(levelid: Int): Cursor
}