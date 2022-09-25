package com.example.orgsv2.ui.recycler.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgsv2.R
import com.example.orgsv2.model.Produto

class ListaProdutoAdapter(
    private val context: Context,
    produtos: List<Produto>

) : RecyclerView.Adapter<ListaProdutoAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(produto: Produto) {
            val nome = itemView.findViewById<TextView>(R.id.activity_formulario_produto_nome)
            nome.text = produto.nome
            val descricao = itemView.findViewById<TextView>(R.id.activity_formulario_produto_descricao)
            descricao.text = produto.descricao
            val valor = itemView.findViewById<TextView>(R.id.activity_formulario_produto_valor)
            valor.text = produto.valor.toPlainString()

        }
    }


    //Ele vai fazer o processo de binding e segurar a view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.produto_item, parent, false)
        return ViewHolder(view)
    }

    //Ele vai definir e indicar a posição da View dentro do Recycler.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)

    }

    // determinar quantos itens queremos apresentar dentro dele.
    override fun getItemCount(): Int = produtos.size
    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()

    }


}
