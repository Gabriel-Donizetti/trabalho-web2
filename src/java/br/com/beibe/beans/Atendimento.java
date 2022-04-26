/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.beans;

import java.util.Date;

/**
 *
 * @author Iury
 */
public class Atendimento {
    private Date data;
    private Usuario cliente;
    private String situacaoAtendimento;
    private Produto produto;
    private TipoAtendimento tipoAtendimento;
    private String descricao;
    private String solucao;
    
   
    public Atendimento() {
    }

    public Atendimento(Date data, String hora, Usuario cliente, String situacaoAtendimento, Produto produto, String descricao, String solucao) {
        this.data = data;
        this.cliente = cliente;
        this.situacaoAtendimento = situacaoAtendimento;
        this.produto = produto;
        this.descricao = descricao;
        this.solucao = solucao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

  
    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public String getSituacaoAtendimento() {
        return situacaoAtendimento;
    }

    public void setSituacaoAtendimento(String situacaoAtendimento) {
        this.situacaoAtendimento = situacaoAtendimento;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public TipoAtendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }
    
    
    
}
