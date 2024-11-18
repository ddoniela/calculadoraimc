package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

const val RESULT_KEY_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(RESULT_KEY_IMC, 0f)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvResult.text = result.toString()
        val classificacao: String = if (result <= 18.5f) {
            tvClassificacao.setTextColor(getColor(R.color.red))
            "Abaixo do peso"
        } else if (result > 18.5f && result <= 24.9f) {
            tvClassificacao.setTextColor(getColor(R.color.green))
            "Peso normal"
        } else if (result > 24.9f && result <= 29.9f) {
            tvClassificacao.setTextColor(getColor(R.color.yellow))
            "Sobrepeso"
        } else if (result > 29.9f && result <= 34.9f) {
            tvClassificacao.setTextColor(getColor(R.color.red))
            "Obesidade grau 1"
        } else if (result > 34.9f && result <= 39.9f) {
            tvClassificacao.setTextColor(getColor(R.color.red))
            "Obesidade grau 2"
        } else {
            tvClassificacao.setTextColor(getColor(R.color.red))
            "Obesidade grau 3"
        }

        tvClassificacao.text = classificacao
    }
}