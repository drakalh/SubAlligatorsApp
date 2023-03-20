package fr.iutgon.suballigatorsapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Skill
{

    @PrimaryKey
    var id: Int = 0

    var name: String = ""

    var deleted: Boolean = false

    var levelId: Int = 0

}