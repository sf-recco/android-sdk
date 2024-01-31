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

package com.recco.internal.core.openapi.model

import com.recco.internal.core.openapi.model.ContentIdDTO
import com.recco.internal.core.openapi.model.ContentTypeDTO
import com.recco.internal.core.openapi.model.RatingDTO
import com.recco.internal.core.openapi.model.StatusDTO
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param id 
 * @param type 
 * @param rating 
 * @param status 
 * @param bookmarked 
 * @param headline 
 * @param imageUrl 
 * @param imageAlt 
 * @param duration The estimated duration in seconds to consume this content
 * @param dynamicImageResizingUrl Responsive image url. Supports transformation via query params. Allowed query params key=values width=number, height=number, quality=1..100, format=auto|jgp|png|webp|tiff, fit=cover|contain|inside|outside
 */
@JsonClass(generateAdapter = true)
data class AppUserRecommendationDTO(

    @Json(name = "id")
    val id: ContentIdDTO,

    @Json(name = "type")
    val type: ContentTypeDTO,

    @Json(name = "rating")
    val rating: RatingDTO,

    @Json(name = "status")
    val status: StatusDTO,

    @Json(name = "bookmarked")
    val bookmarked: kotlin.Boolean,

    @Json(name = "headline")
    val headline: kotlin.String,

    @Json(name = "imageUrl")
    val imageUrl: kotlin.String? = null,

    @Json(name = "imageAlt")
    val imageAlt: kotlin.String? = null,

    /* The estimated duration in seconds to consume this content */
    @Json(name = "duration")
    val duration: kotlin.Int? = null,

    /* Responsive image url. Supports transformation via query params. Allowed query params key=values width=number, height=number, quality=1..100, format=auto|jgp|png|webp|tiff, fit=cover|contain|inside|outside */
    @Json(name = "dynamicImageResizingUrl")
    val dynamicImageResizingUrl: kotlin.String? = null
)
