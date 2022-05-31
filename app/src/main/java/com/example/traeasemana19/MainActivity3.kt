package com.example.traeasemana19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        webnotas.webChromeClient = object : WebChromeClient(){
        }
        webnotas.webViewClient = object : WebViewClient(){
        }
        webnotas.settings.javaScriptEnabled = true
        webnotas.loadUrl("https://estudiantes.ugb.edu.sv/Notas")
    }
}