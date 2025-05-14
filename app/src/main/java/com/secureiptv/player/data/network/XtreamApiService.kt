package com.secureiptv.player.data.network

import com.secureiptv.player.data.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit interface for Xtream Codes API
 */
interface XtreamApiService {

    @GET("player_api.php")
    suspend fun authenticate(
        @Query("username") username: String,
        @Query("password") password: String
    ): Response<AuthResponse>
    
    @GET("player_api.php")
    suspend fun getLiveStreams(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_live_streams"
    ): Response<List<LiveStream>>
    
    @GET("player_api.php")
    suspend fun getLiveCategories(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_live_categories"
    ): Response<List<Category>>
    
    @GET("player_api.php")
    suspend fun getLiveStreamsByCategory(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_live_streams",
        @Query("category_id") categoryId: String
    ): Response<List<LiveStream>>
    
    @GET("player_api.php")
    suspend fun getVodCategories(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_vod_categories"
    ): Response<List<Category>>
    
    @GET("player_api.php")
    suspend fun getVodStreams(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_vod_streams"
    ): Response<List<Movie>>
    
    @GET("player_api.php")
    suspend fun getVodStreamsByCategory(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_vod_streams",
        @Query("category_id") categoryId: String
    ): Response<List<Movie>>
    
    @GET("player_api.php")
    suspend fun getVodInfo(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_vod_info",
        @Query("vod_id") vodId: Int
    ): Response<Movie>
    
    @GET("player_api.php")
    suspend fun getSeriesCategories(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_series_categories"
    ): Response<List<Category>>
    
    @GET("player_api.php")
    suspend fun getSeries(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_series"
    ): Response<List<Series>>
    
    @GET("player_api.php")
    suspend fun getSeriesByCategory(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_series",
        @Query("category_id") categoryId: String
    ): Response<List<Series>>
    
    @GET("player_api.php")
    suspend fun getSeriesInfo(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("action") action: String = "get_series_info",
        @Query("series_id") seriesId: Int
    ): Response<SeriesInfo>
    
    companion object {
        // Stream URL patterns
        fun getLiveStreamUrl(username: String, password: String, streamId: Int): String {
            return "${username}/${password}/${streamId}"
        }
        
        fun getVodStreamUrl(username: String, password: String, streamId: Int): String {
            return "movie/${username}/${password}/${streamId}"
        }
        
        fun getSeriesStreamUrl(username: String, password: String, streamId: Int): String {
            return "series/${username}/${password}/${streamId}"
        }
    }
}