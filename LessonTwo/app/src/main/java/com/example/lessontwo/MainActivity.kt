package com.example.lessontwo

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.lessontwo.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    public fun addText(view: View) {

        binding.textView.text = binding.inputMessage.text.toString()
        binding.textView.visibility = View.VISIBLE
        binding.textView.setBackgroundColor(Color.LTGRAY)
        binding.inputMessage.visibility = View.GONE
        binding.button.visibility = View.GONE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.button.windowToken, 0)
    }

    public fun updateText(view: View) {

        binding.inputMessage.visibility = View.VISIBLE
        binding.button.visibility = View.VISIBLE

        binding.inputMessage.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.inputMessage, 0)
    }
}