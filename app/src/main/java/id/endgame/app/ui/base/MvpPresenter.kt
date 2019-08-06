package id.endgame.app.ui.base

interface MvpPresenter<V : MvpView> {
    fun onAttach(mvpView: V)
    fun onDetach()
    fun setUserAsLoggedOut()
}