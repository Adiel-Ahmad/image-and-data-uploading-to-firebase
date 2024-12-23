package com.example.suffifirebase2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var btn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1=findViewById(R.id.button)
        btn1.setOnClickListener {
            val obj = Intent(this, editeprofile1::class.java)
            startActivity(obj)
        }

    }
}