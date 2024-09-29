package com.mycompany.controledevendasnobd;


public class Vendas {
    private String nome_cliente;
    private int quantidade;
    private String nome_produto;
    private float preco_produto;
    private float valor_final;
    
    public Vendas(){
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getValor_final() {
        valor_final = preco_produto * quantidade;
        return valor_final;
    }
    
    public String getNome_produto() {
        return nome_produto;
    }
    
    
    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setNome_produt(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public void setPreco_produto(float preco_produto) {
        this.preco_produto = preco_produto;
    }
    
    public void exibirVendas(){
    System.out.println("Cliente: " +getNome_cliente());
    System.out.println("Produto: " + getNome_produto());
    System.out.println("Valor final de venda: \n "+ getValor_final() + "\n");
    
    
    
    
    }
}
