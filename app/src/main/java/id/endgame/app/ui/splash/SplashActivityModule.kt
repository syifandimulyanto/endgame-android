package id.endgame.app.ui.splash

import dagger.Module
import dagger.Provides

@Module
class SplashActivityModule {

    @Provides
    internal fun provideSplashPresenter(presenter: SplashPresenter<SplashContract.View>) =
        presenter as SplashContract.Presenter<SplashContract.View>
}