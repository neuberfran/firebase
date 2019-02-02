package com.example.neuber.firebase

import android.R.attr.name
import android.databinding.*
import android.widget.ImageView
import com.bumptech.glide.Glide
import android.databinding.BindingAdapter
import android.databinding.BaseObservable
import android.R.attr.name


class User : BaseObservable() {

    @get:Bindable
    var name: String? = null
        set(name) {
            field = name
            notifyPropertyChanged(BR.name)
        }
    @get:Bindable
    var address: String? = null
        set(address) {
            field = address

            notifyPropertyChanged(BR.address)
        }
    @get:Bindable
    var email: String? = null
        set(email) {
            field = email
            notifyPropertyChanged(BR.email)
        }
    @get:Bindable
    var image: String? = null
        @Bindable
        set(image) {
            field = image
            notifyPropertyChanged(BR.image)
        }

    companion object {


        @BindingAdapter("android:image")
        fun loadImage(imageView: ImageView, image: String) {
            Glide.with(imageView)
                    .load(image)
                    .into(imageView)
        }
    }
}