package com.example.shoppinglistapp.data.database

import com.example.shoppinglistapp.domain.model.ShopItem
import javax.inject.Inject

class ShopItemMapper @Inject constructor() {

    fun mapDbModelToEntity(shopItemDbModel: ShopItemDbModel) = ShopItem(
        name = shopItemDbModel.name,
        count = shopItemDbModel.count,
        enabled = shopItemDbModel.enabled,
        id = shopItemDbModel.id
    )

    fun mapEntityToDbModel(shopItem: ShopItem) = ShopItemDbModel(
        name = shopItem.name,
        count = shopItem.count,
        enabled = shopItem.enabled,
        id = shopItem.id
    )

    fun mapListDbModelToListEntity(list: List<ShopItemDbModel>) = list.map {
        mapDbModelToEntity(it)
    }
}