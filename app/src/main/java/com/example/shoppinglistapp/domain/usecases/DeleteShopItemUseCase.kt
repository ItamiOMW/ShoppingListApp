package com.example.shoppinglistapp.domain.usecases

import com.example.shoppinglistapp.domain.model.ShopItem
import com.example.shoppinglistapp.domain.repository.ShopListRepository
import javax.inject.Inject

class DeleteShopItemUseCase @Inject constructor (private val shopListRepository: ShopListRepository) {

    suspend fun deleteShopItem(item: ShopItem) {
        shopListRepository.deleteShopItem(item)
    }
}