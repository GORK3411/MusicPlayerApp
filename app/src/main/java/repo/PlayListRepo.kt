package repo

import android.provider.ContactsContract.CommonDataKinds.Note
import dao.PlaylistDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.toList
import model.PlayList

class PlayListRepo(private val playlistDao: PlaylistDao) {
    val playLists:Flow<List<PlayList>> = playlistDao.getAll()

//    suspend fun getAllPlaylists() : List<PlayList> = playLists

    /*
    fun addPlaylist(playList: PlayList)
    {
        playLists.add(playList)
    }
    */
    suspend fun addPlaylist(playList: PlayList) = playlistDao.insert(playList)

}