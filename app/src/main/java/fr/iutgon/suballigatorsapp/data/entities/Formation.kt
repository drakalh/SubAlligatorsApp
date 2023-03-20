package fr.iutgon.suballigatorsapp.entities

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Formation {

    @PrimaryKey
    var id: Int = 0

    var name: String = ""

    var levelid: Int = 0

    var deleted: Boolean = false

}