package com.shadowflight.uicommons.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.shadowflight.model.recommendation.Rating
import com.shadowflight.model.recommendation.Recommendation
import com.shadowflight.model.recommendation.Status

class RecommendationPreviewProvider : PreviewParameterProvider<Recommendation> {
    override val values get() = sequenceOf(data)

    companion object {
        val data
            get() = Recommendation(
                id = ContentPreviewProvider.data,
                rating = Rating.LIKE,
                status = Status.VIEWED,
                headline = "Some headline",
                lead = "Some lead",
                imageUrl = null
            )
    }
}