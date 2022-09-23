package cbassdagreat.github.boardgamesboji.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cbassdagreat.github.boardgamesboji.dao.BojiItemDao
import cbassdagreat.github.boardgamesboji.model.ListaBojiItem

@Database(entities = [ListaBojiItem::class], version = 1)
abstract class ProyectoDB : RoomDatabase(){

    abstract fun gameItem() : BojiItemDao

    companion object{
        @Volatile
        private var instance:ProyectoDB? = null

        fun getInstance(context:Context) : ProyectoDB
        {
            if (instance==null)
            {
                synchronized(this)
                {
                    instance=Room.databaseBuilder(context,ProyectoDB::class.java,"project_db").build()
                }
            }
            return instance!!
        }
    }
}