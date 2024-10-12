
package com.mycompany.controledevendascombancodedados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutosDAO {
    
    public void cadastarProduto(Produtos produto){
        String sql1 = "INSERT INTO PRODUTOS(NOME_PRODUTO,PRECO_PRODUTO) VALUES (?, ?)";
        PreparedStatement prepararQuery;
        try {
            prepararQuery = BDAdmin.getConexao().prepareStatement(sql1);
            
            prepararQuery.setString(1, produto.getNome_produto());
            prepararQuery.setFloat(2, produto.getPreco_produto());
            int linhas_afetadas = prepararQuery.executeUpdate();
            
            if(linhas_afetadas > 0){
                System.out.println("Produto cadastrado com sucesso! ");
                System.out.println("----------------------------------------------");
            }else{
                System.out.println("Não foi possível cadastrar o produto! ");
            }
            
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public void deletarProduto(int id_produto){
        String sql2 = "DELETE FROM PRODUTOS WHERE ID_PRODUTO = ?";
        PreparedStatement prepararQuery;
        
        try{
            prepararQuery = BDAdmin.getConexao().prepareStatement(sql2);
            prepararQuery.setInt(1, id_produto);
            
            int linhas_afetadas = prepararQuery.executeUpdate();
          
            if(linhas_afetadas > 0){
                System.out.println("Produto deletado com sucesso! ");
                
            }else{
                System.out.println("Não foi possível deletar o produto! ");
                
            }
                        
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public void listarProdutos(){
        String sql3 = "SELECT * FROM PRODUTOS";
        PreparedStatement prepararQuery;
        try{
            prepararQuery = BDAdmin.getConexao().prepareStatement(sql3);
            System.out.println("Lista de Produtos: ");
            ResultSet resultadoConsulta = prepararQuery.executeQuery();
            
            while(resultadoConsulta.next()){
                System.out.println("ID do produto: " +  resultadoConsulta.getInt("ID_PRODUTO"));
                System.out.println("Nome do produto: " + resultadoConsulta.getString("NOME_PRODUTO"));
                System.out.println("Preco do produto: "  + resultadoConsulta.getFloat("PRECO_PRODUTO"));
                System.out.println("----------------------------------------------");
                
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar produtos! Erro: " + e.getMessage());
        }
        
    }
    
    public void atualizarProduto(Produtos produto){
        String sql4 = "UPDATE PRODUTOS SET NOME_PRODUTO = ?, PRECO_PRODUTO = ? WHERE ID_PRODUTO = ?";
        PreparedStatement prepararQuery;
        try{
            prepararQuery = BDAdmin.getConexao().prepareStatement(sql4);
            prepararQuery.setInt(3, produto.getId_produto());
            prepararQuery.setString(1, produto.getNome_produto());
            prepararQuery.setFloat(2, produto.getPreco_produto());
            
            int linhas_afetadas = prepararQuery.executeUpdate();
            
            if(linhas_afetadas > 0){
                System.out.println("Produto atualizado com sucesso! ");
                
            }else{
                System.out.println("Não foi possível atualizar o produto! ");
            }
            
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    
}
