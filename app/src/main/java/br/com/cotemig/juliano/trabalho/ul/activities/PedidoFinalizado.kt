package br.com.cotemig.juliano.trabalho.ul.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import br.com.cotemig.juliano.trabalho.R

class PedidoFinalizado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido_finalizado)

        var btnvoltar = findViewById<Button>(R.id.finalizarpedido)
        btnvoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}
