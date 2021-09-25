/*
 * The MIT License
 *
 * Copyright 2015 Diego Geronimo D' Onofre.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package erpsystem.forms;

import erpsystem.model.Pessoa;
import erpsystem.model.PessoasDB;
import erpsystem.util.Util;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Diego
 */
public class ConsultaPessoaView extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaPessoaView
     */
    public ConsultaPessoaView() {
        initComponents();
        java.awt.Point p = Util.getCenterPoint(this.getWidth(), this.getHeight());
        this.setLocation(p);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Consulta de Pessoas");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPesquisar = new javax.swing.JButton();
        lblPessoa = new javax.swing.JLabel();
        tfdCliName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        lblPessoa.setText("Nome Pessoa");

        tfdCliName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdCliNameKeyPressed(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "CPF", "Email", "Localização", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.setColumnSelectionAllowed(true);
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);
        tblClientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfdCliName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdCliName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // TODO add your handling code here:
        search();
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private final static Object[] cliCols = new Object[]{"Código",
                                                         "Nome",
                                                         "CPF",
                                                         "Email",
                                                         "Localização",
                                                         "Telefone"
                                                        };
    
    private final TableModel emptyCliModel = new XTableModel(new Object[0][cliCols.length], cliCols);
    
    public final int COD_COL = 0;
    final int NAME           = 1;
    final int CPF            = 2;
    final int EMAIL          = 3;
    final int LOC            = 4;    
    final int TEL            = 5;    
    
    private void fill(java.util.List<Pessoa> cliList)
    {
        TableModel newModel = new XTableModel(cliCols, cliList.size());
        
        for ( int i = 0; i < cliList.size(); i++ ){
            Pessoa cli = cliList.get(i);
            final int cod = cli.getCodigo();
            
            String nome  = cli.getNome();
            String cpf   = cli.getCpf();
            String email = cli.getEmail();
            String loc   = cli.getLocalizacao();
            String tel   = cli.getTelefone();
               
            newModel.setValueAt(cod,   i, COD_COL);
            newModel.setValueAt(nome,  i, NAME   );
            newModel.setValueAt(cpf,   i, CPF    );
            newModel.setValueAt(email, i, EMAIL  );
            newModel.setValueAt(loc,   i, LOC    );
            newModel.setValueAt(tel,   i, TEL    );
        }
        
        tblClientes.setModel(newModel);
        tblClientes.getColumnModel().getColumn(COD_COL).setMinWidth(65);
        tblClientes.getColumnModel().getColumn(COD_COL).setMaxWidth(65);
    }    
    
    public javax.swing.JTable getTblClientes()
    {
        return this.tblClientes;
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        initTab();
        search();
        afterConstruct();
    }//GEN-LAST:event_formWindowOpened

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblClientesMouseClicked

    private void search()
    {
        tblClientes.setEnabled(false);
        String cliName = tfdCliName.getText();
        java.util.List<Pessoa> cliList = PessoasDB.findClient(cliName);
        
        if ( cliList != null )
            fill(cliList);
        
        tblClientes.setEnabled(true);        
    }
    
    private void tfdCliNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdCliNameKeyPressed
        // TODO add your handling code here:
        int code = evt.getKeyCode();
        
        if ( code == KeyEvent.VK_ENTER )
            search();
    }//GEN-LAST:event_tfdCliNameKeyPressed
    
    private void initTab()
    {   
        //Bloqueando a reordenação das colunas
        tblClientes.getTableHeader().setReorderingAllowed(false);
        //Evitando seleção múltipla
        tblClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        tblClientes.setModel(emptyCliModel);
        tblClientes.getColumnModel().getColumn(COD_COL).setMinWidth(65);
        tblClientes.getColumnModel().getColumn(COD_COL).setMaxWidth(65);
        tblClientes.setDefaultRenderer(Object.class, Util.getDefaultCellRenderer());
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaPessoaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaPessoaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaPessoaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaPessoaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaPessoaView().setVisible(true);
            }
        });
    }

    protected void afterConstruct()
    {}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPessoa;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextField tfdCliName;
    // End of variables declaration//GEN-END:variables
}
