
package com.mycompany.controledevendasnobd;

public class Clientes {
    private String nome_cliente;
    
    public Clientes(){
    }
    public String getNome(){
    return nome_cliente;}
    
    public void exibirInformacoes(){
    System.out.println("Nome do cliente: "+ nome_cliente + "\n");
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }
    
}
