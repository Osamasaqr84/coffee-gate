package com.noname.coffee_gate.presentation.menus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.noname.coffee_gate.R
import com.noname.coffee_gate.presentation.home.OnMenuCliked
import kotlinx.android.synthetic.main.home_product_item_list.view.*

class MenusAdapter(activity: FragmentActivity,val listener: OnMenuCliked) : RecyclerView.Adapter<MenusAdapter.CustomView>() {

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
//        val ivProfilee = mView.ivProfilee
//        val action = mView.desion
        val product_img = mView.product_img

        fun bindTo(listener: OnMenuCliked) {
            mView.setOnClickListener {
                listener.OnMenuCliked(0)
            }
            product_img.setCornerRadius(16f, 16f, 0f, 0f)
        }
    }

}
