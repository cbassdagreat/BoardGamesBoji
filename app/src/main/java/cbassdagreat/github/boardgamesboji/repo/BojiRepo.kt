package cbassdagreat.github.boardgamesboji.repo

import android.content.Context
import androidx.lifecycle.LiveData
import cbassdagreat.github.boardgamesboji.model.ListaBoji
import cbassdagreat.github.boardgamesboji.model.BojiItem
import cbassdagreat.github.boardgamesboji.room.ProjectDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BojiRepo (var context: Context){

    private val db = ProjectDB.getInstance(context)

    fun agregar(lista:ListaBoji)
    {
        CoroutineScope(Dispatchers.IO).launch {
            db.gameItem().agregar(lista)
        }

    }

    fun listar() : LiveData<List<BojiItem>>
    {
        return db.gameItem().listar()
    }
}
