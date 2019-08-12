package id.endgame.app.ui.auth.login

import id.endgame.app.R
import id.endgame.app.data.DataManager
import id.endgame.app.ui.base.BasePresenter
import id.endgame.app.utils.AppConstants
import id.endgame.app.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginPresenter<V : LoginContract.View>
@Inject
constructor(
    dataManager: DataManager,
    compositeDisposable: CompositeDisposable,
    schedulerProvider: SchedulerProvider
) :
    BasePresenter<V>(dataManager, compositeDisposable, schedulerProvider),
    LoginContract.Presenter<V> {
    override fun procesLogin(email: Any, password: Any) {

        when {
            email.toString().isNullOrEmpty() -> mvpView?.showErrorLoginPhone(R.string.empty_email)
            password.toString().isNullOrEmpty() -> mvpView?.showErrorLoginPassword(R.string.empty_password)
            else -> {
                mvpView?.showProgress()
                dataManager.login(email.toString(), password.toString())
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ loginResponse ->
                        mvpView?.hideProgress()
                        when {
                            loginResponse.code == 200 -> {
                                dataManager.setAccessToken(loginResponse.data?.accessToken)
                                dataManager.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_SERVER)
                                dataManager.setCurrentUserModel(loginResponse.data)
                                mvpView?.openMainActivity()
                            }
                            else -> {
                                loginResponse.message?.let { mvpView?.showMessage(it) }
                            }
                        }

                    }, { err ->
                        mvpView?.hideProgress()
                        mvpView?.showMessage(R.string.api_no_response)
                    })
            }
        }
    }
}