package com.rohit.thirteenthactivity

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var name: EditText? = null
    var pass: EditText? = null
    var Button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        name = findViewById(R.id.name)
        pass = findViewById(R.id.pass)
        Button = findViewById(R.id.customdialog)
        Button?.setOnClickListener {
            if (name?.text?.trim().isNullOrBlank()) {
                name?.error = "Enter password"
            }
            if (pass?.text?.trim().isNullOrBlank()) {
                pass?.error = "Please enter the password "

            }
           else {
               var dialog = Dialog(this).apply {
                   setContentView(R.layout.custom_dialog)
                   var confirm = findViewById<Button>(R.id.confirmButton)
                   var back = findViewById<Button>(R.id.backButton)
                   var username = findViewById<TextView>(R.id.ct_username)
                   var password = findViewById<TextView>(R.id.ct_password)
                   window?.setLayout(900,600)
                   username.setText(name?.text)
                   password.setText(pass?.text)
                   confirm.setOnClickListener{
                       dismiss()
                   }
                   back.setOnClickListener {
                       dismiss()
                   }
               }.show()

            }
        }
    }
}