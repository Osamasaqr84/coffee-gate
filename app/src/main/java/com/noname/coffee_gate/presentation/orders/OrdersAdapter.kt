package com.noname.coffee_gate.presentation.orders

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.noname.coffee_gate.R
import kotlinx.android.synthetic.main.list_item_order.view.*

class OrdersAdapter(activity: FragmentActivity,val listener:OnOrderCliked) : RecyclerView.Adapter<OrdersAdapter.CustomView>() {

    private val context: Context = activity.baseContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {

        return CustomView(
            LayoutInflater.from(context).inflate(R.layout.list_item_order, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {

        with(holder){
            bindTo(listener)
        }
   }

    override fun getItemCount(): Int {
        return 7
    }

    class CustomView(val mView: View) : RecyclerView.ViewHolder(mView) {
        val order_img = mView.order_img
//        val description = mView.description
//        val ivProfilee = mView.ivProfilee
//        val action = mView.desion

        fun bindTo(listener: OnOrderCliked) {
            mView.setOnClickListener {
                listener.OnOrderCliked(1)
            }
            order_img.setCornerRadius(16f,16f,0f,0f)
        }

    }

}
