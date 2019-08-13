package id.endgame.app.ui.main.notification

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
@Module
internal abstract class NotificationFragmentProvider {

    @ContributesAndroidInjector(modules = [NotificationFragmentModule::class])
    internal abstract fun provideNotificationFragmentFactory(): NotificationFragment
}