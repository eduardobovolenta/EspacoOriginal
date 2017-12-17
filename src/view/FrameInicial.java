//a fazer
//verificar se numero ja esta no banco
//Caso esteja ir direto pro menu, 
//Caso não fazer cadastro
package view;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author eduar
 */
public class FrameInicial extends javax.swing.JFrame {
    
    public FrameInicial() {     
        
        initComponents();
        setLocationRelativeTo(null);
        //ImageIcon icon = new ImageIcon("src/imagens/espacooriginal.png");
        //icon.setImage(icon.getImage().getScaledInstance(background.getWidth(), background.getHeight(), 1));
        //background.setIcon(icon);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        background = new javax.swing.JLabel();
        MenuTransparente = new javax.swing.JMenuBar();
        RealizaPedido = new javax.swing.JMenu();
        jMenuDelivery = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuPresencial = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuGerenciarProdutos = new javax.swing.JMenuItem();
        jMenuControleEstoque = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuRelatorios = new javax.swing.JMenu();
        jMenuSair = new javax.swing.JMenu();
        menuData = new javax.swing.JMenu();
        menuHora = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Espaço Original!");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("FrameInicial"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundoSistema.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1430, 770));

        MenuTransparente.setBackground(new java.awt.Color(0, 0, 0));
        MenuTransparente.setToolTipText("");
        MenuTransparente.setBorderPainted(false);
        MenuTransparente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        RealizaPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fornoIcon.png"))); // NOI18N
        RealizaPedido.setText("Pedidos");
        RealizaPedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuDelivery.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuDelivery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pizzaDrone35px.png"))); // NOI18N
        jMenuDelivery.setText("Realizar Pedido");
        jMenuDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDeliveryActionPerformed(evt);
            }
        });
        RealizaPedido.add(jMenuDelivery);

        jSeparator1.setPreferredSize(new java.awt.Dimension(15, 15));
        RealizaPedido.add(jSeparator1);

        jMenuPresencial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuPresencial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/restaurantIcon35px.png"))); // NOI18N
        jMenuPresencial.setText("Pedido Presencial");
        jMenuPresencial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPresencialActionPerformed(evt);
            }
        });
        RealizaPedido.add(jMenuPresencial);

        MenuTransparente.add(RealizaPedido);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconEstoque35pxB.png"))); // NOI18N
        jMenu4.setText("Produtos");
        jMenu4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuGerenciarProdutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuGerenciarProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/searchProdutos35px.png"))); // NOI18N
        jMenuGerenciarProdutos.setText("Gerenciar Produtos");
        jMenuGerenciarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuGerenciarProdutosActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuGerenciarProdutos);

        MenuTransparente.add(jMenu4);

        jMenuControleEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconEstoque35px.png"))); // NOI18N
        jMenuControleEstoque.setText("Estoque");
        jMenuControleEstoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopcarIcon35px.png"))); // NOI18N
        jMenuItem2.setText("Controle de Estoque");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuControleEstoque.add(jMenuItem2);

        MenuTransparente.add(jMenuControleEstoque);

        jMenuRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/GraficoIcon35px.png"))); // NOI18N
        jMenuRelatorios.setText("Relatórios");
        jMenuRelatorios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuRelatoriosMouseClicked(evt);
            }
        });
        jMenuRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRelatoriosActionPerformed(evt);
            }
        });
        MenuTransparente.add(jMenuRelatorios);

        jMenuSair.setForeground(new java.awt.Color(255, 0, 0));
        jMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/SairIcon35px.png"))); // NOI18N
        jMenuSair.setText("Sair");
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSairMouseClicked(evt);
            }
        });
        MenuTransparente.add(jMenuSair);

        menuData.setText(".");
        menuData.setActionCommand("");
        menuData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuData.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        menuData.setFocusPainted(true);
        menuData.setFocusable(false);
        menuData.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menuData.setHideActionText(true);
        menuData.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuData.setInheritsPopupMenu(true);
        menuData.setMargin(new java.awt.Insets(0, 300, 0, 0));
        menuData.setRolloverEnabled(false);
        menuData.setVerifyInputWhenFocusTarget(false);
        MenuTransparente.add(menuData);

        menuHora.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        menuHora.setMargin(new java.awt.Insets(0, 10, 0, 0));
        MenuTransparente.add(menuHora);

        setJMenuBar(MenuTransparente);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        menuData.setText(formato.format(dataSistema));
        
        Timer timer = new Timer(1000,new hora());
        timer.start();
    }//GEN-LAST:event_formWindowOpened

    private void jMenuDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDeliveryActionPerformed
        BuscaCliente newFrame = new BuscaCliente();
        newFrame.setVisible(true);
    }//GEN-LAST:event_jMenuDeliveryActionPerformed

    private void jMenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMouseClicked
        // TODO add your handling code here:
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?", "Sair do Sistema", JOptionPane.ERROR_MESSAGE);
            if (resposta == JOptionPane.YES_OPTION) {
            System.exit(0);
            }
    }//GEN-LAST:event_jMenuSairMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Estoques estoque = new Estoques();
        estoque.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRelatoriosActionPerformed
        Relatorios menu = new Relatorios();
        menu.setVisible(true);
    // TODO add your handling code here:
    }//GEN-LAST:event_jMenuRelatoriosActionPerformed

    private void jMenuRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuRelatoriosMouseClicked
         Relatorios menu = new Relatorios();
        menu.setVisible(true);


        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuRelatoriosMouseClicked

    private void jMenuPresencialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPresencialActionPerformed
        Mesas mesa =new Mesas();
        mesa.setVisible(true);
    }//GEN-LAST:event_jMenuPresencialActionPerformed

    private void jMenuGerenciarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuGerenciarProdutosActionPerformed
        //        TelaLogin telaLogin = new TelaLogin();
        //        telaLogin.setVisible(true);
        Produtos produtos = new Produtos();
        produtos.setVisible(true);
    }//GEN-LAST:event_jMenuGerenciarProdutosActionPerformed

    
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
            java.util.logging.Logger.getLogger(FrameInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameInicial().setVisible(true);
            }
        });
 
    
    
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuTransparente;
    private javax.swing.JMenu RealizaPedido;
    private javax.swing.JLabel background;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenuControleEstoque;
    private javax.swing.JMenuItem jMenuDelivery;
    private javax.swing.JMenuItem jMenuGerenciarProdutos;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuPresencial;
    private javax.swing.JMenu jMenuRelatorios;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu menuData;
    private javax.swing.JMenu menuHora;
    // End of variables declaration//GEN-END:variables

    class hora implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            menuHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }
    
}



