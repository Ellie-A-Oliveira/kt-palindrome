package com.example.palindrome

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var editText : EditText
    lateinit var resultText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editText = findViewById(R.id.editTextText)
        resultText = findViewById(R.id.textViewResult)
    }

    fun verifyPalindrome(view: View) {
        val word = editText.text.toString()
        if (word.isEmpty()) {
            resultText.text = "Digite um valor!"
            return
        }

        val isPalindrome = word.reversed().lowercase() == word.lowercase()

        resultText.text = if (isPalindrome) {
            "$word é um palíndromo"
        } else {
            "$word não é um palíndromo"
        }
    }
}