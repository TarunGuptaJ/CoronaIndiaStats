package com.example.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val indiaImg : ImageView = findViewById(R.id.indiaMap)
        val indiaFAB : FloatingActionButton = findViewById<FloatingActionButton>(R.id.indiaFAB)

        indiaFAB.setOnClickListener {
            showIndia()
        }
    }

    private fun showIndia()
    {
        val indiaMap : ImageView = findViewById(R.id.indiaMap)
        indiaMap.visibility = View.VISIBLE
    }
}
