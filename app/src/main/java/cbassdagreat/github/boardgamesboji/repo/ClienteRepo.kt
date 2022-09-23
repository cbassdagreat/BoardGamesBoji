package cbassdagreat.github.boardgamesboji.repo

import cbassdagreat.github.boardgamesboji.client.ClientRetrofit
import cbassdagreat.github.boardgamesboji.model.ListaBoji
import retrofit2.Call

class ClienteRepo {

    private val cliente = ClientRetrofit.getInstancia(ClientRetrofit.base_url)

    fun getBoji(): Call<ListaBoji>
    {
        return cliente.getGames()
    }
}