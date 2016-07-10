/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.Domain;

import br.unesp.rc.lcp.FaceFood.beans.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kaborge
 */
public class DadosProduto extends AcessoBanco<Produto>{
    
    private static DadosProduto instancia = null;    
    
    private DadosProduto(){
        
    }
    
    public static DadosProduto getServico(){
        if(instancia == null)
            instancia = new DadosProduto();
        return instancia;
    }

    @Override
    public boolean salvar(Produto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Produto buscar(Integer codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Produto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Produto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> buscarTodos() {
        
        List<Produto> retorno = new ArrayList<Produto>();
        
        String query = "SELECT Id, Nome, PrecoDeCusto, PrecoDeVenda, QuantidadeEstoque, CodigoDeBarras, QuantidadeMinimaEstoque FROM produtos";
        try{
            PreparedStatement stmt = Conexao.getConnection().prepareStatement(query);
           
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Produto aux = new Produto();
                        
                aux.setCodigo(rs.getInt("Id"));
                aux.setNome(rs.getString("Nome"));
                aux.setPrecoDeCusto(rs.getFloat("PrecoDeCusto"));
                aux.setPrecoDeVenda(rs.getFloat("PrecoDeVenda"));
                aux.setQuantidadeEstoque(rs.getInt("QuantidadeEstoque"));
                aux.setCodigoDeBarras(rs.getString("CodigoDeBarras"));
                aux.setQuantidadeMinimaEstoque(rs.getInt("QuantidadeMinimaEstoque"));
                
                retorno.add(aux);
            }
            
            stmt.close();
           }
         catch(SQLException ex){
             System.out.println("Erro na instrução SQL" + ex.getMessage());
         }    
        
        return retorno;
    }
}
