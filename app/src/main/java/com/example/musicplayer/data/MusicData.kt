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
        name = "Coraline",
        artist = "Måneskin",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.coraline,
        time = 0
    ),
    Music(
        id = 1,
        name = "Mockingbird",
        artist = "Eminem",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.mockingbird,
        time = 0
    ),
    Music(
        id = 2,
        name = "505",
        artist = "Arctic Monkeys",
        cover = R.drawable.ic_launcher_background,
        music = R.raw._505,
        time = 0
    ),
    Music(
        id = 3,
        name = "A lesser man",
        artist = "The Weeknd",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.a_lesser_man,
        time = 0
    ),
    Music(
        id = 4,
        name = "All the stars",
        artist = "Kendrick Lamar",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.all_the_stars,
        time = 213
    ),
    Music(
        id = 5,
        name = "Escapism.",
        artist = "RAYE",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.escapizm,
        time = 274
    ),
    Music(
        id = 6,
        name = "São Paulo",
        artist = "The Weeknd",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.sao_paulo,
        time = 302
    ),
    Music(
        id = 7,
        name = "Superman",
        artist = "Eminem",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.superman,
        time = 351

    ),
    Music(
        id = 8,
        name = "Without Me",
        artist = "Eminem",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.without_me,
        time = 492
    ),
    Music(
        id = 9,
        name = "Him & I",
        artist = "G-Eazy & Halsey",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.him_i_i,
        time = 287
    ),
    Music(
        id = 10,
        name = "If Not for You",
        artist = "Måneskin",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.if_not_for_you,
        time = 195
    ),
    Music(
        id = 11,
        name = "Me, Myself & I",
        artist = "G-Eazy & Bebe Rexha",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.me_myself_i_i,
        time = 255
    ),
    Music(
        id = 12,
        name = "Say You Won't Let Go",
        artist = "James Arthur",
        cover = R.drawable.ic_launcher_background,
        music = R.raw.say_you_wont_let_go,
        time = 211
    ),
)
