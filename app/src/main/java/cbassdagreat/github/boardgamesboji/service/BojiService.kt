package cbassdagreat.github.boardgamesboji.service

import cbassdagreat.github.boardgamesboji.model.Boji
import retrofit2.Call
import retrofit2.http.GET

interface BojiService {

    @GET("board_games")
    fun getGames(): Call<Boji>
}