package ru.vkussovet.myapplication.domain.model


data class MenuItem(
    val image: String?,
    val name: String?,
    val ingredients: String?,
    val price: String?,
    val amount: String?,
    val isSpicy: Boolean,

)
