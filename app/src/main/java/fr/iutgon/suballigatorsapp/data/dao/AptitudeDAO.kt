package fr.iutgon.suballigatorsapp.data.dao

import androidx.room.*
import fr.iutgon.suballigatorsapp.data.entities.Aptitude

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
    fun getAll(): List<Aptitude>

    @Query("SELECT * FROM Aptitude WHERE id = :id")
    fun getById(id: Int): Aptitude

    @Query("SELECT * FROM Aptitude WHERE name = :name")
    fun getByName(name: String): Aptitude

    @Query("SELECT * FROM Aptitude WHERE deleted = 0")
    fun getNotDeleted(): List<Aptitude>

    @Query("SELECT * FROM Aptitude WHERE deleted = 1")
    fun getDeleted(): List<Aptitude>

    @Query("SELECT * FROM Aptitude WHERE skillId = :skillId")
    fun getBySkillId(skillId: Int): List<Aptitude>
}