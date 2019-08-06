package id.endgame.app.data.remote

import id.endgame.app.data.entity.UserResponse
import io.reactivex.Observable


interface ApiService {

    fun login(
        phone: String,
        password: String
    ): Observable<UserResponse>
}
