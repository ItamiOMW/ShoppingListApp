package com.example.shoppinglistapp.domain.usecases

import com.example.shoppinglistapp.domain.model.ShopItem
import com.example.shoppinglistapp.domain.repository.ShopListRepository
import javax.inject.Inject

class AddShopItemUseCase @Inject constructor(
    private val shopListRepository: ShopListRepository
) {

    suspend fun addShopItem(item: ShopItem) {
        shopListRepository.addShopItem(item)
    }
}