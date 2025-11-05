package com.example.musicplayerapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.PlayList
import repo.PlayListRepo
import viewModel.PlaylistViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var playlistViewModel: PlaylistViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ///
        val repository = PlayListRepo()
        playlistViewModel = PlaylistViewModel(repository)


        playlistViewModel.addPlaylist("Cool SOng")
        playlistViewModel.addPlaylist("SAd SOng")
        playlistViewModel.addPlaylist("rock SOng")
        playlistViewModel.addPlaylist("rap SOng")

        playlistViewModel.playLists.value?.forEach{ playlist->
            println(playlist.name)
        }

        ///
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}