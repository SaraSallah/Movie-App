package com.example.movieapp.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.MovieAdapter
import com.example.movieapp.model.data.Movie

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: State<T>) {
    if (state is State.Loading)
        view.visibility = View.VISIBLE
    else view.visibility = View.GONE
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: State<T>) {
    if (state is State.Success)
        view.visibility = View.VISIBLE
    else view.visibility = View.GONE
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: State<T>) {
    if (state is State.Error)
        view.visibility = View.VISIBLE
    else view.visibility = View.GONE
}

@BindingAdapter(value = ["app:imageUrl"])
fun setImageFromUrl(view: ImageView, url: String?) {
    Glide.with(view)
        .load(Constant.IMAGE_PATH + url)
        .centerCrop().into(view)
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<Movie>?) {
    if (items != null) {
        (view.adapter as MovieAdapter?)?.setItems(items)
    } else {
        (view.adapter as MovieAdapter?)?.setItems(emptyList())
    }
}