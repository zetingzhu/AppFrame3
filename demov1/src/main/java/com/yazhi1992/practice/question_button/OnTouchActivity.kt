package com.yazhi1992.practice.question_button

import android.os.Bundle
import android.util.Log
import android.view.View

import androidx.appcompat.app.AppCompatActivity
import com.zzt.demov1.R
import kotlinx.android.synthetic.main.activity_on_touch.*

class OnTouchActivity : AppCompatActivity() {
    var ss: OnTouchReturnTrueButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_touch)

        btn1.setOnClickListener(object :
            View.OnClickListener {
            override fun onClick(v: View?) {
                Log.e("zyz", "btn1")
            }
        })
        btn2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.e("zyz", "btn2")
            }
        })
        btn3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.e("zyz", "btn3")
            }
        })
        btn4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.e("zyz", "btn4")
            }
        })
    }
}
