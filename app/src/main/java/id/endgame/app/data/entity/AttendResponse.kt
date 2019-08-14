package id.endgame.app.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by syifandimulyanto.id on 2019-08-14
 */
class AttendResponse: Serializable {
    @Expose
    @SerializedName("id")
    val id: String? = null

    @Expose
    @SerializedName("student_schedule")
    val studentSchedule: ScheduleResponse? = null
}