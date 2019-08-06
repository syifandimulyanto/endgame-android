package id.endgame.app.data.entity.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by syifandimulyanto.id on 2019-06-28
 */
class User : Serializable {
    @Expose
    @SerializedName("id")
    val id: String? = null
    @Expose
    @SerializedName("fullname")
    val fullName: String? = null
    @Expose
    @SerializedName("username")
    val userName: String? = null
    @Expose
    @SerializedName("email")
    val email: String? = null
    @Expose
    @SerializedName("address")
    val address: String? = null
    @Expose
    @SerializedName("province_id")
    val provinceId: String? = null
    @Expose
    @SerializedName("city_id")
    val cityId: String? = null
    @Expose
    @SerializedName("district_id")
    val districtId: String? = null
    @Expose
    @SerializedName("province_label")
    val provinceLabel: String? = null
    @Expose
    @SerializedName("city_label")
    val cityLabel: String? = null
    @Expose
    @SerializedName("district_label")
    val districtLabel: String? = null
    @Expose
    @SerializedName("status")
    val status: String? = null
    @Expose
    @SerializedName("postcode")
    val postcode: String? = null
    @Expose
    @SerializedName("identity_number")
    val identityNumber: String? = null
    @Expose
    @SerializedName("pic")
    val pic: String? = null
    @Expose
    @SerializedName("pic_identity")
    val picIdentity: String? = null
    @Expose
    @SerializedName("last_login")
    val lastLogin: String? = null
    @Expose
    @SerializedName("phone_number")
    val phoneNumber: String? = null
    @Expose
    @SerializedName("updated_at")
    val updatedAt: String? = null
    @Expose
    @SerializedName("created_at")
    val createdAt: String? = null
    @Expose
    @SerializedName("access_token")
    val accessToken: String? = null
    @Expose
    @SerializedName("birthdate")
    val birthdate: String? = null
    @Expose
    @SerializedName("gender")
    val gender: Int? =null
}