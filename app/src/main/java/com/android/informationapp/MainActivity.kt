package com.android.informationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.informationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        dataBinding.apply {
            button.setOnClickListener {
                intent = Intent(this@MainActivity, ResultActivity::class.java)
                intent.putExtra("name", inputName.text.toString())
                intent.putExtra("email", inputEmail.text.toString())
                startActivity(intent)
            }
        }
    }
}