package fr.pjapps.testleboncoin.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import fr.pjapps.testleboncoin.data.apiclient.RestClient
import fr.pjapps.testleboncoin.data.apiclient.service.AlbumService
import fr.pjapps.testleboncoin.data.database.dao.PictureDao
import fr.pjapps.testleboncoin.data.database.entity.PictureDb

/**
 * @author Loïc PAUL-JOSEPH.
 */
class AlbumRepositoryImpl(private val dao: PictureDao) : AlbumRepository {

    override fun getAll(): LiveData<List<PictureDb>> {
        var pictures: LiveData<List<PictureDb>> = MutableLiveData<List<PictureDb>>()
        val count = dao.countAll()
        if (count > 0) {
            pictures = dao.loadAll()
        } else {
            val response = RestClient.createService(AlbumService::class.java).fetchAll().execute()
            if (response.isSuccessful && response.body() != null) {
                val temp = response.body()!!
                insert(temp.map { PictureDb(it) })
                pictures = dao.loadAll()
            }
        }
        return pictures
    }

    override fun insert(pictures: List<PictureDb>) {
        dao.insert(*pictures.toTypedArray())
    }

}