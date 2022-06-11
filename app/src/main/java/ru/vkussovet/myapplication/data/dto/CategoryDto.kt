package ru.vkussovet.myapplication.data.dto


import com.google.gson.annotations.SerializedName
import ru.vkussovet.myapplication.domain.model.CategoryItem


data class CategoryDto(
    val name: String,
    val menuID: Int,
    val image: String,
    @SerializedName("subMenuCount")
    val amount: String
){

    fun toCategoryItem(): CategoryItem {

        return CategoryItem(
            name = name,
            menuID = menuID,
            amount = amount,
            image = image
        )

    }

}
