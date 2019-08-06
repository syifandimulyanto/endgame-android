package id.endgame.app.data.remote

import id.endgame.app.data.entity.UserResponse
import io.reactivex.Observable
import retrofit2.http.*
import retrofit2.http.POST

interface ApiServiceHelper {

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("phone_number") phone: String,
        @Field("password") password: String
    ): Observable<UserResponse>
}
