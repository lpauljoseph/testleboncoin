package fr.pjapps.testleboncoin.album

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

    override fun fetchAllAlbum() {
        launch {
            val pictures = repository.getAll()
            withContext(Dispatchers.Main) {
                view?.showAlbum(pictures)
            }
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