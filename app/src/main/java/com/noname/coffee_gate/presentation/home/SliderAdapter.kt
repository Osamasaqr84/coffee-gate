package com.noname.coffee_gate.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.noname.coffee_gate.R
import kotlinx.android.synthetic.main.list_item_block_slider.view.*

class SliderAdapter() : PagerAdapter() {


  //  private var items: List<Banner>? = null

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): View {
        val context = container.context

        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.list_item_block_slider, container, false)
        val imgSlider = view.img_slider

        if (position == 1)
            imgSlider.setImageResource(R.drawable.slider2)
//        val mainPair=items?.get(position)?.main_pair as MainPair?
//        Glide.with(context)
//            .load(mainPair?.icon?.imagePath)
//            .into(imgSlider)
//
//        view.setSafeOnClickListener {
//            listener.onTrendSelected(items?.get(position)?.url!!,items?.get(position)?.abTitle)
//        }
        container.addView(view)
        return view
    }

//    fun setData(items: List<Banner>) {
//        this.items = items
//        notifyDataSetChanged()
//    }

    override fun getCount(): Int = 5

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }

}