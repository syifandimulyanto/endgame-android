package id.endgame.app.utils


object AppConstants {

    internal val APP_DB_NAME = "endgame.db"
    internal val PREF_NAME = "endgame_pref"
    internal val EMPTY_EMAIL_ERROR = 1001
    internal val INVALID_EMAIL_ERROR = 1002
    internal val EMPTY_PASSWORD_ERROR = 1003
    internal val LOGIN_FAILURE = 1004
    internal val NULL_INDEX = -1L
    const val REQUEST_CAMERA_PERMISSION = 1000
    const val REQUEST_LOCATION_PERMISSION = 1001
    const val REQUEST_SCAN_CLAIM = 2000

    const val REQUEST_SERVER_SUCCESS = "success"
    const val REQUEST_SERVER_ERROR = "error"


    enum class LoggedInMode constructor(val type: Int) {
        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(1)
    }

    // Profile Menu Type
    const val MenuChangePassword = "change_password"
    const val MenuUploadPic = "upload_profile_pic"
    const val MenuCheckPoint = "check_point"
    const val MenuHelp = "help"
    const val MenuSetting = "setting"
    const val MenuLogout = "logout"

    // OTP
    const val OTP_REGISTER = "register"
    const val OTP_FORGOT_PASSWORD = "forgot-password"

    // REGISTER PARAM ACTIVITY
    const val PARAM_OTP = "otp"
    const val PARAM_OTP_PHONE = "phone"
    const val PARAM_OTP_TYPE = "type"
    const val PARAM_QRCODE = "qrcode"

    // PRODUCT REPORT TYPE
    const val REPORT_ISSUE = "issue"

    // UPLOAD IMAGE TYPE
    const val IMAGE_USER_PICTURE = "picture"
    const val IMAGE_USER_IDENTITY = "identity"

    // SCAN NOTIFICATION
    const val TYPE_SUCCESS = 1
    const val TYPE_FAILED = 2
    const val TYPE_NOT_VALID = 3
    const val TYPE_EXPIRED = 4


}