package id.endgame.app.ui.main.user.password

import dagger.Module
import dagger.Provides

/**
 * Created by syifandimulyanto.id on 2019-08-20
 */
@Module
class UserPasswordActivityModule {

    @Provides
    internal fun provideUserPasswordPresenter(presenter: UserPasswordPresenter<UserPasswordContract.View>) =
        presenter as UserPasswordContract.Presenter<UserPasswordContract.View>
}