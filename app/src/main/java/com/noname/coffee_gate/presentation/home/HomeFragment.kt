package com.noname.coffee_gate.presentation.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.noname.coffee_gate.BaseFragment
import com.noname.coffee_gate.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : BaseFragment(), OnMachineCliked, OnMenuCliked {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var adapter: MostPopularAdapter
    private lateinit var machinesadapter: MachinesAdapter
    private lateinit var sliderAdapter: SliderAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity()).get(HomeViewModel::class.java)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = MostPopularAdapter(requireActivity(), this)
        machinesadapter = MachinesAdapter(requireActivity(), this)
        sliderAdapter = SliderAdapter()
        rv_popular_products.adapter = machinesadapter
        vp_slider.adapter = sliderAdapter

//        nearest_search.setOnClickListener {
//            rv_popular_products.layoutManager = LinearLayoutManager(context)
//            rv_popular_products.adapter = machinesadapter
//        }

        viewModel.getSliderLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {

            if (vp_slider?.currentItem!! < sliderAdapter.count - 1) {
                vp_slider?.currentItem = vp_slider.currentItem + 1
            } else {
                vp_slider.currentItem = 0
            }
        })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun layoutId(): Int {
        return R.layout.home_fragment
    }

    override fun OnMachineSelected(index: Int) {
        findNavController().navigate(R.id.machine_profile)

    }

    override fun OnMenuCliked(index: Int) {
        findNavController().navigate(R.id.menuedetails)
    }

}
