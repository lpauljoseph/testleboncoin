package fr.pjapps.testleboncoin.data.repository

import androidx.annotation.WorkerThread
import fr.pjapps.testleboncoin.data.apiclient.model.Picture

/**
 * @author Loïc PAUL-JOSEPH.
 */
interface AlbumRepository {

    @WorkerThread
    fun getAll() : List<Picture>

    @WorkerThread
    fun insert(pictures : List<Picture>)

}