package fr.iutgon.suballigatorsapp.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Aptitude
{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var name: String = ""

    var skillId: Int = 0

}