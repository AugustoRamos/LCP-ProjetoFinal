/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.Controller;

import br.unesp.rc.lcp.FaceFood.Domain.DadosProduto;
import br.unesp.rc.lcp.FaceFood.beans.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kaborge
 */
public class ProdutoServico {
    
    private static ProdutoServico instancia = null;    
    
    private ProdutoServico(){
        
    }
    
    public static ProdutoServico getServico(){
        if(instancia == null)
            instancia = new ProdutoServico();
        return instancia;
    }
    
    public boolean salvar(Produto objeto)
    {
        return DadosProduto.getServico().salvar(objeto);
    }
    
    public Produto buscar(Integer codigo)
    {
        return DadosProduto.getServico().buscar(codigo);
    }
    
    public boolean alterar(Produto objeto)
    {
        return DadosProduto.getServico().alterar(objeto);
    }
    
    public boolean excluir(Produto objeto)
    {
        return true;
    }
    
    public List<Produto> buscarTodos()
    {   
        return DadosProduto.getServico().buscarTodos();
    }
    
    public List<Produto> buscarProdutosAbaixoQuantidadeMinima()
    {
        List<Produto> x = buscarTodos();
        
        List<Produto> retorno = new ArrayList<Produto>();
        
        for (Produto objeto: x) {
            if(objeto.getQuantidadeEstoque() < objeto.getQuantidadeMinimaEstoque())
            {
                retorno.add(objeto);
            }
        }
        
        return retorno;
    }
}
