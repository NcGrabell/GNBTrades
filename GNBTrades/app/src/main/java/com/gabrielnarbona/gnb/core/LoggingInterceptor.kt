package com.gabrielnarbona.gnb.core

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptor : Interceptor {

    private val httpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    override fun intercept(chain: Interceptor.Chain): Response =
        httpLoggingInterceptor.intercept(chain)
}