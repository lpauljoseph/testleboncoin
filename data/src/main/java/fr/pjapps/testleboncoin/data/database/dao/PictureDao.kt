package fr.pjapps.testleboncoin.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.pjapps.testleboncoin.data.database.entity.PictureDb

/**
 * @author Loïc PAUL-JOSEPH.
 */
@Dao
interface PictureDao {

    @Query("SELECT * FROM pictures")
    fun loadAll(): List<PictureDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg pictures: PictureDb)
}