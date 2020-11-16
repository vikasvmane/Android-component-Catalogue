package com.vikas.androidcomponentscatalogue.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vikas.androidcomponentscatalogue.databinding.ActivityCustomViewBinding

class CustomViewActivity : AppCompatActivity() {
    lateinit var binding : ActivityCustomViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}