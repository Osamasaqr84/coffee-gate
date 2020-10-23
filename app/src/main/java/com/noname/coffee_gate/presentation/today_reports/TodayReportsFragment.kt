package com.noname.coffee_gate.presentation.today_reports

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.noname.coffee_gate.BaseFragment

import com.noname.coffee_gate.R
import com.noname.coffee_gate.presentation.orders.OnOrderCliked
import kotlinx.android.synthetic.main.today_reports_fragment.*

class TodayReportsFragment : BaseFragment() , OnOrderCliked {

    companion object {
        fun newInstance() = TodayReportsFragment()
    }

    private lateinit var viewModel: TodayReportsViewModel
    private lateinit var adapter: ReportsOrdersAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ReportsOrdersAdapter(activity!!,this)
        rv_reports_orders.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TodayReportsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun layoutId(): Int {
        return  R.layout.today_reports_fragment
    }

    override fun OnOrderCliked(orderId: Int) {
        findNavController().navigate(R.id.order_details)
    }

}
