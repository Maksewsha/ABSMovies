package ru.maksewsha.absmovies.data.network

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import ru.maksewsha.absmovies.data.models.FilmDataFilters
import ru.maksewsha.absmovies.data.models.FilmDataFiltersFull
import ru.maksewsha.absmovies.data.models.FilmDataFull
import ru.maksewsha.absmovies.data.models.FilmList

interface RetrofitService {

    @Headers("X-API-KEY: fe339ab6-febc-4651-af83-04548c6e79b8", "accept: application/json")
    @GET("/v2.2/films")
    fun getByKeyWord(@Query("keyword")keyWord: String): Call<FilmList>

    @Headers("X-API-KEY: fe339ab6-febc-4651-af83-04548c6e79b8", "accept: application/json")
    @GET("/v2.2/films/{id}")
    fun getByKinopoiskId(@Path("id") id: Int): Call<FilmDataFull>

    companion object{
        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService{
            if(retrofitService ==  null){
                val gson = GsonBuilder().setLenient().create()

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://kinopoiskapiunofficial.tech/api/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}