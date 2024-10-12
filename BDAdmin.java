package com.mycompany.controledevendascombancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDAdmin {
    private static Connection conexao;
    
    public static Connection getConexao() {
        try {
  
            Class.forName("org.postgresql.Driver");
            
            if(conexao == null){
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LOJA", "postgres", "Jp102030");
            System.out.println("Conexao estabelecida");
            }else{
                return conexao;
            }
        } catch(ClassNotFoundException e) {
            System.out.println("Não foi possível encontrar o driver do banco de dados! Erro: " + e.getMessage());
        } catch(SQLException e) {
            System.out.println("Não foi possível conectar ao banco de dados! Erro: " + e.getMessage());
        }
        return null;
    }
   
}
