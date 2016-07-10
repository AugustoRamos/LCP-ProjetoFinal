/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.Domain;

import br.unesp.rc.lcp.FaceFood.beans.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
        String queryVenda = "Insert into Vendas(FormaPagamento, Preco, Data)"+
             "values(?, ?, ?)";    
        
                
        try{
        
            PreparedStatement stmt = Conexao.getConnection().prepareStatement(queryVenda);
            
            java.util.Date utilDate = objeto.getData();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            stmt.setInt(1, objeto.getFormaPagamento().getValue());
            stmt.setFloat(2, objeto.getPreco());
            stmt.setDate(3, sqlDate);          

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao salvar venda");
            }
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int vendaId = generatedKeys.getInt(1);

                    for (Map.Entry<Integer, Float> entry : objeto.getProdutosComprados().entrySet())
                    {
                        String queryProduto = "Insert into Venda_Produtos(VendaId, ProdutoId, Quantidade)"+
                            "values(?, ?, ?)";
                        
                        try{
        
                                PreparedStatement stmtProd = Conexao.getConnection().prepareStatement(queryProduto);

                                stmtProd.setInt(1, vendaId);
                                stmtProd.setInt(2, entry.getKey());
                                stmtProd.setFloat(3, entry.getValue());  
                                
                                stmtProd.executeUpdate();
                            }
                        catch(SQLException ex){
                            System.out.println("Erro na instrução SQL" + ex.getMessage());
                            return false;
                        }                                   
                    }
                }
            else {
                throw new SQLException("Falha ao salvar venda.");
            }
        }
            
        stmt.close();

            return true;
        }
        catch(SQLException ex){
            System.out.println("Erro na instrução SQL" + ex.getMessage());
            return false;
        }      
              
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
