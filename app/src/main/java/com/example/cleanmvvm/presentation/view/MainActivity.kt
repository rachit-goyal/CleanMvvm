package com.example.cleanmvvm.presentation.view

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import coil.load
import com.example.cleanmvvm.R
import com.example.cleanmvvm.data.model.Failed
import com.example.cleanmvvm.data.model.Success
import com.example.cleanmvvm.data.model.UserResponse
import com.example.cleanmvvm.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initDetails()
        showProgressBar()
        observers()
    }

    private fun observers() {
        viewModel.userData.observe(this) { response ->
            if (response is Success) {
                if (response.data is UserResponse) {
                    image.visibility = VISIBLE
                    name.visibility = VISIBLE
                    email.visibility = VISIBLE
                    image.load(response.data.data.avatar)
                    name.text = response.data.data.first_name
                    email.text = response.data.data.email

                }

            } else if (response is Failed) {
                Toast.makeText(this, response.error, Toast.LENGTH_LONG).show()

            }
        }
    }

    private fun showProgressBar() {
        viewModel.progress.observe(this, { showing ->
            if (showing) {
                progress_bar.visibility = VISIBLE
            } else {
                progress_bar.visibility = GONE
            }
        })
    }

    private fun initDetails() {
        viewModel.getUserData()
    }


}