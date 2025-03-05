package com.example.kmp_firsttask

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform