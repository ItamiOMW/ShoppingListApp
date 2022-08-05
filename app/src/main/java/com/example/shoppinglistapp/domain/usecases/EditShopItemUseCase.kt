package com.example.shoppinglistapp.domain.usecases

import com.example.shoppinglistapp.domain.model.ShopItem
import com.example.shoppinglistapp.domain.repository.ShopListRepository
import javax.inject.Inject

class EditShopItemUseCase @Inject constructor (private val shopListRepository: ShopListRepository) {

    suspend fun editShopItem(item: ShopItem) {
        shopListRepository.editShopItem(item)
    }
}