package ru.vkussovet.myapplication.ui.oredering.menurecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.vkussovet.myapplication.databinding.MenuCardBinding
import ru.vkussovet.myapplication.di.API_URL
import ru.vkussovet.myapplication.domain.model.MenuItem



class MenuRecyclerAdapter(
    val context: Context,
    val onMenuIdChanged: (Int) -> Unit
): RecyclerView.Adapter<MenuRecyclerAdapter.MenuRecyclerVH>(){

    private var dataList: List<MenuItem> = emptyList()

    inner class MenuRecyclerVH(binding: MenuCardBinding) : RecyclerView.ViewHolder(binding.root){


        private var image = binding.imageOfMenuFood
        private var name = binding.menuName
        private var ingredients = binding.menuIngredients
        private var price = binding.menuPrice
        private var amount = binding.menuAmount
        private var spicyness = binding.isSpicy

        fun setData(menuItem: MenuItem){
            name.text = menuItem.name
            ingredients.text = menuItem.ingredients
            price.text = menuItem.price
            amount.text = menuItem.amount
            spicyness.text = if(menuItem.isSpicy) SPICY else ""

            Glide.with(context)
                .load("$API_URL/${menuItem.image}" )
                .into(image)
        }

    }

    fun refresh(data: List<MenuItem>){
        this.dataList = data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuRecyclerVH {
        val binding = MenuCardBinding.inflate(LayoutInflater.from(parent.context))
        return MenuRecyclerVH(binding)
    }

    override fun onBindViewHolder(holder: MenuRecyclerVH, position: Int){
        holder.setData(dataList[position])
    }


    override fun getItemCount(): Int = dataList.size


}

private val SPICY = String(Character.toChars(0x1F336))
