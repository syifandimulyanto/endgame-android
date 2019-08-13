package id.endgame.app.ui.main.schedule

import id.endgame.app.data.entity.ScheduleResponse
import id.endgame.app.ui.base.MvpPresenter
import id.endgame.app.ui.base.MvpView

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
interface ScheduleContract {

    interface Presenter<V : View> : MvpPresenter<V> {
    }

    interface View : MvpView {
        fun setSchedules(schedules: List<ScheduleResponse>?)
    }
}