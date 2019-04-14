package fr.pjapps.testleboncoin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.squareup.picasso.Picasso
import fr.pjapps.testleboncoin.R
import fr.pjapps.testleboncoin.data.apiclient.model.Picture
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_picture.*

/**
 * @author Loïc PAUL-JOSEPH.
 */
class PictureAdapter : Adapter<PictureAdapter.PictureVH>() {

    private val items: MutableList<Picture> = mutableListOf()

    operator fun invoke(pictures: List<Picture>) {
        items.clear()
        items.addAll(pictures)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureVH =
        PictureVH(
            LayoutInflater.from(parent.context).inflate(R.layout.item_picture, parent, false)
        )


    override fun onBindViewHolder(holder: PictureVH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class PictureVH(
        override val containerView: View
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: Picture) {
            title.text = item.title
            Picasso.get().load(item.thumbnailUrl).resize(150, 150).into(thumbnail)
        }
    }
}