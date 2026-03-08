package one.next.player.core.data.mappers

import one.next.player.core.common.Utils
import one.next.player.core.database.relations.DirectoryWithMedia
import one.next.player.core.database.relations.MediumWithInfo
import one.next.player.core.model.Folder

fun DirectoryWithMedia.toFolder() = Folder(
    name = directory.name,
    path = directory.path,
    dateModified = directory.modified,
    parentPath = directory.parentPath,
    formattedMediaSize = Utils.formatFileSize(media.sumOf { it.mediumEntity.size }),
    mediaList = media.map(MediumWithInfo::toVideo),
)
