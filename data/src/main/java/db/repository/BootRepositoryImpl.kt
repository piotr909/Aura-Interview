package db.repository

import com.piotrapps.domain.model.BootItem
import com.piotrapps.domain.repository.BootRepository
import db.dao.BootDao
import db.mapper.toDomain
import db.mapper.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class BootRepositoryImpl(private val bootDao: BootDao) :
    BootRepository {
    override suspend fun getBootItems(): Flow<List<BootItem>> {
        return bootDao.loadBootItems()
            .map { list ->
                list.map { it.toDomain() }
            }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun saveBootItem(bootItem: BootItem) {
        bootDao.insert(bootItem.toEntity())
    }
}