package id.endgame.app.ui.base

import id.endgame.app.data.DataManager
import id.endgame.app.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

const val LIMIT = "20"
open class BasePresenter<V : MvpView>
@Inject
constructor(
    val dataManager: DataManager,
    val compositeDisposable: CompositeDisposable,
    val schedulerProvider: SchedulerProvider
) : MvpPresenter<V> {

    private val TAG = "BasePresenter"

    var mvpView: V? = null

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        this.mvpView = null
        this.compositeDisposable.clear()
    }

    fun isViewAttached(): Boolean {
        return mvpView != null
    }

    override fun setUserAsLoggedOut() {
        dataManager.setUserAsLoggedOut()
        mvpView?.openActivityOnTokenExpire()
    }
}