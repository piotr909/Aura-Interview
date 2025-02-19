package di.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import db.BootDatabase
import db.dao.BootDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): BootDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            BootDatabase::class.java,
            "boot_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideBootDao(bootDatabase: BootDatabase): BootDao {
        return bootDatabase.bootDao
    }
}