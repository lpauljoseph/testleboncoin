package fr.pjapps.testleboncoin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.pjapps.testleboncoin.data.database.dao.PictureDao
import fr.pjapps.testleboncoin.data.database.entity.PictureDb

/**
 * @author Loïc PAUL-JOSEPH.
 */
@Database(entities = [PictureDb::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun pictureDao():PictureDao
}