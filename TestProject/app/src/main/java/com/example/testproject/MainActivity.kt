package com.example.testproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.github.clans.fab.FloatingActionMenu
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val floatingMenu : FloatingActionMenu = findViewById(R.id.menu)

        val indiaFAB : com.github.clans.fab.FloatingActionButton = findViewById(R.id.indiaFAB)
        val stateFrag : Fragment = StateFragment()
        val indiaFrag : Fragment = IndiaFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, indiaFrag)
            commit()
        }

        indiaFAB.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                floatingMenu.close(true)
                replace(R.id.flFragment, indiaFrag)
                commit()
            }
        }

        stateFAB.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                floatingMenu.close(true)
                replace(R.id.flFragment, stateFrag)
                commit()
            }
        }
    }

    private fun showIndia()
    {
        val indiaMap : ImageView = findViewById(R.id.indiaMap)
        indiaMap.visibility = View.VISIBLE
    }
}
