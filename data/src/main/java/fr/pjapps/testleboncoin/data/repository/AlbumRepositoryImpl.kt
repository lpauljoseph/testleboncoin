package fr.pjapps.testleboncoin.data.repository

import fr.pjapps.testleboncoin.data.apiclient.RestClient
import fr.pjapps.testleboncoin.data.apiclient.model.Picture
import fr.pjapps.testleboncoin.data.apiclient.service.AlbumService
import fr.pjapps.testleboncoin.data.database.dao.PictureDao
import fr.pjapps.testleboncoin.data.database.entity.PictureDb

/**
 * @author Loïc PAUL-JOSEPH.
 */
class AlbumRepositoryImpl(private val dao: PictureDao) : AlbumRepository {

    override fun getAll(): List<Picture> {
        var pictures: List<Picture> = emptyList()
        val picturesDb = dao.loadAll()
        if (picturesDb.isNotEmpty()) {
            pictures = picturesDb.map { it.toCommonData() }
        } else {
            val response = RestClient.createService(AlbumService::class.java).fetchAll().execute()
            if (response.isSuccessful && response.body() != null) {
                pictures = response.body()!!
                insert(pictures)
            }
        }
        return pictures
    }

    override fun insert(pictures: List<Picture>) {
        val dataDb = pictures.map { PictureDb(it) }
        dao.insert(*dataDb.toTypedArray())
    }

}