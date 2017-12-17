package view;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.dao.ClienteDAO;
import model.dao.ProdutoDAO;

public class BuscaCliente extends javax.swing.JFrame {

    static String nome, endereco, telefone;
    static int clienteID;

    static void setNome(String nome) {
        BuscaCliente.nome = nome;
    }

    static void setEndereco(String endereco) {
        BuscaCliente.endereco = endereco;
    }

    static void setCliendID(int id) {
        BuscaCliente.clienteID = id;
    }

    static int getClientID() {
        return clienteID;
    }

    static String getNome() {
        return nome;
    }

    static String getEndereco() {
        return endereco;
    }

    static void setTelefone(String telefone) {
        BuscaCliente.telefone = telefone;
    }

    static String getTelefone() {
        return telefone;
    }

    public BuscaCliente() {
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnVerificar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnVerificar = new javax.swing.JButton();
        txtTelefone = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(295, 270));
        setMinimumSize(new java.awt.Dimension(295, 270));
        setName("BuscaCliente"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(295, 270));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Telefone:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Endereço: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 137, -1, -1));

        btnSalvar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSalvar.setText("Salvar e ir para menu");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 210, 280, 40));

        btnVerificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/searchIcon15px.png"))); // NOI18N
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 37, -1, 30));

        txtTelefone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 37, 200, 30));

        txtNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 99, 200, 30));

        txtEndereco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 163, 200, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 10, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/testeBack.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 320, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        //TODO add your handling code here:
        
        
        Cliente c = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        
        if (dao.checkTelefone(txtTelefone.getText())) {
        Menu menu = new Menu();
        menu.setVisible(true);
        nome = txtNome.getText();
        endereco = txtEndereco.getText();
        telefone = txtTelefone.getText();
        }else{
        
        c.setTelefone(txtTelefone.getText());
        c.setNome(txtNome.getText());
        c.setEndereco(txtEndereco.getText());
        //Chama o Data Acess Object e coloca o obj criado

        dao.create(c);

        nome = txtNome.getText();
        endereco = txtEndereco.getText();
        telefone = txtTelefone.getText();

        txtTelefone.setText("");
        txtNome.setText("");
        txtEndereco.setText("");

        Menu menu = new Menu();
        menu.setVisible(true);

        dispose();
        }
//        setNome(txtNome.getText());
//        setEndereco(txtEndereco.getText()); 
//        setTelefone(txtTelefone.getText()); 
        this.dispose();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed

        ClienteDAO dao = new ClienteDAO();
        Cliente c = new Cliente();

        if (dao.checkTelefone(txtTelefone.getText())) {
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {

                stmt = con.prepareStatement("SELECT * FROM cliente WHERE telefone LIKE ?");
                stmt.setString(1, "%" + txtTelefone.getText());

                rs = stmt.executeQuery();

                if (rs.next()) {
                    BuscaCliente.setCliendID(rs.getInt("id"));
                    //cliente.setTelefone(rs.getString("telefone"));
                    txtNome.setText(rs.getString("nome"));
                    txtEndereco.setText(rs.getString("endereco"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt, rs);

            }

           
           
        } else {
            txtNome.setEnabled(true);
            txtEndereco.setEnabled(true);
            btnSalvar.setEnabled(true);
        }
        setNome(txtNome.getText());
        setEndereco(txtEndereco.getText());

    }//GEN-LAST:event_btnVerificarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        txtNome.setEnabled(false);
        txtEndereco.setEnabled(false);
    

    }//GEN-LAST:event_formWindowOpened

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

}
