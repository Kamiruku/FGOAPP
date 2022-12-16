package com.example.fgoapp

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener

class Calculator : AppCompatActivity(), CalculatorFragmentRefund.OnDataPass {
    companion object{
        var enemyDetails: List<String?> = emptyList()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            MainActivity.data.hideDecor(window)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        val viewPager: ViewPager = findViewById(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("Main"))
        tabLayout.addTab(tabLayout.newTab().setText("Refund"))

        val adapter: MyAdapter = MyAdapter(this, supportFragmentManager, tabLayout.tabCount, enemyDetails)
        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    override fun onDataPass(data: List<String?>) {
        enemyDetails = data
    }
}

class MyAdapter(context: Context, fm: FragmentManager?, totalTabs: Int, enemyDetails: List<String?>) : FragmentPagerAdapter(fm!!) {
    private val myContext: Context
    private var totalTabs: Int

    init {
        myContext = context
        this.totalTabs = totalTabs
    }

    // this is for fragment tabs
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> CalculatorFragmentMain()
            1 -> CalculatorFragmentRefund()
            else -> CalculatorFragmentMain()
        }
    }

    // this counts total number of tabs
    override fun getCount(): Int {
        return totalTabs
    }
}
