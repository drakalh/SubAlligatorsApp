package fr.iutgon.suballigatorsapp.data.dao

import androidx.room.*
import fr.iutgon.suballigatorsapp.data.entities.Status

@Dao
interface StatusDAO
{
    @Insert
    fun insertStatus(vararg status: Status)

    @Delete
    fun deleteStatus(vararg status: Status)

    @Update
    fun updateStatus(vararg status: Status)

    @Query("SELECT * FROM Status")
    fun getAll(): List<Status>

    @Query("SELECT * FROM Status WHERE id = :id")
    fun getById(id: Int): Status

    @Query("SELECT * FROM Status WHERE name = :name")
    fun getByName(name: String): Status
}