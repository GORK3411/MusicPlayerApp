package dao

import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import model.PlayList

interface  PlaylistDao {
    @Query("SELECT * FROM PlayList")
    fun getAll(): Flow<List<PlayList>>
    @Insert
    suspend fun insert(note: PlayList)

}