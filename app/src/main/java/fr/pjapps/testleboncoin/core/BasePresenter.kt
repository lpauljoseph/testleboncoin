package fr.pjapps.testleboncoin.core

import androidx.annotation.MainThread
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

/**
 * @author Loïc PAUL-JOSEPH.
 */
interface BasePresenter : CoroutineScope {

    val job: Job

    @MainThread
    fun start()

    @MainThread
    fun stop()
}