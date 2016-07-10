/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.beans;

/**
 *
 * @author augustochaves
 */
public enum EFormaDePagamento {
    Dinheiro(0), Cartao(1);
    
    private final int value;
    
    private EFormaDePagamento(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
