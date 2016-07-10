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
        
        boolean retorno = false;
        
        String query = "INSERT INTO Produtos (Nome, PrecoDeCusto, PrecoDeVenda, QuantidadeEstoque, CodigoDeBarras, QuantidadeMinimaEstoque) "
                + "VALUES (?, ?, ?, ?, '', ?)";
     
        try{
        
            PreparedStatement stmt = Conexao.getConnection().prepareStatement(query);

            stmt.setString(1, objeto.getNome());
            stmt.setFloat(2, objeto.getPrecoDeCusto());
            stmt.setFloat(3, objeto.getPrecoDeVenda());
            stmt.setInt(4, objeto.getQuantidadeEstoque());
            stmt.setInt(5, objeto.getQuantidadeMinimaEstoque());

            stmt.execute();
            stmt.close();
            
            retorno = true;
           }
        catch(SQLException ex){
            System.out.println("Erro na instrução SQL" + ex.getMessage());
        }
        
        return retorno;
    }

    @Override
    public Produto buscar(Integer codigo) {
        Produto retorno = null;
        
        String query = "SELECT Id, Nome, PrecoDeCusto, PrecoDeVenda, QuantidadeEstoque, CodigoDeBarras, QuantidadeMinimaEstoque FROM Produtos "
                + "WHERE Id = ?";
        try{
            PreparedStatement stmt = Conexao.getConnection().prepareStatement(query);
           
            stmt.setInt(1, codigo);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {

                retorno = new Produto();
                
                retorno.setCodigo(rs.getInt("Id"));
                retorno.setNome(rs.getString("Nome"));
                retorno.setPrecoDeCusto(rs.getFloat("PrecoDeCusto"));
                retorno.setPrecoDeVenda(rs.getFloat("PrecoDeVenda"));
                retorno.setQuantidadeEstoque(rs.getInt("QuantidadeEstoque"));
                retorno.setCodigoDeBarras(rs.getString("CodigoDeBarras"));
                retorno.setQuantidadeMinimaEstoque(rs.getInt("QuantidadeMinimaEstoque"));
            }
            
            stmt.close();
           }
         catch(SQLException ex){
             System.out.println("Erro na instrução SQL" + ex.getMessage());
         }    
        
        return retorno;
    }

    @Override
    public boolean alterar(Produto objeto) {
        boolean retorno = false;
        
        String query = "UPDATE Produtos SET Nome = ?, PrecoDeCusto = ?, PrecoDeVenda = ?, QuantidadeEstoque = ?, QuantidadeMinimaEstoque = ? "
                + "WHERE Id = ?";
     
        try{
        
            PreparedStatement stmt = Conexao.getConnection().prepareStatement(query);

            stmt.setString(1, objeto.getNome());
            stmt.setFloat(2, objeto.getPrecoDeCusto());
            stmt.setFloat(3, objeto.getPrecoDeVenda());
            stmt.setInt(4, objeto.getQuantidadeEstoque());
            stmt.setInt(5, objeto.getQuantidadeMinimaEstoque());
            stmt.setInt(6, objeto.getCodigo());

            stmt.execute();
            stmt.close();
            
            retorno = true;
           }
        catch(SQLException ex){
            System.out.println("Erro na instrução SQL" + ex.getMessage());
        }
        
        return retorno;
    }

    @Override
    public boolean excluir(Produto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> buscarTodos() {
        
        List<Produto> retorno = new ArrayList<Produto>();
        
        String query = "SELECT Id, Nome, PrecoDeCusto, PrecoDeVenda, QuantidadeEstoque, CodigoDeBarras, QuantidadeMinimaEstoque FROM Produtos";
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
