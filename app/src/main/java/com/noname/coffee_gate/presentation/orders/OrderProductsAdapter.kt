package com.noname.coffee_gate.presentation.orders

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.noname.coffee_gate.R
import com.noname.coffee_gate.presentation.home.OnMenuCliked
import kotlinx.android.synthetic.main.list_item_order.view.*

class OrderProductsAdapter(activity: FragmentActivity) : RecyclerView.Adapter<OrderProductsAdapter.CustomView>() {

    private val context: Context = activity.baseContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {

        return CustomView(
            LayoutInflater.from(context).inflate(R.layout.order_details_item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {

   }

    override fun getItemCount(): Int {
        return 7
    }

    class CustomView(val mView: View) : RecyclerView.ViewHolder(mView) {
        val order_img = mView.order_img
//        val description = mView.description
//        val ivProfilee = mView.ivProfilee
//        val action = mView.desion

        fun bindTo() {
//            mView.setOnClickListener {
//                listener.OnMenuCliked(0)
//            }
            order_img.setCornerRadius(16f,16f,0f,0f)
        }

    }

}
