package cod.a1byte.kotlinapicall.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class User :Observable() {
    @SerializedName("_id")
    @Expose
    public var id: String? = ""
        set(value) {
            field = value
            setChangedAndNotify("id")
        }

    @SerializedName("age")
    @Expose
    public var age: String = ""
        set(value) {
            field = value
            setChangedAndNotify("age")
        }

    @SerializedName("area")
    @Expose
    public var area: String? = ""
        set(value) {
            field = value
            setChangedAndNotify("area")
        }

    @SerializedName("dateOfBirth")
    @Expose
    public var dateOfBirth: String? = ""
        set(value) {
            field = value
            setChangedAndNotify("dateOfBirth")
        }

    @SerializedName("deviceId")
    @Expose
    public var deviceId: String? = ""
        set(value) {
            field = value
            setChangedAndNotify("deviceId")
        }

    @SerializedName("deviceType")
    @Expose
    public var deviceType: String? = ""
        set(value) {
            field = value
            setChangedAndNotify("deviceType")
        }

    @SerializedName("email")
    @Expose
    public var email: String = ""
        set(value) {
            field = value
            setChangedAndNotify("email")
        }

    @SerializedName("password")
    @Expose
    public var password: String = ""
        set(value) {
            field = value
            setChangedAndNotify("password")
        }


    @SerializedName("fullName")
    @Expose
    public var fullName: String = ""
        set(value) {
            field = value
            setChangedAndNotify("fullName")
        }

    @SerializedName("gender")
    @Expose
    public var gender: String = ""
        set(value) {
            field = value
            setChangedAndNotify("gender")
        }

    @SerializedName("mobileNumber")
    @Expose
    public var mobileNumber: String = ""
        set(value) {
            field = value
            setChangedAndNotify("mobileNumber")
        }

    @SerializedName("registrationType")
    @Expose
    public var registrationType: String = ""
        set(value) {
            field = value
            setChangedAndNotify("registrationType")
        }

    @SerializedName("profileImage")
    @Expose
    public var profileImage: String = ""
        set(value) {
            field = value
            setChangedAndNotify("profileImage")
        }

    @SerializedName("token")
    @Expose
    public var token: String = ""
        set(value) {
            field = value
            setChangedAndNotify("token")
        }
    public fun setChangedAndNotify(field: Any)
    {
        setChanged()
        notifyObservers(field)
    }
}