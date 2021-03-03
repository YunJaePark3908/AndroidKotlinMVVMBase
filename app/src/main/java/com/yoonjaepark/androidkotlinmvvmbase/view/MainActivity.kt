package com.yoonjaepark.androidkotlinmvvmbase.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.yoonjaepark.androidkotlinmvvmbase.R
import com.yoonjaepark.androidkotlinmvvmbase.databinding.ActivityMainBinding
import com.yoonjaepark.androidkotlinmvvmbase.viewmodels.LoginViewModel

class MainActivity: AppCompatActivity() {
    companion object{
        @BindingAdapter("toastMessage")
        @JvmStatic
        fun runMe(view: View, message: String?) {
            if (message != null) Toast.makeText(view.context, message, Toast.LENGTH_SHORT).show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.viewModel = LoginViewModel()

        activityMainBinding.executePendingBindings()
    }
}