package com.fr1x3.temperatureconverter

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvType: TextInputLayout = findViewById(R.id.tv_type)

        val items = listOf("Fahrenheit", "Celcius")
        val adapter = ArrayAdapter(applicationContext, R.layout.list_items, items)
        ( tvType.editText as? AutoCompleteTextView)?.setAdapter(adapter)

    }
}