package com.example.traeasemana19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        webcanvas.webChromeClient = object : WebChromeClient(){
        }
        webcanvas.webViewClient = object : WebViewClient(){
        }
        webcanvas.settings.javaScriptEnabled = true
        webcanvas.loadUrl("https://estudiantes.ugb.edu.sv/Home")
    }
}