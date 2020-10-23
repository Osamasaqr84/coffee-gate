package com.noname.coffee_gate.presentation.today_reports

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.noname.coffee_gate.R
import com.noname.coffee_gate.presentation.orders.OnOrderCliked
import kotlinx.android.synthetic.main.order_report.view.*

class ReportsOrdersAdapter(
    activity: FragmentActivity,
    private val listener: OnOrderCliked
) : RecyclerView.Adapter<ReportsOrdersAdapter.CustomView>() {

    private val context: Context = activity.baseContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {

        return CustomView(
            LayoutInflater.from(context).inflate(
                R.layout.order_report,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {

        with(holder)
        {
            bindTo(listener)
        }
    }

    override fun getItemCount(): Int {
        return 5
    }

    class CustomView(val mView: View) : RecyclerView.ViewHolder(mView) {
        //        val title = mView.title
//        val description = mView.description
//        val ivProfilee = mView.ivProfilee
        val order_details = mView.order_details

        fun bindTo(listener: OnOrderCliked) {
            order_details.setOnClickListener {
                listener.OnOrderCliked(1)
            }
        }
    }

}
