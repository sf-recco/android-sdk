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

package com.shadowflight.core.openapi.model

import com.shadowflight.core.openapi.model.MultiChoiceQuestionDTO
import com.shadowflight.core.openapi.model.NumericQuestionDTO
import com.shadowflight.core.openapi.model.QuestionAnswerTypeDTO
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param id 
 * @param index 
 * @param text 
 * @param type 
 * @param multiChoice 
 * @param numeric 
 */
@JsonClass(generateAdapter = true)
data class QuestionDTO(

    @Json(name = "id")
    val id: kotlin.String,

    @Json(name = "index")
    val index: kotlin.Int,

    @Json(name = "text")
    val text: kotlin.String,

    @Json(name = "type")
    val type: QuestionAnswerTypeDTO,

    @Json(name = "multiChoice")
    val multiChoice: MultiChoiceQuestionDTO? = null,

    @Json(name = "numeric")
    val numeric: NumericQuestionDTO? = null
)
