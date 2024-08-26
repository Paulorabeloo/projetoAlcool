package com.example.projetoetanol

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val editAlcool = findViewById<EditText>(R.id.editAlcool)
        val editGasolina = findViewById<EditText>(R.id.editGasolina)
        val botao = findViewById<Button>(R.id.botao)
        val textoResultado = findViewById<TextView>(R.id.textoResultado)

        botao.setOnClickListener {
            val precoAlcool = editAlcool.text.toString().toDoubleOrNull() //transforma tudo em string e depois em double
            val precoGasolina = editGasolina.text.toString().toDoubleOrNull()

            if(precoAlcool != null && precoAlcool != null)
            {
                val resultado = precoAlcool / precoGasolina!!

                if(resultado <= 0.7)
                {
                    textoResultado.text = "Vale à pena abastecer com Álcool"
                }
                else
                {
                    textoResultado.text = "Vale à pena abastecer com Gasolina"
                }
            }
            else
            {
                textoResultado.text = "Por favor insira valores válidos"
            }
        }
    }
}