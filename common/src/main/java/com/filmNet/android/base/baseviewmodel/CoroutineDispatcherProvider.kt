package com.filmNet.android.base.baseviewmodel

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatcherProvider {
    fun bgDispatcher(): CoroutineDispatcher
    fun uiDispatcher(): CoroutineDispatcher
    fun ioDispatcher(): CoroutineDispatcher
    fun immediateDispatcher(): CoroutineDispatcher = uiDispatcher()

}
