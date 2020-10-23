package com.noname.coffee_gate.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.noname.coffee_gate.R
import kotlinx.android.synthetic.main.home_product_item_list.view.*

class MostPopularAdapter(activity: FragmentActivity,private val listener:OnMenuCliked) : RecyclerView.Adapter<MostPopularAdapter.CustomView>() {

    private val context: Context = activity.baseContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {

        return CustomView(
            LayoutInflater.from(context).inflate(R.layout.home_product_item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {

        with(holder)
        {
            bindTo(listener)
        }

   }

    override fun getItemCount(): Int {
        return 7
    }

    class CustomView(val mView: View) : RecyclerView.ViewHolder(mView) {
//        val title = mView.title
//        val description = mView.description
        val product_img = mView.product_img


        fun bindTo(listener: OnMenuCliked) {
            mView.setOnClickListener {
                listener.OnMenuCliked(0)
            }
            product_img.setCornerRadius(16f,16f,0f,0f)
        }
//        val action = mView.desion
    }

}
