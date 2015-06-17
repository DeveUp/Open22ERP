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

import erpsystem.Log;
import erpsystem.Util;
import static erpsystem.Util.msg;
import erpsystem.db.Estoque;
import erpsystem.db.EstoqueDB;
import erpsystem.db.Produto;
import erpsystem.db.ProdutosDB;
import java.awt.event.KeyEvent;

/**
 *
 * @author Diego
 */
public class EstoqueView extends javax.swing.JDialog {

    /**
     * Creates new form EstoqueView
     */
    public EstoqueView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Atualizar Estoque");
        java.awt.Point p = Util.getCenterPoint(this.getWidth(), this.getHeight());
        this.setLocation(p);      
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodProd = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        tfdCodProd = new javax.swing.JTextField();
        lblQt = new javax.swing.JLabel();
        tfdQt = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        lblProdInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblCodProd.setText("Código Produto:");

        btnAdd.setText("Adicionar");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        tfdCodProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfdCodProdKeyPressed(evt);
            }
        });

        lblQt.setText("Quantidade:");

        btnPesquisar.setText("...");
        btnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPesquisarMouseClicked(evt);
            }
        });

        lblProdInfo.setText("Informações do produto...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodProd)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfdCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblProdInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAdd)
                    .addComponent(lblQt)
                    .addComponent(tfdQt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCodProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdCodProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(lblProdInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblQt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdQt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPesquisarMouseClicked
        // TODO add your handling code here:
        findProd();
    }//GEN-LAST:event_btnPesquisarMouseClicked

    private void tfdCodProdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdCodProdKeyPressed
        // TODO add your handling code here:
        java.awt.event.KeyEvent e = evt;
        int code = e.getKeyCode();
        
        if ( code == KeyEvent.VK_ENTER ){
            String s = tfdCodProd.getText().trim();
            if ( Util.isInt(s) ){
                int codProd = Integer.parseInt(s);

                if (! ProdutosDB.exists(codProd) )
                    findProd();
                else{
                    Produto prod = ProdutosDB.find(codProd);
                    
                    if ( prod != null ){
                        fillProd(prod);
                    }
                    else
                        Log.log("Problema: 4647");
                }
            }
        }         
    }//GEN-LAST:event_tfdCodProdKeyPressed

    private boolean validateFields()
    {
        if ( tfdCodProd.getText().trim().equals("") )
        {
            msg("Por favor, informe o código do produto.");
            tfdCodProd.grabFocus();
            return false;        
        }
        
        if ( tfdQt.getText().trim().equals("") )
        {
            msg("Por favor, informe o valor a ser incrementado \n"
              + "ou decrementado do estoque do produto.\n"
              + "Valores negativos são aceitos pelo sistema para decremento\n"
                    + "de estoque.\n"
                    + "Exemplo: -5");
            tfdQt.grabFocus();
            return false;        
        }        
        
        String codProd = tfdCodProd.getText().trim();
        
        if (! Util.isInt(codProd) ){
            msg("Por favor, informe um valor numérico\n"
              + " válido para o código do produto.");
            tfdCodProd.grabFocus();
            return false;
        }             

        String qt = tfdQt.getText().trim();
        
        if (! Util.isInt(qt) ){
            msg("Por favor, informe um valor numérico\n"
              + " válido para a quantidade que será \n"
              + "incrementada ou decrementada do produto.\n"
              + "Valores negativos são aceitos para decremento.\n"
                    + "Exemplo: -10");
            tfdCodProd.grabFocus();
            return false;
        }             
        
        return true;
    }    
    
    public void setCodProd(int codProd)
    {
        String s = String.valueOf(codProd);
        tfdCodProd.setText(s);       

        if (! ProdutosDB.exists(codProd) )
            findProd();
        else{
            Produto prod = ProdutosDB.find(codProd);

            if ( prod != null ){
                fillProd(prod);
            }
            else
                Log.log("Problema: 4697");
        }
    }
    
    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        // TODO add your handling code here:
        if ( validateFields() )
        {
            Estoque estoque = new Estoque();

            String codProd = tfdCodProd.getText();
            String qt = tfdQt.getText();

            int cod = Integer.parseInt(codProd);
            int intQt = Integer.parseInt(qt);
            estoque.setCodProd(cod);
            estoque.setQt(intQt);           
            boolean result = EstoqueDB.addEstoque(estoque);
            
            if ( result ){
                javax.swing.JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso.");
            }
            else
                javax.swing.JOptionPane.showMessageDialog(null, "Ocorreu um problema ao atualizar o estoque.\n"
                                                              + "Recomendável tentar novamente, se o problema\n"
                                                              + "persistir, informe ao Desenvolvedor.");
        }
    }//GEN-LAST:event_btnAddMouseClicked

    
    private void findProd()
    {
        ConsultaProdutoView p = new XConsultaProdutoView(null, true)
        {
            @Override
            public void chosenCode(int code)
            {
                tfdCodProd.setText(String.valueOf(code));
                Produto prod = ProdutosDB.find(code);

                if ( prod != null ){
                    fillProd(prod);
                }
                else
                    Log.log("Problema: 4651");
            }
        };
        p.setVisible(true);        
    } 
    
    private void fillProd(Produto prod)
    {
        lblProdInfo.setText(prod.getSummary());          
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
            java.util.logging.Logger.getLogger(EstoqueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstoqueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstoqueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstoqueView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EstoqueView dialog = new EstoqueView(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel lblCodProd;
    private javax.swing.JLabel lblProdInfo;
    private javax.swing.JLabel lblQt;
    private javax.swing.JTextField tfdCodProd;
    private javax.swing.JTextField tfdQt;
    // End of variables declaration//GEN-END:variables
}
