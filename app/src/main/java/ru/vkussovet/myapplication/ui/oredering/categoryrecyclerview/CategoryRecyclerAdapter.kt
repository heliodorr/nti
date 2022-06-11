package ru.vkussovet.myapplication.ui.oredering.categoryrecyclerview

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ru.vkussovet.myapplication.R
import ru.vkussovet.myapplication.databinding.CategoryCardBinding
import ru.vkussovet.myapplication.di.API_URL
import ru.vkussovet.myapplication.domain.model.CategoryItem

class CategoryRecyclerAdapter(
    val context: Context,
    val onMenuIdChanged: (Int) -> Unit,
    val changeText: (String)-> Unit
): RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryRecyclerVH>() {

    private var changedHolder: CategoryRecyclerVH? = null
    private var dataList: List<CategoryItem> = emptyList()


    fun refresh(data: List<CategoryItem>){
        this.dataList = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryRecyclerVH {
        val binding = CategoryCardBinding.inflate(LayoutInflater.from(parent.context))
        return CategoryRecyclerVH(binding)
    }

    override fun onBindViewHolder(holder: CategoryRecyclerVH, position: Int){
        holder.setData(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

    inner class CategoryRecyclerVH(
        binding: CategoryCardBinding
    ) : RecyclerView.ViewHolder(binding.root){

        private var view = binding.root
        private var textArea = binding.cardTextAre
        private var image: ImageView = binding.imageOfCategoryFood
        private var name: TextView = binding.name
        private var amount: TextView = binding.amount

        private var menuId: Int = -1

        private val defColor =  ContextCompat.getColor(context, R.color.category_card)

        init{
            view.setOnClickListener{
                changedHolder?.discolor()

                textArea.setBackgroundColor(
                    ContextCompat.getColor(context,R.color.purple_700)
                )
                changedHolder = this@CategoryRecyclerVH

                onMenuIdChanged(menuId)
                changeText(name.text as String)
            }
        }

        private fun discolor() {
            textArea.setBackgroundColor(defColor)
        }

        fun setData(categoryItem: CategoryItem){
            name.text = categoryItem.name
            amount.text = categoryItem.amount
            menuId = categoryItem.menuID ?: 0

            Glide.with(context)
                .load("$API_URL/${categoryItem.image}" )
                .into(image)
        }


    }

}