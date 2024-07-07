package com.feirapp.feirapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.feirapp.feirapp.databinding.ImportGroceryItemListItemBinding
import com.feirapp.feirapp.models.groceryItem.GroceryListItemModel

class AdapterGroceryListItem(
    private val context: Context,
    private val groceryItemList: MutableList<GroceryListItemModel>
) : RecyclerView.Adapter<AdapterGroceryListItem.GroceryListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryListItemViewHolder {
        val itemList = ImportGroceryItemListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return GroceryListItemViewHolder(itemList)
    }

    override fun getItemCount() = groceryItemList.size

    override fun onBindViewHolder(holder: GroceryListItemViewHolder, position: Int) {
        holder.txtName.text = groceryItemList[position].name
        holder.txtMeasure.text = groceryItemList[position].measureUnit
        holder.txtQuantity.text = groceryItemList[position].quantity.toString()
        holder.txtPrice.text = "R$%.2f".format(groceryItemList[position].price)
        holder.txtTotalPrice.text = "R$%.2f".format(groceryItemList[position].price * groceryItemList[position].quantity)
    }

    inner class GroceryListItemViewHolder(binding: ImportGroceryItemListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val txtName = binding.tvGroceryItemListItemName
        val txtMeasure = binding.tvGroceryItemListItemMeasure
        val txtQuantity = binding.tvGroceryItemListItemQuantity
        val txtPrice = binding.tvGroceryItemListItemUnitPrice
        val txtTotalPrice = binding.tvGroceryItemListItemTotalPrice
    }
}