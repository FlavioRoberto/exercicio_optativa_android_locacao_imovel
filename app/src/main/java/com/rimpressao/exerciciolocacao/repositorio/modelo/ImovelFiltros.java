package com.rimpressao.exerciciolocacao.repositorio.modelo;

import java.io.Serializable;

public class ImovelFiltros implements Serializable {

    private boolean arcondicionado, piscina, doisOuMaisBanheiros;
    private int quantidadeQuarto;
    private String tipoImovel, cidades, nome;

    public boolean isArcondicionado() {
        return arcondicionado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidades() {
        return cidades;
    }

    public void setCidades(String cidades) {
        this.cidades = cidades;
    }

    public void setArcondicionado(boolean arcondicionado) {
        this.arcondicionado = arcondicionado;
    }

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }

    public boolean isDoisOuMaisBanheiros() {
        return doisOuMaisBanheiros;
    }

    public void setDoisOuMaisBanheiros(boolean doisOuMaisBanheiros) {
        this.doisOuMaisBanheiros = doisOuMaisBanheiros;
    }

    public int getQuantidadeQuarto() {
        return quantidadeQuarto;
    }

    public void setQuantidadeQuarto(int quantidadeQuarto) {
        this.quantidadeQuarto = quantidadeQuarto;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }
}
