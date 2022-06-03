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

        //Se asigna el cliente de Chrome para poder visualizar una ventana de chrome en el webview
        webcanvas.webChromeClient = object : WebChromeClient(){
        }
        //Se asigna el cliente para visualizar la pagina web
        webcanvas.webViewClient = object : WebViewClient(){
        }
        //Se habilita el JavaScript
        webcanvas.settings.javaScriptEnabled = true
        //Se carga la URL
        webcanvas.loadUrl("https://estudiantes.ugb.edu.sv/Home")
    }
}