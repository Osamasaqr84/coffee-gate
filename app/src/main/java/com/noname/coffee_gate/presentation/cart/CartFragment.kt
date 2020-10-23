package com.noname.coffee_gate.presentation.cart

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.noname.coffee_gate.BaseFragment

import com.noname.coffee_gate.R
import kotlinx.android.synthetic.main.cart_fragment.*

class CartFragment : BaseFragment() {

    companion object {
        fun newInstance() =
            CartFragment()
    }

    private lateinit var viewModel: CartViewModel
    private lateinit var adapter: CartAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CartAdapter(activity!!)
        rv_products.adapter = adapter

        confirm.setOnClickListener {
            showConfirmDialog()
        }
    }


    private fun showConfirmDialog() {
        val builder = Dialog(requireActivity())
        builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
        builder.setCancelable(true)
        builder.setContentView(R.layout.confirm_dialog)
        builder.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        requireActivity().window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        val confirmButton = builder.findViewById(R.id.confirmButton) as TextView
        builder.setTitle("")
        confirmButton.setOnClickListener {
            builder.dismiss()
           findNavController().navigate(R.id.orders)
        }

        builder.show()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CartViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun layoutId(): Int {
        return R.layout.cart_fragment
    }

}
