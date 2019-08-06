package id.endgame.app.ui.auth.login

import dagger.Module
import dagger.Provides

@Module
class LoginActivityModule {

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginContract.View>) =
        presenter as LoginContract.Presenter<LoginContract.View>
}