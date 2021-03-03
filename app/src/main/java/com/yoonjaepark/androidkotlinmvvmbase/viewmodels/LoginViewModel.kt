package com.yoonjaepark.androidkotlinmvvmbase.viewmodels

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.yoonjaepark.androidkotlinmvvmbase.model.User
import com.yoonjaepark.androidkotlinmvvmbase.BR

class LoginViewModel: BaseObservable() {
    private var user: User = User("", "")
    private val successMessage = "Login was successful"
    private val errorMessage = "Email or Password not valid"

    @Bindable
    private var toastMessage: String? = null

    fun getToastMessage(): String? {
        return toastMessage
    }

    private fun setToastMessage(toastMessage: String) {
        this.toastMessage = toastMessage
        notifyPropertyChanged(BR.toastMessage)
    }


    fun setUserEmail(email: String) {
        user.email = email
        notifyPropertyChanged(BR.userEmail)
    }

    @Bindable
    fun getUserEmail(): String {
        return user.email
    }

    @Bindable
    fun getUserPassword(): String {
        return user.password
    }

    fun setUserPassword(password: String) {
        user.password = password
        notifyPropertyChanged(BR.userPassword)
    }

    fun LoginViewModel() {
        user = User("", "")
    }

    fun onLoginClicked() {
        if (isInputDataValid()) setToastMessage(successMessage) else setToastMessage(errorMessage)
    }

    fun isInputDataValid(): Boolean {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail())
            .matches() && getUserPassword().length > 5
    }
}