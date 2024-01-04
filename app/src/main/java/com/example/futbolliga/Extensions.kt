package com.example.futbolliga

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.set(url: String, context: Context) {
    Glide.with(context)
        .load(url)
        .fitCenter()
        .placeholder(R.drawable.ic_unknown)
        .into(this)
}