package com.noname.coffee_gate.presentation.orders

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.noname.coffee_gate.BaseFragment

import com.noname.coffee_gate.R
import com.noname.coffee_gate.presentation.favorite.FavoriteAdapter
import com.noname.coffee_gate.presentation.home.OnMenuCliked
import kotlinx.android.synthetic.main.favorite_fragment.*
import kotlinx.android.synthetic.main.orders_fragment.*

class OrdersFragment : BaseFragment(),OnOrderCliked {

    companion object {
        fun newInstance() = OrdersFragment()
    }

    private lateinit var viewModel: OrdersViewModel
    private lateinit var adapter: OrdersAdapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OrdersViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = OrdersAdapter(activity!!,this)
        rv_orders.adapter = adapter
    }
    override fun layoutId(): Int {
        return R.layout.orders_fragment
    }

    override fun OnOrderCliked(orderId: Int) {
        findNavController().navigate(R.id.order_details)
    }

}
