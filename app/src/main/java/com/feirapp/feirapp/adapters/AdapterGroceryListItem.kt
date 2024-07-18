package com.feirapp.feirapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.feirapp.feirapp.EditBrandAndAltNameCallback
import com.feirapp.feirapp.databinding.ImportGroceryItemListItemBinding
import com.feirapp.feirapp.fragments.modals.EditItemModal
import com.feirapp.feirapp.models.groceryItem.dtos.GroceryListItemModel

class AdapterGroceryListItem(
    private val context: Context,
    private val groceryItemList: MutableList<GroceryListItemModel>,
    private val fragmentManager: FragmentManager
) : RecyclerView.Adapter<AdapterGroceryListItem.GroceryListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryListItemViewHolder {
        val itemList =
            ImportGroceryItemListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return GroceryListItemViewHolder(itemList)
    }

    override fun getItemCount() = groceryItemList.size

    override fun onBindViewHolder(holder: GroceryListItemViewHolder, position: Int) {
        val item = groceryItemList[position]
        val callback = EditBrandAndAltNameCallback { updatedItem ->
            groceryItemList[position].brand = updatedItem.brand
        }

        with(holder) {
            item.apply {
                txtName.text = name
                txtMeasure.text = measureUnit?.stringValue
                txtQuantity.text = quantity.toString()
                txtPrice.text = "R$%.2f".format(price)
                txtTotalPrice.text = "R$%.2f".format(price * quantity)
                btItem.setOnClickListener {
                    EditItemModal.start(fragmentManager, item, callback)
                }
            }
        }
    }

    inner class GroceryListItemViewHolder(binding: ImportGroceryItemListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val txtName = binding.tvGroceryItemListItemName
        val txtMeasure = binding.tvGroceryItemListItemMeasure
        val txtQuantity = binding.tvGroceryItemListItemQuantity
        val txtPrice = binding.tvGroceryItemListItemUnitPrice
        val txtTotalPrice = binding.tvGroceryItemListItemTotalPrice
        val btItem = binding.clRoot
    }
}
