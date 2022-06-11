package ru.vkussovet.myapplication.data.dto

import com.google.gson.annotations.SerializedName

data class CategoryDtoHolder(
    val status: Boolean,
    @SerializedName("menuList")
    val categoryItemList: List<CategoryDto>?
)