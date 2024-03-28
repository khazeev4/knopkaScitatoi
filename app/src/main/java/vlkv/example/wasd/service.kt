package vlkv.example.wasd

import retrofit2.http.GET

interface service {
    @GET("/random")
    suspend fun getdata():model

}