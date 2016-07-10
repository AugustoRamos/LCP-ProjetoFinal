/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.Domain;

import br.unesp.rc.lcp.FaceFood.beans.Venda;
import java.util.List;

/**
 *
 * @author Kaborge
 */
public class DadosVenda extends AcessoBanco<Venda>{
    
    private static DadosVenda instancia = null;    
    
    private DadosVenda(){

    }
    
    public static DadosVenda getServico(){
        if(instancia == null)
            instancia = new DadosVenda();
        return instancia;
    }

    @Override
    public boolean salvar(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Venda buscar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venda> buscarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
