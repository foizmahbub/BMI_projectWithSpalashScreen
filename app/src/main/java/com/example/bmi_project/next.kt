package com.example.bmi_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmi_project.databinding.ActivityNextBinding

class next : AppCompatActivity() {
    lateinit var binding: ActivityNextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ShowBtn.setOnClickListener {


            val height = binding.Edt1.text.toString().toDouble()/100
            val weight =binding.Edt2.text.toString().toDouble()
            val bmi=weight/(height*height)


            binding.BMITv.text =String.format("BMI is : %2f",bmi)
            binding.BMItypeTv.text=when(bmi){
                in 1.00..18.5->"Under_weight"
                in 18.5..24.99->"Perfect"
                in 25.0..29.99->"Over Weight"
                in 30.0..34.99->"OBESE"



                else -> "Extremely OBESE"
            }

        }


    }
}