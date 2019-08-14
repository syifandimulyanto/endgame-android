package id.endgame.app.ui.main.attend

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by syifandimulyanto.id on 2019-08-14
 */
@Module
internal abstract class AttendFragmentProvider {

    @ContributesAndroidInjector(modules = [AttendFragmentModule::class])
    internal abstract fun provideAttendFragmentFactory(): AttendFragment
}