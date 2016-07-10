/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.beans;

/**
 *
 * @author Kaborge
 */
public class Produto {
    
    private int codigo;
    
    private String nome;
    
    private float precoDeCusto;
    
    private float precoDeVenda;

    private int quantidadeEstoque;
    
    private String codigoDeBarras;
    
    private int quantidadeMinimaEstoque;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the precoDeCusto
     */
    public float getPrecoDeCusto() {
        return precoDeCusto;
    }

    /**
     * @param precoDeCusto the precoDeCusto to set
     */
    public void setPrecoDeCusto(float precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }

    /**
     * @return the precoDeVenda
     */
    public float getPrecoDeVenda() {
        return precoDeVenda;
    }

    /**
     * @param precoDeVenda the precoDeVenda to set
     */
    public void setPrecoDeVenda(float precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    /**
     * @return the quantidadeEstoque
     */
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    /**
     * @param quantidadeEstoque the quantidadeEstoque to set
     */
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * @return the codigoDeBarras
     */
    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    /**
     * @param codigoDeBarras the codigoDeBarras to set
     */
    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    /**
     * @return the quantidadeMinimaEstoque
     */
    public int getQuantidadeMinimaEstoque() {
        return quantidadeMinimaEstoque;
    }

    /**
     * @param quantidadeMinimaEstoque the quantidadeMinimaEstoque to set
     */
    public void setQuantidadeMinimaEstoque(int quantidadeMinimaEstoque) {
        this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
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
