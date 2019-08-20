package id.endgame.app.ui.main.user

import id.endgame.app.R
import id.endgame.app.data.DataManager
import id.endgame.app.ui.base.BasePresenter
import id.endgame.app.utils.AppConstants
import id.endgame.app.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by syifandimulyanto.id on 2019-06-25
 */

class UserPresenter<V : UserContract.View>
@Inject
constructor(
    dataManager: DataManager,
    compositeDisposable: CompositeDisposable,
    schedulerProvider: SchedulerProvider
) :
    BasePresenter<V>(dataManager, compositeDisposable, schedulerProvider),
    UserContract.Presenter<V> {

    override fun onAttach(mvpView: V) {
        super.onAttach(mvpView)
        loadUserProfile()
    }

    override fun loadUser() {
        loadUserProfile()
    }

    override fun createMenu() {
        val menuList = listOf<ProfileMenuItem>(
            ProfileMenuItem(
                R.string.profile_menu_change_password,
                AppConstants.MenuChangePassword
            ),
            ProfileMenuItem(
                R.string.profile_menu_help,
                AppConstants.MenuHelp
            ),
            ProfileMenuItem(
                R.string.profile_menu_setting,
                AppConstants.MenuSetting
            ),
            ProfileMenuItem(
                R.string.profile_menu_logout,
                AppConstants.MenuLogout
            )
        )
        mvpView?.displayMenu(menuList)
    }

    private fun loadUserProfile() {
        if (dataManager.getCurrentUserLoggedInMode() == AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type) {
            mvpView?.openLoginActivity()
        } else {
            val user = dataManager.getCurrentUserModel()
            mvpView?.displayProfile(user)
        }
    }
}