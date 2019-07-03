package com.lifecycle.example

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

open class BaseActivity : AppCompatActivity(), View.OnClickListener {


    val SUPER_TAG = "Activity Life Cycle : "
    val TAG = this::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvTitle = findViewById<TextView>(R.id.tvActivityTitle)
        Log.d(TAG, "$SUPER_TAG:$TAG in onCreate()")

        val btnStart1 = findViewById<Button>(R.id.btnStartActivity1)
        val btnFinish1 = findViewById<Button>(R.id.btnFinishActivity1)
        val btnStart2 = findViewById<Button>(R.id.btnStartActivity2)
        val btnFinish2 = findViewById<Button>(R.id.btnFinishActivity2)
        val btnStart3 = findViewById<Button>(R.id.btnStartActivity3)
        val btnFinish3 = findViewById<Button>(R.id.btnFinishActivity3)
        val btnStart4 = findViewById<Button>(R.id.btnStartActivity4)
        val btnFinish4 = findViewById<Button>(R.id.btnFinishActivity4)
        btnStart1.setOnClickListener(this)
        btnStart2.setOnClickListener(this)
        btnStart3.setOnClickListener(this)
        btnStart4.setOnClickListener(this)
        btnFinish1.setOnClickListener(this)
        btnFinish2.setOnClickListener(this)
        btnFinish3.setOnClickListener(this)
        btnFinish4.setOnClickListener(this)
        btnFinish1.visibility = View.INVISIBLE
        btnFinish2.visibility = View.INVISIBLE
        btnFinish3.visibility = View.INVISIBLE
        btnFinish4.visibility = View.INVISIBLE
        if (this is FirstActivity) {
            tvTitle.text = getString(R.string.activity_1)
            btnFinish1.visibility = View.VISIBLE
        } else if (this is SecondActivity) {
            tvTitle.text = getString(R.string.activity_2)
            btnFinish2.visibility = View.VISIBLE
        } else if (this is ThirdActivity) {
            tvTitle.text = getString(R.string.activity_3)
            btnFinish3.visibility = View.VISIBLE

        } else if (this is ThirdActivity) {
            tvTitle.text = getString(R.string.activity_3)
            btnFinish3.visibility = View.VISIBLE

        } else if (this is FourthActivity) {
            tvTitle.text = getString(R.string.activity_4)
            btnFinish4.visibility = View.VISIBLE

        }

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnFinishActivity1,
            R.id.btnFinishActivity2,
            R.id.btnFinishActivity4,
            R.id.btnFinishActivity3
            -> {
                finish()
            }
            R.id.btnStartActivity1,
            R.id.btnStartActivity2,
            R.id.btnStartActivity3,
            R.id.btnStartActivity4
            -> {
                var activity = FirstActivity::class.java as Class<*>
                when (v.id) {
                    R.id.btnStartActivity1 -> {
                        activity = FirstActivity::class.java
                    }
                    R.id.btnStartActivity2 -> {
                        activity = SecondActivity::class.java
                    }
                    R.id.btnStartActivity3
                    -> {
                        activity = ThirdActivity::class.java
                    }
                    R.id.btnStartActivity4
                    -> {
                        activity = FourthActivity::class.java
                    }
                }
                val intent = Intent(this, activity)
                startActivity(intent)
            }
        }

    }


    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$SUPER_TAG:$TAG in onStart()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "$SUPER_TAG:$TAG in onRestart()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$SUPER_TAG:$TAG in onStop()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$SUPER_TAG:$TAG in onPause()")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d(TAG, "$SUPER_TAG:$TAG in onNewIntent()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$SUPER_TAG:$TAG in onResume()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$SUPER_TAG:$TAG in onDestroy()")
    }
}
