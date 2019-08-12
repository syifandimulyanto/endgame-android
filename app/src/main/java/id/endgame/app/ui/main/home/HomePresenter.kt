package id.endgame.app.ui.main.home

import id.endgame.app.R
import id.endgame.app.data.DataManager
import id.endgame.app.ui.base.BasePresenter
import id.endgame.app.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by syifandimulyanto.id on 2019-08-08
 */
class HomePresenter<V : HomeContract.View>
@Inject
constructor(
    dataManager: DataManager,
    compositeDisposable: CompositeDisposable,
    schedulerProvider: SchedulerProvider
) :
    BasePresenter<V>(dataManager, compositeDisposable, schedulerProvider),
    HomeContract.Presenter<V> {

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        fetchSliders()
    }

    private fun fetchSliders() {
        mvpView?.showProgress()
        dataManager.slider()
            .compose(schedulerProvider.ioToMainObservableScheduler())
            .subscribe({ resp ->
                mvpView?.hideProgress()
                mvpView?.setSliders(resp)

            }, { err ->
                mvpView?.hideProgress()
                mvpView?.showMessage(R.string.api_no_response)
            })
    }
}