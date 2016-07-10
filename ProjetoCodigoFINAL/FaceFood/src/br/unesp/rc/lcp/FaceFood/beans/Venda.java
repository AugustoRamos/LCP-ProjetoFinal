/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.beans;

import br.unesp.rc.lcp.FaceFood.Domain.EFormaDePagamento;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Kaborge
 */
public class Venda {
    
    private int codigo;
    
    private Map<Integer, Float> produtosComprados = new HashMap<Integer, Float>();
    
    private EFormaDePagamento formaPagamento;
    
    private float preco;
    
    private Date data;

    /**
     * @return the produtosComprados
     */
    public Map<Integer, Float> getProdutosComprados() {
        return produtosComprados;
    }

    /**
     * @param produtosComprados the produtosComprados to set
     */
    public void setProdutosComprados(Map<Integer, Float> produtosComprados) {
        this.produtosComprados = produtosComprados;
    }

    /**
     * @return the formaPagamento
     */
    public EFormaDePagamento getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(EFormaDePagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
