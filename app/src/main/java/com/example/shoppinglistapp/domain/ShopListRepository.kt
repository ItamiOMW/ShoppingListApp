package com.example.shoppinglistapp.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    suspend fun addShopItem(item: ShopItem)

    suspend fun deleteShopItem(item: ShopItem)

    suspend fun getShopItem(id: Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>

    suspend fun editShopItem(item: ShopItem)
}