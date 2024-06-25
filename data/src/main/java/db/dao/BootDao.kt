package db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import db.entity.BootEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BootDao {

    @Query("SELECT * FROM boot")
    fun loadBootItems(): Flow<List<BootEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(bootItem: BootEntity)
}