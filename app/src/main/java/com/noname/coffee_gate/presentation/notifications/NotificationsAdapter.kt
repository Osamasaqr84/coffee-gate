package com.noname.coffee_gate.presentation.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.noname.coffee_gate.R

class NotificationsAdapter(activity: FragmentActivity) : RecyclerView.Adapter<NotificationsAdapter.CustomView>() {

    private val context: Context = activity.baseContext

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {

        return CustomView(
            LayoutInflater.from(context).inflate(R.layout.notification_item_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {

   }

    override fun getItemCount(): Int {
        return 10
    }

    class CustomView(val mView: View) : RecyclerView.ViewHolder(mView) {
//        val title = mView.title
//        val description = mView.description
//        val ivProfilee = mView.ivProfilee
//        val action = mView.desion
    }

}
