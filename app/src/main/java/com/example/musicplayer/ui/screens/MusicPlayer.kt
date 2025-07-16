package com.example.musicplayer.ui.screens

import android.net.Uri
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.example.musicplayer.R
import com.example.musicplayer.data.Music

@Composable
fun MusicPlayer(
    playList: List<Music>,
    currentMusicIndex: Int,
    onMusicChange: (Int) -> Unit
) {
    val context = LocalContext.current
    val player = remember { ExoPlayer.Builder(context).build() }
    var currentTrack by remember { mutableStateOf(playList[currentMusicIndex]) }
    var isPlaying by remember { mutableStateOf(false) }

    LaunchedEffect(currentTrack) {
        player.clearMediaItems()
        val path = "android.resource://" + context.packageName + "/" + currentTrack.music
        val mediaItem = MediaItem.fromUri(Uri.parse(path))
        player.addMediaItem(mediaItem)
        player.prepare()
        if (isPlaying) {
            player.play()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            player.release()
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)) { // Ensures the LazyColumn takes up available space above the BottomBar
            items(playList) { song ->
                BodyItem(song = song, isPlaying = isPlaying && song.id == currentTrack.id, onPlayPauseClick = {
                    isPlaying = !isPlaying
                    if (isPlaying) {
                        currentTrack = song
                        player.clearMediaItems()
                        val path = "android.resource://" + context.packageName + "/" + song.music
                        val mediaItem = MediaItem.fromUri(Uri.parse(path))
                        player.addMediaItem(mediaItem)
                        player.prepare()
                        player.play()
                    } else {
                        player.pause()
                    }
                })
            }

        }
        BottomBar(
            isPlaying = isPlaying,
            onPlayPauseClick = {
                isPlaying = !isPlaying
                if (isPlaying) {
                    player.play()
                } else {
                    player.pause()
                }
            },
            onPreviousClick = {
                val newIndex = (currentMusicIndex - 1 + playList.size) % playList.size
                currentTrack = playList[newIndex]
                onMusicChange(newIndex)
                isPlaying = true
                player.play()
            },
            onNextClick = {
                val newIndex = (currentMusicIndex + 1) % playList.size
                currentTrack = playList[newIndex]
                onMusicChange(newIndex)
                isPlaying = true
                player.play()
            }
        )
    }
}

@Composable
fun BodyItem(
    song: Music,
    isPlaying: Boolean,
    onPlayPauseClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .clip(CircleShape)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Play/Pause Button
                Button(
                    onClick = onPlayPauseClick,
                    modifier = Modifier.size(100.dp),
                    shape = CircleShape,
                ) {
                    Image(
                        painter = painterResource(
                            id = if (isPlaying) R.drawable.pause else R.drawable.play_arrow
                        ),
                        contentDescription = "Play/Pause Button",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }

                // Song Info Column
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = song.name,
                        style = MaterialTheme.typography.headlineLarge,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = song.artist,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun BottomBar(isPlaying: Boolean, onPlayPauseClick: () -> Unit, onPreviousClick: () -> Unit, onNextClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onPreviousClick,
                modifier = Modifier
                    .size(80.dp) // Adjust the size as needed
            ) {
                Image(
                    painter = painterResource(id = R.drawable.previous),
                    contentDescription = "Previous",
                    modifier = Modifier.size(80.dp) // Adjust the size to make the icon larger
                )
            }
            Button(
                onClick = onPlayPauseClick,
                modifier = Modifier
                    .size(120.dp) // Adjust the size as needed
            ) {
                Image(
                    painter = painterResource(id = if (isPlaying) R.drawable.pause else R.drawable.play_arrow),
                    contentDescription = "Play/Pause Button",
                    modifier = Modifier.size(120.dp) // Adjust the size to make the icon larger
                )
            }
            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .size(80.dp) // Adjust the size as needed
            ) {
                Image(
                    painter = painterResource(id = R.drawable.next),
                    contentDescription = "Next",
                    modifier = Modifier.size(80.dp) // Adjust the size to make the icon larger
                )
            }
        }
    }
}
