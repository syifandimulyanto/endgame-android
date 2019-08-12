package id.endgame.app.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by syifandimulyanto.id on 2019-08-08
 */
class Slider : Serializable {
    @Expose
    @SerializedName("url")
    val url: String? = null

    @Expose
    @SerializedName("title")
    val title: String? = null
}