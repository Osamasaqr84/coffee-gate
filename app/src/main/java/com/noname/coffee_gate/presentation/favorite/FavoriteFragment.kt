package com.noname.coffee_gate.presentation.favorite

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noname.coffee_gate.BaseFragment

import com.noname.coffee_gate.R
import com.noname.coffee_gate.presentation.home.MostPopularAdapter
import kotlinx.android.synthetic.main.favorite_fragment.*

class FavoriteFragment : BaseFragment() {

    companion object {
        fun newInstance() = FavoriteFragment()
    }

    private lateinit var viewModel: FavoriteViewModel
    private lateinit var adapter: FavoriteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = FavoriteAdapter(activity!!)
        rv_fav_products .adapter = adapter
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FavoriteViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun layoutId(): Int {
        return  R.layout.favorite_fragment
    }

}
