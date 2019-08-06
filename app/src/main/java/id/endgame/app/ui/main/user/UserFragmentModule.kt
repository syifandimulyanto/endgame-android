package id.endgame.app.ui.main.user

import dagger.Module
import dagger.Provides

/**
 * Created by syifandimulyanto.id on 2019-06-25
 */
@Module
class UserFragmentModule {

    @Provides
    internal fun provideUserPresenter(presenter: UserPresenter<UserContract.View>) =
        presenter as UserContract.Presenter<UserContract.View>
}