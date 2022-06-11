package ru.vkussovet.myapplication.ui.oredering

import android.app.Application
import androidx.lifecycle.*
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch
import ru.vkussovet.myapplication.domain.model.MenuItem
import ru.vkussovet.myapplication.domain.model.CategoryItem
import ru.vkussovet.myapplication.domain.usecase.GetCategoryItemsUseCase
import ru.vkussovet.myapplication.domain.usecase.GetMenuItemsUseCase

class OrderingViewModel(
    application: Application,
    private val categoryItemsUseCase: GetCategoryItemsUseCase,
    private val menuItemsUseCase: GetMenuItemsUseCase
) : AndroidViewModel(application) {

    private val _categoryItems: MutableLiveData<List<CategoryItem>> = MutableLiveData()
    val categoryItems: LiveData<List<CategoryItem>> = _categoryItems

    private val _menuItems: MutableLiveData<List<MenuItem>> = MutableLiveData()
    val menuItems: LiveData<List<MenuItem>> = _menuItems

    fun initDownload() {
        refreshCategoryItems()
    }

    val onMenuItemChanged: (Int) -> Unit = { menuId ->
        refreshMenuItems(menuId)
    }

    private fun refreshCategoryItems() {
        Glide.with(getApplication<Application>().applicationContext)

        viewModelScope.launch {
            _categoryItems.value = categoryItemsUseCase.execute()
        }
    }
    private fun refreshMenuItems(menuId: Int) {

        viewModelScope.launch {
            _menuItems.value = menuItemsUseCase.execute(menuId)
        }
    }
}