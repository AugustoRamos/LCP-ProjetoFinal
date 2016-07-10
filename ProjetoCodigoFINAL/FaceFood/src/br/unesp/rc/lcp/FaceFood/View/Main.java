package br.unesp.rc.lcp.FaceFood.View;

import br.unesp.rc.lcp.FaceFood.Controller.ProdutoServico;
import br.unesp.rc.lcp.FaceFood.Controller.VendaServico;
import br.unesp.rc.lcp.FaceFood.Domain.EFormaDePagamento;
import br.unesp.rc.lcp.FaceFood.Domain.EMenuProduto;
import br.unesp.rc.lcp.FaceFood.beans.Produto;
import br.unesp.rc.lcp.FaceFood.beans.Venda;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by augustochaves on 06/06/16.
 */
public class Main {
    static Scanner scan = new Scanner(System.in);
    static String input;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        menuInicial();
        
         try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void relatorioEstoque()
    {
        List<Produto> x = ProdutoServico.getServico().buscarTodos();
        
        System.out.println("");
        System.out.println("                Relatorio de Estoque");
        
        System.out.println("");
        
        for (Produto objeto: x) {
            System.out.println(" Codigo: " + objeto.getCodigo());
            System.out.println(" Nome: " + objeto.getNome());
            System.out.println(" Codigo de Barras: " + objeto.getCodigoDeBarras());
            System.out.println(" Preco de custo: " + objeto.getPrecoDeCusto());
            System.out.println(" Preco de Venda: " + objeto.getPrecoDeVenda());
            System.out.println(" Quantidade no Estoque: " + objeto.getQuantidadeEstoque());
            System.out.println(" Quantidade Minima para Alerta: " + objeto.getQuantidadeMinimaEstoque());
            
            System.out.println("");
        }
        try {
             System.in.read();
         } catch (IOException ex) {
             Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public static void menuPrincipal()
    {
        System.out.println();
        do
        {
            System.out.println("                Menu");
            
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Realizar vendas");
            System.out.println("3. Relatório de Lucros e Vendas");
            System.out.println("4. Relatório de Estoque");
            
            input = scan.next();
            
            switch(input)
            {
                case "1":
                    menuProduto();
                    break;
                case "2":
                    vendeProdutos();
                    break;
                case "3":
                    relatorioLucro();
                    break;
                case "4":
                    relatorioEstoque();
                    menuPrincipal();
                    break;
            }
            
            
        }while(input != "0");      
        
        System.out.println();
    }
    
    public static int exibeMenuProduto(){

        System.out.println("Escolha uma opção:\n");
        System.out.println(EMenuProduto.valueOf("Cadastrar").ordinal() + " - " + EMenuProduto.Cadastrar);
        System.out.println(EMenuProduto.valueOf("Editar").ordinal() + " - " + EMenuProduto.Editar);
        System.out.println(EMenuProduto.valueOf("Deletar").ordinal() + " - " + EMenuProduto.Deletar);
        System.out.println(EMenuProduto.valueOf("Listar").ordinal() + " - " + EMenuProduto.Listar);
        System.out.println(EMenuProduto.valueOf("Buscar").ordinal() + " - " + EMenuProduto.Buscar);
        System.out.println(EMenuProduto.valueOf("Voltar").ordinal() + " - " + EMenuProduto.Voltar);

        System.out.print("\nInforme a opção escolhida: ");
        
        return scan.nextInt();              
    }
    
    public static void menuProduto(){
                      
        int option = 0, id = 0;

        do{
            option = exibeMenuProduto();

            EMenuProduto optionEnum = EMenuProduto.values()[option];

            switch (optionEnum){
                case Cadastrar:
                    cadastraProduto();
                    
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    menuProduto();
                    break;
                case Editar:
                    System.out.println("\n\nEdição de Produto\n");
                    System.out.println("Informe o cod. de barras do produto a ser editado: ");
                    id = scan.nextInt();

                    editaProduto(id);
                    
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    menuProduto();
                    break;
                case Deletar:
                    System.out.println("\n\nExclusão de Produto\n");
                    System.out.println("Informe o cod. de barras do produto a ser excluído: ");
                    id = scan.nextInt();

                    deletaProduto(id);
                    
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    menuProduto();
                    break;
                case Listar:
                    relatorioEstoque();
                    menuProduto();
                    break;
                case Buscar:
                    System.out.println("\n\nBusca de Produto\n");
                    System.out.println("Informe o cod. de barras do produto a ser buscado: ");
                    id = scan.nextInt();
                    Produto produto = buscaProduto(id); 
                    if(produto!= null)
                        exibeProduto(produto);                    
                    else
                        System.out.println("Produto não encontrado!");
                    
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    menuProduto();
                    break;
                default:
                    menuPrincipal();
                    break;
            }
        }
        while(option != 0);
    }
    
    public static void relatorioLucro()
    {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        
        float valorCartao = 0;
        float valorDinheiro = 0;
        
        System.out.println("");
        System.out.println("                Relatorio de Lucro e Venda");
        
        System.out.println("");
        
        System.out.println("Entre com a data Inicial");
        input = scan.next();
        
        System.out.println("Entre com a data final");
        input = scan.next();
        
        VendaServico vendaServico = VendaServico.getServico();

        Map<Date, ArrayList<Venda>> vendas = vendaServico.buscarTodosPeriodo(null, null);
        
        System.out.println("");
        System.out.println("Vendas");
        
        for(Entry<Date, ArrayList<Venda>> entry : vendas.entrySet()) 
        {
           
            System.out.println("");
            
            System.out.println("Dia " + dateFormat.format(entry.getKey()));
            
            for (Venda objeto: entry.getValue()) {

                for(Entry<Integer, Float> entry2 : objeto.getProdutosComprados().entrySet()) {
                    Integer key = entry2.getKey();
                    Float value = entry2.getValue();

                    System.out.println("");
                    
                    System.out.println("     Produto: " + key);
                    System.out.println("     Quantidade: " + value);
                    
                    
                }
                System.out.println("");
                System.out.println("  Valor : " + objeto.getPreco());     
                System.out.println("  Forma Pagamento : " + objeto.getFormaPagamento());  

                if(objeto.getFormaPagamento() == EFormaDePagamento.Cartao)
                {
                    valorCartao += objeto.getPreco() ;
                }
                else
                {
                    valorDinheiro += objeto.getPreco() ;
                }
                
                 System.out.println("--------------------");
            }   
        }
        
        System.out.println("");
        
        System.out.println("Faturamento em dinheiro no periodo: " + valorDinheiro);
        System.out.println("");
        System.out.println("Faturamento em cartao no periodo: " + valorCartao);    
        System.out.println("");

        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        menuPrincipal();
    }
    
    public static void menuInicial()
    {
        ProdutoServico produtoServico = ProdutoServico.getServico();
        
        System.out.println("                Sistema FaceFood!!!");
        System.out.println();
        List<Produto> x = produtoServico.buscarProdutosAbaixoQuantidadeMinima();
        
        if(x.size() > 0)
        {
            System.out.println("Existem produtos com quantidade abaixo do estipulado!");
            System.out.println("Produtos:");
            
            for (Produto objeto: x) {
                System.out.println("        " + objeto.getNome());
            }
            
            System.out.println("Deseja acessar Relatório de Estoque?");
            
            input = scan.next();
            
            if(input.equals("S") || input.equals("s"))
                relatorioEstoque();
            else
            {
                menuPrincipal();
            }
        }
    }
    
    private static void exibeProduto(Produto objeto){
        System.out.println(" Codigo: " + objeto.getCodigo());
        System.out.println(" Nome: " + objeto.getNome());
        System.out.println(" Codigo de Barras: " + objeto.getCodigoDeBarras());
        System.out.println(" Preco de custo: " + objeto.getPrecoDeCusto());
        System.out.println(" Preco de Venda: " + objeto.getPrecoDeVenda());
        System.out.println(" Quantidade no Estoque: " + objeto.getQuantidadeEstoque());
        System.out.println(" Quantidade Minima para Alerta: " + objeto.getQuantidadeMinimaEstoque());
     }

    private static void cadastraProduto() {
        Produto objeto = new Produto();
        scan.nextLine();

        
        System.out.println("\n\nNome: ");
        objeto.setNome(scan.nextLine());

        System.out.println("\n\nCódigo de Barras: ");
        objeto.setCodigoDeBarras(scan.nextLine());

        System.out.println("\nPreço de Venda: ");
        objeto.setPrecoDeVenda(scan.nextFloat());

        System.out.println("\nPreço de Compra");
        objeto.setPrecoDeCusto(scan.nextFloat());

        System.out.println("\nQuantidade em estoque: ");
        objeto.setQuantidadeEstoque(scan.nextInt());

        System.out.println("\nQuantidade mínima em estoque: ");
        objeto.setQuantidadeMinimaEstoque(scan.nextInt());

        if(ProdutoServico.getServico().salvar(objeto))
            System.out.println("\nProduto cadastrado com sucesso!\n");
        else
            System.out.println("\nErro ao cadastrar produto. Tente novamente.");       
    }
    
    private static void vendeProdutos() {
        int id = 0;
        Map<Integer, Float>  produtos =  new HashMap<Integer, Float>();
        System.out.println("\n\nVenda de Produto\n");
        
        do{
            System.out.println("Informe o cod. do produto a ser vendido ou 0 para prosseguir: ");
            id = scan.nextInt();
            //if(id != 0 && ProdutoServico.getServico().buscar(id) != null){
                produtos.put(id, 40.0f);
            //}
            //else if(id != 0)
                //System.out.println("Produto não encontrado!\n");
            
        }
        while(id != 0);       
        
        Venda objeto = new Venda();                  
       
        System.out.println("Forma de Pagamento\n\n" 
                + EFormaDePagamento.valueOf("Dinheiro").ordinal() + " - " + EFormaDePagamento.Dinheiro + "\n" 
                + EFormaDePagamento.valueOf("Cartao").ordinal() + " - " +EFormaDePagamento.Cartao +"\n");
        
        float soma = 0.0f;
        for (float f : produtos.values()) {
            soma += f;
        }
        
        objeto.setFormaPagamento(EFormaDePagamento.values()[scan.nextInt()]);
        objeto.setProdutosComprados(produtos);
        objeto.setPreco(soma);                 
        objeto.setData(new Date());        

        if(VendaServico.getServico().salvar(objeto))
            System.out.println("Venda efetuada com sucesso!\n");
        else
            System.out.println("Erro ao efetuar venda!");
        
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        menuPrincipal();
    }

    private static Produto buscaProduto(Integer id) {
        return ProdutoServico.getServico().buscar(id);
    }

    private static boolean deletaProduto(Integer id) {
        Produto objeto = ProdutoServico.getServico().buscar(id);
        
        return ProdutoServico.getServico().excluir(objeto);
    }

    private static boolean editaProduto(Integer id) {
        Produto objeto = ProdutoServico.getServico().buscar(id);       
        scan.nextLine();

        System.out.println("\n\nNome: ");
        objeto.setNome(scan.nextLine());

        System.out.println("\n\nCódigo de Barras: ");
        objeto.setCodigoDeBarras(scan.nextLine());

        System.out.println("\nPreço de Venda: ");
        objeto.setPrecoDeVenda(scan.nextFloat());

        System.out.println("\nPreço de Compra");
        objeto.setPrecoDeCusto(scan.nextFloat());

        System.out.println("\nQuantidade em estoque: ");
        objeto.setQuantidadeEstoque(scan.nextInt());

        System.out.println("\nQuantidade mínima em estoque: ");
        objeto.setQuantidadeMinimaEstoque(scan.nextInt());

        if(ProdutoServico.getServico().alterar(objeto)){
            System.out.println("Produto alterado com sucesso!");
            return true;
        }
        
        System.out.println("Erro ao alterar produto!");        
        return false;
    }
}
