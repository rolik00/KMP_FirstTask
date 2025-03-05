package com.example.kmp_firsttask

import kotlin.random.Random

class CommonLogic {
    private var value = 0

    fun increment(): Int{
        value++
        return value
    }

    fun decrement(): Int{
        value--
        return value
    }

    fun random(): Int{
        value = Random.nextInt(0, 100)
        return value
    }
}