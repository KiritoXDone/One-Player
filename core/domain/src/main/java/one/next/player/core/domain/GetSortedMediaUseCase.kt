package one.next.player.core.domain

import java.io.File
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import one.next.player.core.common.Dispatcher
import one.next.player.core.common.NextDispatchers
import one.next.player.core.data.repository.PreferencesRepository
import one.next.player.core.model.Folder
import one.next.player.core.model.MediaViewMode

class GetSortedMediaUseCase @Inject constructor(
    private val getSortedVideosUseCase: GetSortedVideosUseCase,
    private val getSortedFoldersUseCase: GetSortedFoldersUseCase,
    private val getSortedFolderTreeUseCase: GetSortedFolderTreeUseCase,
    private val preferencesRepository: PreferencesRepository,
    @Dispatcher(NextDispatchers.Default) private val defaultDispatcher: CoroutineDispatcher,
) {

    operator fun invoke(folderPath: String? = null): Flow<Folder?> = combine(
        getSortedVideosUseCase(folderPath),
        getSortedFoldersUseCase(),
        getSortedFolderTreeUseCase(folderPath),
        preferencesRepository.applicationPreferences,
    ) { videos, folders, folderTree, preferences ->
        when (preferences.mediaViewMode) {
            MediaViewMode.FOLDER_TREE -> folderTree
            MediaViewMode.FOLDERS -> if (folderPath == null) {
                Folder.rootFolder.copy(
                    mediaList = emptyList(),
                    folderList = folders,
                )
            } else {
                val file = File(folderPath)
                Folder(
                    name = file.name,
                    path = file.path,
                    dateModified = file.lastModified(),
                    mediaList = videos,
                    folderList = emptyList(),
                )
            }
            MediaViewMode.VIDEOS -> Folder.rootFolder.copy(
                mediaList = videos,
                folderList = emptyList(),
            )
        }
    }.flowOn(defaultDispatcher)
}
