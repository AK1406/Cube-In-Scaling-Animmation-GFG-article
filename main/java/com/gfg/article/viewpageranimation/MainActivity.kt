package com.gfg.article.viewpageranimation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager


class MainActivity : AppCompatActivity() {
    // creating object of ViewPager
    lateinit var mViewPager: ViewPager

    // images array
    private var images = intArrayOf(R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4)

    // Creating Object of ViewPagerAdapter
    private lateinit var mViewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the ViewPager Object
        mViewPager = findViewById(R.id.viewPagerMain)

        mViewPager.setPageTransformer(true, CubeInScalingAnimation())

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = ViewPagerAdapter(this@MainActivity, images)

        // Adding the Adapter to the ViewPager
        mViewPager.adapter = mViewPagerAdapter
    }
}
