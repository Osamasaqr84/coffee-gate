package com.noname.coffee_gate.presentation.contactus

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noname.coffee_gate.BaseFragment

import com.noname.coffee_gate.R

class ContactUsFragment : BaseFragment() {

    companion object {
        fun newInstance() = ContactUsFragment()
    }

    private lateinit var viewModel: ContactUsViewModel


    override fun layoutId(): Int {
        return R.layout.contact_us_fragment
    }

}
