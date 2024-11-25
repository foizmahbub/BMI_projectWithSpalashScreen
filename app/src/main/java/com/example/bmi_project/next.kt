package com.example.bmi_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.bmi_project.databinding.ActivityNextBinding
import java.lang.ArithmeticException

class next : AppCompatActivity() {
    lateinit var binding: ActivityNextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityNextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ShowBtn.setOnClickListener {


            val height = binding.Edt1.text.toString()
            val weight = binding.Edt2.text.toString()
            if (height.isEmpty() ) {
                binding.BMITv.text = "please Enter Your Height. "
                return@setOnClickListener

            }else if (weight.isEmpty()) {
                binding.BMITv.text = "please Enter Your  Weight. "
                return@setOnClickListener
            }

            try {

                val weight = weight.toDouble()
                val height = height.toDouble()/100

                if (weight <= 0 && height <= 0) {
                    binding.BMITv.text = "Weight and height must be positive values."
                    return@setOnClickListener

                }
                val bmi = weight / (height * height)



            binding.BMITv.text = String.format("BMI is : %2f", bmi)
            binding.BMItypeTv.text = when (bmi) {
                in 1.00..18.5 -> "Under_weight"
                in 18.5..24.99 -> "Perfect"
                in 25.0..29.99 -> "Over Weight"
                in 30.0..34.99 -> "OBESE"


                else -> "Extremely OBESE"
            }
            }catch (e:NullPointerException){
                binding.BMITv.text="Invalid input!Please enter numeric values."

            }catch (e:ArithmeticException){
                binding.BMITv.text="Height must be greater then Zero."
            }
        }
        }
    }



