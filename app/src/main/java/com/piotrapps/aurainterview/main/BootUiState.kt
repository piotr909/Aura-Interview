package com.piotrapps.aurainterview.main

data class BootUiState(
    val bootTimes: List<String>,
    val allowedDismissalsCount: Int = 5,
    val allowedDismissalInterval: Int = 20
)