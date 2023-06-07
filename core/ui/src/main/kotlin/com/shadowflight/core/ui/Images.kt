package com.shadowflight.core.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.shadowflight.core.ui.theme.AppTheme

// width/height positive ratio
const val ASPECT_RATIO_1_1 = 1f
const val ASPECT_RATIO_6_5 = 6f / 5f // 0.83
const val ASPECT_RATIO_4_3 = 4f / 3f // 0.75
const val ASPECT_RATIO_10_7 = 10f / 7f // 0.7
const val ASPECT_RATIO_16_9 = 16f / 9f // 0.56
const val ASPECT_RATIO_10_5 = 10f / 5f // 0.5
const val ASPECT_RATIO_10_4 = 10f / 4f // 0.4

@Composable
fun AppImagePottedPlant2(
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.colors.illustration
) {
    AppImageTinted(
        modifier = modifier,
        drawableRes = R.drawable.ic_potted_plant_2,
        drawableResTint = R.drawable.ic_potted_plant_2_tint,
        tint = tint,
    )
}

@Composable
private fun AppImageTinted(
    modifier: Modifier = Modifier,
    @DrawableRes drawableRes: Int,
    @DrawableRes drawableResTint: Int,
    tint: Color
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(drawableResTint),
            colorFilter = ColorFilter.tint(tint),
            contentDescription = null,
        )
        Image(
            painter = painterResource(drawableRes),
            contentDescription = null
        )
    }
}
