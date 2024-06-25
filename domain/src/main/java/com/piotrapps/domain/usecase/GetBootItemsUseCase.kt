package com.piotrapps.domain.usecase

import com.piotrapps.domain.model.BootItem
import com.piotrapps.domain.repository.BootRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBootItemsUseCase @Inject constructor(
    private val bootRepository: BootRepository
) {

    suspend operator fun invoke(): Flow<List<BootItem>> {
        return bootRepository.getBootItems()
    }
}