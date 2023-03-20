package fr.iutgon.suballigatorsapp.data.dao

import android.database.Cursor
import androidx.room.*
import fr.iutgon.suballigatorsapp.entities.Skill

@Entity
interface SkillDAO
{

    @Insert
    fun insertSkill(vararg skill: Skill)

    @Delete
    fun deleteSkill(vararg skill: Skill)

    @Update
    fun updateSkill(vararg skill: Skill)

    @Query("SELECT * FROM Skill")
    fun getAll(): Cursor

    @Query("SELECT * FROM Skill WHERE id = :id")
    fun getById(id: Int): Cursor

    @Query("SELECT * FROM Skill WHERE name = :name")
    fun getByName(name: String): Cursor

    @Query("SELECT * FROM Skill WHERE levelid = :levelid")
    fun getByLevelId(levelid: Int): Cursor

    @Query("SELECT * FROM Skill WHERE deleted = 0")
    fun getNotDeleted(): Cursor

    @Query("SELECT * FROM Skill WHERE deleted = 1")
    fun getDeleted(): Cursor

}