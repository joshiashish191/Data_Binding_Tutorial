package com.example.databindingtutorial

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.example.databindingtutorial.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        findViewById<TextView>(R.id.title).text = "Data Binding tutorial from Technopoints"
        binding.customText = CustomText(binding.enterText.text.toString())
        binding.submitButton.setOnClickListener {
            binding.customText = CustomText(binding.enterText.text.toString())
        }
    }
}

@BindingAdapter("setCustomText")
fun TextView.setCustomText(customText: String) {
    this.text = customText
}