package fr.pjapps.testleboncoin.di

import androidx.room.Room
import fr.pjapps.testleboncoin.album.AlbumContract
import fr.pjapps.testleboncoin.album.AlbumPresenter
import fr.pjapps.testleboncoin.data.database.AppDatabase
import fr.pjapps.testleboncoin.data.repository.AlbumRepository
import fr.pjapps.testleboncoin.data.repository.AlbumRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

/**
 * @author Loïc PAUL-JOSEPH.
 */

private val DATABASE_NAME = "leboncoin.db"

val databaseModule = module {

    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, DATABASE_NAME)
            .build()
    }

    single { get<AppDatabase>().pictureDao() }

}

val repositoryModule = module {
    single<AlbumRepository> { AlbumRepositoryImpl(get()) }
}

val presenterModule = module {
    single <AlbumContract.Presenter>{ (view:AlbumContract.View) -> AlbumPresenter(view, get()) }
}