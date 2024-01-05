package com.example.futbolliga.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.futbolliga.R

fun ImageView.set(url: String, context: Context) {
    Glide.with(context)
        .load(url)
        .fitCenter()
        .placeholder(R.drawable.ic_unknown)
        .into(this)
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}