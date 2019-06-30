package com.rimpressao.exerciciolocacao.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rimpressao.exerciciolocacao.R;
import com.rimpressao.exerciciolocacao.helpers.DinheiroHelper;
import com.rimpressao.exerciciolocacao.repositorio.modelo.Imovel;
import java.util.ArrayList;


public class AdapterImovel extends RecyclerView.Adapter<ImovelViewHolder> {
    private ArrayList<Imovel> listaImoveis;
    private Context context;

    public AdapterImovel(ArrayList<Imovel> listaImoveis, Context context) {
        this.listaImoveis = listaImoveis;
        this.context = context;
    }

    @NonNull
    @Override
    public ImovelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.imovel, viewGroup, false);
        ImovelViewHolder holder = new ImovelViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImovelViewHolder imovelViewHolder, int i) {
        final ImovelViewHolder holder = (ImovelViewHolder) imovelViewHolder;
        final Imovel imovel = listaImoveis.get(i);
        holder.descricao.setText(imovel.getDescricao());
        holder.localizacao.setText(imovel.getLocalizacao());
        holder.nome.setText(imovel.getNome());
        holder.quantidadeQuarto.setText(String.valueOf(imovel.getQuantidadeQuarto())+" quartos");
        holder.telefoneContato.setText(imovel.getTelefoneContato());
        holder.valor.setText(DinheiroHelper.doubleParaDinheiro(imovel.getValor()));
        holder.imagem.setImageBitmap(imovel.getImagem());
        holder.vagasGaragem.setText(imovel.getVagasGaragem()+" vagas na garagem");
        holder.tipo.setText(imovel.getTipo());
    }

    @Override
    public int getItemCount() {
        return listaImoveis.size();
    }
}
