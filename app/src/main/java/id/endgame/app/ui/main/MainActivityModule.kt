package id.endgame.app.ui.main

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainPresenter(presenter: MainPresenter<MainContract.View>) =
        presenter as MainContract.Presenter<MainContract.View>
}