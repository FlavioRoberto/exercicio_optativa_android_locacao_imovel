package com.rimpressao.exerciciolocacao.servicos;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.VectorDrawableCompat;

import com.rimpressao.exerciciolocacao.R;
import com.rimpressao.exerciciolocacao.repositorio.modelo.Imovel;

import java.util.ArrayList;

public class ImovelServico {

    private Context context;

    public ImovelServico(Context context) {
        this.context = context;
    }

    public ArrayList<Imovel> listarImoveis() {
        Drawable casaDrawable =  context.getResources().getDrawable(R.drawable.imovel);

        ArrayList<Imovel> imoveis = new ArrayList<>();

        imoveis.add(new Imovel("Imovel 1", "Bela casa no bairro Santa Tereza, unico dono, financiamento pela caixa",
                "Divinópolis",
                2, 3, "(37) 99140-6667", 150000.00,
                "CASA", ((BitmapDrawable) casaDrawable).getBitmap()));

        imoveis.add(new Imovel("Imovel 2", "Casa com terreiro, excelenete para quem tem crianças e pets.",
                "Divinópolis",
                3, 2, "(37) 99140-6667", 230000.00,
                "CASA", ((BitmapDrawable) casaDrawable).getBitmap()));

        imoveis.add(new Imovel("Imovel 3", "Casa com terreiro e arcondicionado, excelenete para quem tem crianças e pets.",
                "Divinópolis",
                4, 1, "(37) 99140-6667", 230000.00,
                "CASA", ((BitmapDrawable) casaDrawable).getBitmap()));

        imoveis.add(new Imovel("Imovel 4", "Apartamento com piscina, excelenete para quem tem crianças e pets.",
                "Belo Horizonte",
                1, 2, "(37) 99140-6667", 230000.00,
                "APARTAMENTO", ((BitmapDrawable) casaDrawable).getBitmap()));

        return imoveis;
    }

}
