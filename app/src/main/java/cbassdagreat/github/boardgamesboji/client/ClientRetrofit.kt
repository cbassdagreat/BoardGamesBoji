package cbassdagreat.github.boardgamesboji.client

import cbassdagreat.github.boardgamesboji.service.BojiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientRetrofit {

    companion object{
        const val base_url ="https://board-games-fake-api.herokuapp.com/"
        private var cliente: Retrofit? = null

        fun getInstancia(url: String):BojiService{
            if(cliente == null)
            {
                cliente = Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return cliente!!.create(BojiService::class.java)

        }
    }
}