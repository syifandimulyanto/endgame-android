package id.endgame.app.ui.main.home

import id.endgame.app.data.entity.model.Slider
import id.endgame.app.ui.base.MvpPresenter
import id.endgame.app.ui.base.MvpView

/**
 * Created by syifandimulyanto.id on 2019-08-08
 */
interface HomeContract {

    interface Presenter<V : View> :
        MvpPresenter<V> {
    }

    interface View : MvpView {
        fun setSliders(sliders: List<Slider>)
    }
}