package com.eduardocampos.appgorjeta

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
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

        // lógica envolvida para o radio Button de selecionar porcentagem
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

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.num_people,
            android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerNumberOfPeople.adapter = adapter

        var numOfPeopleSelected = 0
        binding.spinnerNumberOfPeople.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
            )   {
                numOfPeopleSelected = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        binding.btnDone.setOnClickListener {
            val totalAmount = binding.tieTotal.text

            if (totalAmount?.isEmpty() == true){
                Snackbar
                    .make(binding.tieTotal, "Preencha todos os Campos", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val totalAmount: Float = binding.tieTotal.text.toString().toFloat()


                val totalWithTips = totalAmount + ((totalAmount * percentage) / 100)
                val totalPerClient = totalWithTips / numOfPeopleSelected
                binding.tvResult.text = "Total with  tips per client: $totalPerClient"
            }
        }

        binding.btnClean.setOnClickListener {
            binding.tvResult.text = ""
            binding.tieTotal.setText("")
            binding.rbOptionOne.isChecked = false
            binding.rbOptionTwo.isChecked = false
            binding.rbOptionThree.isChecked = false
        }

    }
}