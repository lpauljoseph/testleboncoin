package fr.pjapps.testleboncoin.data.apiclient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Loïc PAUL-JOSEPH.
 */
object RestClient {

    private val retrofit: Retrofit

    init {
        val builder =
            Retrofit.Builder()
                .baseUrl("https://static.leboncoin.fr")
                .addConverterFactory(GsonConverterFactory.create())
        retrofit = builder.build()
    }

    fun <T> createService(clazz: Class<T>): T = retrofit.create(clazz)

}