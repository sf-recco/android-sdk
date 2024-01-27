@file:UnstableApi package com.recco.internal.feature.media.player

import android.view.View
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.media3.common.util.UnstableApi
import androidx.media3.ui.PlayerView
import com.recco.internal.core.media.MediaPlayerState
import com.recco.internal.core.media.rememberMediaPlayerStateWithLifecycle
import com.recco.internal.core.model.media.Audio
import com.recco.internal.core.model.recommendation.Rating
import com.recco.internal.core.ui.R
import com.recco.internal.core.ui.components.AppAsyncImage
import com.recco.internal.core.ui.components.AppScreenStateAware
import com.recco.internal.core.ui.components.AppTopBar
import com.recco.internal.core.ui.components.AppTopBarDefaults
import com.recco.internal.core.ui.components.BackIconButton
import com.recco.internal.core.ui.components.UiState
import com.recco.internal.core.ui.components.UserInteractionRecommendation
import com.recco.internal.core.ui.components.UserInteractionRecommendationCard
import com.recco.internal.core.ui.theme.AppSpacing
import com.recco.internal.core.ui.theme.AppTheme
import com.recco.internal.feature.media.description.MediaDescriptionUi
import com.recco.internal.feature.media.description.MediaDescriptionViewModel
import com.recco.internal.feature.media.description.preview.MediaDescriptionUiPreviewProvider
import kotlinx.coroutines.launch

@Composable
internal fun FullMediaPlayerRoute(
    navigateUp: () -> Unit,
    viewModel: MediaDescriptionViewModel = hiltViewModel()
) {
    val uiState by viewModel.viewState.collectAsStateWithLifecycle(
        initialValue = UiState()
    )

    FullMediaPlayerScreen(
        navigateUp = navigateUp,
        uiState = uiState,
        onUserInteract = {

        }
    )
}

@Composable
private fun FullMediaPlayerScreen(
    navigateUp: () -> Unit,
    uiState: UiState<MediaDescriptionUi>,
    onUserInteract: (FullMediaPlayerUserInteract) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(AppTheme.colors.background)
    ) {
        AppScreenStateAware(
            uiState = uiState,
            retry = { onUserInteract(FullMediaPlayerUserInteract.Retry) },
            isFloatingFooter = true,
            footerContent = {
                UserInteractionRecommendationCard(
                    modifier = Modifier.padding(bottom = AppSpacing.dp_24),
                    userInteraction = UserInteractionRecommendation(
                        rating = Rating.DISLIKE,
                        isBookmarked = false,
                        isBookmarkLoading = false,
                        isLikeLoading = false,
                        isDislikeLoading = false
                    ),
                    toggleBookmarkState = { TODO() },
                    toggleLikeState = { TODO() },
                    toggleDislikeState = { TODO() }
                )
            }

        ) {
            if (uiState.data != null) {
                MediaPlayerContent(checkNotNull(uiState.data))
            }
        }

        AppTopBar(
            title = null,
            elevation = 0.dp,
            navigationIcon = {
                BackIconButton(
                    onClick = navigateUp,
                    iconTint = Color.White
                )
            },
            backgroundColor = Color.Transparent,
            actions = { },
        )
    }
}

@Composable
private fun MediaPlayerContent(uiState: MediaDescriptionUi) {
    Box {
        val playerState = when (uiState) {
            is MediaDescriptionUi.AudioDescriptionUi ->
                rememberMediaPlayerStateWithLifecycle(media = uiState.audio)
            is MediaDescriptionUi.VideoDescriptionUi ->
                rememberMediaPlayerStateWithLifecycle(media = uiState.video)

        }
        var isPlayButtonShown by remember { mutableStateOf(true) }
        var areControlsShown by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()

        LaunchedEffect(playerState.playerView) {
            scope.launch {
                playerState.playerView.setControllerVisibilityListener(
                    PlayerView.ControllerVisibilityListener { visibility ->
                        areControlsShown = visibility == View.VISIBLE
                    })
            }
        }

        MediaPlayer(
            playerState = playerState,
            modifier = Modifier.align(Alignment.Center)
        )

        if (uiState is MediaDescriptionUi.AudioDescriptionUi) {
            AnimatedVisibility(
                visible = !playerState.isPlaying,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                AudioImage(uiState.audio)
                DarkOverlay()
            }

            AnimatedVisibility(
                visible = areControlsShown || !playerState.isPlaying,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                AudioHeader()
            }

        }

        LaunchedEffect(key1 = Unit) {
            playerState.playerView.hideController()
        }

        val coroutineScope = rememberCoroutineScope()

        AnimatedVisibility(
            visible = !playerState.isPlaying,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.align(Alignment.Center)
        ) {
            PlayButton(
                onClick = {
                    playerState.play()
                    isPlayButtonShown = false

                    coroutineScope.launch {
                        playerState.playerView.showController()
                    }
                }
            )
        }
    }
}

@Composable
private fun AudioImage(audio: Audio) {
    audio?.imageUrl?.let {
        AppAsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            data = it,
            alt = audio.imageAlt,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
private fun MediaPlayer(
    playerState: MediaPlayerState,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { ctx ->
            playerState.playerView
        },
        modifier = modifier
            .fillMaxSize()
    )
}

@Composable
private fun DarkOverlay() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.6f))
    )
}

@Composable
private fun AudioHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(AppSpacing.dp_16),
        modifier = Modifier.fillMaxWidth()
    ) {

        Spacer(modifier = Modifier.height(AppTopBarDefaults.Height))

        Text(
            text = "Sleeping like a baby",
            style = AppTheme.typography.h1.copy(color = Color.White),
        )

        Text(
            text = "Audio • 1-5min",
            style = AppTheme.typography.labelSmall.copy(color = Color.White),
        )
    }
}

@Composable
private fun PlayButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    FloatingActionButton(
        onClick = {
            onClick.invoke()
        },
        backgroundColor = AppTheme.colors.accent,
        modifier = modifier
            .size(72.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.recco_ic_play),
            tint = Color.White,
            contentDescription = null
        )
    }
}


@Preview
@Composable
private fun VideoScreenPreview(
    @PreviewParameter(MediaDescriptionUiPreviewProvider::class) uiState: UiState<MediaDescriptionUi>
) {

    AppTheme {
        FullMediaPlayerScreen(
            navigateUp = {},
            uiState = uiState,
            onUserInteract = {}
        )
    }
}
