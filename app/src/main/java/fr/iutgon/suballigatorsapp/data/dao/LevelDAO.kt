package fr.iutgon.suballigatorsapp.data.dao

import android.database.Cursor
import androidx.room.*
import java.util.logging.Level

@Entity
interface LevelDAO
{

    @Insert
    fun insertLevel(vararg level: Level)

    @Delete
    fun deleteLevel(vararg level: Level)

    @Update
    fun updateLevel(vararg level: Level)

    @Query("SELECT * FROM Level")
    fun getAll(): Cursor

    @Query("SELECT * FROM Level WHERE id = :id")
    fun getById(id: Int): Cursor

    @Query("SELECT * FROM Level WHERE name = :name")
    fun getByName(name: String): Cursor

    @Query("SELECT * FROM Level WHERE deleted = 0")
    fun getNotDeleted(): Cursor

    @Query("SELECT * FROM Level WHERE deleted = 1")
    fun getDeleted(): Cursor

}