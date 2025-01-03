package com.eduardocampos.appgorjeta

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.eduardocampos.appgorjeta.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


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
            if (isChecked) {
                percentage = 10
            }
        }

        binding.rbOptionTwo.setOnCheckedChangeListener { _, isChecked ->
            println("Edu1 Botao 2:$isChecked")
            if (isChecked) {
                percentage = 15
            }
        }

        binding.rbOptionThree.setOnCheckedChangeListener { _, isChecked ->
            println("Edu1 Botao 3:$isChecked")
            if (isChecked) {
                percentage = 20
            }
        }

        binding.btnClean.setOnClickListener {

        }

        binding.btnDone.setOnClickListener {
            val totalAmount = binding.tieTotal.text
            val nPeople = binding.tieNumPeople.text

            if (totalAmount?.isEmpty() == true || nPeople?.isEmpty() == true){
                Snackbar
                    .make(binding.tieTotal, "Preencha todos os Campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val totalAmount: Float = binding.tieTotal.text.toString().toFloat()
                val nPeople: Int = binding.tieNumPeople.text.toString().toInt()

                val totalWithTips = totalAmount + ((totalAmount * percentage) / 100)
                val totalPerClient = totalWithTips / nPeople
                binding.tvResult.text = "Total with  tips per client: $totalPerClient"
            }
        }

        binding.btnClean.setOnClickListener {
            binding.tvResult.text = ""
            binding.tieTotal.setText("")
            binding.tieNumPeople.setText("")
            binding.rbOptionOne.isChecked = false
            binding.rbOptionTwo.isChecked = false
            binding.rbOptionThree.isChecked = false
        }

    }
}