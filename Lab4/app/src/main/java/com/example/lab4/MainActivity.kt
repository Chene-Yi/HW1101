package com.example.lab4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // Step1：宣告 ActivityResultLauncher，負責處理 SecActivity 回傳結果
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        // Step12：檢查回傳結果是否為 RESULT_OK
        if (result.resultCode == Activity.RESULT_OK) {
            // Step13：取得回傳的 Intent，並從中獲取飲料名稱、甜度和冰塊
            val intent = result.data
            val drink = intent?.getStringExtra("drink")
            val sugar = intent?.getStringExtra("sugar")
            val ice = intent?.getStringExtra("ice")

            // Step14：設定 tvMeal 的文字
            findViewById<TextView>(R.id.tvMeal).text = "飲料：$drink\n\n甜度：$sugar\n\n冰塊：$ice"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 設定系統欄位的 padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Step2：取得 btnChoice 元件並設定點擊事件
        findViewById<Button>(R.id.btnChoice).setOnClickListener {
            // Step4：透過 Intent 從 MainActivity 切換到 SecActivity
            val intent = Intent(this, SecActivity::class.java)
            // Step5：使用 startForResult 啟動 Intent
            startForResult.launch(intent)
        }
    }
}
