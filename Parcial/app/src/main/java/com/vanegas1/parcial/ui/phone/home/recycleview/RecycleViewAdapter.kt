package com.vanegas1.parcial.ui.phone.home.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vanegas1.parcial.data.model.PhoneModel
import com.vanegas1.parcial.databinding.CardItemBinding

class RecycleViewAdapter(private val clickListener: (PhoneModel) -> Unit)
    : RecyclerView.Adapter<RecycleViewHolder>() {
    private val phones = ArrayList<PhoneModel>()

    fun setData(phonesList: List<PhoneModel>){
        phones.clear()
        phones.addAll(phonesList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecycleViewHolder {
        val binding = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecycleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return phones.size
    }

    override fun onBindViewHolder(holder: RecycleViewHolder, position: Int) {
        val phone = phones[position]
        holder.bind(phone, clickListener)
    }
}