package com.example.taller2app.utils

import android.media.session.MediaSession
import android.net.Uri
import java.net.URL

class NetworkUtilities{


    companion object{
        const val BASE_URL = "http://localhost/"
        const val PATH_COIN = "coin"

        fun buildURL(id: String) = URL(
            Uri.parse(BASE_URL)
            .buildUpon()
            .appendPath(PATH_COIN)
            .appendPath(id)
            .build().toString()
        )

        fun buildURL() = URL(
            Uri.parse(BASE_URL)
            .buildUpon()
            .build().toString()
        )
        /*
        fun getHTTPResult(url: URL) = url.openConnection()
            .addRequestProperty("Authoization", "Bear ${Token}")
            */
        fun getHTTPResult(url: URL) = url.readText()

    }
}