package br.com.cotemig.juliano.trabalho.ul.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import br.com.cotemig.juliano.trabalho.R
import coil.load


class PagamentoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagamento)

        var nome = intent.getStringExtra("nome")
        var valor = intent.getStringExtra("valor")
        var picture = intent.getStringExtra("picture")

        getDetalhes(nome, valor, picture)

        var btn = findViewById<Button>(R.id.finalizarpedido)
        btn.setOnClickListener {
            finalizado()
        }

        var btncancelar = findViewById<Button>(R.id.cancelarpedido)
        btncancelar.setOnClickListener {
            cancelado()
        }
    }

    private fun finalizado(){
        val intent = Intent(this, DisplayMetrics::class.java).apply {
            putExtra(action, R.layout.activity_pedido_finalizado)
        }
    }

    private fun cancelado() {
        val intent = Intent(this, DisplayMetrics::class.java).apply {
            putExtra(action, R.layout.activity_main)
        }
    }

    fun getDetalhes(nome: String?, valor: String?, picture: String?, ) {

        var nomedetalhe = findViewById<TextView>(R.id.nomedetalhe)
        nomedetalhe.text = nome

        var valordetalhe = findViewById<TextView>(R.id.valordetalhe)
        valordetalhe.text = valor

        var imagemdetalhe = findViewById<ImageView>(R.id.imagemdetalhe)
        imagemdetalhe.load(picture)

    }
}