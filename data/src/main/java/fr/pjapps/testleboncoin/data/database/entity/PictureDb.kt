package fr.pjapps.testleboncoin.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import fr.pjapps.testleboncoin.data.apiclient.model.Picture

/**
 * @author Loïc PAUL-JOSEPH.
 */
@Entity(tableName = "pictures")
class PictureDb(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(index = true)
    val albumId: Long,
    val title: String = "",
    val url: String = "",
    val thumbnailUrl: String = ""
) {

    constructor(picture: Picture) : this(
        picture.id,
        picture.albumId,
        picture.title ?: "",
        picture.url ?: "",
        picture.thumbnailUrl ?: ""
    )

    fun toCommonData(): Picture = Picture(id, albumId, title, url, thumbnailUrl)


}