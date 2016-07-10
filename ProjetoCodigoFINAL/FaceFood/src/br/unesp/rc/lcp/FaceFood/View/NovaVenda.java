/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.View;

import br.unesp.rc.lcp.FaceFood.Controller.ProdutoServico;
import br.unesp.rc.lcp.FaceFood.Controller.VendaServico;
import br.unesp.rc.lcp.FaceFood.Domain.EFormaDePagamento;
import br.unesp.rc.lcp.FaceFood.Domain.TabelaVenda;
import br.unesp.rc.lcp.FaceFood.beans.Produto;
import br.unesp.rc.lcp.FaceFood.beans.Venda;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaborge
 */
public class NovaVenda extends javax.swing.JPanel {

    /**
     * Creates new form NovaVenda
     */
    
    Map<Integer, TabelaVenda> produtosComprados;
    
    public NovaVenda() {
        initComponents();
    }

    public void IniciaTela()
    {
        produtosComprados = new HashMap<Integer, TabelaVenda>();
        jTextField1.setText("");
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    }
    
    private void AlteraTabelaCompra()
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        for (Map.Entry<Integer, TabelaVenda> entry : produtosComprados.entrySet()) {
            TabelaVenda value = entry.getValue();
            
            model.addRow(new Object[]{
                value.getDescricao()
                , value.getQuantidade()
                , "R$ " + (value.getQuantidade() * value.getPreco())});
        }

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(820, 350));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Quantidade", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        jButton1.setText("Pagar Cartão");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pagar Dinheiro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Código do produto");

        jButton3.setText("Adicionar Produto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jLabel1)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        try
        {
            int codigoProduto = Integer.parseInt(jTextField1.getText());
            
            Produto produtoSelecionado = ProdutoServico.getServico().buscar(codigoProduto);
            
            if(produtoSelecionado != null)
            {
                if(!produtosComprados.containsKey(produtoSelecionado.getCodigo()))
                {
                    TabelaVenda aux = new TabelaVenda();
                    
                    aux.setDescricao(produtoSelecionado.getNome());
                    aux.setPreco(produtoSelecionado.getPrecoDeVenda());
                    aux.setQuantidade(1);
                    
                    produtosComprados.put(produtoSelecionado.getCodigo(), aux);
                }else
                {
                    TabelaVenda aux = produtosComprados.get(produtoSelecionado.getCodigo());
                    aux.setQuantidade(aux.getQuantidade() + 1);
                }
                
                AlteraTabelaCompra();
            }
        }catch(Exception ex)
        {
            System.out.println("br.unesp.rc.lcp.FaceFood.View.NovaVenda.jButton3ActionPerformed()" + ex.getMessage());
        }
        jTextField1.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void fecharVenda(EFormaDePagamento formaPagamento)
    {
        try
        {
            float valor = 0;
            HashMap<Integer, Float> auxXprodutosComprados = new HashMap<Integer, Float>();

            Venda venda = new Venda();

            venda.setData(new Date());
            venda.setFormaPagamento(formaPagamento);

            for (Map.Entry<Integer, TabelaVenda> entry : produtosComprados.entrySet()) {
                TabelaVenda value = entry.getValue();

                valor = valor + (value.getPreco() * value.getQuantidade());

                auxXprodutosComprados.put(entry.getKey(), value.getQuantidade());
            }

            venda.setProdutosComprados(auxXprodutosComprados);

            venda.setPreco(valor);

            VendaServico.getServico().salvar(venda);

            IniciaTela();
        }
        catch(Exception ex)
        {
            System.out.println("br.unesp.rc.lcp.FaceFood.View.NovaVenda.fecharVenda()" + ex.getMessage());
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fecharVenda(EFormaDePagamento.Cartao);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fecharVenda(EFormaDePagamento.Dinheiro);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
