package com.noname.coffee_gate.presentation.machineprofile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.noname.coffee_gate.BaseFragment

import com.noname.coffee_gate.R
import com.noname.coffee_gate.presentation.home.MostPopularAdapter
import com.noname.coffee_gate.presentation.home.OnMenuCliked
import kotlinx.android.synthetic.main.machine_profile_fragment.*

class MachineProfileFragment : BaseFragment(),OnMenuCliked {

    companion object {
        fun newInstance() = MachineProfileFragment()
    }

    private lateinit var viewModel: MachineProfileViewModel
    private lateinit var adapter: MostPopularAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = MostPopularAdapter(activity!!,this)

        rv_machine_products.adapter = adapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MachineProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun layoutId(): Int {
        return R.layout.machine_profile_fragment
    }

    override fun OnMenuCliked(index: Int) {
        findNavController().navigate(R.id.menuedetails)
    }

}
