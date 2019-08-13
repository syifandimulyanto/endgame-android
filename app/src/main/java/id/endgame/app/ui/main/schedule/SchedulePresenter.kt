package id.endgame.app.ui.main.schedule

import id.endgame.app.R
import id.endgame.app.data.DataManager
import id.endgame.app.ui.base.BasePresenter
import id.endgame.app.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class SchedulePresenter<V : ScheduleContract.View>
@Inject
constructor(
    dataManager: DataManager,
    compositeDisposable: CompositeDisposable,
    schedulerProvider: SchedulerProvider
) :
    BasePresenter<V>(dataManager, compositeDisposable, schedulerProvider),
    ScheduleContract.Presenter<V> {

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        fetchSchedules()
    }

    private fun fetchSchedules() {
        mvpView?.showProgress()
        dataManager.schedule()
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe({ resp ->
                mvpView?.hideProgress()
                mvpView?.setSchedules(resp)

            }, { err ->
                mvpView?.hideProgress()
                mvpView?.showMessage(R.string.api_no_response)
            })
    }
}