package com.example.orgsv2.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgsv2.R
import com.example.orgsv2.dao.ProdutoDao
import com.example.orgsv2.ui.recycler.adapter.ListaProdutoAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity(R.layout.activity_lista_produtos) {
    private val dao = ProdutoDao()
    private val adapter = ListaProdutoAdapter(
        this, produtos = dao.buscaTodos()
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
        configuraRecyclerView()
        configuraFab()

    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_formulario_produto_floatingActionButton)
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produtos_recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}