package com.thelightphone.zork2

import androidx.compose.foundation.background
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.thelightphone.sdk.SimpleLightScreen
import com.thelightphone.sdk.SealedLightActivity
import com.thelightphone.sdk.rememberKeyboardOptions
import com.thelightphone.sdk.ui.*

/** Full-screen LP3 keyboard editor for a single Zork command. */
class ZorkInputScreen(
    sealedActivity: SealedLightActivity,
    private val initial: String,
) : SimpleLightScreen<String>(sealedActivity) {

    @Composable
    override fun Content() {
        val colors by LightThemeController.colors.collectAsState()
        val state = rememberTextFieldState(initial)
        val keyboardOptionsFlow = rememberKeyboardOptions()
        LightTheme(colors = colors) {
            LightTextInputEditor(
                title = "Command",
                state = state,
                keyboardOptionsFlow = keyboardOptionsFlow,
                onSubmit = { result: CharSequence -> goBack(result.toString().trim()) },
                onBack = { goBack(null) },
                modifier = Modifier.background(LightThemeTokens.colors.background),
            )
        }
    }
}
