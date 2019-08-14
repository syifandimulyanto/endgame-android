package id.endgame.app.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class Notification : Serializable {
    @Expose
    @SerializedName("id")
    val id: String? = null

    @Expose
    @SerializedName("title")
    val title: String? = null

    @Expose
    @SerializedName("slug")
    val slug: String? = null

    @Expose
    @SerializedName("description")
    val description: String? = null

    @Expose
    @SerializedName("type")
    val type: String? = null

    @Expose
    @SerializedName("user_id")
    val userId: String? = null

    @Expose
    @SerializedName("created_at")
    val createdAt: String? = null

    @Expose
    @SerializedName("url")
    val url: String? = null
}