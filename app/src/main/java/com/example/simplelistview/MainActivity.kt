package com.example.simplelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val arrayOfString = arrayOf<String>("Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayOfString)
        list_view.adapter = adapter
g

    }
}
