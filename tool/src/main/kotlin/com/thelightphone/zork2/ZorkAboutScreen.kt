package com.thelightphone.zork2

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.thelightphone.sdk.SimpleLightScreen
import com.thelightphone.sdk.SealedLightActivity
import com.thelightphone.sdk.ui.*

/** About page for Zork II. */
class ZorkAboutScreen(
    sealedActivity: SealedLightActivity,
    private val restart: () -> Unit,
) : SimpleLightScreen<Unit>(sealedActivity) {

    @Composable
    override fun Content() {
        val colors by LightThemeController.colors.collectAsState()
        LightTheme(colors = colors) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(LightThemeTokens.colors.background),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clickable { goBack(null) },
                        contentAlignment = Alignment.CenterStart,
                    ) {
                        LightText(
                            text = "←",
                            variant = LightTextVariant.Paragraph,
                            modifier = Modifier.padding(start = 16.dp),
                        )
                    }
                    LightText(
                        text = AboutText.TITLE,
                        variant = LightTextVariant.Paragraph,
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentWidth(Alignment.CenterHorizontally),
                    )
                    Spacer(Modifier.weight(1f))
                }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 2f.gridUnitsAsDp(), vertical = 2f.gridUnitsAsDp()),
                ) {
                    Spacer(Modifier.height(1f.gridUnitsAsDp()))

                    sectionHeader("Story")
                    LightText(
                        text = AboutText.STORY,
                        variant = LightTextVariant.Copy,
                        align = TextAlign.Left,
                    )
                    Spacer(Modifier.height(1f.gridUnitsAsDp()))

                    sectionHeader("Attribution")
                    LightText(
                        text = AboutText.ATTRIBUTION,
                        variant = LightTextVariant.Copy,
                        align = TextAlign.Left,
                    )
                    Spacer(Modifier.height(1f.gridUnitsAsDp()))

                    sectionHeader("Save system")
                    LightText(
                        text = """Three numbered slots — type "save" in the game to write the current state to the next free slot, or tap the save icon in the top-left corner of the game screen.

Each slot keeps both the Z-machine state and the visible transcript, so reloading a slot shows the same screen you left.

Tap the Saves menu to browse, load, or delete individual slots.""",
                        variant = LightTextVariant.Copy,
                        align = TextAlign.Left,
                    )
                    Spacer(Modifier.height(2f.gridUnitsAsDp()))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(LightThemeTokens.colors.background),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { restart(); goBack(null) },
                            contentAlignment = Alignment.Center,
                        ) {
                            LightText(
                                text = "Restart",
                                variant = LightTextVariant.Paragraph,
                            )
                        }
                    }
                }

                LightText(
                    text = "Version ${AboutText.VERSION}",
                    variant = LightTextVariant.Fine,
                    align = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 2f.gridUnitsAsDp()),
                )
            }
        }
    }

    @Composable
    private fun sectionHeader(text: String) {
        LightText(
            text = text.uppercase(),
            variant = LightTextVariant.Fine,
            align = TextAlign.Start,
            modifier = Modifier.padding(top = 2f.gridUnitsAsDp(), bottom = 0.5f.gridUnitsAsDp()),
        )
    }
}
