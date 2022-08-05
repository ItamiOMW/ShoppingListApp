package com.example.shoppinglistapp.di

import androidx.lifecycle.ViewModel
import com.example.shoppinglistapp.presentation.main_screen.MainViewModel
import com.example.shoppinglistapp.presentation.edit_screen.ShopItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ShopItemViewModel::class)
    fun bindShopItemVM(viewModel: ShopItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainVM(viewModel: MainViewModel): ViewModel
}