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

package com.shadowflight.openapi.api

import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.squareup.moshi.Json
import com.shadowflight.openapi.model.ApiErrorDTO
import com.shadowflight.openapi.model.PATReferenceDeleteDTO
import com.shadowflight.openapi.model.ZitadelPATDTO

interface AppUserAuthenticationApi {

    /**
     * Authenticate an app user supplying an app PAT and the associated user client id.         If the user client id does not exist in the app, a new user will be registered on the fly.         This endpoint should be used also after the PAT expires to retrieve a new one.         
     * 
     * Responses:
     *  - 200: OK
     *  - 401: Unauthorized
     *
     * @param clientUserId 
     * @return [ZitadelPATDTO]
     */
    @POST("api/v1/app_users/login")
    suspend fun login(@Header("Client-User-Id") clientUserId: kotlin.String): Response<ZitadelPATDTO>

    /**
     * Logout an app user supplying PAT&#39;s id and the associated user client id.
     * 
     * Responses:
     *  - 204: No Content
     *  - 401: Unauthorized
     *
     * @param clientUserId 
     * @param paTReferenceDeleteDTO 
     * @return [Unit]
     */
    @POST("api/v1/app_users/logout")
    suspend fun logout(@Header("Client-User-Id") clientUserId: kotlin.String, @Body paTReferenceDeleteDTO: PATReferenceDeleteDTO): Response<Unit>
}
