package db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import db.converters.DateConverter
import db.dao.BootDao
import db.entity.BootEntity

@Database(entities = [BootEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class BootDatabase: RoomDatabase() {
    abstract val bootDao: BootDao
}