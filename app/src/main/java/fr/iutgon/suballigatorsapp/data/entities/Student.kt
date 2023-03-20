package fr.iutgon.suballigatorsapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Student {
    @PrimaryKey
    var id: Int = 0

    @ColumnInfo(name = "lastname")
    var lastname: String = ""

    @ColumnInfo(name = "firstname")
    var firstname: String = ""

    @ColumnInfo(name = "formationId")
    var formationId: Int = 0

    @ColumnInfo(name = "studentDeleted")
    var studentDeleted: Int = 0
}