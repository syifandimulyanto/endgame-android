package id.endgame.app.data.remote

import id.endgame.app.data.entity.UserResponse
import id.endgame.app.data.entity.model.Notification
import id.endgame.app.data.entity.model.Slider
import io.reactivex.Observable


interface ApiService {

    fun login(
        email: String,
        password: String
    ): Observable<UserResponse>

    fun slider(): Observable<List<Slider>>

    fun notification(): Observable<List<Notification>>

}
