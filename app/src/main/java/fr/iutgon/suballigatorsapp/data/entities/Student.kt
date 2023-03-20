package fr.iutgon.suballigatorsapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Student {
    @PrimaryKey
    var id: Int = 0

    var name: String = ""

    var formationId: Int = 0

    var phone: String = ""

    var deleted: Boolean = false
}