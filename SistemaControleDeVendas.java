
package com.mycompany.controledevendascombancodedados;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SistemaControleDeVendas {
    public static void main(String[]args){
        BDAdmin.getConexao();
        VendasDAO controleVendas = new VendasDAO();
        ClientesDAO controleClientes = new ClientesDAO();
        ProdutosDAO controleProdutos = new ProdutosDAO();
        Scanner scan = new Scanner(System.in);
        int resp = 0;
        do{
        System.out.println("Selecione uma opção: ");
        System.out.println("1 - Criar venda. ");
        System.out.println("2 - Atualizar venda. ");
        System.out.println("3 - Listar vendas. ");
        System.out.println("4 - Deletar venda. ");
        System.out.println("5 - Administrar clientes. ");
        System.out.println("6 - Administrar produtos. ");
        System.out.println("0 - Sair do programa. \n");
        
        resp = scan.nextInt();
        scan.nextLine();
        
        switch(resp){
            case 1:
                Vendas venda = new Vendas();
              
                  
                System.out.println("Insira o ID do cliente: ");
                int id_cliente = scan.nextInt();
                venda.setId_cliente(id_cliente);
                
                System.out.println("Insira o ID do produto: ");
                int id_produto = scan.nextInt();
                venda.setId_produto(id_produto);

                System.out.println("Insira a quantidade vendida: ");
                int quantidade = scan.nextInt();
                scan.nextLine();
                venda.setQuantidade(quantidade);
                
                
                controleVendas.cadastrarVenda(venda);
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                break;
            case 2:
                Vendas vendaUpdate = new Vendas();
                System.out.println("Insira os dados do cliente para substituí-los: \n"); 
                
                System.out.println("Insira o ID da venda a ser atualizada: ");
                int id_venda_update = scan.nextInt();
                vendaUpdate.setId_venda(id_venda_update);
                
                scan.nextLine();
                
                System.out.println("Insira o ID do cliente");
                int id_cliente_update = scan.nextInt();
                vendaUpdate.setId_cliente(id_cliente_update);
                
                System.out.println("Insira o ID do produto: ");
                int id_produto_update = scan.nextInt();
                vendaUpdate.setId_produto(id_produto_update);
                
                System.out.println("Insira a quantidade do produto: ");
                int quantidade_update = scan.nextInt();
                vendaUpdate.setQuantidade(quantidade_update);
                
                controleVendas.atualizarVendas(vendaUpdate);
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                break;
        
        case 3:
                
                controleVendas.listarVendas();
                System.out.println("-------------------------------------------------------------------------------------------------------------");
                break;
        
        case 4:
            System.out.println("Insira o ID da venda que você quer apagar: ");
            int id_venda_delete = scan.nextInt();
            controleVendas.deletarVendas(id_venda_delete);
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            break;
        
        case 5:
            System.out.println("O que você quer fazer? ");
            System.out.println("1 - Cadastrar cliente. ");
            System.out.println("2 - Atualizar cliente. ");
            System.out.println("3 - Listar clientes. ");
            System.out.println("4 - Deletar cliente");
            System.out.println("------------------------------------------------------------------------------------------------------------- \n");
            
            int resp_clientes = 0;
                resp_clientes = scan.nextInt();
                scan.nextLine();
                switch(resp_clientes){
                    case 1:
                        Clientes cliente = new Clientes();
                        System.out.println("Insira o nome do cliente a ser cadastrado: ");
                        String nome_cliente = scan.nextLine();
                        cliente.setNome_cliente(nome_cliente);
                        
                        controleClientes.cadastrarCliente(cliente);
                        break;
                    case 3:
                        controleClientes.listarClientes();
                        System.out.println("-------------------------------------------------------------------------------------------------------------");
                        break;
                    case 2:
                        Clientes cliente_update = new Clientes();
                        System.out.println("Insira o id do cliente a ser atualizado: ");
                        int id_clientes_update = scan.nextInt();
                        cliente_update.setId_cliente(id_clientes_update);
                        
                        System.out.println("Atualize o nome do cliente: ");
                        String nome_cliente_update = scan.nextLine();
                        cliente_update.setNome_cliente(nome_cliente_update);
                        
                        controleClientes.atualizarCliente(cliente_update);
                        break;
                    case 4:
                        System.out.println("Insira o ID do cliente a ser deletado: ");
                        int id_cliente_delete = scan.nextInt();
                        controleClientes.deletarCliente(id_cliente_delete);
                        break;
                    default:
                        System.out.println("Saindo do programa...");
                        break;
                }
        case 6:
            System.out.println("O que você quer fazer? ");
            System.out.println("1 - Cadastrar produto. ");
            System.out.println("2 - Atualizar produto. ");
            System.out.println("3 - Listar produtos. ");
            System.out.println("4 - Deletar produto. ");
            int resp_produtos = 0;
            resp_produtos = scan.nextInt();
                switch(resp_produtos){
                    case 1:
                        Produtos produto = new Produtos();
                        System.out.println("Cadastro de Produtos:  \n");
                        
                        
                        System.out.println("Insira o nome do produto: ");
                        String nome_produto = scan.nextLine();
                        produto.setNome_produto(nome_produto);
                        
                        System.out.println("Insira o preço do produto: ");
                        float preco_produto = scan.nextFloat();
                        produto.setPreco_produto(preco_produto);
                        
                        controleProdutos.cadastarProduto(produto);
                        break;
                    case 2:
                        Produtos produtos_update = new Produtos();
                        System.out.println("Atualize o produto: \n");
                        
                        System.out.println("Insira o ID do produto a ser atualizado: ");
                        int id_produto_updat = scan.nextInt();
                        produtos_update.setId_produto(id_produto_updat);
                        
                        System.out.println("Insira o nome do produto para atualizá-lo: ");
                        String nome_produto_update = scan.nextLine();
                        produtos_update.setNome_produto(nome_produto_update);
                        
                        System.out.println("Insira o preço do produto: ");
                        float preco_produto_update = scan.nextFloat();
                        produtos_update.setPreco_produto(preco_produto_update);
                        break;
                    case 3:
                        controleProdutos.listarProdutos();
                        System.out.println("-------------------------------------------------------------------------------------------------------------");
                        break;
                        
                    case 4:
                        System.out.println("Insira o ID do Produto para excluí-lo: ");
                        int id_produto_delete = scan.nextInt();
                        controleProdutos.deletarProduto(id_produto_delete);
                        break;
                        
                    default:
                        System.out.println("Saindo do programa...");
                        break;
                }
                    
        case 0:
            System.out.println("Saindo do programa..;");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
            break;
        default :
            System.out.println("Insira uma opção válida! ");
            break;
        }
        }while (resp != 0);
        
    }
}
