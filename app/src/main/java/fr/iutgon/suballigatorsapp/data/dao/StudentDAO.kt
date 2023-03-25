package fr.iutgon.suballigatorsapp.data.dao

import androidx.room.*
import fr.iutgon.suballigatorsapp.data.entities.Student

@Dao
interface StudentDAO {
    @Insert
    fun insert(vararg student: Student)

    @Delete
    fun delete(vararg student: Student)

    @Update
    fun update(vararg student: Student)

    @Query("SELECT * FROM Student")
    fun getAll(): List<Student>

    @Query("SELECT * FROM Student WHERE id = :id")
    fun getById(id: Int): Student

    @Query("SELECT * FROM Student WHERE name = :name")
    fun getByName(name: String): Student

    @Query("SELECT * FROM Student WHERE formationid = :formationid")
    fun getByFormationId(formationid: Int): List<Student>

    @Query("SELECT * FROM Student WHERE phone = :phone")
    fun getByPhone(phone: String): Student

    @Query("SELECT * FROM Student WHERE deleted = 0")
    fun getNotDeleted(): List<Student>

    @Query("SELECT * FROM Student WHERE deleted = 1")
    fun getDeleted(): List<Student>
}