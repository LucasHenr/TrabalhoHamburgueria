package br.com.cotemig.juliano.trabalho.ul.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.cotemig.juliano.trabalho.R
import br.com.cotemig.juliano.trabalho.adapters.CardapioAdapter
import br.com.cotemig.juliano.trabalho.models.Hamburguer
import coil.load
import org.w3c.dom.Text

class DescricaoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descricao)


        var nome = intent.getStringExtra("nome")
        var valor = intent.getStringExtra("valor")
        var descicao = intent.getStringExtra("descicao")
        var picture = intent.getStringExtra("picture")

        getItem(nome, valor, descicao, picture)

    }

    fun getItem(nome: String?, valor: String?, descicao: String?, picture: String?, ) {

        var namehamburguer = findViewById<TextView>(R.id.namehamburguer)
        namehamburguer.text = nome

        var valorhamburger = findViewById<TextView>(R.id.valorhamburger)
        valorhamburger.text = valor

        var descricao = findViewById<TextView>(R.id.descricao)
        descricao.text = descicao

        var picturehamburguer = findViewById<ImageView>(R.id.picturehamburguer)
        picturehamburguer.load(picture)

    }

    fun showDetalhes(list: List<Hamburguer>) {

        var item = findViewById<RecyclerView>(R.id.item)
        item.adapter = CardapioAdapter(this, list) { hamburguer ->
            var intent = Intent(this, DescricaoActivity::class.java)
            intent.putExtra("nome", hamburguer.nome)
            intent.putExtra("valor", hamburguer.valor)
            intent.putExtra("descicao", hamburguer.descicao)
            intent.putExtra("picture", hamburguer.picture)
            startActivity(intent)
        }


    }
}