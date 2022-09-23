package cbassdagreat.github.boardgamesboji.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import cbassdagreat.github.boardgamesboji.model.ListaBoji
import cbassdagreat.github.boardgamesboji.repo.BojiRepo
import cbassdagreat.github.boardgamesboji.repo.ClienteRepo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BojiViewModel(application: Application) : AndroidViewModel(application){

    private val clienteRepo = ClienteRepo()
    private val bojiRepo = BojiRepo(getApplication())
    private val log = "ERROR_CALL"

    val listaBoji = bojiRepo.listar()

    fun callBojiItem()
    {
        clienteRepo.getBoji().enqueue(object :Callback<ListaBoji >{
            override fun onResponse(call: Call<ListaBoji>, response: Response<ListaBoji>) {
                response.body().let{
                    bojiRepo.agregar(it!!)
                }
            }

            override fun onFailure(call: Call<ListaBoji>, t: Throwable) {
                Log.e(log,t.message.toString())
            }

        })
    }

}