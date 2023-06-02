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
 * @param bookmarked 
 */
@JsonClass(generateAdapter = true)
data class UpdateBookmarkDTO(

    @Json(name = "contentId")
    val contentId: ContentIdDTO,

    @Json(name = "contentType")
    val contentType: UpdateBookmarkDTO.ContentType,

    @Json(name = "bookmarked")
    val bookmarked: kotlin.Boolean
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
}

