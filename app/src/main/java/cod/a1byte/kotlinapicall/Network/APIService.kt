package cod.a1byte.kotlinapicall.Network

import cod.a1byte.kotlinapicall.Model.RootUser
import cod.a1byte.kotlinapicall.RetrofitClient
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIService {
    @POST("users/login")
    @FormUrlEncoded
    fun registrationPost(@Field("email") email: String,
                         @Field("password") password: String) : Call<RootUser>
}


//**App Utils**

object ApiUtils {

    val BASE_URL = "http://162.243.7.101:4300/api/v1/"

    val apiService: APIService
        get() = RetrofitClient.getClient(BASE_URL)!!.create(APIService::class.java)


}
