package com.noname.coffee_gate.presentation.authentication.forgetpassword

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.noname.coffee_gate.BaseFragment

import com.noname.coffee_gate.R
import com.noname.coffee_gate.local.PreferenceHelper
import com.noname.coffee_gate.presentation.authentication.AuthenticationViewModel
import kotlinx.android.synthetic.main.login_fragment.*

class ForgetPasswordFragment : BaseFragment() {

    companion object {
        fun newInstance() = ForgetPasswordFragment()
    }

    private lateinit var viewModel: AuthenticationViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AuthenticationViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun layoutId(): Int {
        return R.layout.forget_password_fragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
