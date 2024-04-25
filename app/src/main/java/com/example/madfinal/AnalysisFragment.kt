//package com.example.madfinal
//
//import android.graphics.Color
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Toast
//import com.db.williamchart.ExperimentalFeature
//import com.example.madfinal.databinding.FragmentAnalysisBinding
//import com.google.android.material.tabs.TabLayout
//
//
//class AnalysisFragment : Fragment() {
//    // Define properties directly within AnalysisFragment
//    private var barSet = listOf(
//        "JAN" to 4F,
//        "FEB" to 7F,
//        "MAR" to 2F,
//        "MAY" to 2.3F,
//        "APR" to 5F,
//        "JUN" to 4F
//    )
//    private var horizontalBarSet = listOf(
//        "2020" to 5F,
//        "2021" to 6.4F,
//        "2022" to 3F
//    )
//    private var donutSet = listOf(
//        20f,
//        80f,
//        100f
//    )
//    private var lineSet = listOf(
//        "day1" to 5f,
//        "day2" to 4.5f,
//        "day3" to 4.7f,
//        "day4" to 3.5f,
//        "day5" to 3.6f,
//        "day6" to 7.5f,
//        "day7" to 7.5f,
//        "day8" to 10f,
//        "day9" to 5f,
//        "day10" to 6.5f,
//        "day11" to 3f,
//        "day12" to 4f
//    )
//    private var animationDuration = 1000L
//    private lateinit var dataBind: FragmentAnalysisBinding
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        dataBind = FragmentAnalysisBinding.inflate(inflater,container,false)
//        return dataBind.root
//    }
//    @OptIn(ExperimentalFeature::class)
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        dataBind.apply {
//
//            tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//                override fun onTabSelected(tab: TabLayout.Tab?) {
//                    // Check which tab is selected and show the corresponding views
//                    when (tab?.id) {
//                        R.id.home_vertcalBar_Charts -> {
//                            Toast.makeText(context, "clicked1", Toast.LENGTH_SHORT).show()
//                            //  vertical Bar
//                            barChart.animation.duration = animationDuration
//                            barChart.animate(barSet)
//
//                            vertiFinal.visibility = View.VISIBLE
//                            horizFinal.visibility = View.GONE
//                            donutFinal.visibility = View.GONE
//                            lineFinal.visibility = View.GONE
//                        }
//                        R.id.home_horizondalBar_Charts -> {
//                            Toast.makeText(context, "clicked2", Toast.LENGTH_SHORT).show()
//                            //  Horizontal Bar
//                            barChartHorizontal.animation.duration = animationDuration
//                            barChartHorizontal.animate(horizontalBarSet)
//
//                            vertiFinal.visibility = View.GONE
//                            horizFinal.visibility = View.VISIBLE
//                            donutFinal.visibility = View.GONE
//                            lineFinal.visibility = View.GONE
//                        }
//                        R.id.home_donut_Charts -> {
//                            Toast.makeText(context, "clicked3", Toast.LENGTH_SHORT).show()
//                            //  Donut
//                            donutChart.donutColors = intArrayOf(
//                                Color.parseColor("#FFFFFF"),
//                                Color.parseColor("#345673"),
//                                Color.parseColor("#645829")
//                            )
//                            donutChart.animation.duration = animationDuration
//                            donutChart.animate(donutSet)
//                            vertiFinal.visibility = View.GONE
//                            horizFinal.visibility = View.GONE
//                            donutFinal.visibility = View.VISIBLE
//                            lineFinal.visibility = View.GONE
//                        }
//                        R.id.home_line_Charts -> {
//                            Toast.makeText(context, "clicked4", Toast.LENGTH_SHORT).show()
//                            //  line
//                            lineChart.gradientFillColors =
//                                intArrayOf(
//                                    Color.parseColor("#FFFFFF"),
//                                    Color.TRANSPARENT
//                                )
//                            lineChart.animation.duration = animationDuration
//                            lineChart.onDataPointTouchListener = { index, _, _ ->
//                                tvChartData.text = lineSet.toList()[index]
//                                    .second
//                                    .toString()
//                            }
//                            lineChart.animate(lineSet)
//                            vertiFinal.visibility = View.GONE
//                            horizFinal.visibility = View.GONE
//                            donutFinal.visibility = View.GONE
//                            lineFinal.visibility = View.VISIBLE
//                        }
//                    }
//                }
//
//                override fun onTabUnselected(tab: TabLayout.Tab?) {
//                    // Not needed in this case
//                }
//
//                override fun onTabReselected(tab: TabLayout.Tab?) {
//                    // Not needed in this case
//                }
//            })
//
////            homeVertcalBarCharts.setOnClickListener {
////                vertiFinal.visibility = View.VISIBLE
////                horizFinal.visibility = View.GONE
////                donutFinal.visibility = View.GONE
////                lineFinal.visibility = View.GONE
////            }
////            homeHorizondalBarCharts.setOnClickListener {
////                vertiFinal.visibility = View.GONE
////                horizFinal.visibility = View.VISIBLE
////                donutFinal.visibility = View.GONE
////                lineFinal.visibility = View.GONE
////            }
////            homeDonutCharts.setOnClickListener {
////                vertiFinal.visibility = View.GONE
////                horizFinal.visibility = View.GONE
////                donutFinal.visibility = View.VISIBLE
////                lineFinal.visibility = View.GONE
////            }
////            homeLineCharts.setOnClickListener {
////                vertiFinal.visibility = View.GONE
////                horizFinal.visibility = View.GONE
////                donutFinal.visibility = View.GONE
////                lineFinal.visibility = View.VISIBLE
////            }
//        }
//
//    }
//
//
//}
package com.example.madfinal

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.db.williamchart.ExperimentalFeature
import com.example.madfinal.databinding.FragmentAnalysisBinding
import com.google.android.material.tabs.TabLayout

class AnalysisFragment : Fragment() {
    private lateinit var dataBind: FragmentAnalysisBinding
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
        dataBind = FragmentAnalysisBinding.inflate(inflater, container, false)
        return dataBind.root
    }

    @OptIn(ExperimentalFeature::class)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBind.apply {
            tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    tab?.let {
                        handleTabSelection(it.id)
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {}

                override fun onTabReselected(tab: TabLayout.Tab?) {}
            })
        }
    }

    private fun handleTabSelection(tabId: Int) {
        when (tabId) {
            R.id.home_vertcalBar_Charts -> {
                Toast.makeText(context, "clicked1", Toast.LENGTH_SHORT).show()
                dataBind.barChart.animation.duration = animationDuration
                dataBind.barChart.animate(barSet)
                showViews(dataBind.vertiFinal)
            }
            R.id.home_horizontalBar_Charts -> {
                Toast.makeText(context, "clicked2", Toast.LENGTH_SHORT).show()
                dataBind.barChartHorizontal.animation.duration = animationDuration
                dataBind.barChartHorizontal.animate(horizontalBarSet)
                showViews(dataBind.horizFinal)
            }
            R.id.home_donut_Charts -> {
                Toast.makeText(context, "clicked3", Toast.LENGTH_SHORT).show()
                dataBind.donutChart.donutColors = intArrayOf(
                    Color.parseColor("#FFFFFF"),
                    Color.parseColor("#345673"),
                    Color.parseColor("#645829")
                )
                dataBind.donutChart.animation.duration = animationDuration
                dataBind.donutChart.animate(donutSet)
                showViews(dataBind.donutFinal)
            }
            R.id.home_line_Charts -> {
                Toast.makeText(context, "clicked4", Toast.LENGTH_SHORT).show()

                dataBind.lineChart.gradientFillColors =
                    intArrayOf(
                        Color.parseColor("#FFFFFF"),
                        Color.TRANSPARENT
                    )
                dataBind.lineChart.animation.duration = animationDuration
                dataBind.lineChart.onDataPointTouchListener = { index, _, _ ->
                    dataBind.tvChartData.text = lineSet.toList()[index].second.toString()
                }
                dataBind.lineChart.animate(lineSet)
                showViews(dataBind.lineFinal)
            }
        }
    }


    private fun showViews(vararg views: View) {
        views.forEach { it.visibility = View.VISIBLE }
        val hiddenViews = listOf(dataBind.vertiFinal, dataBind.horizFinal, dataBind.donutFinal, dataBind.lineFinal) - views
        hiddenViews.forEach { it.visibility = View.GONE }
    }
}
