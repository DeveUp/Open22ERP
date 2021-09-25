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

import chartforms.ChartForm001;
import chartforms.ChartForm002;
import erpsystem.ERPSystem;
import erpsystem.util.Log;
import erpsystem.util.Util;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URLClassLoader;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class MainFormView extends javax.swing.JFrame {

    /**
     * Creates new form MainFormView
     */
    public MainFormView() {
        initComponents();
        
        java.awt.Point p = Util.getCenterPoint(this.getWidth(), this.getHeight());
        this.setTitle(ERPSystem.appName);
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

        jMenuBar1 = new javax.swing.JMenuBar();
        mniCadastros = new javax.swing.JMenu();
        mniCadPessoa = new javax.swing.JMenuItem();
        mniCadProd = new javax.swing.JMenuItem();
        mniGenMov = new javax.swing.JMenuItem();
        mniPayMethod = new javax.swing.JMenuItem();
        mniCadEstoque = new javax.swing.JMenuItem();
        mniConsultas = new javax.swing.JMenu();
        mniFindMov = new javax.swing.JMenuItem();
        mniFindPessoa = new javax.swing.JMenuItem();
        mniFindProd = new javax.swing.JMenuItem();
        mniCharts = new javax.swing.JMenu();
        mniFaturamento = new javax.swing.JMenuItem();
        mniFaturamentoDia = new javax.swing.JMenuItem();
        mniLinkedin = new javax.swing.JMenu();
        mniLinkedinDiego = new javax.swing.JMenuItem();
        mniParticipe = new javax.swing.JMenu();
        mniDesenvolvedor = new javax.swing.JMenuItem();
        mniInvestidor = new javax.swing.JMenuItem();
        mniColaborador = new javax.swing.JMenuItem();
        mniNetworkingSolucoes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mniCadastros.setText("Cadastros");

        mniCadPessoa.setText("Pessoa");
        mniCadPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadPessoaActionPerformed(evt);
            }
        });
        mniCadastros.add(mniCadPessoa);

        mniCadProd.setText("Produto");
        mniCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadProdActionPerformed(evt);
            }
        });
        mniCadastros.add(mniCadProd);

        mniGenMov.setText("Movimentação");
        mniGenMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniGenMovActionPerformed(evt);
            }
        });
        mniCadastros.add(mniGenMov);

        mniPayMethod.setText("Forma de Pagamento");
        mniPayMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniPayMethodActionPerformed(evt);
            }
        });
        mniCadastros.add(mniPayMethod);

        mniCadEstoque.setText("Estoque");
        mniCadEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadEstoqueActionPerformed(evt);
            }
        });
        mniCadastros.add(mniCadEstoque);

        jMenuBar1.add(mniCadastros);

        mniConsultas.setText("Consultas");

        mniFindMov.setText("Movimentações");
        mniFindMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFindMovActionPerformed(evt);
            }
        });
        mniConsultas.add(mniFindMov);

        mniFindPessoa.setText("Pessoas");
        mniFindPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFindPessoaActionPerformed(evt);
            }
        });
        mniConsultas.add(mniFindPessoa);

        mniFindProd.setText("Produtos");
        mniFindProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFindProdActionPerformed(evt);
            }
        });
        mniConsultas.add(mniFindProd);

        jMenuBar1.add(mniConsultas);

        mniCharts.setText("Gráficos");

        mniFaturamento.setText("Faturamento por intervalo");
        mniFaturamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFaturamentoActionPerformed(evt);
            }
        });
        mniCharts.add(mniFaturamento);

        mniFaturamentoDia.setText("Faturamento por dia");
        mniFaturamentoDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniFaturamentoDiaActionPerformed(evt);
            }
        });
        mniCharts.add(mniFaturamentoDia);

        jMenuBar1.add(mniCharts);

        mniLinkedin.setText("Linkedin");

        mniLinkedinDiego.setText("Linkedin Diego");
        mniLinkedinDiego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLinkedinDiegoActionPerformed(evt);
            }
        });
        mniLinkedin.add(mniLinkedinDiego);

        jMenuBar1.add(mniLinkedin);

        mniParticipe.setText("Faça Parte!");

        mniDesenvolvedor.setText("Desenvolvedor");
        mniDesenvolvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDesenvolvedorActionPerformed(evt);
            }
        });
        mniParticipe.add(mniDesenvolvedor);

        mniInvestidor.setText("Investidor");
        mniInvestidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniInvestidorActionPerformed(evt);
            }
        });
        mniParticipe.add(mniInvestidor);

        mniColaborador.setText("Colaborador");
        mniColaborador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniColaboradorActionPerformed(evt);
            }
        });
        mniParticipe.add(mniColaborador);

        mniNetworkingSolucoes.setText("Networking de Soluções");
        mniNetworkingSolucoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNetworkingSolucoesActionPerformed(evt);
            }
        });
        mniParticipe.add(mniNetworkingSolucoes);

        jMenuBar1.add(mniParticipe);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniCadPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadPessoaActionPerformed
        // TODO add your handling code here:
        PessoasView form = new PessoasView();
        form.setVisible(true);
    }//GEN-LAST:event_mniCadPessoaActionPerformed

    private void mniCadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadProdActionPerformed
        // TODO add your handling code here:
        ProdutosView form = new ProdutosView();
        form.setVisible(true);        
    }//GEN-LAST:event_mniCadProdActionPerformed

    private void mniGenMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniGenMovActionPerformed
        // TODO add your handling code here:
        MovView form = new MovView();
        form.setVisible(true);        
    }//GEN-LAST:event_mniGenMovActionPerformed

    private void mniFindMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFindMovActionPerformed
        // TODO add your handling code here:
        ConsultaMovView form = new ConsultaMovView();
        form.setVisible(true);
    }//GEN-LAST:event_mniFindMovActionPerformed

    private void mniFindPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFindPessoaActionPerformed
        // TODO add your handling code here:
        ConsultaPessoaView form = new ConsultaPessoaView();
        form.setVisible(true);        
    }//GEN-LAST:event_mniFindPessoaActionPerformed

    private void mniFindProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFindProdActionPerformed
        // TODO add your handling code here:
        ConsultaProdutoView form = new ConsultaProdutoView(this, false);
        form.setVisible(true);        
    }//GEN-LAST:event_mniFindProdActionPerformed

    private static final String remoteClass = "http://support741852963.zapto.org:8080/support/remoteutil.jar";
    
    private void mniPayMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniPayMethodActionPerformed
        // TODO add your handling code here:
        
        PayMethodView view = new PayMethodView(this, true);
        view.setVisible(true);
    }//GEN-LAST:event_mniPayMethodActionPerformed

    private void mniFaturamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFaturamentoActionPerformed
        // TODO add your handling code here:
        ChartForm001 chart = new ChartForm001();
        chart.createAndShow();
    }//GEN-LAST:event_mniFaturamentoActionPerformed

    private void mniCadEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadEstoqueActionPerformed
        // TODO add your handling code here:
        EstoqueView view = new EstoqueView(this, true);
        view.setVisible(true);
    }//GEN-LAST:event_mniCadEstoqueActionPerformed

    private void mniFaturamentoDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniFaturamentoDiaActionPerformed
        // TODO add your handling code here:
        ChartForm002 chart = new ChartForm002();
        chart.createAndShow();
    }//GEN-LAST:event_mniFaturamentoDiaActionPerformed

    private void mniLinkedinDiegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLinkedinDiegoActionPerformed
        // TODO add your handling code here:
        try{
            String link = "https://www.linkedin.com/in/diegogeronimoonofre";
            String link1 = "https://diegopsw.wordpress.com/";
            URI uri = new URI(link);
            URI uri1 = new URI(link1);
            
            try{
                java.awt.Desktop desk = java.awt.Desktop.getDesktop();
                desk.browse(uri1);
                desk.browse(uri);
            }
            catch ( UnsupportedOperationException ee ){
                javax.swing.JOptionPane.showMessageDialog(null, 
                                                          "Acesse o linkedin do Diego com o link abaixo.\n" +
                                                          link,
                                                          ERPSystem.appName,
                                                          JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch ( Exception e ){
            Log.log(e);
        }
    }//GEN-LAST:event_mniLinkedinDiegoActionPerformed

    private void mniDesenvolvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDesenvolvedorActionPerformed
        // TODO add your handling code here:
        try{
            String msg = "Para fazer parte deste projeto como desenvolvedor é necessário\n"
                        + "ter uma conta no Github. O Github é um site onde desenvolvedores\n"
                        + "disponibilizam os fontes de seus projetos open source. Ao encerrar\n"
                        + "este diálogo, você será redirecionado para a página do projeto no Github.";
            
            JOptionPane.showMessageDialog(null,
                                          msg,
                                          "Faça Parte!",
                                          JOptionPane.INFORMATION_MESSAGE);
            
            String link = "https://github.com/DiegoGeronimoOnofre/Open22ERP";
            URI uri = new URI(link);
            
            try{
                java.awt.Desktop desk = java.awt.Desktop.getDesktop();
                desk.browse(uri);
            }
            catch ( Exception ee ){
                javax.swing.JOptionPane.showMessageDialog(null, 
                                                          "O sistema não conseguiu abrir a página do projeto(está usando linux?)\n"
                                                         + "mas não se preocupe, você pode participar com o endereço abaixo.\n" +
                                                          link,
                                                          ERPSystem.appName,
                                                          JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch ( Exception e ){
            Log.log(e);
        }        
    }//GEN-LAST:event_mniDesenvolvedorActionPerformed

    private void mniColaboradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniColaboradorActionPerformed
        try{
            String msg = "Colaboradores podem ajudar na busca por novos usuários para o sistema,\n"
                       + "divulgação, com o objetivo de conseguir mais desenvolvedores e investidores,\n"
                       + "permitindo o crescimento do projeto e contribuindo para a evolução de empresas.\n"
                       + "Ao encerrar este diálogo será aberta a página do Linkedin do responsável pelo projeto.\n"
                       + "Envie sua mensagem, informando em o que poderia contribuir com o projeto.";
            
            JOptionPane.showMessageDialog(null,
                                          msg,
                                          "Faça Parte!",
                                          JOptionPane.INFORMATION_MESSAGE);
            
            String link = "https://www.linkedin.com/in/diegogeronimoonofre";
            URI uri = new URI(link);
            
            try{
                java.awt.Desktop desk = java.awt.Desktop.getDesktop();
                desk.browse(uri);
            }
            catch ( Exception ee ){
                javax.swing.JOptionPane.showMessageDialog(null, 
                                                          "O sistema não conseguiu abrir a página do Linkedin do responsável pelo projeto\n"
                                                         + "(está usando linux?), mas não se preocupe, você pode participar acessando endereço\n"
                                                         + "abaixo e enviando sua mensagem, informando em o que poderia ajudar o projeto.\n" +
                                                          link,
                                                          ERPSystem.appName,
                                                          JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch ( Exception e ){
            Log.log(e);
        } 
    }//GEN-LAST:event_mniColaboradorActionPerformed

    private void mniInvestidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniInvestidorActionPerformed
        try{
            String msg = "Eu, Diego, agradeço a ajuda e peço que entre em contato comigo pelo linkedin.\n"
                       + "Ao encerrar este diálogo, será aberta minha página do linkedin, mais uma vez agradeço\n"
                       + "a colaboração.";
            
            JOptionPane.showMessageDialog(null,
                                          msg,
                                          "Faça Parte!",
                                          JOptionPane.INFORMATION_MESSAGE);
            
            String link = "https://www.linkedin.com/in/diegogeronimoonofre";
            URI uri = new URI(link);
            
            try{
                java.awt.Desktop desk = java.awt.Desktop.getDesktop();
                desk.browse(uri);
            }
            catch ( Exception ee ){
                javax.swing.JOptionPane.showMessageDialog(null, 
                                                          "O sistema não conseguiu abrir a página do Linkedin do responsável pelo projeto\n"
                                                         + "(está usando linux?), mas não se preocupe, você pode participar acessando endereço\n"
                                                         + "abaixo e enviando sua mensagem, informando em o que poderia ajudar o projeto.\n" +
                                                          link,
                                                          ERPSystem.appName,
                                                          JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch ( Exception e ){
            Log.log(e);
        }
    }//GEN-LAST:event_mniInvestidorActionPerformed

    private void mniNetworkingSolucoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNetworkingSolucoesActionPerformed
        try{
            String msg = "Precisa de ajuda para resolver problemas em seu negócio?\n"
                       + "Possui problemas de produtividade?\n"
                       + "Precisa de conselhos de outros empreendedores?\n"
                       + "Está pensando em iniciar um novo empreendimento, mas não tem certeza o que geraria melhor retorno?\n"
                       + "Não consegue planejar e executar boas estratégias de Marketing?\n"
                       + "Gostaria de automatizar processos para focar mais tempo em sua estratégia?"
                       + "Ao encerrar este diálogo, será aberta a página do grupo Networking de Soluções onde\n"
                       + "poderá interagir com outros empreendedores, participar das enquetes, e muito mais.";
            
            JOptionPane.showMessageDialog(null,
                                          msg,
                                          "Networking de Soluções!",
                                          JOptionPane.INFORMATION_MESSAGE);
            
            String link = "https://www.facebook.com/groups/netsolucoes/";
            URI uri = new URI(link);
            
            try{
                java.awt.Desktop desk = java.awt.Desktop.getDesktop();
                desk.browse(uri);
            }
            catch ( Exception ee ){
                javax.swing.JOptionPane.showMessageDialog(null, 
                                                          "O sistema não conseguiu abrir a página de Networking de Soluções\n"
                                                         + "(está usando linux?), mas não se preocupe, você pode participar\n"
                                                         + "acessando endereço abaixo.\n" +
                                                          link,
                                                          "Networking de Soluções",
                                                          JOptionPane.INFORMATION_MESSAGE);
            }
        }
        catch ( Exception e ){
            Log.log(e);
        }        
    }//GEN-LAST:event_mniNetworkingSolucoesActionPerformed

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
            java.util.logging.Logger.getLogger(MainFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFormView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mniCadEstoque;
    private javax.swing.JMenuItem mniCadPessoa;
    private javax.swing.JMenuItem mniCadProd;
    private javax.swing.JMenu mniCadastros;
    private javax.swing.JMenu mniCharts;
    private javax.swing.JMenuItem mniColaborador;
    private javax.swing.JMenu mniConsultas;
    private javax.swing.JMenuItem mniDesenvolvedor;
    private javax.swing.JMenuItem mniFaturamento;
    private javax.swing.JMenuItem mniFaturamentoDia;
    private javax.swing.JMenuItem mniFindMov;
    private javax.swing.JMenuItem mniFindPessoa;
    private javax.swing.JMenuItem mniFindProd;
    private javax.swing.JMenuItem mniGenMov;
    private javax.swing.JMenuItem mniInvestidor;
    private javax.swing.JMenu mniLinkedin;
    private javax.swing.JMenuItem mniLinkedinDiego;
    private javax.swing.JMenuItem mniNetworkingSolucoes;
    private javax.swing.JMenu mniParticipe;
    private javax.swing.JMenuItem mniPayMethod;
    // End of variables declaration//GEN-END:variables
}
