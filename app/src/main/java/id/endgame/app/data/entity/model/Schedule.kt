package id.endgame.app.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by syifandimulyanto.id on 2019-08-13
 */
class Schedule : Serializable {
    @Expose
    @SerializedName("id")
    val id: String? = null

    @Expose
    @SerializedName("period")
    val period: String? = null

    @Expose
    @SerializedName("period_year")
    val periodYear: String? = null

    @Expose
    @SerializedName("start_date")
    val startDate: String? = null

    @Expose
    @SerializedName("end_date")
    val endDate: String? = null

    @Expose
    @SerializedName("day")
    val day: String? = null

    @Expose
    @SerializedName("start_time")
    val startTime: String? = null

    @Expose
    @SerializedName("end_time")
    val endTime: String? = null

    @Expose
    @SerializedName("course")
    val course: Course? = null
}