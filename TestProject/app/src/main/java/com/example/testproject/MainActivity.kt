package com.example.testproject

import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.LocationManager
import android.location.LocationListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.github.clans.fab.FloatingActionMenu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val floatingMenu : FloatingActionMenu = findViewById(R.id.menu)

        val indiaFAB : com.github.clans.fab.FloatingActionButton = findViewById(R.id.indiaFAB)
        val welcomeFrag : Fragment = WelcomeFragment()
        val indiaFrag : Fragment = IndiaFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, welcomeFrag)
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
                replace(R.id.flFragment, welcomeFrag)
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
