package hu.bme.aut.android.kimiquotes.mock.persistence

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.bme.aut.android.kimiquotes.persistence.KimiQuotesDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MockDbModule {

    @Provides
    @Singleton
    fun providesQuotesDao(): KimiQuotesDao = MockQuotesDao()
}