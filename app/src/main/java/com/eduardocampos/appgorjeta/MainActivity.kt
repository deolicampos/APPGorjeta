package com.eduardocampos.appgorjeta

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eduardocampos.appgorjeta.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        var percentage: Int = 0

        binding.rbOptionOne.setOnCheckedChangeListener { _, isChecked ->
            println("Edu1 Botao 1:$isChecked")
            if (isChecked){
                percentage = 10
            }
        }

        binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            println("Edu1 Botao 2:$isChecked")
            if (isChecked){
                percentage = 15
            }
        }

        binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
            println("Edu1 Botao 3:$isChecked")
            if (isChecked){
                percentage = 20
            }
        }

        binding.btnClean.setOnClickListener {

        }

        binding.btnDone.setOnClickListener {
            val totalAmount: Float = binding.tieTotal.text.toString().toFloat()
            val nPeople: Int = binding.tieNumPeople.text.toString().toInt()


            val totalWithTips = totalAmount + ((totalAmount*percentage)/100)

            println("Edu1 O total é: $totalWithTips")
        }

    }
}