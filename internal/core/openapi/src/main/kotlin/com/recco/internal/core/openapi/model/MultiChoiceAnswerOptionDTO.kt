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

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 *
 *
 * @param id
 * @param text
 */
@JsonClass(generateAdapter = true)
data class MultiChoiceAnswerOptionDTO(

    @Json(name = "id")
    val id: kotlin.Int,

    @Json(name = "text")
    val text: kotlin.String
)
