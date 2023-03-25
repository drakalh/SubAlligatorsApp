package fr.iutgon.suballigatorsapp.data.dao

import androidx.room.*
import fr.iutgon.suballigatorsapp.data.entities.Formation

@Dao
interface FormationDAO {
    @Insert
    fun insert(vararg formation: Formation)

    @Delete
    fun delete(vararg formation: Formation)

    @Update
    fun update(vararg formation: Formation)

    @Query("SELECT * FROM Formation")
    fun getAll(): List<Formation>

    @Query("SELECT * FROM Formation WHERE id = :id")
    fun getById(id: Int): Formation

    @Query("SELECT * FROM Formation WHERE name = :name")
    fun getByName(name: String): Formation

    @Query("SELECT * FROM Formation WHERE levelId = :levelId")
    fun getByLevelId(levelId: Int): List<Formation>

    @Query("SELECT * FROM Formation WHERE deleted = 0")
    fun getNotDeleted(): List<Formation>

    @Query("SELECT * FROM Formation WHERE deleted = 1")
    fun getDeleted(): List<Formation>

}