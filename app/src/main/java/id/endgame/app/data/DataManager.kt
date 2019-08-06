package id.endgame.app.data

import id.endgame.app.data.local.prefs.PreferenceHelper
import id.endgame.app.data.remote.ApiService
import id.endgame.app.utils.AppConstants

interface DataManager : ApiService,
    PreferenceHelper {

    fun setUserAsLoggedOut()

    fun updateUserInfo(loggedInMode: AppConstants.LoggedInMode)

}