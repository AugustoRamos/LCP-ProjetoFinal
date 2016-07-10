/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.Domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author Emerson
 */
public class Conexao {
    public static Connection getConnection(){
        Connection conexao = null;
        String usuario = "root";
        String senha = "teste";
        String urlDB = "jdbc:mysql://localhost/FaceFood";
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            conexao = DriverManager.getConnection(urlDB, usuario, senha);
            
        } catch(ClassNotFoundException ex){
            System.out.println("Não encontrou o driver");
        } catch (SQLException ex) {
            Logger.getLogger("Não foi possível conectar");
        }  
        finally{
            return conexao;
        }
    }
}
