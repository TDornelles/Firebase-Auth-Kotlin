package com.firebase.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.firebase.auth.databinding.ActivityLoginBinding
import com.firebase.auth.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.hide()

        binding.btnExit.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        var userName: String? = FirebaseAuth.getInstance().currentUser?.displayName
        var userEmail: String? = FirebaseAuth.getInstance().currentUser?.email

        var tvUserInfo = binding.tvUserInfo
        var userData: String = ("Nome:" + userName + "\nEmail:" + userEmail)
        tvUserInfo.setText(userData)
    }
}