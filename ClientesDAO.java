
package com.mycompany.controledevendascombancodedados;
//PREPARED STATEMENT/ STRING SQL/SET SUBSTITUICAO PARAMETRO/ OU RESULT SET E ITERAR SOBRE OS RESULTADOS

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientesDAO {
    
    public void cadastrarCliente(Clientes cliente){
        String sql1 = "INSERT INTO CLIENTES(NOME) VALUES ?";
        
        PreparedStatement prepararQuery;
        
        try{
           
            prepararQuery = BDAdmin.getConexao().prepareStatement(sql1);
            prepararQuery.setString(1, cliente.getNome_cliente());
            int linhas_alteradas = prepararQuery.executeUpdate();
            if(linhas_alteradas > 0){
                System.out.println("Cliente cadastrado com sucesso! ");
                System.out.println();
            }else{
                System.out.println("Não foi possível cadastrar o cliente!  ");
                System.out.println();
            }
        }catch(SQLException e){
            System.out.println("Erro:  " + e.getMessage());
        }
    
    }
    
    public void listarClientes(){
        String sql2 = "SELECT * FROM CLIENTES";
        
        PreparedStatement prepararQuery;
        try{
            prepararQuery = BDAdmin.getConexao().prepareStatement(sql2);
            System.out.println("Lista de Clientes: ");
            ResultSet resultadoConsulta = prepararQuery.executeQuery();
            while(resultadoConsulta.next()){
                System.out.println("ID do cliente: " + resultadoConsulta.getInt("ID_CLIENTE"));
                System.out.println("Nome do cliente: " + resultadoConsulta.getString("NOME_CLIENTE"));
                System.out.println("----------------------------------------------");
            }
            
        }catch(SQLException e){
            System.out.println("Erro ao listar clientes! Erro: " + e.getMessage());
        }
    }
    
    public void deletarCliente(int id_cliente){
        String sql3 = "DELETE FROM CLIENTES WHERE ID_CLIENTE = ?";
        
        PreparedStatement prepararQuery;
        try{
            prepararQuery = BDAdmin.getConexao().prepareStatement(sql3);
            prepararQuery.setInt(1, id_cliente);
            int linhas_afetadas = prepararQuery.executeUpdate();
            if(linhas_afetadas > 0){
                System.out.println("Cliente deletado com sucesso! ");
                System.out.println("----------------------------------------------");
            }else{
                System.out.println("Não foi possível deletar o cliente! ");
            }
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
            System.out.println("----------------------------------------------");
        }
    }
    
    public void atualizarCliente(Clientes cliente){
        String sql4 = "UPDATE CLIENTES SET NOME_CLIENTE = ? WHERE ID_CLIENTE = ?";
        
        PreparedStatement prepararQuery;
        try{
            prepararQuery = BDAdmin.getConexao().prepareStatement(sql4);
            prepararQuery.setInt(2, cliente.getId_cliente());
            prepararQuery.setString(1, cliente.getNome_cliente());
            
            int linhas_afetadas = prepararQuery.executeUpdate();
            if(linhas_afetadas > 0){
                System.out.println("Cliente atualizado com sucesso! ");
                            System.out.println("----------------------------------------------");
            }else{
                System.out.println("Não foi possível atualizar o cliente! ");
            }
        }catch(SQLException e){
            System.out.println("Erro: "+ e.getMessage());
                        System.out.println("----------------------------------------------");
        }
    }
    
}
