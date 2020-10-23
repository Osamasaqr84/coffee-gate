package com.noname.coffee_gate.presentation.menus

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.noname.coffee_gate.BaseFragment

import com.noname.coffee_gate.R
import com.noname.coffee_gate.presentation.home.MachinesAdapter
import com.noname.coffee_gate.presentation.home.OnMenuCliked
import kotlinx.android.synthetic.main.menus_fragment.*

class MenusFragment : BaseFragment() ,OnMenuCliked{

    companion object {
        fun newInstance() = MenusFragment()
    }

    private lateinit var viewModel: MenusViewModel
    private lateinit var menuesadapter: MenusAdapter


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MenusViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menuesadapter = MenusAdapter(activity!!,this)
        rv_menues.adapter = menuesadapter
    }
    override fun layoutId(): Int {
        return R.layout.menus_fragment
    }

    override fun OnMenuCliked(index: Int) {
        findNavController().navigate(R.id.menuedetails)
    }

}
