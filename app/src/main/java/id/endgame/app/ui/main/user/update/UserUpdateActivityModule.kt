package id.endgame.app.ui.main.user.update

import dagger.Module
import dagger.Provides

/**
 * Created by syifandimulyanto.id on 2019-08-20
 */
@Module
class UserUpdateActivityModule {

    @Provides
    internal fun provideUserUpdatePresenter(presenter: UserUpdatePresenter<UserUpdateContract.View>) =
        presenter as UserUpdateContract.Presenter<UserUpdateContract.View>
}