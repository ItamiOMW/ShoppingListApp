package com.example.shoppinglistapp

import android.app.Application
import com.example.shoppinglistapp.di.DaggerAppComponent

class ShopApp: Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }
}