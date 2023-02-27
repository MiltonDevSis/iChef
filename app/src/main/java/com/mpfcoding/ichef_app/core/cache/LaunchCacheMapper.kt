package com.mpfcoding.ichef_app.core.cache

import com.mpfcoding.ichef_app.core.cache.entity.LaunchEntity
import com.mpfcoding.ichef_app.core.domain.Launch
import com.mpfcoding.ichef_app.core.utils.EntityMapper
import javax.inject.Inject

class LaunchCacheMapper @Inject constructor() : EntityMapper<LaunchEntity, Launch> {

    override fun mapFromEntity(entity: LaunchEntity): Launch {
        return Launch(
            productId = entity.productId!!,
            productName = entity.productName,
            productPrice = entity.productPrice,
            productQuantity = entity.productQuantity

        )
    }

    override fun mapToEntity(domainModel: Launch?): LaunchEntity {
        return LaunchEntity(
            productId = domainModel!!.productId,
            productName = domainModel.productName,
            productPrice = domainModel.productPrice,
            productQuantity = domainModel.productQuantity
        )
    }

    fun mapFromEntityList(entities: List<LaunchEntity>): List<Launch> {
        return entities.map { mapFromEntity(it) }
    }
}