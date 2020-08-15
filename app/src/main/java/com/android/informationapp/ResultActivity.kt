package com.android.informationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.informationapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this@ResultActivity, R.layout.activity_result)
        dataBinding.apply {
            Result.text = "${intent.getStringExtra("name")} - ${intent.getStringExtra("email")}"
        }
    }
}