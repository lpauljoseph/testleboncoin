package fr.pjapps.testleboncoin.album

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import fr.pjapps.testleboncoin.core.BasePresenter
import fr.pjapps.testleboncoin.core.BaseView
import fr.pjapps.testleboncoin.data.apiclient.model.Picture

/**
 * @author Loïc PAUL-JOSEPH.
 */
interface AlbumContract {

    interface View : BaseView<Presenter> {
        fun showAlbum(pictures: LiveData<List<Picture>>)
    }

    interface Presenter : BasePresenter {
        @MainThread
        fun fetchAllAlbum()
    }
}