package fr.iutgon.suballigatorsapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Status
{
    @PrimaryKey
    var id: Int = 0

    var name: String = ""

    var color: String = ""
}