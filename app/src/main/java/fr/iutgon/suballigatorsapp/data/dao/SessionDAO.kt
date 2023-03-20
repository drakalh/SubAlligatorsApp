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
}