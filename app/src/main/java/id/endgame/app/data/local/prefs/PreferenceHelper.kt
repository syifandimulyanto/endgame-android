package id.endgame.app.data.local.prefs

import id.endgame.app.data.entity.model.User
import id.endgame.app.utils.AppConstants

interface PreferenceHelper {

    fun getCurrentUserLoggedInMode(): Int

    fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode)

    fun getAccessToken(): String?

    fun setAccessToken(accessToken: String?)

    fun setCurrentUserModel(userModel: User?)

    fun getCurrentUserModel(): User?

}