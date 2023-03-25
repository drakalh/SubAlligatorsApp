package fr.iutgon.suballigatorsapp.data.dao

import androidx.room.*
import fr.iutgon.suballigatorsapp.data.entities.Level

@Dao
interface LevelDAO
{
    @Insert
    fun insertLevel(vararg level: Level)

    @Delete
    fun deleteLevel(vararg level: Level)

    @Update
    fun updateLevel(vararg level: Level)

    @Query("SELECT * FROM Level")
    fun getAll(): List<Level>

    @Query("SELECT * FROM Level WHERE id = :id")
    fun getById(id: Int): Level

    @Query("SELECT * FROM Level WHERE name = :name")
    fun getByName(name: String): Level

    @Query("SELECT * FROM Level WHERE deleted = 0")
    fun getNotDeleted(): List<Level>

    @Query("SELECT * FROM Level WHERE deleted = 1")
    fun getDeleted(): List<Level>
}