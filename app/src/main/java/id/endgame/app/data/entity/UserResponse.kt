package id.endgame.app.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import id.endgame.app.data.entity.model.User

/**
 * Created by @adriyoutomo on 01/07/2019.
 */
class UserResponse : BaseResponse() {
    @Expose
    @SerializedName("data")
    val data: User? = null
}