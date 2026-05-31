# MusicPlayer

The **MusicPlayer** app is a simple Android music player built with Jetpack Compose and ExoPlayer. It enables playback of a list of music tracks from local app resources, with features such as play/pause, switching between tracks, and displaying track information (title, artist).

## Features

- Playback of music tracks from local resources (raw files).
- Track list with name, artist, and cover art (placeholder).
- Playback controls: Play/Pause, Previous, Next.
- Animated track card with a circular shape.
- Responsive user interface based on Jetpack Compose.
- Playback state management via ExoPlayer.

## Requirements

- **Android SDK**: API 21 (Lollipop) or higher.
- **Kotlin**: Version 1.9.0 or higher.
- **Jetpack Compose**: Latest stable version.
- **ExoPlayer**: Version 2.19.1 or higher.
- **Music resources**: MP3 audio files placed in the `res/raw` folder.

## Project Structure

- **`MainActivity.kt`**: The main activity of the app, initializing the track list and the `MusicPlayer` component.
- **`data/Music.kt`**: The `Music` data model and the `getPlayList` function providing a static list of tracks.
- **`ui/screens/MusicPlayer.kt`**: UI components, including:
  - `MusicPlayer`: The main player screen.
  - `BodyItem`: A card representing a single track.
  - `BottomBar`: The control bar with Previous, Play/Pause, and Next buttons.

## Installation

1. Clone the repository:
   ```bash
   git clone <repository-URL>
   ```
2. Open the project in Android Studio.
3. Add music files (MP3) to the `res/raw` folder and update the `musicList` in `Music.kt` to match the file names.
4. Sync the project with Gradle:
   ```bash
   ./gradlew sync
   ```
5. Run the app on an emulator or a physical Android device.

## Usage

1. When the app launches, it displays the track list defined in `musicList`.
2. Click the Play button on a track card to start playback.
3. Use the control bar at the bottom of the screen to:
   - Pause/resume playback (Play/Pause).
   - Go to the previous track (Previous).
   - Go to the next track (Next).

## Track List

The app includes a sample track list defined in `Music.kt`. Each track has the following attributes:
- `id`: Unique identifier.
- `name`: Track title.
- `artist`: Artist name.
- `music`: Music resource ID (`R.raw.<filename>`).
- `cover`: Cover art resource ID (currently a placeholder).
- `time`: Track duration in seconds (partially implemented).

Sample tracks:
- "Coraline" – Måneskin
- "Mockingbird" – Eminem
- "505" – Arctic Monkeys
- "São Paulo" – The Weeknd
- ... (full list in `Music.kt`)

## Dependencies

Add the following dependencies to your `build.gradle` (app module):

```gradle
dependencies {
    implementation "androidx.activity:activity-compose:1.9.2"
    implementation "androidx.compose.material3:material3:1.3.0"
    implementation "com.google.android.exoplayer:exoplayer:2.19.1"
}
```

## Limitations and Possible Improvements

- **No dynamic track loading**: The track list is static and requires manual updates in the code.
- **Placeholder cover art**: All tracks use the same icon (`ic_launcher_background`).
- **No playback progress**: No progress bar or duration display has been implemented.
- **Possible improvements**:
  - Adding a progress bar and track duration display.
  - Loading tracks from device storage.
  - Supporting cover art from MP3 metadata.
  - Adding shuffle and repeat modes.

## License

This project is available under the MIT License. See the `LICENSE` file for details.