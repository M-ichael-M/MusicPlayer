package com.example.musicplayer.data

import com.example.musicplayer.R

data class Music(
    val id: Int,
    val name: String,
    val artist: String,
    val music: Int,
    val cover: Int,
    val time: Int,
)

fun getPlayList(): List<Music> {
    return musicList
}

val musicList = listOf(
    Music(
        id = 0,
        name = "Escape Your Love",
        artist = "FASSounds",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.eyl,
        time = 0
    ),
    Music(
        id = 1,
        name = "Action trailer promo rock",
        artist = "MagpieMusic",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.atp,
        time = 0
    ),
    Music(
        id = 2,
        name = "Powerful Percussion",
        artist = "EnergySound",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.pp,
        time = 0
    )
)
