package com.example.calculator

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var number1 = findViewById<TextView>(R.id.number1)
        var number2 = findViewById<TextView>(R.id.number2)

        var addButton = findViewById<Button>(R.id.add)
        var subtractButton = findViewById<Button>(R.id.subtract)
        var multiplyButton = findViewById<Button>(R.id.multiply)
        var divideButton = findViewById<Button>(R.id.divide)

        var answerText = findViewById<TextView>(R.id.answer)

        // Function to hide keyboard
        fun hideKeyboard() {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }

        addButton.setOnClickListener {
            var answer = number1.text.toString().toInt() + number2.text.toString().toInt()
            hideKeyboard()
            answerText.text = answer.toString()
        }



        subtractButton.setOnClickListener {
            var answer = number1.text.toString().toInt() - number2.text.toString().toInt()
            hideKeyboard()
            answerText.text = answer.toString()
        }

        multiplyButton.setOnClickListener {
            var answer = number1.text.toString().toInt() * number2.text.toString().toInt()
            hideKeyboard()
            answerText.text = answer.toString()
        }

        divideButton.setOnClickListener {
            var answer = number1.text.toString().toInt() / number2.text.toString().toInt()
            hideKeyboard()
            answerText.text = answer.toString()
        }



    }
}