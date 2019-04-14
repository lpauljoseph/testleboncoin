package fr.pjapps.testleboncoin.data.apiclient.service

import fr.pjapps.testleboncoin.data.apiclient.model.Picture
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author Loïc PAUL-JOSEPH.
 */
interface AlbumService {

    @GET("img/shared/technical-test.json")
    fun fetchAll() : Call<List<Picture>>

}