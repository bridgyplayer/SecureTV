# SecureTV - Build Fixes

This document summarizes the fixes made to resolve build issues in the SecureTV Android IPTV Player application.

## JVM Target Compatibility Issues

1. **Java and Kotlin JVM Target Mismatch**
   - Changed Java compatibility from Java 11 to Java 8 (1.8)
   - Updated Kotlin JVM target to match Java 8
   - Updated kapt compiler options to use Java 8

2. **Gradle Configuration**
   - Downgraded Android Gradle Plugin to 7.4.2 (from 8.1.0)
   - Downgraded Gradle to 7.5 (from 8.2)
   - Simplified Java compilation options
   - Removed Kotlin JVM target validation setting from gradle.properties

## OkHttp API Usage Updates

1. **Updated HttpUrl API Usage**
   - Changed `HttpUrl.parse(url)` to `url.toHttpUrl()`
   - Changed `url.host()` to `url.host`
   - Changed `url.scheme()` to `url.scheme`
   - Changed `url.port()` to `url.port`
   - Changed `request.url()` to `request.url`
   - Added import for `okhttp3.HttpUrl.Companion.toHttpUrl`

## ExoPlayer API Updates

1. **Updated Player Error Handling**
   - Changed `ExoPlaybackException` to `PlaybackException`
   - Changed `MediaItem.SubtitleConfiguration.SELECTION_FLAG_DEFAULT` to `C.SELECTION_FLAG_DEFAULT`
   - Added import for `com.google.android.exoplayer2.C`

## UI Component Fixes

1. **SeriesScreen.kt**
   - Added public method `getSeriesInfo()` to MainViewModel to avoid direct repository access
   - Fixed episode rendering issues by changing `seriesInfo.episodes` to `seriesInfo.seasons`

2. **MoviesScreen.kt**
   - Changed `movie.coverUrl` to `movie.cover` to match the actual property name in the Movie data class

3. **MainScreen.kt**
   - Fixed experimental Material API warning by properly importing and using Material components
   - Added direct imports for Material components (TopAppBar, Text, Icon, IconButton)
   - Removed aliased imports that were causing unresolved reference errors
   - Used Material components consistently throughout the TopAppBar implementation
   - Fixed Composable context issues by ensuring all UI components are properly wrapped

## Dependency Conflict Fixes

1. **Material3 Dependency Conflicts**
   - Fixed duplicate class errors between Material3 versions (1.1.1 and 1.3.2)
   - Added explicit dependency on Material (androidx.compose.material:material)
   - Used configuration resolution strategy to force Material3 version 1.1.1
   - Excluded conflicting Material3-android module

2. **Lifecycle Library Conflicts**
   - Fixed NullPointerException in lifecycle-livedata-core-2.8.3
   - Added explicit dependency on lifecycle-livedata-core:2.6.1
   - Used configuration resolution strategy to force lifecycle-livedata-core version 2.6.1
   - Excluded conflicting lifecycle-livedata-core version 2.8.3

## Resource Fixes

1. **Launcher Icons**
   - Added missing launcher icons in multiple densities (mdpi, hdpi, xhdpi, xxhdpi, xxxhdpi)
   - Created both regular and round versions of the launcher icon

## Syntax Fixes

1. **PlayerScreen.kt**
   - Removed extra closing brace
   - Added missing import for clickable modifier

## Documentation Updates

1. **README.md**
   - Added build status badge
   - Added troubleshooting section
   - Added reference to SETUP.md

2. **SETUP.md**
   - Added detailed instructions for Java 8 compatibility

3. **FIXES.md**
   - Created comprehensive documentation of all fixes applied to the project