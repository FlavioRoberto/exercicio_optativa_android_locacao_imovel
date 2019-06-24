package com.rimpressao.exerciciolocacao.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rimpressao.exerciciolocacao.R;

public class ImovelViewHolder extends RecyclerView.ViewHolder {

    final ImageView imagem;
    final TextView nome, descricao, localizacao, quantidadeQuarto,
                   vagasGaragem, telefoneContato, valor, tipo;

    public ImovelViewHolder(@NonNull View itemView) {
        super(itemView);
        imagem = itemView.findViewById(R.id.imovel_imagem);
        nome = itemView.findViewById(R.id.imovel_titulo);
        descricao = itemView.findViewById(R.id.imovel_descricao);
        localizacao = itemView.findViewById(R.id.imovel_localizacao);
        quantidadeQuarto = itemView.findViewById(R.id.imovel_quartos);
        vagasGaragem = itemView.findViewById(R.id.imovel_vagas_garagem);
        telefoneContato = itemView.findViewById(R.id.imovel_telefone);
        valor = itemView.findViewById(R.id.imovel_valor);
        tipo = itemView.findViewById(R.id.imovel_tipo);
    }
}
