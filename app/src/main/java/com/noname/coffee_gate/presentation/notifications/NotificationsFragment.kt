package com.noname.coffee_gate.presentation.notifications

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.noname.coffee_gate.BaseFragment
import com.noname.coffee_gate.R
import kotlinx.android.synthetic.main.notifications_fragment.*

class NotificationsFragment : BaseFragment() {

    companion object {
        fun newInstance() = NotificationsFragment()
    }

    private lateinit var viewModel: NotificationsViewModel
    private lateinit var adapter: NotificationsAdapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NotificationsAdapter(activity!!)
        rv_notification .adapter = adapter

    }
    override fun layoutId(): Int {

        return R.layout.notifications_fragment
    }

}
