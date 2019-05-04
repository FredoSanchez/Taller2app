package com.example.taller2app

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.taller2app.models.Coin
import com.example.taller2app.utils.CoinSerializer
import com.example.taller2app.utils.NetworkUtilities
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    class CoinsFetch: AsyncTask<Unit, Unit, List<Coin>>(){
        override fun doInBackground(vararg params: Unit?): List<Coin> {
            val url = NetworkUtilities.buildURL()
            val resultString = NetworkUtilities.getHTTPResult(url)

            val resultJSON = JSONObject(resultString)

            return if (resultJSON.getBoolean("success")){
                CoinSerializer.parseCoins(
                    resultJSON.getJSONArray("docs").toString()
                )
            }else{
                listOf<Coin>()
            }
        }
    }

}

