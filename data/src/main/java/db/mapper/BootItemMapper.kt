package db.mapper

import com.piotrapps.domain.model.BootItem
import db.entity.BootEntity

fun BootEntity.toDomain(): BootItem {
    return BootItem(this.bootTime)
}

fun BootItem.toEntity(): BootEntity {
    return BootEntity(
        0,
        this.bootDate
    )
}