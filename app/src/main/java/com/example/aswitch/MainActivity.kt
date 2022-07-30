package com.example.aswitch

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var count = 0
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var str: String? = "Good Morning"
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val textView = findViewById<TextView>(R.id.tvCount)
        val button = findViewById<Button>(R.id.btnCount)
        val button2 = findViewById<Button>(R.id.button2)
        viewModel.count.observe(this, Observer {
            textView.text = it.toString()
        })

        //textView.text = viewModel.count.toString()

        button.setOnClickListener{
            viewModel.updateCount()
            //textView.text = viewModel.count.toString()
        }

        button2.setOnClickListener{
            test() //ผมลืมตรงนี้ครับ
            }


        val secondActbutton = findViewById<Button>(R.id.button)
        secondActbutton.setOnClickListener {
            val Intent = Intent(this,SecondActivity::class.java)
            startActivity(Intent)
        }

    }

    //อันนี้คือวิธีสร้าง function
    fun test(){
        //val ควรสร้างด้วยตัวอักษรเล็กนำ ไม่ใช่ตัวใหญ่ เช่น val intent ไม่่ใช่ val Intent
        val intent = Intent(this, SecondActivity::class.java).apply {
            this.putExtra("EXTRA_MESSAGE", "Good Morning");
        }
        startActivity(intent)
    }
}