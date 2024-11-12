package com.example.imagechanger

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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

        var button = findViewById<Button>(R.id.button)
        var imageView = findViewById<ImageView>(R.id.imageView)

        button.setOnClickListener {
            if (imageView.tag == "image1.png") {
                imageView.setImageResource(R.drawable.image2)
                imageView.tag = "image2.png"
            } else if (imageView.tag == "image2.png") {
                imageView.setImageResource(R.drawable.image3)
                imageView.tag = "image3.png"
            } else {
                imageView.setImageResource(R.drawable.image1)
                imageView.tag = "image1.png"
            }

        }
    }
}