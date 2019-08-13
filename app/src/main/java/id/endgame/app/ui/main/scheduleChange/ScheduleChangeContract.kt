package id.endgame.app.ui.main.scheduleChange

import id.endgame.app.data.entity.ScheduleChangeResponse
import id.endgame.app.ui.base.MvpPresenter
import id.endgame.app.ui.base.MvpView

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
interface ScheduleChangeContract {

    interface Presenter<V : View> : MvpPresenter<V> {
    }

    interface View : MvpView {
        fun setScheduleChange(schedules: List<ScheduleChangeResponse>?)
    }
}