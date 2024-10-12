package com.mycompany.controledevendascombancodedados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendasDAO {

    public void cadastrarVenda(Vendas venda){
         String sql1 = "INSERT INTO VENDAS(FK_CLIENTES_ID_CLIENTE,FK_PRODUTOS_ID_PRODUTO,QUANTIDADE,VALOR_FINAL) VALUES (?,?,?,?)";
         String sql2 = "SELECT PRECO_PRODUTO FROM PRODUTOS WHERE ID_PRODUTO = ?";
 
        
         try(PreparedStatement prepararQuery2 = BDAdmin.getConexao().prepareStatement(sql2)){
            
             prepararQuery2.setInt(1, venda.getId_produto());
             ResultSet resultadoPreco = prepararQuery2.executeQuery();
             
             if(resultadoPreco.next()){
                 float preco_produto = resultadoPreco.getFloat("PRECO_PRODUTO");
                 int quantidade = venda.getQuantidade();
                  
                 float calculo_valor_final = preco_produto * quantidade;
                try(PreparedStatement prepararQuery = BDAdmin.getConexao().prepareStatement(sql1)){  
                 
                 prepararQuery.setInt(1, venda.getId_cliente());
                 prepararQuery.setInt(2, venda.getId_produto());
                 prepararQuery.setInt(3, venda.getQuantidade());
                 prepararQuery.setFloat(4, calculo_valor_final);
                 
                 int linhas_alteradas = prepararQuery.executeUpdate(); 
                 if(linhas_alteradas > 0 ){
                     System.out.println("Venda cadastrada com sucesso! ");
                 }else{
                     System.out.println("Não foi possível cadastrar a venda!");
                 }
               }catch(SQLException e){
                   System.out.println("Erro ao cadastrar a venda!" + e.getMessage());
               }
             }else{
                 System.out.println("Produto não encontrado! ");
             }
         }catch(SQLException e){
             System.out.println("Não foi possível cadastrar a venda! ");
         }
}
    
    public void listarVendas(){
        String sql3 = "SELECT * FROM VENDAS";
        
        
        try(PreparedStatement prepararQuery = BDAdmin.getConexao().prepareStatement(sql3)){
            
            System.out.println("Lista de Vendas: \n");
            ResultSet resultadoConsulta = prepararQuery.executeQuery();
            while(resultadoConsulta.next()){
                System.out.println("ID da venda: " + resultadoConsulta.getInt("ID_VENDA"));
                System.out.println("ID do cliente: " + resultadoConsulta.getString("FK_CLIENTES_ID_CLIENTE"));
                System.out.println("ID do produto: " + resultadoConsulta.getInt("FK_PRODUTOS_ID_PRODUTO"));
                System.out.println("Quantidade Vendida: " + resultadoConsulta.getInt("QUANTIDADE"));
                System.out.println("Valor da venda: " + resultadoConsulta.getFloat("VALOR_FINAL"));
                System.out.println("-------------------------------------------------------------------------------------------------------------");
            }
        }catch(SQLException e){
            System.out.println("Erro ao listar os clientes! Erro: " + e.getMessage());
        }
    }
    
    public void deletarVendas(int id_venda){
        String sql4 = "DELETE FROM VENDAS WHERE ID_VENDA = (?)";
        
        
        try(PreparedStatement prepararQuery = BDAdmin.getConexao().prepareStatement(sql4)){
            
            prepararQuery.setInt(1,id_venda);
            int linhas_delete = prepararQuery.executeUpdate();
            if(linhas_delete > 0){
            System.out.println("Venda deletada com sucesso!");
            
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            }else{
                System.out.println("Não foi encontrar a venda!");
                System.out.println("-------------------------------------------------------------------------------------------------------------");
            }
        }catch(SQLException e){
            System.out.println("Não foi possível deletar a venda! Erro: " + e.getMessage());
            System.out.println("-------------------------------------------------------------------------------------------------------------");
        }
    }
       public void atualizarVendas(Vendas venda){
           String sql5 = "UPDATE VENDAS SET FK_CLIENTES_ID_CLIENTE = ?,FK_PRODUTOS_ID_PRODUTO = ?,QUANTIDADE = ? , VALOR_FINAL = ? WHERE ID_VENDA = ?";
           String sql4 = "SELECT PRECO_PRODUTO FROM PRODUTOS WHERE ID_PRODUTO = ?";
           
           try(PreparedStatement prepararQuery2 = BDAdmin.getConexao().prepareStatement(sql4)){
               prepararQuery2.setInt(1, venda.getId_produto());
               ResultSet resultadoPreco = prepararQuery2.executeQuery();
               
               if(resultadoPreco.next()){
                   float preco_produto = resultadoPreco.getFloat("PRECO_PRODUTO");
                   float new_valor_final = preco_produto *  venda.getQuantidade();
               
           
           try(PreparedStatement prepararQuery = BDAdmin.getConexao().prepareStatement(sql5)){
           
               prepararQuery.setInt(1, venda.getId_cliente());
               prepararQuery.setInt(2, venda.getId_produto());
               prepararQuery.setInt(3,venda.getQuantidade());
               prepararQuery.setFloat(4, new_valor_final);
               prepararQuery.setInt(5, venda.getId_venda());
               
               int linhas_afetadas = prepararQuery.executeUpdate();
                if(linhas_afetadas > 0){
                    System.out.println("Venda atualizada com sucesso! ");
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                } else{    
                    System.out.println("Não foi possível encontrar a venda!");
                }         System.out.println("-------------------------------------------------------------------------------------------------------------");
                }        }
           } catch(SQLException e){
               
                       System.out.println("Não foi possível atualizar a venda! Erro: "+ e.getMessage());
                       System.out.println("-------------------------------------------------------------------------------------------------------------");
           }
     
}
       public static void main(String[] args){
           BDAdmin.getConexao();
           VendasDAO venda = new VendasDAO();
           venda.listarVendas();
       }
}

