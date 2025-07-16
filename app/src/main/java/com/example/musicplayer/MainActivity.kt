package com.example.musicplayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import com.example.musicplayer.data.getPlayList
import com.example.musicplayer.ui.screens.MusicPlayer

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val playList = getPlayList()
            val currentMusicIndex = remember { mutableIntStateOf(0) }

            MusicPlayer(
                playList = playList,
                currentMusicIndex = currentMusicIndex.intValue,
                onMusicChange = { index -> currentMusicIndex.intValue = index }
            )
        }
    }
}