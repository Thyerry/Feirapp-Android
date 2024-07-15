package com.feirapp.feirapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.feirapp.feirapp.databinding.ImportGroceryItemListItemBinding
import com.feirapp.feirapp.extensions.toast
import com.feirapp.feirapp.models.groceryItem.dtos.GroceryListItemModel

class AdapterGroceryListItem(
    private val context: Context,
    private val groceryItemList: List<GroceryListItemModel>
) : RecyclerView.Adapter<AdapterGroceryListItem.GroceryListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryListItemViewHolder {
        val itemList =
            ImportGroceryItemListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return GroceryListItemViewHolder(itemList)
    }

    override fun getItemCount() = groceryItemList.size

    override fun onBindViewHolder(holder: GroceryListItemViewHolder, position: Int) {
        with(holder) {
            groceryItemList[position].apply {
                txtName.text = name
                txtMeasure.text = measureUnit.stringValue
                txtQuantity.text = quantity.toString()
                txtPrice.text = "R$%.2f".format(price)
                txtTotalPrice.text = "R$%.2f".format(price * quantity)
            }
            btnAdd.setOnClickListener { context.toast("Adicionado ao carrinho") }
        }
    }

    inner class GroceryListItemViewHolder(binding: ImportGroceryItemListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val txtName = binding.tvGroceryItemListItemName
        val txtMeasure = binding.tvGroceryItemListItemMeasure
        val txtQuantity = binding.tvGroceryItemListItemQuantity
        val txtPrice = binding.tvGroceryItemListItemUnitPrice
        val txtTotalPrice = binding.tvGroceryItemListItemTotalPrice
        val btnAdd = binding.constraintLayout
    }
}