package com.rimpressao.exerciciolocacao.repositorio.modelo;

import android.graphics.Bitmap;
import android.media.Image;

public class Imovel {
    private Bitmap imagem;
   private String nome, descricao, localizacao, quantidadeQuarto,
    vagasGaragem, telefoneContato, valor, tipo;

    public Imovel(String nome, String descricao, String localizacao,
                  String quantidadeQuarto, String vagasGaragem, String telefoneContato,
                  String valor, String tipo, Bitmap imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.quantidadeQuarto = quantidadeQuarto;
        this.vagasGaragem = vagasGaragem;
        this.telefoneContato = telefoneContato;
        this.valor = valor;
        this.tipo = tipo;
        this.imagem = imagem;
    }

    public Bitmap getImagem() {
        return imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public String getQuantidadeQuarto() {
        return quantidadeQuarto;
    }

    public String getVagasGaragem() {
        return vagasGaragem;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public String getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }
}
