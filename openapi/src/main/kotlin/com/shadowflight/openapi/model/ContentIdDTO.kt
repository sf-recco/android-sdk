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

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param itemId 
 * @param catalogId 
 */
@JsonClass(generateAdapter = true)
data class ContentIdDTO(

    @Json(name = "itemId")
    val itemId: kotlin.String,

    @Json(name = "catalogId")
    val catalogId: kotlin.String
)
