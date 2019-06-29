package com.rimpressao.exerciciolocacao.repositorio.modelo;

import android.graphics.Bitmap;
import android.media.Image;

public class Imovel {
    private Bitmap imagem;
    private String nome, descricao, localizacao, telefoneContato, tipo;
    private int quantidadeQuarto, vagasGaragem;
    private Double valor;

    public Imovel(String nome, String descricao, String localizacao,
                  int quantidadeQuarto, int vagasGaragem, String telefoneContato,
                  Double valor, String tipo, Bitmap imagem) {
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

    public int getQuantidadeQuarto() {
        return quantidadeQuarto;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public Double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }
}
