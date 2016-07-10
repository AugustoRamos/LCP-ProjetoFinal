/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.Controller;

import br.unesp.rc.lcp.FaceFood.Domain.DadosVenda;
import br.unesp.rc.lcp.FaceFood.Domain.EFormaDePagamento;
import br.unesp.rc.lcp.FaceFood.beans.Produto;
import br.unesp.rc.lcp.FaceFood.beans.Venda;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kaborge
 */
public class VendaServico {
    private static VendaServico instancia = null;    
    
    private VendaServico(){
        
    }
    
    public static VendaServico getServico(){
        if(instancia == null)
            instancia = new VendaServico();
        return instancia;
    }
    
    public boolean salvar(Venda objeto)
    {
        Map<Integer, Float> produtos = objeto.getProdutosComprados();
        
        for (Map.Entry<Integer, Float> entry : produtos.entrySet())
        {
            Produto produto = ProdutoServico.getServico().buscar(entry.getKey());
            
            if (produto != null)
                produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - 1);            
        }    
        
        return true;
    }
    
    public Venda buscar(Integer codigo)
    {
        return null;
    }
    
    public boolean alterar(Venda objeto)
    {
        return true;
    }
    
    public boolean excluir(Venda objeto)
    {
        return true;
    }
    
    public Map<Date, ArrayList<Venda>> buscarTodosPeriodo(Date inicio, Date fim)
    {
        //Período será considerado na query quando houver acesso à base de dados
        
        HashMap<Date, ArrayList<Venda>> x = new HashMap<Date, ArrayList<Venda>>();
        Date data = new Date();
        
        ArrayList<Venda> vendas = new ArrayList<Venda>();
        
        for(int i = 0; i <= 10; i++)
        {
            Map<Integer, Float> y = new HashMap<Integer, Float>();
            Venda z = new Venda();

            z.setData(new Date());
            if(i % 2 == 0)
                z.setFormaPagamento(EFormaDePagamento.Cartao);
            else
                z.setFormaPagamento(EFormaDePagamento.Dinheiro);
            z.setPreco((float)200);

            y.put(1, (float)200);
            y.put(2, (float)50);
            
            z.setProdutosComprados(y);
           
            vendas.add(z);                   
           
        }
        
         if(!x.containsKey(data))
                x.put(data, vendas);
        
        return x;
    }
}
