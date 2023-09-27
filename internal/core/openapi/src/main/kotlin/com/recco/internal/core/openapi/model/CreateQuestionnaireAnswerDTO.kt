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

import com.recco.internal.core.openapi.model.QuestionAnswerTypeDTO
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * 
 *
 * @param questionnaireId 
 * @param questionId 
 * @param type 
 * @param multichoice 
 * @param numeric 
 */
@JsonClass(generateAdapter = true)
data class CreateQuestionnaireAnswerDTO(

    @Json(name = "questionnaireId")
    val questionnaireId: kotlin.String,

    @Json(name = "questionId")
    val questionId: kotlin.String,

    @Json(name = "type")
    val type: QuestionAnswerTypeDTO,

    @Json(name = "multichoice")
    val multichoice: kotlin.collections.List<kotlin.Int>? = null,

    @Json(name = "numeric")
    val numeric: kotlin.Double? = null
)
