package com.anwesh.uiprojects.xtolineview

/**
 * Created by anweshmishra on 12/09/18.
 */

import android.view.View
import android.content.Context
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Canvas

val nodes : Int = 5

fun Canvas.drawXTLineNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.strokeWidth = Math.min(w, h) / 60
    paint.strokeCap = Paint.Cap.ROUND
    val sc1 : Float = Math.min(0.5f, scale) * 2
    val sc2 : Float = Math.min(0.5f, Math.max(0f, scale - 0.5f)) * 2
    val gap = w / (nodes + 1)
    val size : Float = gap/2
    save()
    translate(gap + i * gap, h/2)
    for(j in 0..1) {
        val sf : Float = 1f - 2 * (j % 2)
        save()
        translate(0f, (h/2 - size/2) * sc2)
        rotate(45f * (1 - sc1))
        drawLine(0f, -size/2, 0f, size/2, paint)
        restore()
    }
    restore()
}