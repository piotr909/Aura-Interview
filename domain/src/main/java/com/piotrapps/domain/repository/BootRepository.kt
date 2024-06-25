package com.piotrapps.domain.repository

import com.piotrapps.domain.model.BootItem
import kotlinx.coroutines.flow.Flow

interface BootRepository {

    suspend fun getBootItems(): Flow<List<BootItem>>

    suspend fun saveBootItem(bootItem: BootItem)
}