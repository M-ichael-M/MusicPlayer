# MusicPlayer

Aplikacja **MusicPlayer** to prosty odtwarzacz muzyczny na Androida, zbudowany przy użyciu Jetpack Compose i ExoPlayer. Umożliwia odtwarzanie listy utworów muzycznych z lokalnych zasobów aplikacji, z funkcjami takimi jak play/pause, przełączanie między utworami oraz wyświetlanie informacji o utworze (tytuł, artysta).

## Funkcjonalności

- Odtwarzanie utworów muzycznych z lokalnych zasobów (pliki raw).
- Lista utworów z nazwą, artystą i okładką (placeholder).
- Przyciski sterowania: Play/Pause, Previous, Next.
- Animowana karta utworu z okrągłym kształtem.
- Responsywny interfejs użytkownika oparty na Jetpack Compose.
- Zarządzanie stanem odtwarzania za pomocą ExoPlayer.

## Wymagania

- **Android SDK**: API 21 (Lollipop) lub nowszy.
- **Kotlin**: Wersja 1.9.0 lub nowsza.
- **Jetpack Compose**: Najnowsza stabilna wersja.
- **ExoPlayer**: Wersja 2.19.1 lub nowsza.
- **Zasoby muzyczne**: Pliki muzyczne w formacie MP3 umieszczone w folderze `res/raw`.

## Struktura projektu

- **`MainActivity.kt`**: Główna aktywność aplikacji, inicjalizująca listę utworów i komponent `MusicPlayer`.
- **`data/Music.kt`**: Model danych `Music` oraz funkcja `getPlayList` dostarczająca statyczną listę utworów.
- **`ui/screens/MusicPlayer.kt`**: Komponenty UI, w tym:
  - `MusicPlayer`: Główny ekran odtwarzacza.
  - `BodyItem`: Karta reprezentująca pojedynczy utwór.
  - `BottomBar`: Pasek sterowania z przyciskami Previous, Play/Pause, Next.

## Instalacja

1. Sklonuj repozytorium:
   ```bash
   git clone <URL-repozytorium>
   ```
2. Otwórz projekt w Android Studio.
3. Dodaj pliki muzyczne (MP3) do folderu `res/raw` i zaktualizuj listę `musicList` w pliku `Music.kt` zgodnie z nazwami plików.
4. Zsynchronizuj projekt z Gradle:
   ```bash
   ./gradlew sync
   ```
5. Uruchom aplikację na emulatorze lub fizycznym urządzeniu z Androidem.

## Użycie

1. Po uruchomieniu aplikacji wyświetli się lista utworów zdefiniowana w `musicList`.
2. Kliknij przycisk Play na karcie utworu, aby rozpocząć odtwarzanie.
3. Użyj paska sterowania na dole ekranu, aby:
   - Wstrzymać/wznowić odtwarzanie (Play/Pause).
   - Przejść do poprzedniego utworu (Previous).
   - Przejść do następnego utworu (Next).

## Lista utworów

Aplikacja zawiera przykładową listę utworów zdefiniowaną w `Music.kt`. Każdy utwór ma następujące atrybuty:
- `id`: Unikalny identyfikator.
- `name`: Tytuł utworu.
- `artist`: Nazwa artysty.
- `music`: ID zasobu muzycznego (R.raw.<nazwa_pliku>).
- `cover`: ID zasobu okładki (obecnie placeholder).
- `time`: Długość utworu w sekundach (częściowo zaimplementowane).

Przykładowe utwory:
- "Coraline" – Måneskin
- "Mockingbird" – Eminem
- "505" – Arctic Monkeys
- "São Paulo" – The Weeknd
- ... (pełna lista w `Music.kt`)

## Zależności

W pliku `build.gradle` (moduł aplikacji) należy dodać następujące zależności:

```gradle
dependencies {
    implementation "androidx.activity:activity-compose:1.9.2"
    implementation "androidx.compose.material3:material3:1.3.0"
    implementation "com.google.android.exoplayer:exoplayer:2.19.1"
}
```

## Ograniczenia i możliwe ulepszenia

- **Brak dynamicznego wczytywania utworów**: Lista utworów jest statyczna i wymaga ręcznej aktualizacji w kodzie.
- **Placeholder okładek**: Wszystkie utwory używają tej samej ikony (`ic_launcher_background`).
- **Brak postępu odtwarzania**: Nie zaimplementowano paska postępu ani wyświetlania czasu trwania.
- **Możliwe ulepszenia**:
  - Dodanie paska postępu i czasu trwania utworu.
  - Wczytywanie utworów z pamięci urządzenia.
  - Obsługa okładek z metadanych MP3.
  - Dodanie losowego odtwarzania i pętli.

## Licencja

Projekt jest dostępny na licencji MIT. Szczegóły w pliku `LICENSE`.