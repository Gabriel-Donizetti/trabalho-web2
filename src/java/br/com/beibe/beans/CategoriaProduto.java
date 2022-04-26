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
public class CategoriaProduto {
    private String nome;

    public CategoriaProduto(String nome) {
        this.nome = nome;
    }

    public CategoriaProduto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
}
