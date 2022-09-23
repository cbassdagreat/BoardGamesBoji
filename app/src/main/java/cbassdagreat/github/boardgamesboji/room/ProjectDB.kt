package cbassdagreat.github.boardgamesboji.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cbassdagreat.github.boardgamesboji.dao.BojiItemDao
import cbassdagreat.github.boardgamesboji.model.BojiItem

@Database(entities = [BojiItem::class], version = 1)
abstract class ProjectDB : RoomDatabase(){

    abstract fun gameItem() : BojiItemDao

    companion object{
        @Volatile
        private var instance:ProjectDB? = null

        fun getInstance(context:Context) : ProjectDB
        {
            if (instance==null)
            {
                synchronized(this)
                {
                    instance=Room.databaseBuilder(context,ProjectDB::class.java,"project_db").build()
                }
            }
            return instance!!
        }
    }
}