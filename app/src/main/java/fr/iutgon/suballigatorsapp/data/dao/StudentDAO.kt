package fr.iutgon.suballigatorsapp.dao

import android.database.Cursor
import androidx.room.*
import fr.iutgon.suballigatorsapp.entities.Student

@Dao
interface StudentDAO {
    @Insert
    fun insert(vararg student: Student)

    @Delete
    fun delete(vararg student: Student)

    @Update
    fun update(vararg student: Student)

    @Query("SELECT * FROM Student")
    fun getAll(): Cursor
}