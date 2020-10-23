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
import kotlinx.android.synthetic.main.favorite_fragment.*
import kotlinx.android.synthetic.main.order_details_fragment.*
import kotlinx.android.synthetic.main.orders_fragment.*
import kotlinx.android.synthetic.main.product_details_fragment.*

class OrderDetailsFragment : BaseFragment() {

    companion object {
        fun newInstance() = OrderDetailsFragment()
    }

    private lateinit var viewModel: OrdersViewModel
    private lateinit var adapter: OrderProductsAdapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OrdersViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = OrderProductsAdapter(activity!!)
        rv_products.adapter = adapter


    }

    override fun layoutId(): Int {
        return R.layout.order_details_fragment
    }

}
