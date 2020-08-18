package com.android.informationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.android.informationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var mainHandler: Handler
    private var counter: Int = 0
    private val tikTok = object: Runnable {
        override fun run() {
            counter++
            Log.i("Lifecycle", counter.toString())
            mainHandler.postDelayed(this, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        dataBinding.apply {
            setSupportActionBar(toolbarKita)
            supportActionBar?.title = "Biodata"
            button.setOnClickListener {
                intent = Intent(this@MainActivity, ResultActivity::class.java)
                intent.putExtra("name", inputName.text.toString())
                intent.putExtra("email", inputEmail.text.toString())
                startActivity(intent)
            }
        }
        mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(tikTok)
        Log.i("Lifecycle","onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "onStart")
    }


    override fun onPause() {
        super.onPause()
        mainHandler.removeCallbacks(tikTok)
        Log.i("Lifecycle", "onPause")
    }

    override fun onResume() {
        super.onResume()
        mainHandler.post(tikTok)
        Log.i("Lifecycle", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "onRestart")
    }
}