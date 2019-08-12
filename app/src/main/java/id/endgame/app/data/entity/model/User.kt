package id.endgame.app.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by syifandimulyanto.id on 2019-06-28
 */
class User : Serializable {
    @Expose
    @SerializedName("id")
    val id: String? = null
    @Expose
    @SerializedName("email")
    val email: String? = null
    @Expose
    @SerializedName("first_name")
    val firstName: String? = null
    @Expose
    @SerializedName("last_name")
    val lastName: String? = null
    @Expose
    @SerializedName("access_token")
    val accessToken: String? = null

}