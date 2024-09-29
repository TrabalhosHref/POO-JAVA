/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controledevendasnobd;

/**
 *
 * @author User
 */
public class Produtos {
    private String nome_produto;
    private float preco;
    
    public Produtos(){
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public float getPreco() {
        return  preco;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public void exibirProdutos(){
    System.out.println("Nome do produto: " + getNome_produto() + "\nPreco do produto:" + getPreco() + "\n");
    }
}
