package id.endgame.app

import android.app.Activity
import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import id.endgame.app.di.component.DaggerAppComponent
import timber.log.Timber
import javax.inject.Inject

class MyApp : MultiDexApplication(), HasActivityInjector {

    @Inject
    internal lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector() = activityDispatchingAndroidInjector

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
        }

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}