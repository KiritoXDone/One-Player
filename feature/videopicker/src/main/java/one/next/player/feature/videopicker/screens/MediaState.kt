package one.next.player.feature.videopicker.screens

import one.next.player.core.model.Folder

sealed interface MediaState {
    data object Loading : MediaState
    data class Success(val data: Folder?) : MediaState
}
