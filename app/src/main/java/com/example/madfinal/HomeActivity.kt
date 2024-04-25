package com.example.madfinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.view.View
import com.example.madfinal.databinding.HomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity(){

    private lateinit var auth: FirebaseAuth

    private lateinit var homebinding: HomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homebinding = HomeBinding.inflate(layoutInflater)
        setContentView(homebinding.root)
        auth = FirebaseAuth.getInstance()


    }

}
