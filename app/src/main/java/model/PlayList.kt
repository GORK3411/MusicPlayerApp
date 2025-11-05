package model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PlayList(
                    val name: String,@PrimaryKey(autoGenerate = true) val id: Int = 0
) {

}