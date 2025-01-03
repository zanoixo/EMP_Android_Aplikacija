package com.example.moviecatalog.network

import com.example.moviecatalog.data.Top10
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Headers


/**Below is an example of the HTTP request
 *
 * GET /api HTTP/1.1
 * x-rapidapi-key: 5ce6a98cbdmshsjie297a61e07f32386d1cp1c3f67jsn91eadf5d1141
 * x-rapidapi-host: motivation-quotes4.p.rapidapi.com
 * host: motivation-quotes4.p.rapidapi.com
 */

//Relevant information for accessing the selected api.
private const val BASE_URL =
    "https://imdb-top-100-movies.p.rapidapi.com/" //mind the forward slash character at the end of the URL
private const val KEY = "993a0f3628msh280c2749561d8e7p18a735jsn92e8b920c013"
private const val HOST = "imdb-top-100-movies.p.rapidapi.com"

//By using kotlinx.serialization converter, the Retrofit builder builds a retrofit object.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

//Api call creation by implementing means of the Retrofit object for service.
interface ApiService {
    @Headers("x-rapidapi-key: $KEY",
        "x-rapidapi-host: $HOST")
    @GET("api")
    suspend fun get10(): List<Top10>
}

//Below is a public Api object that exposes the lazy-initialized Retrofit service.
//When utilizing lazy inicialization, the creation creation of the object is
//delayed, until there is an actual need for this object.
//This way, unnecessary waisting of resources is ensured.
object Api {
    val retrofitService: ApiService by lazy { retrofit.create(ApiService::class.java)}
}