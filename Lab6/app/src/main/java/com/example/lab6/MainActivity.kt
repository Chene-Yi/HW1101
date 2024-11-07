package com.example.lab6

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import android.view.View

class MainActivity : AppCompatActivity() {

    private val items = arrayOf("選項 1", "選項 2", "選項 3", "選項 4", "選項 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btnToast).setOnClickListener {
            showToast("預設 Toast")
        }

        findViewById<Button>(R.id.btnSnackBar).setOnClickListener {
            showSnackbar(it, "按鈕式 Snackbar", "按鈕") {
                showToast("已回應")
            }
        }

        findViewById<Button>(R.id.btnDialog1).setOnClickListener {
            showAlertDialogWithButtons()
        }

        findViewById<Button>(R.id.btnDialog2).setOnClickListener {
            showListAlertDialog()
        }

        findViewById<Button>(R.id.btnDialog3).setOnClickListener {
            showSingleChoiceAlertDialog()
        }
    }

    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun showSnackbar(view: View, message: String, actionText: String, action: () -> Unit) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
            .setAction(actionText) { action() }
            .show()
    }

    private fun showAlertDialogWithButtons() {
        AlertDialog.Builder(this).apply {
            setTitle("按鈕式 AlertDialog")
            setMessage("AlertDialog 內容")
            setNeutralButton("左按鈕") { _, _ -> showToast("左按鈕") }
            setNegativeButton("中按鈕") { _, _ -> showToast("中按鈕") }
            setPositiveButton("右按鈕") { _, _ -> showToast("右按鈕") }
            show()
        }
    }

    private fun showListAlertDialog() {
        AlertDialog.Builder(this).apply {
            setTitle("列表式 AlertDialog")
            setItems(items) { _, i -> showToast("你選的是${items[i]}") }
            show()
        }
    }

    private fun showSingleChoiceAlertDialog() {
        var position = 0
        AlertDialog.Builder(this).apply {
            setTitle("單選式 AlertDialog")
            setSingleChoiceItems(items, 0) { _, i -> position = i }
            setPositiveButton("確定") { _, _ -> showToast("你選的是${items[position]}") }
            show()
        }
    }
}
