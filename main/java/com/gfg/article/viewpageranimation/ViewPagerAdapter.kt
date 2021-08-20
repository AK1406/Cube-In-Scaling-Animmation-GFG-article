package com.gfg.article.viewpageranimation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import java.util.*


internal class ViewPagerAdapter(private val context: Context, private val images: IntArray) : PagerAdapter() {

    //Layout Inflater
    var mLayoutInflater: LayoutInflater
    override fun getCount(): Int {
        //return the number of images
        return images.size
    }

    init {
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //inflating the item.xml
        val itemView: View = mLayoutInflater.inflate(R.layout.item, container, false)

        //referencing the image view from the item.xml file
        val imageView: ImageView = itemView.findViewById(R.id.imageViewMain)

        //setting the image in the imageView
        imageView.setImageResource(images[position])

        //Adding the View
        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }


}

