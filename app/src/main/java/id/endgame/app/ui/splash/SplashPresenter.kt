package id.endgame.app.ui.splash

import android.os.Handler
import id.endgame.app.data.DataManager
import id.endgame.app.ui.base.BasePresenter
import id.endgame.app.utils.AppConstants
import id.endgame.app.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SplashPresenter<V : SplashContract.View>
@Inject
constructor(
    dataManager: DataManager,
    compositeDisposable: CompositeDisposable,
    schedulerProvider: SchedulerProvider
) :
    BasePresenter<V>(dataManager, compositeDisposable, schedulerProvider),
    SplashContract.Presenter<V> {

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        Handler().postDelayed({
            if (dataManager.getCurrentUserLoggedInMode() == AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type) {
                mvpView.openLoginActivity()
            } else {
                mvpView.openMainActivity()
            }
        }, 2000)
    }
}