package com.shadowflight.core.ui

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.drawablepainter.rememberDrawablePainter
import com.shadowflight.core.ui.theme.AppTheme

// width/height positive ratio
const val ASPECT_RATIO_1_1 = 1f
const val ASPECT_RATIO_6_5 = 6f / 5f // 0.83
const val ASPECT_RATIO_4_3 = 4f / 3f // 0.75
const val ASPECT_RATIO_10_7 = 10f / 7f // 0.7
const val ASPECT_RATIO_16_9 = 16f / 9f // 0.56
const val ASPECT_RATIO_10_5 = 10f / 5f // 0.5
const val ASPECT_RATIO_10_4 = 10f / 4f // 0.4


/**
 * @param data This can be a URL, a [painterResource], a [java.io.File], ...
 * @param placeholderRes Used for error and fallback states if [placeholderContent] is null. Not use both.
 * @param placeholderContent Used for error and fallback states if [placeholderRes] is null. Not use both.
 * @param loadingAnimationDrawable Used for loading state if [loadingContent] is null. Not use both.
 * @param loadingContent Used for loading state if [loadingAnimationDrawable] is null. Not use both.
 * @param contentScale
 * @param aspectRatio Width/Height, i.e: 16f/9f, ASPECT_RATIO_16_9
 * @param onStateChange Useful for example if you need to get for example the size of the image loaded.
 */
@Composable
fun AsyncImageAdjustedViewBounds(
    modifier: Modifier,
    data: Any?,
    @DrawableRes placeholderRes: Int? = R.drawable.bg_image_placeholder,
    placeholderContent: (@Composable () -> Unit)? = null,
    loadingAnimationDrawable: AnimationDrawable? = loadingAnimationDrawable(),
    loadingContent: (@Composable () -> Unit)? = null,
    contentScale: ContentScale = ContentScale.Crop,
    aspectRatio: Float? = null,
    onStateChange: (AsyncImagePainter.State) -> Unit = {},
) {
    Box {
        if (data == null && placeholderContent != null) {
            placeholderContent()
        } else {
            val placeholderPainter = placeholderRes?.let { painterResource(it) }
                .takeIf { placeholderContent == null }

            val painter = rememberAsyncImagePainter(
                model = data,
                contentScale = contentScale,
                error = placeholderPainter,
                fallback = placeholderPainter,
            )

            val state = painter.state
            onStateChange(state)

            Image(
                painter = painter,
                contentScale = contentScale,
                contentDescription = null,
                modifier = modifier.let {
                    if (aspectRatio != null) it.aspectRatio(aspectRatio)
                    else it
                },
            )

            when (state) {
                AsyncImagePainter.State.Empty -> Unit
                is AsyncImagePainter.State.Loading -> {
                    if (loadingAnimationDrawable == null) {
                        loadingContent?.invoke()
                    } else {
                        Image(
                            modifier = modifier,
                            painter = rememberDrawablePainter(loadingAnimationDrawable),
                            contentScale = ContentScale.Crop,
                            contentDescription = null,
                        )
                    }
                }
                is AsyncImagePainter.State.Success -> Unit
                is AsyncImagePainter.State.Error -> {
                    if (placeholderRes == null) {
                        placeholderContent?.invoke()
                    }
                }
            }
        }
    }
}

@Composable
fun loadingAnimationDrawable() = loadingAnimationDrawable(
    context = LocalContext.current,
    loadingResImages = listOf(
        R.drawable.bg_loading_1,
        R.drawable.bg_loading_2,
        R.drawable.bg_loading_3,
        R.drawable.bg_loading_4,
        R.drawable.bg_loading_5,
        R.drawable.bg_loading_6,
        R.drawable.bg_loading_7,
    )
)

@Composable
fun loadingCardAnimationDrawable() = loadingAnimationDrawable(
    context = LocalContext.current,
    loadingResImages = listOf(
        R.drawable.bg_loading_card_1,
        R.drawable.bg_loading_card_2,
        R.drawable.bg_loading_card_3,
        R.drawable.bg_loading_card_4,
        R.drawable.bg_loading_card_5,
        R.drawable.bg_loading_card_6,
        R.drawable.bg_loading_card_7,
    )
)

