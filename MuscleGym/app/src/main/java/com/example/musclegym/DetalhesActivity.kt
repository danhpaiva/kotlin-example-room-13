package com.example.musclegym

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musclegym.repository.AppDataBase

class DetalhesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalhes)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvNomeSuplementoDetalhes = findViewById<TextView>(R.id.tvNomeSuplementoDetalhes)
        val tvDescricaoDetalhes = findViewById<TextView>(R.id.tvDescricaoDetalhes)
        val tvPrecoDetalhes = findViewById<TextView>(R.id.tvPrecoDetalhes)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)

        val suplementoDatabase = AppDataBase.getDataBase(this).suplementoDAO()

        val retornoSelect = suplementoDatabase.get(1)

        val nome = retornoSelect.nome
        val descricao = retornoSelect.descricao
        val preco = retornoSelect.preco

        tvNomeSuplementoDetalhes.text = "Nome: $nome"
        tvDescricaoDetalhes.text = "Descrição: $descricao"
        tvPrecoDetalhes.text = "Preço: R$ $preco"

        btnVoltar.setOnClickListener {
            onBackPressed()
        }
    }
}