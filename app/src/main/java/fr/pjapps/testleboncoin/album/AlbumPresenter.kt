package fr.pjapps.testleboncoin.album

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import fr.pjapps.testleboncoin.data.apiclient.model.Picture
import fr.pjapps.testleboncoin.data.database.entity.PictureDb
import fr.pjapps.testleboncoin.data.repository.AlbumRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

/**
 * @author Loïc PAUL-JOSEPH.
 */
class AlbumPresenter(
    private var view: AlbumContract.View?,
    private val repository: AlbumRepository
) : AlbumContract.Presenter {

    override val job: Job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    private var allAlbumDb: LiveData<List<PictureDb>>? = null
    lateinit var allAlbum: LiveData<List<Picture>>

    override fun fetchAllAlbum() {
        launch {
            if (allAlbumDb == null) {
                allAlbumDb = repository.getAll()
                allAlbumDb?.let { data ->
                    allAlbum = Transformations.map(data) {
                        it.map { pictureDb -> pictureDb.toCommonData() }
                    }
                }
            }
            withContext(Dispatchers.Main) { view?.showAlbum(allAlbum) }
        }
    }

    override fun start() {
        fetchAllAlbum()
    }

    override fun stop() {
        view = null
        job.cancel()
    }

}