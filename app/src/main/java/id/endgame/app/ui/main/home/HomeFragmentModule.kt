package id.endgame.app.ui.main.home

import dagger.Module
import dagger.Provides

/**
 * Created by syifandimulyanto.id on 2019-08-08
 */
@Module
class HomeFragmentModule {

    @Provides
    internal fun provideHomePresenter(presenter: HomePresenter<HomeContract.View>) =
        presenter as HomeContract.Presenter<HomeContract.View>
}