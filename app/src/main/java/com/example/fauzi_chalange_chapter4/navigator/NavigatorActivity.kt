package com.example.fauzi_chalange_chapter4.navigator

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fauzi_chalange_chapter4.MainActivity
import com.example.fauzi_chalange_chapter4.login.LoginActivity

class NavigatorActivity : AppCompatActivity() {
    private val viewModel by viewModels<NavigatorViewModel>{
        NavigatorViewModel.provideFactory(this, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (viewModel.checkLogin()){
            startActivity(Intent(this, MainActivity::class.java))
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}