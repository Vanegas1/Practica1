package com.vanegas1.parcial.ui.phone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.vanegas1.parcial.PhoneReviewerApplication
import com.vanegas1.parcial.data.model.PhoneModel
import com.vanegas1.parcial.repositories.PhoneRepository

class PhoneViewModel(private val repository: PhoneRepository) : ViewModel() {

    var name = MutableLiveData("")
    var brand = MutableLiveData("")
    var price = MutableLiveData("")
    var status = MutableLiveData("")

    fun getPhones() = repository.getPhones()
    fun addPhones(phone: PhoneModel) = repository.addPhones(phone)

    fun createPhone() {
        if (!validateData()) {
            status.value = WRONG_INFORMATION
            return
        }

        val phone = PhoneModel(
            name.value!!,
            brand.value!!,
            price.value!!
        )

        addPhones(phone)
        clearData()

        status.value = PHONE_CREATED
    }

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrBlank() -> return false
            brand.value.isNullOrBlank() -> return false
            price.value.isNullOrBlank() -> return false
        }
        return true
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    fun clearData() {
        name.value = ""
        brand.value = ""
        price.value = ""
    }

    fun setSelectedPhones(phone: PhoneModel){
        name.value = phone.name
        brand.value = phone.brand
        price.value = phone.price
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as PhoneReviewerApplication
                PhoneViewModel(app.phoneRepository)
            }
        }

        const val PHONE_CREATED = "Phone created"
        const val WRONG_INFORMATION = "Wrong information"
        const val INACTIVE = ""
    }
}