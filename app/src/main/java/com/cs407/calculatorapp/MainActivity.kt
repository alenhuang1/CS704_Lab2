package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        val firstNumber = findViewById<EditText>(R.id.first_number)
        val secondNumber = findViewById<EditText>(R.id.second_number)
        val add = findViewById<Button>(R.id.add)
        val subtract = findViewById<Button>(R.id.subtract)
        val multiply = findViewById<Button>(R.id.multiply)
        val divide = findViewById<Button>(R.id.divide)

        add.setOnClickListener{
            val first = firstNumber.text.toString().toInt()
            val second = secondNumber.text.toString().toInt()
            val result = (first + second).toString()

            val intent = Intent(this,Results::class.java)
            intent.putExtra("EXTRA_MESSAGE", result)
            startActivity(intent)
        }

        subtract.setOnClickListener{
            val first = firstNumber.text.toString().toInt()
            val second = secondNumber.text.toString().toInt()
            val result = (first - second).toString()

            val intent = Intent(this,Results::class.java)
            intent.putExtra("EXTRA_MESSAGE", result)
            startActivity(intent)
        }

        multiply.setOnClickListener{
            val first = firstNumber.text.toString().toInt()
            val second = secondNumber.text.toString().toInt()
            val result = (first * second).toString()

            val intent = Intent(this,Results::class.java)
            intent.putExtra("EXTRA_MESSAGE", result)
            startActivity(intent)
        }

        divide.setOnClickListener{
            val first = firstNumber.text.toString().toInt()
            val second = secondNumber.text.toString().toInt()
            if (second == 0) {
                val result = "Cannot divide by 0"
                val intent = Intent(this, Results::class.java)
                intent.putExtra("EXTRA_MESSAGE", result)
                startActivity(intent)
            }
            else{
                val result = (first / second).toString()
                val intent = Intent(this, Results::class.java)
                intent.putExtra("EXTRA_MESSAGE", result)
                startActivity(intent)
            }
        }
    }
}