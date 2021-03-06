/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.lcp.FaceFood.View;

import br.unesp.rc.lcp.FaceFood.Controller.ProdutoServico;
import br.unesp.rc.lcp.FaceFood.beans.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kaborge
 */
public class CadastrarProdutos extends javax.swing.JPanel {

    /**
     * Creates new form CadastrarProdutos
     */
    public CadastrarProdutos() {
        initComponents();
    }

    public void IniciaTela()
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        
        ProdutoServico servicoProdutos = ProdutoServico.getServico();
        
        List<Produto> produtos = servicoProdutos.buscarTodos();
        
        for (Produto objeto: produtos)
        {
            model.addRow(new Object[]{
                    objeto.getCodigo()
                    , objeto.getNome()
                    , objeto.getPrecoDeVenda()
                    , objeto.getPrecoDeCusto()
                    , objeto.getQuantidadeEstoque() 
                    , objeto.getQuantidadeMinimaEstoque()});
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descrição", "Preço", "Custo ", "Quantidade", "Quantidade Mínima"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton1.setText("Efetivar Alterações");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Adicionar Produto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(140, 140, 140))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        
        model.addRow(new Object[]{
                    -1
                    , ""
                    , 0
                    , 0
                    , 0
                    , 0});
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(!jTable1.isEditing())
        { 
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            int nRow = dtm.getRowCount();

            List<Produto> protudosAdicionar = new ArrayList<Produto>();
            List<Produto> protudosAlterar = new ArrayList<Produto>();

            for (int i = 0 ; i < nRow ; i++)
            {
                Produto aux = new Produto();

                aux.setCodigo(Integer.parseInt(dtm.getValueAt(i,0).toString()));
                aux.setNome(dtm.getValueAt(i,1).toString());
                aux.setPrecoDeVenda(Float.parseFloat(dtm.getValueAt(i,2).toString()));
                aux.setPrecoDeCusto(Float.parseFloat(dtm.getValueAt(i,3).toString()));
                aux.setQuantidadeEstoque(Integer.parseInt(dtm.getValueAt(i,4).toString()));
                aux.setQuantidadeMinimaEstoque(Integer.parseInt(dtm.getValueAt(i,5).toString()));

                if(aux.getCodigo() > 0)
                    protudosAlterar.add(aux);
                else
                    protudosAdicionar.add(aux);
            }
            
            for (Produto produto : protudosAdicionar) {
                ProdutoServico.getServico().salvar(produto);
            }
            
            for (Produto produto : protudosAlterar) {
                ProdutoServico.getServico().alterar(produto);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
