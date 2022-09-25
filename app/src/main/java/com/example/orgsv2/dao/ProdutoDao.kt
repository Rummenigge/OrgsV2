package com.example.orgsv2.dao

import com.example.orgsv2.model.Produto

class ProdutoDao {

    fun adiciona(produto: Produto) {
        produtos.add(produto)

    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()

    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}