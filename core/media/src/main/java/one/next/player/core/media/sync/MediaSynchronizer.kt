package one.next.player.core.media.sync

interface MediaSynchronizer {
    suspend fun refresh(path: String? = null): Boolean
    suspend fun registerManualVideoPath(path: String)
    fun startSync()
    fun stopSync()
}
