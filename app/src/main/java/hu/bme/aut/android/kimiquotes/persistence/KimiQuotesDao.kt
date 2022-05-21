package hu.bme.aut.android.kimiquotes.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface KimiQuotesDao {
    @Query("SELECT * FROM quote")
    fun getAll(): List<Quote>

    @Query("SELECT * FROM quote WHERE favourite = '1'")
    fun getFavourites(): List<Quote>

    @Insert
    fun insertAll(vararg quotes: Quote)

    @Query("DELETE FROM quote")
    fun deleteAll()
}