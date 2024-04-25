package com.example.madfinal

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.db.williamchart.ExperimentalFeature
import com.example.madfinal.databinding.FragmentHomeBinding
import com.example.madfinal.databinding.LayoutVerticalBarChartBinding
import com.google.android.material.tabs.TabLayout


class HomeFragment : Fragment() {
    private lateinit var dataBind: FragmentHomeBinding
    private val animationDuration = 1000L

    private var barSet = listOf(
        "JAN" to 4F,
        "FEB" to 7F,
        "MAR" to 2F,
        "MAY" to 2.3F,
        "APR" to 5F,
        "JUN" to 4F
    )

    private var horizontalBarSet = listOf(
        "2020" to 5F,
        "2021" to 6.4F,
        "2022" to 3F
    )

    private var donutSet = listOf(
        20f,
        80f,
        100f
    )

    private var lineSet = listOf(
        "day1" to 5f,
        "day2" to 4.5f,
        "day3" to 4.7f,
        "day4" to 3.5f,
        "day5" to 3.6f,
        "day6" to 7.5f,
        "day7" to 7.5f,
        "day8" to 10f,
        "day9" to 5f,
        "day10" to 6.5f,
        "day11" to 3f,
        "day12" to 4f
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBind = FragmentHomeBinding.inflate(inflater, container, false)
        return dataBind.root
    }

    @OptIn(ExperimentalFeature::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBind.apply {

            call()

            // Set up tab selection listener
            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    // Show toast message based on selected tab
                    when (tab?.position) {
                        0 -> showViews(verticalBarChart.root)
                        1 -> showViews(horizontalBarChart.root)
                        2 -> showViews(donutChart.root)
                        3 -> showViews(lineChart.root)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    // Do nothing
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    // Do nothing
                }
            })

        }
    }
    fun showViews(vararg views: View) {
        call()
        views.forEach { it.visibility = View.VISIBLE }
        val hiddenViews = listOf(dataBind.verticalBarChart.root, dataBind.horizontalBarChart.root, dataBind.donutChart.root, dataBind.lineChart.root) - views
        hiddenViews.forEach { it.visibility = View.GONE }
    }
    @OptIn(ExperimentalFeature::class)
    fun call(){
        // Vertical Chart
        dataBind.verticalBarChart.barChart.animation.duration = animationDuration
        dataBind.verticalBarChart.barChart.animate(barSet)

        //Horizontal Chart
        dataBind.horizontalBarChart.barChartHorizontal.animation.duration = animationDuration
        dataBind.horizontalBarChart.barChartHorizontal.animate(horizontalBarSet)

        // donut Chart
        dataBind.donutChart.donutChart.donutColors = intArrayOf(
            Color.parseColor("#FFFFFF"),
            Color.parseColor("#345673"),
            Color.parseColor("#645829")
        )
        dataBind.donutChart.donutChart.animation.duration = animationDuration
        dataBind.donutChart.donutChart.animate(donutSet)

        // line Chart
        dataBind.lineChart.lineChart.gradientFillColors =
            intArrayOf(
                Color.parseColor("#FFFFFFFF"),
                Color.TRANSPARENT
            )
        dataBind.lineChart.lineChart.animation.duration = animationDuration

        dataBind.lineChart.lineChart.onDataPointTouchListener = { index, _, _ ->
            dataBind.lineChart.tvChartData.text = lineSet.toList()[index].second.toString()
        }
        dataBind.lineChart.lineChart.animate(lineSet)
    }

}
