package di.repository

import com.piotrapps.domain.repository.BootRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import db.dao.BootDao
import db.repository.BootRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideBootRepository(bootDao: BootDao): BootRepository {
        return BootRepositoryImpl(bootDao)
    }
}