package hu.bme.aut.android.kimiquotes.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(
    @PrimaryKey val id: Int,
    val quote: String,
    val year: Int,
    val favourite: Boolean
)
