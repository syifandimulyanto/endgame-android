package id.endgame.app.data

import android.content.Context
import id.endgame.app.data.entity.*
import id.endgame.app.data.entity.model.User
import id.endgame.app.data.local.prefs.PreferenceHelper
import id.endgame.app.data.remote.ApiServiceHelper
import id.endgame.app.utils.AppConstants
import io.reactivex.Observable

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject
constructor(
    private val context: Context,
    private val preferenceHelper: PreferenceHelper,
    private val apiService: ApiServiceHelper
) : DataManager {

    override fun setUserAsLoggedOut() {
        preferenceHelper.setAccessToken("")
        preferenceHelper.setCurrentUserModel(null)
        preferenceHelper.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT)
    }

    override fun updateUserInfo(loggedInMode: AppConstants.LoggedInMode) {
    }

    override fun getCurrentUserLoggedInMode(): Int = preferenceHelper.getCurrentUserLoggedInMode()

    override fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode) {
        preferenceHelper.setCurrentUserLoggedInMode(mode)
    }

    override fun getAccessToken(): String? = preferenceHelper.getAccessToken()

    override fun setAccessToken(accessToken: String?) {
        preferenceHelper.setAccessToken(accessToken)
    }

    override fun login(phone: String, password: String): Observable<UserResponse> {
        return apiService.login(phone, password)
    }

    override fun setCurrentUserModel(userModel: User?) {
        return preferenceHelper.setCurrentUserModel(userModel)
    }

    override fun getCurrentUserModel(): User? {
        return preferenceHelper.getCurrentUserModel()
    }

}
