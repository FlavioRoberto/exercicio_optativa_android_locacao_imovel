package com.rimpressao.exerciciolocacao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rimpressao.exerciciolocacao.R;
import com.rimpressao.exerciciolocacao.adapters.AdapterImovel;
import com.rimpressao.exerciciolocacao.repositorio.modelo.Imovel;
import com.rimpressao.exerciciolocacao.servicos.ImovelServico;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImovelServico servicoImovel;
    private RecyclerView rvImoveis;
    private EditText editText;

    private ArrayList<Imovel> listaImoveis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.pesquisa);
        editText.setOnEditorActionListener(editorActionListener);

        getSupportActionBar().hide();

        carregarRecyclerViewImovel();
    }

    private void carregarRecyclerViewImovel() {
        servicoImovel = new ImovelServico(getApplicationContext());
        listaImoveis = servicoImovel.listarImoveis();
        AdapterImovel adapterImovel = new AdapterImovel(listaImoveis,getApplicationContext());
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
        for (Imovel item: listaImoveis) {
            final String texto = editText.getText().toString();

            Log.d("ITEM", texto);

            if (editText.getText() != null) {
                if (item != null && !item.getNome().contains(texto)) {
                    listaImoveis.remove(item);
                }
            }
            else {
                listaImoveis = servicoImovel.listarImoveis();
            }
        }
    }
}
