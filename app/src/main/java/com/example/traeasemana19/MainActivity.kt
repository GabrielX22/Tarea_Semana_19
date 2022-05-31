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

        imagecrear.setOnClickListener {
            crearshortcut()
        }

    }
    fun crearshortcut(){
        if (ShortcutManagerCompat.isRequestPinShortcutSupported(applicationContext)) {
            val shortcutInfo = ShortcutInfoCompat.Builder(applicationContext, "#1")
                .setIntent(
                    Intent(
                        applicationContext,
                        MainActivity::class.java
                    ).setAction(Intent.ACTION_MAIN)
                ) // !!! intent's action must be set on oreo
                .setShortLabel("Test")
                .setIcon(IconCompat.createWithResource(applicationContext, R.drawable.elcut))
                .build()
            ShortcutManagerCompat.requestPinShortcut(applicationContext, shortcutInfo, null)
        } else {
            Toast.makeText(
                this@MainActivity,
                "El sistema no soporta accesos directos",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}