/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.beibe.beans;

/**
 *
 * @author Iury
 */
public class Produto {
    private String nome;
    private String descricao;
    private Float peso;
    private CategoriaProduto categoria;

    public Produto() {
    }

    public Produto(String nome, String descricao, Float peso, CategoriaProduto categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.peso = peso;
        this.categoria = categoria;
    }

        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public CategoriaProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }
    
}
