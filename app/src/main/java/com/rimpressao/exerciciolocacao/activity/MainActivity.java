package com.rimpressao.exerciciolocacao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rimpressao.exerciciolocacao.R;
import com.rimpressao.exerciciolocacao.adapters.AdapterImovel;
import com.rimpressao.exerciciolocacao.repositorio.modelo.Imovel;
import com.rimpressao.exerciciolocacao.servicos.ImovelServico;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImovelServico servicoImovel;
    private RecyclerView rvImoveis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carregarRecyclerViewImovel();
    }

    private void carregarRecyclerViewImovel() {
        servicoImovel = new ImovelServico(getApplicationContext());
        ArrayList<Imovel> listaImoveis = servicoImovel.listarImoveis();
        AdapterImovel adapterImovel = new AdapterImovel(listaImoveis,getApplicationContext());
        rvImoveis = (RecyclerView) findViewById(R.id.lista_imoveis);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvImoveis.setLayoutManager(layoutManager);
        rvImoveis.setItemAnimator(new DefaultItemAnimator());
        rvImoveis.setAdapter(adapterImovel);
        adapterImovel.notifyDataSetChanged();
    }
}
