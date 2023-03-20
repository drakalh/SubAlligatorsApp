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
}