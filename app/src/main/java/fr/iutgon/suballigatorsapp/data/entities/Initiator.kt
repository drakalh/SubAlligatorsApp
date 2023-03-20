package fr.iutgon.suballigatorsapp.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Initiator {
    @PrimaryKey
    var id: Int = 0

    var name: String = ""

    var email: String = ""

    var password: String = ""

    var director: Boolean = false

    var levelid: Int = 0

    var deleted: Boolean = false
}