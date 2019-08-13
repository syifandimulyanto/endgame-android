package id.endgame.app.ui.main.notification

import id.endgame.app.R
import id.endgame.app.data.DataManager
import id.endgame.app.ui.base.BasePresenter
import id.endgame.app.ui.main.home.HomeContract
import id.endgame.app.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class NotificationPresenter<V : NotificationContract.View>
@Inject
constructor(
    dataManager: DataManager,
    compositeDisposable: CompositeDisposable,
    schedulerProvider: SchedulerProvider
) :
    BasePresenter<V>(dataManager, compositeDisposable, schedulerProvider),
    NotificationContract.Presenter<V> {

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        fetchNotifications()
    }

    private fun fetchNotifications() {
        mvpView?.showProgress()
        dataManager.notification()
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe({ resp ->
                mvpView?.hideProgress()
                mvpView?.setNotifications(resp)

            }, { err ->
                mvpView?.hideProgress()
                mvpView?.showMessage(R.string.api_no_response)
            })
    }
}