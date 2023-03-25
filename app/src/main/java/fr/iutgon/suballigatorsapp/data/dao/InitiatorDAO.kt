package fr.iutgon.suballigatorsapp.data.dao

import androidx.room.*
import fr.iutgon.suballigatorsapp.data.entities.Initiator

@Dao
interface InitiatorDAO {
    @Insert
    fun insert(vararg initiator: Initiator)

    @Delete
    fun delete(vararg initiator: Initiator)

    @Update
    fun update(vararg initiator: Initiator)

    @Query("SELECT * FROM Initiator")
    fun getAll(): List<Initiator>

    @Query("SELECT * FROM Initiator WHERE id = :id")
    fun getById(id: Int): Initiator

    @Query("SELECT * FROM Initiator WHERE name = :name")
    fun getByName(name: String): Initiator

    @Query("SELECT * FROM Initiator WHERE email = :email and password = :password")
    fun getByEmailAndPassword(email: String, password: String): Initiator

    @Query("SELECT * FROM Initiator WHERE levelId = :levelId")
    fun getByLevelId(levelId: Int): List<Initiator>
}