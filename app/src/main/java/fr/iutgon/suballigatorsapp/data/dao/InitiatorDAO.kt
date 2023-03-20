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
}