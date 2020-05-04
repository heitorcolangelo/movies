package com.heitorcolangelo.data.factory

import java.util.*

interface MockFactory<T> {
    fun make(): T

    fun makeList(elements: Int): List<T> {
        return mutableListOf<T>().also { list ->
            repeat(elements) {
                list.add(make())
            }
        }
    }

    fun randomId(): String {
        return UUID.randomUUID().toString()
    }

    fun randomString(): String {
        return UUID.randomUUID().toString()
    }

    fun randomBoolean(): Boolean {
        return Math.random() < 0.5
    }
}
