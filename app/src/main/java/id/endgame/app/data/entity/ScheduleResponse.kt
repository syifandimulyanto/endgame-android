package id.endgame.app.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import id.endgame.app.data.entity.model.Schedule
import java.io.Serializable

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class ScheduleResponse: Serializable {
    @Expose
    @SerializedName("id")
    val id: String? = null

    @Expose
    @SerializedName("schedule")
    val schedule: Schedule? = null
}