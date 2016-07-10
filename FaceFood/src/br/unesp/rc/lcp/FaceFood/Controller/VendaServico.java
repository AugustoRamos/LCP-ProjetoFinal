/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.Controller;

import br.unesp.rc.lcp.FaceFood.Domain.DadosVenda;
import br.unesp.rc.lcp.FaceFood.beans.DataHolderRelatorioLucros;
import br.unesp.rc.lcp.FaceFood.beans.EFormaDePagamento;
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
        
        DadosVenda.getServico().salvar(objeto);
        
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
    
    public List<DataHolderRelatorioLucros> buscarTodosPeriodo(Date inicio, Date fim)
    {
        return DadosVenda.getServico().buscarRelatrioVendas(inicio, fim);
    }
}
