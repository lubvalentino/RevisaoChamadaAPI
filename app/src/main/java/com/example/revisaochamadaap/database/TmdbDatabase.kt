package com.example.revisaochamadaap.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.revisaochamadaap.model.Result

object TmdbDatabase {
    //entities = todas as nossas classes que definimos como Entity
    //exportSchema = false => não exportar um arquivo físico
    @Database(entities = [Result::class], version = 1, exportSchema = false)
    abstract class TmdbRoomDatabase : RoomDatabase() {
        //tem que colocar para cada Dao
        abstract fun movieDao(): MovieDao
    }

    fun getDatabase(context: Context):TmdbRoomDatabase{
        return Room.databaseBuilder(
            context,
            TmdbRoomDatabase::class.java, "tmdb-db"
        ).build()
    }
}