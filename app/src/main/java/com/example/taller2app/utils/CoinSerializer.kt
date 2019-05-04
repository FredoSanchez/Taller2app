package com.example.taller2app.utils

import com.example.taller2app.models.Coin
import org.json.JSONArray
import org.json.JSONObject

class CoinSerializer {
    companion object{
        fun parseCoins(coinsText: String): List<Coin>{
            var coinsJSON = JSONArray(coinsText)
            var coins:MutableList<Coin> = MutableList(coinsJSON.length()-1){
                parseCoin(coinsJSON[it].toString())
            }

            return coins
            //for (i in 0..coinsJSON.length()-1)
        }

        fun parseCoin(coinText: String): Coin{
            val coinJSON = JSONObject(coinText)
            return with(coinJSON){
                Coin(getString("name"), getDouble("value"))
            }

        }
    }
}