package com.piotrapps.aurainterview.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.piotrapps.domain.model.BootItem
import com.piotrapps.domain.usecase.SaveBootDateUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject


@AndroidEntryPoint
class BootCompleteReceiver : BroadcastReceiver() {

    @Inject
    lateinit var saveBootDateUseCase: SaveBootDateUseCase

    override fun onReceive(context: Context, intent: Intent) {
        CoroutineScope(Dispatchers.IO).launch {
            saveBootDateUseCase(BootItem(Date()))
        }
    }
}