package com.thelightphone.zork2

import com.thelightphone.sdk.EntryPoint
import com.thelightphone.sdk.LightEntryPoint
import com.thelightphone.sdk.shared.LightServerData
import kotlinx.coroutines.flow.StateFlow

@EntryPoint
object Zork2EntryPoint : LightEntryPoint {
    // Zork II is fully offline — no server data or push notifications.
    override suspend fun onToolCreate(
        serverData: StateFlow<LightServerData?>,
    ) {
    }

    override suspend fun onPushNotification(
        data: ByteArray,
    ) {
    }
}
