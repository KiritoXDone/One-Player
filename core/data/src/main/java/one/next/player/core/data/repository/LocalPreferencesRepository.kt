package one.next.player.core.data.repository

import javax.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import one.next.player.core.common.di.ApplicationScope
import one.next.player.core.datastore.datasource.AppPreferencesDataSource
import one.next.player.core.datastore.datasource.PlayerPreferencesDataSource
import one.next.player.core.model.ApplicationPreferences
import one.next.player.core.model.PlayerPreferences
import one.next.player.core.model.SettingsBackup

class LocalPreferencesRepository @Inject constructor(
    private val appPreferencesDataSource: AppPreferencesDataSource,
    private val playerPreferencesDataSource: PlayerPreferencesDataSource,
    @ApplicationScope private val applicationScope: CoroutineScope,
) : PreferencesRepository {

    override val applicationPreferences: StateFlow<ApplicationPreferences> =
        appPreferencesDataSource.preferences.stateIn(
            scope = applicationScope,
            started = SharingStarted.Eagerly,
            initialValue = ApplicationPreferences(),
        )

    override val playerPreferences: StateFlow<PlayerPreferences> =
        playerPreferencesDataSource.preferences.stateIn(
            scope = applicationScope,
            started = SharingStarted.Eagerly,
            initialValue = PlayerPreferences(),
        )

    override suspend fun updateApplicationPreferences(
        transform: suspend (ApplicationPreferences) -> ApplicationPreferences,
    ) {
        appPreferencesDataSource.update(transform)
    }

    override suspend fun updatePlayerPreferences(
        transform: suspend (PlayerPreferences) -> PlayerPreferences,
    ) {
        playerPreferencesDataSource.update(transform)
    }

    override suspend fun exportSettings(): SettingsBackup = SettingsBackup(
        applicationPreferences = applicationPreferences.value,
        playerPreferences = playerPreferences.value,
    )

    override suspend fun importSettings(settingsBackup: SettingsBackup) {
        appPreferencesDataSource.update { settingsBackup.applicationPreferences }
        playerPreferencesDataSource.update { settingsBackup.playerPreferences }
    }

    override suspend fun resetPreferences() {
        appPreferencesDataSource.update { ApplicationPreferences() }
        playerPreferencesDataSource.update { PlayerPreferences() }
    }
}
