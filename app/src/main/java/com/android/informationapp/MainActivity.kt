package com.android.informationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        Log.i("Lifecycle","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "onStart")
    }


    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "onPause")
    }
}