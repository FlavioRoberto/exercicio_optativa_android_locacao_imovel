package com.rimpressao.exerciciolocacao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.rimpressao.exerciciolocacao.R;
import com.rimpressao.exerciciolocacao.repositorio.modelo.ImovelFiltros;

public class FiltroActivity extends AppCompatActivity {
    private RadioGroup radioGroupTipo, radioGroupQuantQuartos;
    private Spinner spinner;
    private ImovelFiltros imovelFiltros;
    private CheckBox  chkArcondicionado, chkPiscina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);
        radioGroupTipo = findViewById(R.id.tipo);
        radioGroupQuantQuartos = findViewById(R.id.rgQuantidadeQuarto);
        spinner = findViewById(R.id.spinnerCidades);
        imovelFiltros = new ImovelFiltros();
        chkArcondicionado = findViewById(R.id.checkboxArCondicionado);
        chkPiscina = findViewById(R.id.checkboxPiscina);

        inicializaFIltros();

        radioGroupTipo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String tipo = i == 1 ? "Casa" : "Apartamento";
                imovelFiltros.setTipoImovel(tipo);
            }
        });

        radioGroupQuantQuartos.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioQuarto1: imovelFiltros.setQuantidadeQuarto(1);break;
                    case R.id.radioQuarto2: imovelFiltros.setQuantidadeQuarto(2);break;
                    case R.id.radioQuarto3: imovelFiltros.setQuantidadeQuarto(3);break;
                    case R.id.radioQuarto4: imovelFiltros.setQuantidadeQuarto(4);break;
                }
            }
        });

        chkArcondicionado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                imovelFiltros.setArcondicionado(b);
            }
        });

        chkPiscina.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                imovelFiltros.setPiscina(b);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                imovelFiltros.setCidades(adapterView.getItemAtPosition(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                imovelFiltros.setCidades(adapterView.getItemAtPosition(0).toString());
            }
        });
    }


    private void inicializaFIltros(){
        imovelFiltros.setQuantidadeQuarto(1);
        imovelFiltros.setTipoImovel("CASA");
    }

    public void fechar(View view) {
        finish();
    }

    public void limpaFiltros(View view) {

    }

    public void filtrar(View view) {
        Intent intent = new Intent(FiltroActivity.this, MainActivity.class);
        intent.putExtra("filtros", imovelFiltros);
        startActivity(intent);
        finish();
    }
}
