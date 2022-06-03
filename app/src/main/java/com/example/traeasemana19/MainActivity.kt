package com.example.traeasemana19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.pm.ShortcutInfoCompat
import androidx.core.content.pm.ShortcutManagerCompat
import androidx.core.graphics.drawable.IconCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se crea el evento CLICk
        imagecrear.setOnClickListener {
            //Se coloca la funcion
            crearshortcut()
        }

    }
    //la funcion que crea un acceso directo
    fun crearshortcut(){
        //Se compara si soporta el acceso direvto y aso se crea una variable que construye el acceso directo
        if (ShortcutManagerCompat.isRequestPinShortcutSupported(applicationContext)) {
            val shortcutInfo = ShortcutInfoCompat.Builder(applicationContext, "#1")
                    //Se setea un intent y el intent que abrira
                .setIntent(
                    Intent(
                        applicationContext,
                        MainActivity::class.java
                    ).setAction(Intent.ACTION_MAIN)
                )
                //Se selecciona lo que dira, el icono y se construye el acceso directo
                .setShortLabel("Test")
                .setIcon(IconCompat.createWithResource(applicationContext, R.drawable.elcut))
                .build()
            ShortcutManagerCompat.requestPinShortcut(applicationContext, shortcutInfo, null)
        } else {
            //De lo contrario se creara un toast, el cual dira que no es posible crear el acceso directo
            Toast.makeText(
                this@MainActivity,
                "El sistema no soporta accesos directos",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}