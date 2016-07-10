/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.beans;

import java.util.Date;

/**
 *
 * @author Emerson
 */
public class DataHolderRelatorioLucros {
    private Date data;
    
    private float pagamentoDinheiro;
    
    private float pagamentoCartao;

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
     * @return the pagamentoDinheiro
     */
    public float getPagamentoDinheiro() {
        return pagamentoDinheiro;
    }

    /**
     * @param pagamentoDinheiro the pagamentoDinheiro to set
     */
    public void setPagamentoDinheiro(float pagamentoDinheiro) {
        this.pagamentoDinheiro = pagamentoDinheiro;
    }

    /**
     * @return the pagamentoCartao
     */
    public float getPagamentoCartao() {
        return pagamentoCartao;
    }

    /**
     * @param pagamentoCartao the pagamentoCartao to set
     */
    public void setPagamentoCartao(float pagamentoCartao) {
        this.pagamentoCartao = pagamentoCartao;
    }
}
