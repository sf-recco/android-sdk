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

import com.shadowflight.openapi.model.MultiChoiceAnswerOptionDTO
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param maxOptions 
 * @param minOptions 
 * @param options 
 */
@JsonClass(generateAdapter = true)
data class MultiChoiceQuestionDTO(

    @Json(name = "maxOptions")
    val maxOptions: kotlin.Int,

    @Json(name = "minOptions")
    val minOptions: kotlin.Int,

    @Json(name = "options")
    val options: kotlin.collections.List<MultiChoiceAnswerOptionDTO>
)
