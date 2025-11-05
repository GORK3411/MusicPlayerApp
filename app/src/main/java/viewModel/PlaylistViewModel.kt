package viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import model.PlayList
import repo.PlayListRepo


class PlaylistViewModel(private val repository: PlayListRepo):ViewModel() {


    val playLists = MutableLiveData<List<PlayList>>()
    init {

          repository.playLists.collect{a-> playLists.
        }


    }
    /**/
     fun loadPlaylists() {

        playLists.value = repository.playLists.toList()
    }

    fun addPlaylist(text: String) = view{
        repository.addPlaylist(
            PlayList(text)
        )
        //loadPlaylists() // update LiveData

    }
}
