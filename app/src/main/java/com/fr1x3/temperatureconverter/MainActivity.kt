package com.fr1x3.temperatureconverter

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import com.fr1x3.temperatureconverter.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var items: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        items = listOf("Fahrenheit", "Celcius")
        val adapter = ArrayAdapter(applicationContext, R.layout.list_items, items)
        ( binding.tvType.editText as? AutoCompleteTextView)?.setAdapter(adapter)

        binding.btnConvertTemp.setOnClickListener { convert() }
    }

    //validate
    private fun isNumeric(str: String?) = str?.toDoubleOrNull()?.let { true } ?: false

    fun convert(){
        val input = binding.tvDegrees.editText?.text.toString()
        if( isNumeric(input)){
            val type = binding.tvType.editText?.text.toString()
            when(type){
                items[1]  -> setResult( convertToFahrenheit(input.toDouble()))
                items[0] -> setResult( convertToDegrees(input.toDouble()))
            }


        }else{
            Toast.makeText(applicationContext, "Degree input is not numeric", Toast.LENGTH_LONG).show()
        }
    }

    // convert to farenheit
    private fun convertToFahrenheit(input: Double) : String =
        String.format("%.4f \u2109",((input * 9/5) + 32))

    // convert to celcius
    private fun convertToDegrees(input: Double) : String =
        String.format("%.4f \u2103",((input - 32) * 5/9 ))

    private fun setResult(result: String){
        binding.tvResults.editText?.setText(result)
    }

}