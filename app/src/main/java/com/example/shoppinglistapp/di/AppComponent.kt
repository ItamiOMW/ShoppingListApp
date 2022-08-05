package com.example.shoppinglistapp.di

import android.app.Application
import com.example.shoppinglistapp.presentation.MainActivity
import com.example.shoppinglistapp.presentation.ShopItemFragment
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: ShopItemFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }
}