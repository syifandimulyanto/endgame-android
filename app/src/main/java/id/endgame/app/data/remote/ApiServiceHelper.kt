package id.endgame.app.data.remote

import id.endgame.app.data.entity.AttendResponse
import id.endgame.app.data.entity.ScheduleChangeResponse
import id.endgame.app.data.entity.ScheduleResponse
import id.endgame.app.data.entity.UserResponse
import id.endgame.app.data.entity.model.Notification
import id.endgame.app.data.entity.model.Slider
import io.reactivex.Observable
import retrofit2.http.*
import retrofit2.http.POST

interface ApiServiceHelper {

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Observable<UserResponse>


    @GET("slider")
    fun slider(): Observable<List<Slider>>

    @GET("notification")
    fun notification(): Observable<List<Notification>>

    @GET("schedule")
    fun schedule(): Observable<List<ScheduleResponse>>

    @GET("scheduleChange")
    fun scheduleChange(): Observable<List<ScheduleChangeResponse>>

    @GET("attend")
    fun attend(): Observable<List<AttendResponse>>

}
