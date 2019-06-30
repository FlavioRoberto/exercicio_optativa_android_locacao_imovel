package com.rimpressao.exerciciolocacao.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.rimpressao.exerciciolocacao.R;
import com.rimpressao.exerciciolocacao.repositorio.modelo.Imovel;

public class FiltroActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    Spinner spinner;

    Imovel imovel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtro);



        radioGroup = (RadioGroup) findViewById(R.id.tipo);
        spinner = (Spinner) findViewById(R.id.spinnerCidades);

        imovel = new Imovel();
    }

    public void fechar(View view) {
        finish();
    }

    public void limpaFiltros(View view) {

    }

    public void filtrar(View view) {
        Intent intent = new Intent(FiltroActivity.this, MainActivity.class);
    }
}
