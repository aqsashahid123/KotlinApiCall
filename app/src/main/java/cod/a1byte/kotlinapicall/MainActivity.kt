package cod.a1byte.kotlinapicall

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import cod.a1byte.kotlinapicall.Model.User
import cod.a1byte.kotlinapicall.ViewModel.UserViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = User()
        user.age = "12"
        user.area="canal"
        user.dateOfBirth ="ds"
        user.fullName ="fullName"
//
        val userViewModel = UserViewModel(user)
        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)
        binding.setVariable(BR.modelata, userViewModel)
    }
}
