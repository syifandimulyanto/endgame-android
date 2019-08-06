package id.endgame.app.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import id.endgame.app.data.entity.model.User
import id.endgame.app.di.PreferenceInfo
import id.endgame.app.utils.AppConstants
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(context: Context,
                                              @PreferenceInfo private val prefFileName: String) :
    PreferenceHelper {
    companion object {
        private val PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE"
        private val PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN"
        private val PREF_KEY_USER_MODEL = "PREF_USER_MODEL"
    }

    private val mPrefs: SharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getCurrentUserLoggedInMode() = mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE, AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type)

    override fun getAccessToken(): String {
        val accessToken = mPrefs.getString(PREF_KEY_ACCESS_TOKEN, "")
        return if(accessToken.isNullOrEmpty()){
            ""
        }else{
            accessToken
        }
    }

    override fun setAccessToken(accessToken: String?) = mPrefs.edit { putString(PREF_KEY_ACCESS_TOKEN, accessToken) }

    override fun setCurrentUserLoggedInMode(mode: AppConstants.LoggedInMode) {
        mPrefs.edit { putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.type) }
    }

    override fun setCurrentUserModel(userModel: User?) = mPrefs.edit{ putString(PREF_KEY_USER_MODEL, GsonBuilder().create().toJson(userModel)) }
    override fun getCurrentUserModel() = Gson().fromJson(mPrefs.getString(PREF_KEY_USER_MODEL, ""), User::class.java)


}