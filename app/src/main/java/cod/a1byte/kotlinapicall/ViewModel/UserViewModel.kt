package cod.a1byte.kotlinapicall.ViewModel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.util.Log
import android.view.View
import cod.a1byte.kotlinapicall.Model.RootUser
import cod.a1byte.kotlinapicall.Model.User
import cod.a1byte.kotlinapicall.Network.APIService
import cod.a1byte.kotlinapicall.Network.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import cod.a1byte.kotlinapicall.BR

class UserViewModel(private val user: User) : Observer, BaseObservable() {
    override fun update(p0: Observable?, p1: Any?) {
        if (p1 is String) {
            if (p1 == "age") {
                notifyPropertyChanged(BR.age)
            }
            if (p1 == "email") {
                notifyPropertyChanged(BR.email)
            }
            if (p1 == "fullName") {
                notifyPropertyChanged(BR.fullName)
            }
            if (p1 == "gender") {
                notifyPropertyChanged(BR.gender)
            }
        }
    }

    init {
        user.addObserver(this)
    }

    var email: String = ""
        @Bindable get() {
            return user.email
        }
        set(value) {
            if (field != value) {
                field = value
                user.email = value
                notifyPropertyChanged(BR.email)
            }
        }
    var password: String = ""
        @Bindable get() {
            return user.password
        }
        set(value) {
            if (field != value) {
                field = value
                user.password = value
                notifyPropertyChanged(BR.password)
            }
        }
    val age: String
        @Bindable get() {
            return user.age
        }
    val fullName: String
        @Bindable get() {
            return user.fullName
        }
    val gender: String
        @Bindable get() {
            return user.gender
        }
    val registrationType: String
        @Bindable
        get() {
            return user.registrationType
        }

    fun onButtonClick(view: View) {
        sendCall()
    }


    private fun sendCall() {
        var mAPIService: APIService? = null

        mAPIService = ApiUtils.apiService
        mAPIService.registrationPost(email, password).enqueue(object : Callback<RootUser> {
            //        mAPIService!!.registrationPost("asd@asd.com", "qwerty1+A").enqueue(object : Callback<RootUser> {
            override fun onResponse(call: Call<RootUser>, response: Response<RootUser>) {
                Log.i("resp", "post submitted to API." + response.body())
                if (response.isSuccessful()) {
                    var user: User
                    user = response.body()!!.user
                    updateData(user)
//                    user.setChangedAndNotify(BR._all)
//                    user.email =email
//                    user.fullName = user.fullName


                    //  notifyChange()
                    Log.i("", "post registration to API" + response.body()!!.toString())
                }
            }

            override fun onFailure(call: Call<RootUser>, t: Throwable) {
                Log.e("Resp", t.message)
            }
        })
    }

    private fun updateData(user: User) {
       // this.user = user
        this.user.fullName = user.email
        this.user.age = user.age
        this.user.gender = user.gender
//        this.user.setChangedAndNotify(user)
    }
}