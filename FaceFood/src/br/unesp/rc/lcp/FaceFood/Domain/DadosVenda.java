/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.Domain;

import br.unesp.rc.lcp.FaceFood.beans.DataHolderRelatorioLucros;
import br.unesp.rc.lcp.FaceFood.beans.Produto;
import br.unesp.rc.lcp.FaceFood.beans.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    
    public List<DataHolderRelatorioLucros> buscarRelatrioVendas(Date inicial, Date fim) {
        List<DataHolderRelatorioLucros> retorno = new ArrayList<DataHolderRelatorioLucros>();
        
        String query = "select Data	"
                + ", CASE WHEN FormaPagamento = 0 THEN Preco END as PagamentoDinheiro    "
                + ",  CASE WHEN FormaPagamento = 1 THEN Preco END as PagamentoCartao    "
                + "from vendas     "
                + "where Data between ? and ?    "
                + "order by Data";
        try{
            PreparedStatement stmt = Conexao.getConnection().prepareStatement(query);
           
            DateFormat df = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            
            stmt.setString(1, df.format(inicial)); 
            stmt.setString(2, df.format(fim));
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                DataHolderRelatorioLucros aux = new DataHolderRelatorioLucros();

                aux.setData(rs.getDate("Data"));
                aux.setPagamentoDinheiro(rs.getFloat("PagamentoDinheiro"));
                aux.setPagamentoCartao(rs.getFloat("PagamentoCartao"));
                retorno.add(aux);
            }
            
            stmt.close();
           }
         catch(SQLException ex){
             System.out.println("Erro na instrução SQL" + ex.getMessage());
         }           
        
        return retorno;
    }


    @Override
    public boolean salvar(Venda objeto) {
        String queryVenda = "Insert into Vendas(FormaPagamento, Preco, Data)"+
             "values(?, ?, ?)";           
                
        try{
        
            PreparedStatement stmt = Conexao.getConnection().prepareStatement(queryVenda, Statement.RETURN_GENERATED_KEYS);
            
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
    
