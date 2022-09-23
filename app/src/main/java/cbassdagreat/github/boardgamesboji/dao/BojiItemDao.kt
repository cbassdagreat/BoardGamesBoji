package cbassdagreat.github.boardgamesboji.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cbassdagreat.github.boardgamesboji.model.ListaBoji
import cbassdagreat.github.boardgamesboji.model.BojiItem


@Dao
interface BojiItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun agregar(listaBoji: ListaBoji)

    @Query("select age, artist, description, designer, id, image, name, officialLink, players, playingTime, price, publisher, year from board_game")
    fun listar(): LiveData<List<BojiItem>>
}