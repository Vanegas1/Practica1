package com.vanegas1.parcial.repositories

import com.vanegas1.parcial.data.model.PhoneModel

class PhoneRepository(private val phones: MutableList<PhoneModel>) {

    fun getPhones() = phones
    fun addPhones(phone: PhoneModel) = phones.add(phone)
}