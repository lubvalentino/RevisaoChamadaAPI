package com.example.revisaochamadaap.database

import androidx.room.*
import com.example.revisaochamadaap.model.Result

//vai fazer todas as operações na tabela
@Dao
interface MovieDao {
    //mostrar a sua tabela criada inteira
    @Query("SELECT * FROM movies")
    suspend fun getAllMovies(): List<Result>

    //onConflict => tratar conflitos ao inserir,
    // nesse caso ele vai atualizar se achar um arquivo que já existe
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllMovies(movies: List<Result>)


}