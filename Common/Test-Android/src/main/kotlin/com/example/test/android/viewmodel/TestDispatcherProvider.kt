package com.example.test.android.viewmodel

import com.heitorcolangelo.domain.common.providers.DispatcherProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher

@ExperimentalCoroutinesApi
object TestDispatcherProvider : DispatcherProvider {
    override fun io() = TestCoroutineDispatcher()

    override fun ui() = TestCoroutineDispatcher()
}
