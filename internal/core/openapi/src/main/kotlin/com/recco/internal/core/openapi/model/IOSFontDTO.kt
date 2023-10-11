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
 * Values: SF_PRO,HELVETICA_NEUE,AVENIR_NEXT,APPLE_SD_GOTHIC_NEO,GEORGIA
 */
@Suppress("RemoveRedundantQualifierName")
@JsonClass(generateAdapter = false)
enum class IOSFontDTO(val value: kotlin.String) {

    @Json(name = "sf_pro")
    SF_PRO("sf_pro"),

    @Json(name = "helvetica_neue")
    HELVETICA_NEUE("helvetica_neue"),

    @Json(name = "avenir_next")
    AVENIR_NEXT("avenir_next"),

    @Json(name = "apple_sd_gothic_neo")
    APPLE_SD_GOTHIC_NEO("apple_sd_gothic_neo"),

    @Json(name = "georgia")
    GEORGIA("georgia");

    /**
     * Override toString() to avoid using the enum variable name as the value, and instead use
     * the actual value defined in the API spec file.
     *
     * This solves a problem when the variable name and its value are different, and ensures that
     * the client sends the correct enum values to the server always.
     */
    override fun toString(): String = value
}
