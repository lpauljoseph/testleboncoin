package fr.pjapps.testleboncoin.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.pjapps.testleboncoin.R
import fr.pjapps.testleboncoin.album.AlbumContract
import fr.pjapps.testleboncoin.data.apiclient.model.Picture
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity(), AlbumContract.View {


    override val presenter: AlbumContract.Presenter by inject { parametersOf(this) }
    private val adapter: PictureAdapter by lazy { PictureAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }

    override fun showAlbum(pictures: List<Picture>) {
        adapter(pictures)
    }
}