private fun loadingAnimationDrawable(
    context: Context,
    loadingResImages: List<Int>
): AnimationDrawable {
    val animationDrawable = AnimationDrawable()
    val durationTransition = (400..1000).random()

    loadingResImages.shuffled().forEach { imageRes ->
        ContextCompat.getDrawable(context, imageRes)?.let { drawable ->
            animationDrawable.addFrame(drawable, durationTransition)
            animationDrawable.setEnterFadeDuration(durationTransition)
            animationDrawable.setExitFadeDuration(durationTransition)
        }
    }

    return animationDrawable
}

@Composable
fun AppTintedImagePottedPlant2(
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.colors.illustration
) {
    AppTintedImage(
        modifier = modifier,
        drawableRes = R.drawable.ic_potted_plant_2,
        drawableResTint = R.drawable.ic_potted_plant_2_tint,
        tint = tint,
    )
}

@Composable
fun AppTintedImageApple(
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.colors.illustration
) {
    AppTintedImage(
        modifier = modifier,
        drawableRes = R.drawable.ic_apple,
        drawableResTint = R.drawable.ic_apple_tint,
        tint = tint,
    )
}

@Composable
fun AppTintedImageNoConnection(
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.colors.illustration
) {
    AppTintedImage(
        modifier = modifier,
        drawableRes = R.drawable.ic_no_connection, // FIXME
        drawableResTint = R.drawable.ic_no_connection_tint,
        tint = tint,
    )
}

@Composable
fun AppTintedImagePeopleDigital(
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.colors.illustration
) {
    AppTintedImage(
        modifier = modifier,
        drawableRes = R.drawable.ic_people_digital, // FIXME
        drawableResTint = R.drawable.ic_people_digital_tint,
        tint = tint,
    )
}

@Composable
fun AppTintedImageRidingBike(
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.colors.illustration
) {
    AppTintedImage(
        modifier = modifier,
        drawableRes = R.drawable.ic_riding_bike, // FIXME
        drawableResTint = R.drawable.ic_riding_bike_tint,
        tint = tint,
    )
}

@Composable
fun AppTintedImageAboutYou(
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.colors.illustration
) {
    AppTintedImage(
        modifier = modifier,
        drawableRes = R.drawable.ic_about_you, // FIXME
        drawableResTint = R.drawable.ic_about_you_tint,
        tint = tint,
    )
}

@Composable
fun AppTintedImagePortrait1(
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.colors.illustration
) {
    AppTintedImage(
        modifier = modifier,
        drawableRes = R.drawable.ic_portrait_1, // FIXME
        drawableResTint = R.drawable.ic_portrait_1_tint,
        tint = tint,
    )
}

@Composable
fun AppTintedImagePortrait2(
    modifier: Modifier = Modifier,
    tint: Color = AppTheme.colors.illustration
) {
    AppTintedImage(
        modifier = modifier,
        drawableRes = R.drawable.ic_portrait_2, // FIXME
        drawableResTint = R.drawable.ic_portrait_2_tint,
        tint = tint,
    )
}

@Composable
private fun AppTintedImage(
    modifier: Modifier = Modifier,
    @DrawableRes drawableRes: Int,
    @DrawableRes drawableResTint: Int,
    tint: Color
) {
    Box(
        modifier = modifier
            .width(IntrinsicSize.Min)
            .height(IntrinsicSize.Min)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(drawableResTint),
            colorFilter = ColorFilter.tint(tint),
            contentDescription = null,
        )
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(drawableRes),
            contentDescription = null
        )
    }
}

@Preview
@Composable
private fun PreviewAppTintedImagePottedPlant2() {
    Column {
        AppTintedImagePottedPlant2()
        AppTintedImagePottedPlant2(tint = AppTheme.colors.error)
    }
}

@Preview
@Composable
private fun PreviewAppTintedImageApple() {
    Column {
        AppTintedImageApple()
        AppTintedImageApple(tint = AppTheme.colors.error)
    }
}