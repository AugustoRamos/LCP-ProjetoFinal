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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kaborge
 */
abstract class AcessoBanco<T> {
    
    protected Connection conexao = Conexao.getConnection();
    
    public abstract boolean salvar(T objeto);
    
    public abstract T buscar(Integer codigo);
    
    public abstract boolean alterar(T objeto);
    
    public abstract boolean excluir(T objeto);
    
    public abstract List<T> buscarTodos();
}
