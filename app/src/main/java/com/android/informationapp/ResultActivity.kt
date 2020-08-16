package com.android.informationapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.android.informationapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityResultBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this@ResultActivity, R.layout.activity_result)
        dataBinding.apply {
            Result.text = intent.getStringExtra("name") + "\n" + intent.getStringExtra("email")
            button2.setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, Result.text.toString())
                }
                startActivity(sendIntent)
            }
        }
        Log.i("Lifecycle", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i("Lifecycle", "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Lifecycle", "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Lifecycle", "onResume")
    }
}