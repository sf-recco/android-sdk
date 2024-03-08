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

package com.recco.internal.core.openapi.api

import retrofit2.http.*
import retrofit2.Response
import okhttp3.RequestBody
import com.squareup.moshi.Json
import com.recco.internal.core.openapi.model.ApiErrorDTO
import com.recco.internal.core.openapi.model.AppUserArticleDTO
import com.recco.internal.core.openapi.model.AppUserAudioDTO
import com.recco.internal.core.openapi.model.AppUserRecommendationDTO
import com.recco.internal.core.openapi.model.AppUserVideoDTO
import com.recco.internal.core.openapi.model.ContentTypeDTO
import com.recco.internal.core.openapi.model.TopicDTO
import com.recco.internal.core.openapi.model.UpdateBookmarkDTO
import com.recco.internal.core.openapi.model.UpdateRatingDTO

interface RecommendationApi {

    /**
     * A list of content filtered by topic.
     * 
     * Responses:
     *  - 401: Unauthorized
     *  - 200: OK
     *
     * @param topic 
     * @param contentTypes  (optional)
     * @return [kotlin.collections.List<AppUserRecommendationDTO>]
     */
    @GET("api/v1/me/recommendations/explore/topics/{topic}")
    suspend fun exploreContentByTopic(@Path("topic") topic: TopicDTO, @Query("contentTypes") contentTypes: @JvmSuppressWildcards kotlin.collections.List<ContentTypeDTO>? = null): Response<kotlin.collections.List<AppUserRecommendationDTO>>

    /**
     * Get an article.
     * 
     * Responses:
     *  - 401: Unauthorized
     *  - 200: OK
     *
     * @param catalogId 
     * @return [AppUserArticleDTO]
     */
    @GET("api/v1/me/recommendations/articles")
    suspend fun getArticle(@Query("catalogId") catalogId: kotlin.String): Response<AppUserArticleDTO>

    /**
     * Get an audio.
     * 
     * Responses:
     *  - 401: Unauthorized
     *  - 200: OK
     *
     * @param catalogId 
     * @return [AppUserAudioDTO]
     */
    @GET("api/v1/me/recommendations/audios")
    suspend fun getAudio(@Query("catalogId") catalogId: kotlin.String): Response<AppUserAudioDTO>

    /**
     * A list of bookmarked recommendations.
     * 
     * Responses:
     *  - 401: Unauthorized
     *  - 200: OK
     *
     * @return [kotlin.collections.List<AppUserRecommendationDTO>]
     */
    @GET("api/v1/me/recommendations/bookmarked")
    suspend fun getBookmarkedRecommendations(): Response<kotlin.collections.List<AppUserRecommendationDTO>>

    /**
     * A list of most popular content.
     * 
     * Responses:
     *  - 401: Unauthorized
     *  - 200: OK
     *
     * @param contentTypes  (optional)
     * @return [kotlin.collections.List<AppUserRecommendationDTO>]
     */
    @GET("api/v1/me/recommendations/most_popular")
    suspend fun getMostPopularContent(@Query("contentTypes") contentTypes: @JvmSuppressWildcards kotlin.collections.List<ContentTypeDTO>? = null): Response<kotlin.collections.List<AppUserRecommendationDTO>>

    /**
     * A list of newest content.
     * 
     * Responses:
     *  - 401: Unauthorized
     *  - 200: OK
     *
     * @param contentTypes  (optional)
     * @return [kotlin.collections.List<AppUserRecommendationDTO>]
     */
    @GET("api/v1/me/recommendations/newest")
    suspend fun getNewestContent(@Query("contentTypes") contentTypes: @JvmSuppressWildcards kotlin.collections.List<ContentTypeDTO>? = null): Response<kotlin.collections.List<AppUserRecommendationDTO>>

    /**
     * A list of starting recommendations.
     * 
     * Responses:
     *  - 401: Unauthorized
     *  - 200: OK
     *
     * @param contentTypes  (optional)
     * @return [kotlin.collections.List<AppUserRecommendationDTO>]
     */
    @GET("api/v1/me/recommendations/starting")
    suspend fun getStartingRecommendations(@Query("contentTypes") contentTypes: @JvmSuppressWildcards kotlin.collections.List<ContentTypeDTO>? = null): Response<kotlin.collections.List<AppUserRecommendationDTO>>

    /**
     * A list of tailored recommendations filtered by topic.
     * 
     * Responses:
     *  - 401: Unauthorized
     *  - 200: OK
     *
     * @param topic 
     * @param contentTypes  (optional)
     * @return [kotlin.collections.List<AppUserRecommendationDTO>]
     */
    @GET("api/v1/me/recommendations/tailored/topics/{topic}")
    suspend fun getTailoredRecommendationsByTopic(@Path("topic") topic: TopicDTO, @Query("contentTypes") contentTypes: @JvmSuppressWildcards kotlin.collections.List<ContentTypeDTO>? = null): Response<kotlin.collections.List<AppUserRecommendationDTO>>

    /**
     * A list of recommendations which are improved by the preferences.
     * 
     * Responses:
     *  - 401: Unauthorized
     *  - 200: OK
     *
     * @param contentTypes  (optional)
     * @return [kotlin.collections.List<AppUserRecommendationDTO>]
     */
    @GET("api/v1/me/recommendations/preferred")
    suspend fun getUserPreferredRecommendations(@Query("contentTypes") contentTypes: @JvmSuppressWildcards kotlin.collections.List<ContentTypeDTO>? = null): Response<kotlin.collections.List<AppUserRecommendationDTO>>

    /**
     * Get a video.
     * 
     * Responses:
     *  - 401: Unauthorized
     *  - 200: OK
     *
     * @param catalogId 
     * @return [AppUserVideoDTO]
     */
    @GET("api/v1/me/recommendations/videos")
    suspend fun getVideo(@Query("catalogId") catalogId: kotlin.String): Response<AppUserVideoDTO>

    /**
     * Set recommendation bookmark state.
     * 
     * Responses:
     *  - 401: Unauthorized
     *  - 204: No Content
     *
     * @param updateBookmarkDTO 
     * @return [Unit]
     */
    @PUT("api/v1/me/recommendations/bookmark")
    suspend fun setBookmark(@Body updateBookmarkDTO: UpdateBookmarkDTO): Response<Unit>

    /**
     * Set recommendation rating.
     * 
     * Responses:
     *  - 401: Unauthorized
     *  - 204: No Content
     *
     * @param updateRatingDTO 
     * @return [Unit]
     */
    @PUT("api/v1/me/recommendations/rating")
    suspend fun setRating(@Body updateRatingDTO: UpdateRatingDTO): Response<Unit>
}
