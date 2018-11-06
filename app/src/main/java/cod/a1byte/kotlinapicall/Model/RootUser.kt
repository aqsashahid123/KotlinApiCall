package cod.a1byte.kotlinapicall.Model

import com.google.gson.annotations.SerializedName

class RootUser {
    @SerializedName("status")
    var status: Status? = null
    @SerializedName("user")

    var user: User = User()

}