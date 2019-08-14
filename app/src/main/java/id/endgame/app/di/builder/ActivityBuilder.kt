package id.endgame.app.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector

import id.endgame.app.ui.auth.login.LoginActivity
import id.endgame.app.ui.auth.login.LoginActivityModule
import id.endgame.app.ui.main.MainActivity
import id.endgame.app.ui.main.MainActivityModule
import id.endgame.app.ui.main.attend.AttendFragmentProvider
import id.endgame.app.ui.main.home.HomeFragmentProvider
import id.endgame.app.ui.main.notification.NotificationFragmentProvider
import id.endgame.app.ui.main.schedule.ScheduleActivity
import id.endgame.app.ui.main.schedule.ScheduleActivityModule
import id.endgame.app.ui.main.scheduleChange.ScheduleChangeActivity
import id.endgame.app.ui.main.scheduleChange.ScheduleChangeActivityModule
import id.endgame.app.ui.main.user.UserFragmentProvider
import id.endgame.app.ui.splash.SplashActivity
import id.endgame.app.ui.splash.SplashActivityModule

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(modules = [LoginActivityModule::class])
    internal abstract fun bindLoginActivity(): LoginActivity

    @ContributesAndroidInjector(
        modules = [
            MainActivityModule::class,
            HomeFragmentProvider::class,
            AttendFragmentProvider::class,
            NotificationFragmentProvider::class,
            UserFragmentProvider::class
        ]
    )
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [ScheduleActivityModule::class])
    internal abstract fun bindScheduleActivity(): ScheduleActivity

    @ContributesAndroidInjector(modules = [ScheduleChangeActivityModule::class])
    internal abstract fun bindScheduleChangeActivity(): ScheduleChangeActivity

}
