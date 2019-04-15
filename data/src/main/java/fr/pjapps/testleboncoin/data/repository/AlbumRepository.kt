package fr.pjapps.testleboncoin.data.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import fr.pjapps.testleboncoin.data.database.entity.PictureDb

/**
 * @author Loïc PAUL-JOSEPH.
 */
interface AlbumRepository {

    @WorkerThread
    fun getAll(): LiveData<List<PictureDb>>

    @WorkerThread
    fun insert(pictures: List<PictureDb>)

}