package id.endgame.app.ui.main.attend

import id.endgame.app.R
import id.endgame.app.data.DataManager
import id.endgame.app.ui.base.BasePresenter
import id.endgame.app.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by syifandimulyanto.id on 2019-08-14
 */
class AttendPresenter<V : AttendContract.View>
@Inject
constructor(
    dataManager: DataManager,
    compositeDisposable: CompositeDisposable,
    schedulerProvider: SchedulerProvider
) :
    BasePresenter<V>(dataManager, compositeDisposable, schedulerProvider),
    AttendContract.Presenter<V> {

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        fetchAttends()
    }

    private fun fetchAttends() {
        mvpView?.showProgress()
        dataManager.attend()
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe({ resp ->
                mvpView?.hideProgress()
                mvpView?.setAttends(resp)

            }, { err ->
                mvpView?.hideProgress()
                mvpView?.showMessage(R.string.api_no_response)
            })
    }
}