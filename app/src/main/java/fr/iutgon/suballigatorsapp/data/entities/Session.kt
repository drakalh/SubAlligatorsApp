package fr.iutgon.suballigatorsapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Session {

    @PrimaryKey
    var id: Int = 0

    var date: String = ""

    var formationId: Int = 0

    var deleted: Boolean = false

}