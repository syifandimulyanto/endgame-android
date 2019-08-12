package id.endgame.app.ui.main.home

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by syifandimulyanto.id on 2019-08-08
 */
@Module
internal abstract class HomeFragmentProvider {

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    internal abstract fun provideHomeFragmentFactory(): HomeFragment
}