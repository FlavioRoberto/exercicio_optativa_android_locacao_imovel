package com.rimpressao.exerciciolocacao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.rimpressao.exerciciolocacao.R;
import com.rimpressao.exerciciolocacao.adapters.AdapterImovel;
import com.rimpressao.exerciciolocacao.repositorio.modelo.Imovel;
import com.rimpressao.exerciciolocacao.repositorio.modelo.ImovelFiltros;
import com.rimpressao.exerciciolocacao.servicos.ImovelServico;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {
    private ImovelServico servicoImovel;
    private RecyclerView rvImoveis;
    private EditText editText;
    private AdapterImovel adapterImovel;
    private ArrayList<Imovel> listaImoveis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        editText = (EditText) findViewById(R.id.pesquisa);
        editText.setOnEditorActionListener(editorActionListener);

        carregarRecyclerViewImovel();


    }

    @Override
    protected void onStart() {
        super.onStart();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ImovelFiltros filtros = (ImovelFiltros) bundle.get("filtros");
            listarPor(filtros);
        }
    }

    public void chamaFiltros(View view) {
        Intent intent = new Intent(MainActivity.this, FiltroActivity.class);
        startActivity(intent);
        finish();
    }

    private void carregarRecyclerViewImovel() {
        servicoImovel = new ImovelServico(getApplicationContext());
        listaImoveis = servicoImovel.listarImoveis();
        adapterImovel = new AdapterImovel(listaImoveis, getApplicationContext());
        rvImoveis = (RecyclerView) findViewById(R.id.lista_imoveis);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvImoveis.setLayoutManager(layoutManager);
        rvImoveis.setItemAnimator(new DefaultItemAnimator());
        rvImoveis.setAdapter(adapterImovel);
        adapterImovel.notifyDataSetChanged();
    }

    private TextView.OnEditorActionListener editorActionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            switch (actionId) {
                case EditorInfo.IME_ACTION_SEARCH:
                    realizaPesquisa();
                    break;
            }
            return false;
        }
    };

    private void realizaPesquisa() {

        listaImoveis.clear();
        final String texto = editText.getText().toString();

        if (editText.getText() != null) {
            listarPorNome(editText.getText().toString());
        }
    }

    private boolean compararCamposStrig(String campo1, String campo2) {
        if (campo1 != null && campo2 != null)
            return campo1.toLowerCase().contains(campo2.toLowerCase());
        return false;
    }


    private void listarPorNome(String nome) {
        listaImoveis.clear();

        for (Imovel item : servicoImovel.listarImoveis()) {
            if (compararCamposStrig(item.getNome(), nome))
                listaImoveis.add(item);
        }

        adapterImovel.notifyDataSetChanged();
    }

    private void listarPor(ImovelFiltros imovel) {
        if (imovel == null)
            return;

        listaImoveis.clear();

        for (Imovel item : servicoImovel.listarImoveis()) {
            boolean adicionar = true;

            if (!compararCamposStrig(item.getTipo(), imovel.getTipoImovel()))
                adicionar = false;

            if (!compararCamposStrig(item.getLocalizacao(), imovel.getCidades()))
                adicionar = false;

            if (item.getQuantidadeQuarto() != imovel.getQuantidadeQuarto())
                adicionar = false;

            if(imovel.isPiscina() && !compararCamposStrig(item.getDescricao(),"piscina"))
                adicionar = false;

            if(imovel.isArcondicionado() && !compararCamposStrig(item.getDescricao(),"arcondicionado"))
                adicionar = false;

            if(adicionar)
                listaImoveis.add(item);
        }

        adapterImovel.notifyDataSetChanged();

    }
}
