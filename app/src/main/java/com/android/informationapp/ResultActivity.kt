package com.android.informationapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.android.informationapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var dataBinding: ActivityResultBinding
    private var counter: Int = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this@ResultActivity, R.layout.activity_result)
        dataBinding.apply {
            resultText.text = intent.getStringExtra("name") + "\n" + intent.getStringExtra("email")
            shareButton.setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, resultText.text.toString())
                }
                startActivity(sendIntent)
            }

            if (savedInstanceState !== null) {
                resultText.text = savedInstanceState.getString("COUNTER_NUMBER")
                counter = savedInstanceState.getString("COUNTER_NUMBER")?.toInt()!!
            }
            upButton.setOnClickListener {
                counter++
                resultText.text = counter.toString()
            }

        }
        Log.i("Lifecycle", "onCreate")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putString("COUNTER_NUMBER", counter.toString())
        }
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

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Lifecycle", "onRestart")
    }
}