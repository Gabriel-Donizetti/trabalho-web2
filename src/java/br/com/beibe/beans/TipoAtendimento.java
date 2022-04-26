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
public class TipoAtendimento {
    private String nome;

    public TipoAtendimento(String nome) {
        this.nome = nome;
    }

    public TipoAtendimento() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
 
}
