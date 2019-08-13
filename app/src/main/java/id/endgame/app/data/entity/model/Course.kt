package id.endgame.app.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class Course : Serializable {
    @Expose
    @SerializedName("id")
    val id: String? = null

    @Expose
    @SerializedName("code")
    val code: String? = null

    @Expose
    @SerializedName("name")
    val name: String? = null

}