package id.endgame.app.ui.main.user

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by syifandimulyanto.id on 2019-06-25
 */
@Module
internal abstract class UserFragmentProvider {

    @ContributesAndroidInjector(modules = [UserFragmentModule::class])
    internal abstract fun provideUserFragmentFactory(): UserFragment
}