package id.endgame.app.data.remote

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

}
