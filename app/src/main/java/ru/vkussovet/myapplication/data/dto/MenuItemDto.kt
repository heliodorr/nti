package ru.vkussovet.myapplication.data.dto

import com.google.gson.annotations.SerializedName
import ru.vkussovet.myapplication.domain.model.MenuItem

data class MenuItemDto(
    val image: String?,
    val name: String?,

    @SerializedName("content")
    val ingredients: String?,

    val price: String?,

    @SerializedName("weight")
    val amount: String?,

    val spicy: String?
){

    fun toMenuItem(): MenuItem{

        return MenuItem(
            name = name,
            image = image,
            ingredients = ingredients,
            price = "$price $rubSymbol",
            amount = "/ $amount.",
            isSpicy = spicy!=null
        )

    }


}

private const val rubSymbol = '\u20bd'
