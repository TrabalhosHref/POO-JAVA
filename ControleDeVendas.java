
package com.mycompany.controledevendasnobd;
import java.util.ArrayList;
import java.util.Scanner;
public class ControleDeVendas {
    public static void main(String[] args){
    ArrayList<Produtos> ListaDeProdutos = new ArrayList<>();
    ArrayList<Clientes> ListaDeClientes = new ArrayList<>();
    ArrayList<Vendas> ListaDeVendas = new ArrayList<>();
    int resp = 0;
    Scanner scan = new Scanner(System.in);
    do{
    System.out.println("MENU: ");
    System.out.println("1. Criar Produto.");
    System.out.println("2. Listar Produtos. ");
    System.out.println("3. Criar Cliente. ");
    System.out.println("4. Listar Clientes. ");
    System.out.println("5. Criar Venda. ");
    System.out.println("6. Listar Vendas. ");
    System.out.println("7. Deletar Cliente. ");
    System.out.println("8. Deletar Produto. ");
    System.out.println("9. Deletar Venda. ");
    System.out.println("0. Sair do Programa.\n ");
    System.out.println("Selecione uma opção: ");
    resp = scan.nextInt();
    scan.nextLine();
    
        switch (resp){
            case 1:
                Produtos produto = new Produtos();
                
                System.out.println("Nome do produto: ");
                String nome_prdt = scan.nextLine();
                produto.setNome_produto(nome_prdt);
                
                System.out.println("Preco do produto: ");
                float preco = scan.nextFloat();
                scan.nextLine();
                produto.setPreco(preco);
                ListaDeProdutos.add(produto);
                
                System.out.println("\nProduto adicionado com sucesso! \n");
                
                break;
            case 2:
                for(Produtos p : ListaDeProdutos){
                p.exibirProdutos();}
                
                break;
            case 3:
                Clientes cliente = new Clientes();
                
                System.out.println("Escreva o nome do cliente: ");
                String nome_client = scan.nextLine();
              
                cliente.setNome_cliente(nome_client);
                ListaDeClientes.add(cliente);
                
                System.out.println("\nCliente adicionado com sucesso! \n");
                break;
            case 4:
                for(Clientes c : ListaDeClientes){
                c.exibirInformacoes();
               
                
                }
                break;
            case 5:
                Vendas venda = new Vendas();
                
                System.out.println("Insira o nome do cliente: ");
                String nome_clien = scan.nextLine();
                venda.setNome_cliente(nome_clien);
                
                System.out.println("Insira o produto vendido: ");
                String nome_produto = scan.nextLine();
                venda.setNome_produt(nome_produto);
                
                System.out.println("Insira o preço do produto vendido: ");   
                float preco_produto = scan.nextFloat();
                scan.nextLine();
                venda.setPreco_produto(preco_produto);
                
                System.out.println("Insira a quantidade vendida: ");        
                int quantidade = scan.nextInt();
                scan.nextLine();
                venda.setQuantidade(quantidade);   
                
                ListaDeVendas.add(venda); 
                System.out.println("\nVenda adicionada com sucesso! \n");
                break;
            case 6:
                for(Vendas v : ListaDeVendas){
                v.exibirVendas();
                
                
                }
                break;
            case 7:
                System.out.println("Insira o nome do cliente a ser deletado: ");
                String nome_delete = scan.nextLine();
                for(int i = 0; i < ListaDeClientes.size(); i ++){
                    if(ListaDeClientes.get(i).getNome().equalsIgnoreCase(nome_delete)){
                        ListaDeClientes.remove(i);
                        System.out.println("\nCliente removido com sucesso! \n");
                    }
                    else{
                        System.out.println("\nCliente não encontrado! \n");
                    }
                    
                
                }
                break;
            case 8:
                System.out.println("Escreva o nome do produto a ser deletado: ");
                String nome_prdt_delete = scan.nextLine();
                for(int i = 0; i < ListaDeProdutos.size();i++){
                    if(ListaDeProdutos.get(i).getNome_produto().equalsIgnoreCase(nome_prdt_delete)){
                        ListaDeProdutos.remove(i);
                        System.out.println("\nProduto removido com sucesso! \n");
                        
                    }
                    else{
                        System.out.println("\nProduto não encotrado!\n ");
                    }
                }  
                break;
            case 9:
                System.out.println("Escreva o nome do cliente que está relacionado com a venda a ser deletada: ");
                String delete_venda = scan.nextLine();
                for(int i = 0; i < ListaDeVendas.size();i++){
                    if(ListaDeVendas.get(i).getNome_cliente().equalsIgnoreCase(delete_venda)){
                        ListaDeVendas.remove(i);
                        System.out.println("\nVenda removida com sucesso! \n");
                        
                    }
                    else{
                        System.out.println("\nVenda não encontrada! \n");
                    }
              }
                break;
                    
            default:
                System.out.println("\nFim do Programa! \n");
        }
        
    }while (resp != 0);
    }
}
