package com.piotrapps.domain.usecase

import com.piotrapps.domain.model.BootItem
import com.piotrapps.domain.repository.BootRepository
import javax.inject.Inject

class SaveBootDateUseCase @Inject constructor(
    private val bootRepository: BootRepository
) {
    suspend operator fun invoke(bootItem: BootItem) {
        bootRepository.saveBootItem(bootItem)
    }

}