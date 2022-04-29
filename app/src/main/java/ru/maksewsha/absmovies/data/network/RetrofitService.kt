package ru.maksewsha.absmovies.data.network

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import ru.maksewsha.absmovies.data.models.FilmDataFilters
import ru.maksewsha.absmovies.data.models.FilmDataFiltersFull
import ru.maksewsha.absmovies.data.models.FilmDataFull
import ru.maksewsha.absmovies.data.models.FilmList

interface RetrofitService {

    @Headers("X-API-KEY: fe339ab6-febc-4651-af83-04548c6e79b8", "accept: application/json", "Accept: application/json")
    @GET("./")
    fun getByKeyWord(@Query("keyword")keyWord: String): Call<FilmList>

    @Headers("X-API-KEY: fe339ab6-febc-4651-af83-04548c6e79b8", "accept: application/json", "Accept: application/json")
    @GET("/v2.2/films/{id}")
    fun getByKinopoiskId(@Path("id") id: Int): Call<FilmDataFull>

    companion object{

        private val API = "https://kinopoiskapiunofficial.tech/api/v2.2/films/"
        var retrofitService: RetrofitService? = null

        fun getInstance(): RetrofitService{

            Log.d("TAG", API)

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

            if(retrofitService ==  null){
                val gson = GsonBuilder().setLenient().create()

                val retrofit = Retrofit.Builder()
                    .baseUrl(API)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient)
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}