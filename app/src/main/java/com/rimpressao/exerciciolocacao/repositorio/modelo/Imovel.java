package com.rimpressao.exerciciolocacao.repositorio.modelo;

import android.graphics.Bitmap;
import android.media.Image;

public class Imovel {
    private Bitmap imagem;
    private String nome, descricao, localizacao, telefoneContato, tipo;
    private int quantidadeQuarto, vagasGaragem;
    private Double valor;

    public Imovel() {

    }

    public Imovel(String nome){
        this.nome = nome;
    }

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

    public void setImagem(Bitmap imagem) {
        this.imagem = imagem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setQuantidadeQuarto(int quantidadeQuarto) {
        this.quantidadeQuarto = quantidadeQuarto;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
