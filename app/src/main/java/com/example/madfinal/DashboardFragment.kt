package com.example.madfinal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.example.madfinal.databinding.FragmentDashboardBinding
import com.google.firebase.auth.FirebaseAuth

class DashboardFragment : Fragment(), View.OnClickListener {

    private lateinit var dataBind: FragmentDashboardBinding
    private lateinit var auth: FirebaseAuth
    private var startingPosition = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBind = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_dashboard,
            container,
            false
        )
        return dataBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    override fun onClick(view: View) {
        loadFragmentFromBottomNav(view.id)
    }

    private fun setupUI() {
        loadFragmentFromBottomNav(R.id.nav_home)
        dataBind.navHome.setOnClickListener(this)
        dataBind.navAdd.setOnClickListener(this)
        dataBind.navProfile.setOnClickListener(this)
        dataBind.navAnalysis.setOnClickListener(this)
        dataBind.navTransaction.setOnClickListener(this)
    }

    private fun loadFragment(fragment: Fragment?, newPosition: Int): Boolean {
        if (fragment != null) {
            val transaction: FragmentTransaction = childFragmentManager.beginTransaction()
            if (startingPosition > newPosition) {
                transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
            }
            if (startingPosition < newPosition) {
                transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left)
            }
            transaction.replace(R.id.frame_container, fragment)
            transaction.commit()
            startingPosition = newPosition
            return true
        }
        return false
    }

    private fun loadFragmentFromBottomNav(itemId: Int): Boolean {

        var fragment: Fragment? = null
        var position = 0

        when (itemId) {
            R.id.nav_home -> {
                fragment = HomeFragment()
                position = 0
            }

            R.id.nav_transaction -> {
                fragment = TransactionFragment()
                position = 1
            }

            R.id.nav_add -> {
                fragment = AddFragment()
                position = 2
            }

            R.id.nav_analysis -> {
                fragment = AnalysisFragment()
                position = 3
            }

            R.id.nav_profile -> {
                fragment = ProfileFragment()
                position = 4
            }

        }
        return loadFragment(fragment, position)
    }
}