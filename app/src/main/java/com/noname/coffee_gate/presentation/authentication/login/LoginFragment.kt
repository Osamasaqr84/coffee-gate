package com.noname.coffee_gate.presentation.authentication.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.noname.coffee_gate.BaseFragment

import com.noname.coffee_gate.R
import com.noname.coffee_gate.local.PreferenceHelper
import com.noname.coffee_gate.presentation.authentication.AuthenticationViewModel
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : BaseFragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: AuthenticationViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AuthenticationViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun layoutId(): Int {
        return R.layout.login_fragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        go_to_register.setOnClickListener {
            findNavController().navigate(R.id.register)
        }

        forget_password.setOnClickListener {
            findNavController().navigate(R.id.forget_password)
        }
        sign_in.setOnClickListener {
            if (email.text.toString() == "admin")
                PreferenceHelper.setUserGroupId(2)
            else if (email.text.toString() == "user")
                 PreferenceHelper.setUserGroupId(1)

            val intent = activity?.intent
                activity?.finish()
                activity?.startActivity(intent)
        }
    }
}
