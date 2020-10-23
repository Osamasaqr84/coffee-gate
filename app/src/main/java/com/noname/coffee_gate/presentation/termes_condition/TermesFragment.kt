package com.noname.coffee_gate.presentation.termes_condition

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.noname.coffee_gate.R

class TermesFragment : Fragment() {

    companion object {
        fun newInstance() = TermesFragment()
    }

    private lateinit var viewModel: TermesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.termes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TermesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
