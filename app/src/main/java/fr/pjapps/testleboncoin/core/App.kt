package fr.pjapps.testleboncoin.core

import android.app.Application
import fr.pjapps.testleboncoin.di.databaseModule
import fr.pjapps.testleboncoin.di.presenterModule
import fr.pjapps.testleboncoin.di.repositoryModule
import org.koin.android.ext.android.startKoin

/**
 * @author Loïc PAUL-JOSEPH.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(databaseModule, repositoryModule, presenterModule)
        )
    }
}
