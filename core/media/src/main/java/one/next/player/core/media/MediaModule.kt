package one.next.player.core.media

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import one.next.player.core.media.services.LocalMediaService
import one.next.player.core.media.services.MediaService
import one.next.player.core.media.sync.LocalMediaInfoSynchronizer
import one.next.player.core.media.sync.LocalMediaSynchronizer
import one.next.player.core.media.sync.MediaInfoSynchronizer
import one.next.player.core.media.sync.MediaSynchronizer

@Module
@InstallIn(SingletonComponent::class)
interface MediaModule {

    @Binds
    @Singleton
    fun bindsMediaSynchronizer(
        mediaSynchronizer: LocalMediaSynchronizer,
    ): MediaSynchronizer

    @Binds
    @Singleton
    fun bindsMediaInfoSynchronizer(
        mediaInfoSynchronizer: LocalMediaInfoSynchronizer,
    ): MediaInfoSynchronizer

    @Binds
    @Singleton
    fun bindMediaService(
        mediaService: LocalMediaService,
    ): MediaService
}
