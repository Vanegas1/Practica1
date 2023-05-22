package com.vanegas1.parcial

import android.app.Application
import com.vanegas1.parcial.data.phones
import com.vanegas1.parcial.repositories.PhoneRepository

class PhoneReviewerApplication : Application() {
    val phoneRepository: PhoneRepository by lazy {
        PhoneRepository(phones)
    }
}