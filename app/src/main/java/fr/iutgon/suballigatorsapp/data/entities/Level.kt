package fr.iutgon.suballigatorsapp.data.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Level
{

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var name: String = ""

    var deleted: Boolean = false
}