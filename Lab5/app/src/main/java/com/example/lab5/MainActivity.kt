package com.example.lab5

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private fun logLifecycleEvent(event: String) {
        Log.e(TAG, event)
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupWindowInsets()

        logLifecycleEvent("onCreate")

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        viewPager2.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager2.offscreenPageLimit = 1
    }

    override fun onRestart() {
        super.onRestart()
        logLifecycleEvent("onRestart")
    }

    override fun onStart() {
        super.onStart()
        logLifecycleEvent("onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifecycleEvent("onResume")
    }

    override fun onPause() {
        super.onPause()
        logLifecycleEvent("onPause")
    }

    override fun onStop() {
        super.onStop()
        logLifecycleEvent("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycleEvent("onDestroy")
    }
}
