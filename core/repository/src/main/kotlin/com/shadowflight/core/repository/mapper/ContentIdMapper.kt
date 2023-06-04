package com.shadowflight.core.repository.mapper

import com.shadowflight.core.model.recommendation.ContentId
import com.shadowflight.core.openapi.model.ContentIdDTO

fun ContentIdDTO.asEntity() = ContentId(itemId = itemId, catalogId = catalogId)
fun ContentId.asDTO() = ContentIdDTO(itemId = itemId, catalogId = catalogId)