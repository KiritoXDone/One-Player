package one.next.player.core.data.mappers

import one.next.player.core.database.entities.SubtitleStreamInfoEntity
import one.next.player.core.model.SubtitleStreamInfo

fun SubtitleStreamInfoEntity.toSubtitleStreamInfo() = SubtitleStreamInfo(
    index = index,
    title = title,
    codecName = codecName,
    language = language,
    disposition = disposition,
)
