package com.recco.internal.feature.media.description

import com.recco.internal.core.model.media.Audio
import com.recco.internal.core.model.media.Video
import com.recco.internal.core.model.recommendation.ContentId
import com.recco.internal.core.model.recommendation.ContentType
import com.recco.internal.core.model.recommendation.TrackItem
import com.recco.internal.feature.media.asTrackItem

sealed class MediaDescriptionUi(
    val contentId: ContentId,
    val imageUrl: String?,
    val imageAlt: String?,
) {
    data class VideoDescriptionUi(
        val video: Video,
    ): MediaDescriptionUi(
        contentId = video.id,
        imageAlt = video.imageAlt,
        imageUrl = video.imageUrl
    )

    data class AudioDescriptionUi(
        val audio: Audio,
    ): MediaDescriptionUi(
        contentId = audio.id,
        imageAlt = audio.imageAlt,
        imageUrl = audio.imageUrl
    )

    val contentType: ContentType
        get() = when {
            this is AudioDescriptionUi -> ContentType.AUDIO
            this is VideoDescriptionUi -> ContentType.VIDEO
            else -> error("Non supported ContentType: $this, for MediaDescriptionUi")
        }

    val trackItem: TrackItem
        get() = when(this) {
            is AudioDescriptionUi -> audio.asTrackItem()
            is VideoDescriptionUi -> video.asTrackItem()
        }
}
