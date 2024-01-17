package hu.szg.improveyourself.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
abstract class BaseModel {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}