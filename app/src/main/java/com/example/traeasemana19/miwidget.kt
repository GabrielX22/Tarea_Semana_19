package com.example.traeasemana19

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews

/**
 * Implementation of App Widget functionality.
 */
class miwidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

@SuppressLint("RemoteViewLayout")
internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {

    //Se hace 2 variables las cuales estaran pendientes de habre un intent, uno abre el de canvas
    val canva : PendingIntent = Intent(context,MainActivity2::class.java).let { intent ->
        PendingIntent.getActivity(context, 0, intent, 0)  }

    //Y este otro abre el de notas
    val notas : PendingIntent = Intent(context,MainActivity3::class.java).let { intent ->
        PendingIntent.getActivity(context, 0, intent, 0)  }


    //Aqui se aplica en la vista remota, que se aplique, que los botones esten pendientes al tap para abrir sus activity
    val views = RemoteViews(context.packageName, R.layout.miwidget)
        .apply { setOnClickPendingIntent(R.id.ircanvas,canva)}
        .apply { setOnClickPendingIntent(R.id.irnotas,notas)}
    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}