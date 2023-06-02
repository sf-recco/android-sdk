/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package com.shadowflight.openapi.model

import com.shadowflight.openapi.model.ContentIdDTO
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param contentId 
 * @param contentType 
 * @param rating 
 */
@JsonClass(generateAdapter = true)
data class UpdateRatingDTO(

    @Json(name = "contentId")
    val contentId: ContentIdDTO,

    @Json(name = "contentType")
    val contentType: UpdateRatingDTO.ContentType,

    @Json(name = "rating")
    val rating: UpdateRatingDTO.Rating
) {
    /**
     * 
     *
     * Values: ARTICLES
     */
    @JsonClass(generateAdapter = false)
    enum class ContentType(val value: kotlin.String) {
        @Json(name = "articles") ARTICLES("articles");
    }
    /**
     * 
     *
     * Values: LIKE,DISLIKE,NOT_RATED
     */
    @JsonClass(generateAdapter = false)
    enum class Rating(val value: kotlin.String) {
        @Json(name = "like") LIKE("like"),
        @Json(name = "dislike") DISLIKE("dislike"),
        @Json(name = "not_rated") NOT_RATED("not_rated");
    }
}

