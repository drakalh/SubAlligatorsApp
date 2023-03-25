package fr.iutgon.suballigatorsapp.data.dao

import androidx.room.*
import fr.iutgon.suballigatorsapp.data.entities.Skill

@Dao
interface SkillDAO
{
    @Insert
    fun insertSkill(vararg skill: Skill)

    @Delete
    fun deleteSkill(vararg skill: Skill)

    @Update
    fun updateSkill(vararg skill: Skill)

    @Query("SELECT * FROM Skill")
    fun getAll(): List<Skill>

    @Query("SELECT * FROM Skill WHERE id = :id")
    fun getById(id: Int): Skill

    @Query("SELECT * FROM Skill WHERE name = :name")
    fun getByName(name: String): Skill

    @Query("SELECT * FROM Skill WHERE levelid = :levelid")
    fun getByLevelId(levelid: Int): List<Skill>

    @Query("SELECT * FROM Skill WHERE deleted = 0")
    fun getNotDeleted(): List<Skill>

    @Query("SELECT * FROM Skill WHERE deleted = 1")
    fun getDeleted(): List<Skill>
}