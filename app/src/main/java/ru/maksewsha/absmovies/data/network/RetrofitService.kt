package ru.maksewsha.absmovies.data.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.maksewsha.absmovies.data.models.FilmDataFilters
import ru.maksewsha.absmovies.data.models.FilmDataFull

interface RetrofitService {

    @GET("/api/v2.2/films")
    fun getByKeyWord(@Query("keyword")keyWord: String): Call<List<FilmDataFilters>>

    @GET("/api/v2.2/films/{id}")
    fun getByKinopoiskId(@Path("id") id: Int): Call<List<FilmDataFull>>

    companion object{
        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService{
            if(retrofitService ==  null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://kinopoiskapiunofficial.tech")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}