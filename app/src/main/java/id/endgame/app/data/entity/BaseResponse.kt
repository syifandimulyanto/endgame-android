package id.endgame.app.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by syifandimulyanto.id on 2019-06-28
 */
open class BaseResponse {
    @Expose
    @SerializedName("status")
    val status: String? = null
    @Expose
    @SerializedName("code")
    val code: Int? = null
    @Expose
    @SerializedName("message")
    val message: String? = null
}