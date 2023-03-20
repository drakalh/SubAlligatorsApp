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

    @Query("SELECT * FROM Student WHERE id = :id")
    fun getById(id: Int): Cursor

    @Query("SELECT * FROM Student WHERE name = :name")
    fun getByName(name: String): Cursor

    @Query("SELECT * FROM Student WHERE formationid = :formationid")
    fun getByFormationId(formationid: Int): Cursor

    @Query("SELECT * FROM Student WHERE phone = :phone")
    fun getByPhone(phone: String): Cursor

    @Query("SELECT * FROM Student WHERE deleted = 0")
    fun getNotDeleted(): Cursor

    @Query("SELECT * FROM Student WHERE deleted = 1")
    fun getDeleted(): Cursor
}