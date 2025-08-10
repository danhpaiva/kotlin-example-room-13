package com.example.musclegym

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.musclegym.model.Suplemento
import com.example.musclegym.repository.AppDataBase

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

        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
                cadastrarSuplemento()
        }
    }

    private fun cadastrarSuplemento(){

        val etNomeSuplemento = findViewById<EditText>(R.id.etNomeSuplemento)
        val etDescricao = findViewById<EditText>(R.id.etDescricao)
        val etPreco = findViewById<EditText>(R.id.etPreco)

        val nome = etNomeSuplemento.text.toString()
        val descricao = etDescricao.text.toString()
        val preco = etPreco.text.toString()


        if (nome.isNotEmpty() && descricao.isNotEmpty() && preco.isNotEmpty()) {

            val suplementoDatabase = AppDataBase.getDataBase(this).suplementoDAO()

            suplementoDatabase.insertSuplemento(Suplemento().apply {
                this.nome = nome
                this.descricao = descricao
                this.preco = preco
            })

            Toast.makeText(this, "Cartao cadastrado com sucesso!", Toast.LENGTH_SHORT).show()

            etNomeSuplemento.text.clear()
            etDescricao.text.clear()
            etPreco.text.clear()
            etNomeSuplemento.requestFocus()

            val intent = Intent(this, DetalhesActivity::class.java)

            startActivity(intent)

        } else {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT)
                .show()
        }
    }
}