package com.vanegas1.parcial.ui.phone.home.recycleview

import androidx.recyclerview.widget.RecyclerView
import com.vanegas1.parcial.data.model.PhoneModel
import com.vanegas1.parcial.databinding.CardItemBinding

class RecycleViewHolder(private val binding: CardItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(phone: PhoneModel, clickListener: (PhoneModel) -> Unit) {
        binding.titleTextView.text = phone.name
        binding.brandTextView.text = phone.brand

        binding.idCardViewPhone.setOnClickListener {
            clickListener(phone)
        }
    }
}