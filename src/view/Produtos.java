/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Produto;
import model.dao.ProdutoDAO;

/**
 *
 * @author eduar
 */
public class Produtos extends javax.swing.JFrame {

    /**
     * Creates new form Produtos
     */
    public Produtos() {
        initComponents();
        setLocationRelativeTo(null);
        getRootPane().setDefaultButton(btnBuscarPizza);  
    }

    public void readJTablePizza(int idCategoria) {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setNumRows(0);
        ProdutoDAO produto = new ProdutoDAO();

        for (Produto p : produto.readProduto(idCategoria)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getIdCategoria(),
                p.getNome(),
                p.getTamanho(),
                p.getPreco()

            });
        }
    }

    public void readJTableBebida(int idCategoria) {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos1.getModel();
        modelo.setNumRows(0);
        ProdutoDAO produto = new ProdutoDAO();

        for (Produto p : produto.readProduto(idCategoria)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getIdCategoria(),
                p.getNome(),
                p.getTamanho(),
                p.getPreco()

            });
        }

    }

    public void readJTablePorcao(int idCategoria) {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos2.getModel();
        modelo.setNumRows(0);
        ProdutoDAO produto = new ProdutoDAO();

        for (Produto p : produto.readProduto(idCategoria)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getIdCategoria(),
                p.getNome(),
                p.getTamanho(),
                p.getPreco()

            });
        }

    }

    public void readJTableSobremesa(int idCategoria) {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos3.getModel();
        modelo.setNumRows(0);
        ProdutoDAO produto = new ProdutoDAO();

        for (Produto p : produto.readProduto(idCategoria)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getIdCategoria(),
                p.getNome(),
                p.getTamanho(),
                p.getPreco()

            });
        }

    }

    public void readForNome(String nome) {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setNumRows(0);
        ProdutoDAO produto = new ProdutoDAO();

        for (Produto p : produto.read()) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getIdCategoria(),
                p.getNome(),
                p.getTamanho(),
                p.getPreco()

            });
        }
    }
    
    
        public void readJTablePizzas(String nome, int categoria) {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setNumRows(0);
        ProdutoDAO pizza = new ProdutoDAO();

        for (Produto p : pizza.readForNome(nome, categoria)) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getIdCategoria(),
                p.getNome(),
                p.getTamanho(),
                p.getPreco()
            });

        }
    }

    public void readJTableBebidas(String nome, int categoria) {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos1.getModel();
        modelo.setNumRows(0);
        ProdutoDAO bebida = new ProdutoDAO();

        for (Produto b : bebida.readForNome(nome, categoria)) {
            modelo.addRow(new Object[]{
                b.getId(),
                b.getIdCategoria(),
                b.getNome(),
                b.getTamanho(),
                b.getPreco()
            });

        }
    }



    public void readJTablePorcao(String nome, int categoria) {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos2.getModel();
        modelo.setNumRows(0);

        ProdutoDAO porcao = new ProdutoDAO();

        for (Produto pr : porcao.readForNome(nome, categoria)) {
            modelo.addRow(new Object[]{
                 pr.getId(),
                pr.getIdCategoria(),
                pr.getNome(),
                pr.getTamanho(),
                pr.getPreco()

            });

        }
    }

   

    public void readJTableSobremesa(String nome, int categoria) {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos3.getModel();
        modelo.setNumRows(0);

        ProdutoDAO sobremesa = new ProdutoDAO();

        for (Produto s : sobremesa.readForNome(nome, categoria)) {
            modelo.addRow(new Object[]{
                 s.getId(),
                s.getIdCategoria(),
                s.getNome(),
                s.getTamanho(),
                s.getPreco()

            });

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

        jPanel1 = new javax.swing.JPanel();
        btnPizza = new javax.swing.JButton();
        btnPorcao = new javax.swing.JButton();
        btnSobremesa = new javax.swing.JButton();
        btnBebidas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtTamanho = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        panelPrincipal = new javax.swing.JPanel();
        panelPizza = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();
        txtBuscarPizza = new javax.swing.JTextField();
        btnCadastrarPizza = new javax.swing.JButton();
        btnBuscarPizza = new javax.swing.JButton();
        btnExcluirPizza = new javax.swing.JButton();
        btnAtualizarPizza = new javax.swing.JButton();
        panelBebidas = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTProdutos1 = new javax.swing.JTable();
        txtBuscarBebida = new javax.swing.JTextField();
        btnCadastrarBebida = new javax.swing.JButton();
        btnBuscarBebida = new javax.swing.JButton();
        btnExcluirBebida = new javax.swing.JButton();
        btnAtualizarBebida = new javax.swing.JButton();
        panelPorcao = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTProdutos2 = new javax.swing.JTable();
        txtBuscarPorcao = new javax.swing.JTextField();
        btnCadastrarPorcao = new javax.swing.JButton();
        btnBuscarPorcao = new javax.swing.JButton();
        btnExcluirPorcao = new javax.swing.JButton();
        btnAtualizarPorcao = new javax.swing.JButton();
        panelSobremesa = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTProdutos3 = new javax.swing.JTable();
        txtBuscarSobremesa = new javax.swing.JTextField();
        btnCadastrarSobremesa = new javax.swing.JButton();
        btnBuscarSobremesa = new javax.swing.JButton();
        btnExcluirSobremesa = new javax.swing.JButton();
        btnAtualizarSobremesa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(920, 735));
        setMinimumSize(new java.awt.Dimension(920, 735));
        setPreferredSize(new java.awt.Dimension(920, 735));
        setSize(new java.awt.Dimension(920, 735));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPizza.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnPizza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pizzaIcon50PX.png"))); // NOI18N
        btnPizza.setText("Pizza");
        btnPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPizzaActionPerformed(evt);
            }
        });
        getContentPane().add(btnPizza, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 156, 50));

        btnPorcao.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnPorcao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/porcaoIcon50px.png"))); // NOI18N
        btnPorcao.setText("Porção");
        btnPorcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorcaoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPorcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 156, 50));

        btnSobremesa.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnSobremesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sobremesaIcon50px.png"))); // NOI18N
        btnSobremesa.setText("Sobremesa");
        btnSobremesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobremesaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSobremesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 156, 50));

        btnBebidas.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bebidaIcon50px.png"))); // NOI18N
        btnBebidas.setText("Bebidas");
        btnBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebidasActionPerformed(evt);
            }
        });
        getContentPane().add(btnBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 156, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOME");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 38, 53, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TAMANHO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PREÇO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 93, -1));
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 58, 242, -1));

        txtTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTamanhoActionPerformed(evt);
            }
        });
        getContentPane().add(txtTamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 59, 142, -1));
        getContentPane().add(txtPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 155, -1));

        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        panelPrincipal.setOpaque(false);
        panelPrincipal.setLayout(new java.awt.CardLayout());

        panelPizza.setOpaque(false);

        jScrollPane3.setOpaque(false);

        jTProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "IDCATEGORIA", "NOME", "TAMANHO", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProdutos.setOpaque(false);
        jTProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTProdutos);
        if (jTProdutos.getColumnModel().getColumnCount() > 0) {
            jTProdutos.getColumnModel().getColumn(2).setPreferredWidth(270);
        }

        btnCadastrarPizza.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastrarPizza.setText("Cadastrar");
        btnCadastrarPizza.setPreferredSize(new java.awt.Dimension(100, 40));
        btnCadastrarPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPizzaActionPerformed(evt);
            }
        });

        btnBuscarPizza.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarPizza.setText("Buscar");
        btnBuscarPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPizzaActionPerformed(evt);
            }
        });

        btnExcluirPizza.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirPizza.setText("Excluir");
        btnExcluirPizza.setPreferredSize(new java.awt.Dimension(100, 40));
        btnExcluirPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPizzaActionPerformed(evt);
            }
        });

        btnAtualizarPizza.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtualizarPizza.setText("Atualizar");
        btnAtualizarPizza.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAtualizarPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarPizzaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPizzaLayout = new javax.swing.GroupLayout(panelPizza);
        panelPizza.setLayout(panelPizzaLayout);
        panelPizzaLayout.setHorizontalGroup(
            panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPizzaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPizzaLayout.createSequentialGroup()
                        .addComponent(btnCadastrarPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnAtualizarPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPizzaLayout.setVerticalGroup(
            panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPizzaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBuscarPizza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addGroup(panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCadastrarPizza, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(btnExcluirPizza, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(btnAtualizarPizza, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE))
                    .addComponent(txtBuscarPizza, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelPizza, "pizza");

        panelBebidas.setOpaque(false);

        jTProdutos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "IDCATEGORIA", "NOME", "TAMANHO", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProdutos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTProdutos1);

        btnCadastrarBebida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastrarBebida.setText("Cadastrar");
        btnCadastrarBebida.setPreferredSize(new java.awt.Dimension(100, 40));
        btnCadastrarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarBebidaActionPerformed(evt);
            }
        });

        btnBuscarBebida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarBebida.setText("Buscar");
        btnBuscarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarBebidaActionPerformed(evt);
            }
        });

        btnExcluirBebida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirBebida.setText("Excluir");
        btnExcluirBebida.setPreferredSize(new java.awt.Dimension(100, 40));
        btnExcluirBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirBebidaActionPerformed(evt);
            }
        });

        btnAtualizarBebida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtualizarBebida.setText("Atualizar");
        btnAtualizarBebida.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAtualizarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarBebidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBebidasLayout = new javax.swing.GroupLayout(panelBebidas);
        panelBebidas.setLayout(panelBebidasLayout);
        panelBebidasLayout.setHorizontalGroup(
            panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBebidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBebidasLayout.createSequentialGroup()
                        .addComponent(btnCadastrarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnAtualizarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBebidasLayout.setVerticalGroup(
            panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBebidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAtualizarBebida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluirBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarBebida, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btnCadastrarBebida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPrincipal.add(panelBebidas, "bebida");

        panelPorcao.setOpaque(false);

        jTProdutos2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "IDCATEGORIA", "NOME", "TAMANHO", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProdutos2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTProdutos2);

        btnCadastrarPorcao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastrarPorcao.setText("Cadastrar");
        btnCadastrarPorcao.setPreferredSize(new java.awt.Dimension(100, 40));
        btnCadastrarPorcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarPorcaoActionPerformed(evt);
            }
        });

        btnBuscarPorcao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarPorcao.setText("Buscar");
        btnBuscarPorcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPorcaoActionPerformed(evt);
            }
        });

        btnExcluirPorcao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirPorcao.setText("Excluir");
        btnExcluirPorcao.setPreferredSize(new java.awt.Dimension(100, 40));
        btnExcluirPorcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPorcaoActionPerformed(evt);
            }
        });

        btnAtualizarPorcao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtualizarPorcao.setText("Atualizar");
        btnAtualizarPorcao.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAtualizarPorcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarPorcaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPorcaoLayout = new javax.swing.GroupLayout(panelPorcao);
        panelPorcao.setLayout(panelPorcaoLayout);
        panelPorcaoLayout.setHorizontalGroup(
            panelPorcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPorcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPorcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPorcaoLayout.createSequentialGroup()
                        .addComponent(btnCadastrarPorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirPorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnAtualizarPorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBuscarPorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarPorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        panelPorcaoLayout.setVerticalGroup(
            panelPorcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPorcaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPorcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscarPorcao, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPorcaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAtualizarPorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluirPorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscarPorcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadastrarPorcao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPrincipal.add(panelPorcao, "porcao");

        panelSobremesa.setOpaque(false);

        jTProdutos3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "IDCATEGORIA", "NOME", "TAMANHO", "PREÇO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProdutos3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTProdutos3MouseEntered(evt);
            }
        });
        jScrollPane6.setViewportView(jTProdutos3);

        btnCadastrarSobremesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCadastrarSobremesa.setText("Cadastrar");
        btnCadastrarSobremesa.setPreferredSize(new java.awt.Dimension(100, 40));
        btnCadastrarSobremesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarSobremesaActionPerformed(evt);
            }
        });

        btnBuscarSobremesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarSobremesa.setText("Buscar");
        btnBuscarSobremesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSobremesaActionPerformed(evt);
            }
        });

        btnExcluirSobremesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirSobremesa.setText("Excluir");
        btnExcluirSobremesa.setPreferredSize(new java.awt.Dimension(100, 40));
        btnExcluirSobremesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirSobremesaActionPerformed(evt);
            }
        });

        btnAtualizarSobremesa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAtualizarSobremesa.setText("Atualizar");
        btnAtualizarSobremesa.setPreferredSize(new java.awt.Dimension(100, 40));
        btnAtualizarSobremesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarSobremesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSobremesaLayout = new javax.swing.GroupLayout(panelSobremesa);
        panelSobremesa.setLayout(panelSobremesaLayout);
        panelSobremesaLayout.setHorizontalGroup(
            panelSobremesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSobremesaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSobremesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSobremesaLayout.createSequentialGroup()
                        .addComponent(btnCadastrarSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAtualizarSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscarSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelSobremesaLayout.setVerticalGroup(
            panelSobremesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSobremesaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSobremesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSobremesaLayout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addGroup(panelSobremesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarSobremesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelSobremesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnExcluirSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAtualizarSobremesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCadastrarSobremesa, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))))
                    .addComponent(btnBuscarSobremesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelPrincipal.add(panelSobremesa, "sobremesa");

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/testeBack.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTamanhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTamanhoActionPerformed

    private void btnCadastrarPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPizzaActionPerformed
        // TODO add your handling code here:
        if(txtNome.getText().trim().equals("") || txtTamanho.getText().trim().equals("") || txtPreco.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Não deixe nada em branco...");
        }else{
        
        Produto p = new Produto();
        ProdutoDAO dao = new ProdutoDAO();

        p.setIdCategoria(1);
        p.setNome(txtNome.getText());
        p.setTamanho(txtTamanho.getText());
        p.setPreco(Double.parseDouble(txtPreco.getText()));
        dao.create(p);

        txtNome.setText("");
        txtTamanho.setText("");
        txtPreco.setText("");

        readJTablePizza(1);
        }

    }//GEN-LAST:event_btnCadastrarPizzaActionPerformed

    private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutosMouseClicked
        // TODO add your handling code here:
        if (jTProdutos.getSelectedRow() != -1) {

            txtNome.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 2).toString());
            txtTamanho.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 3).toString());
            txtPreco.setText(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 4).toString());

        }
    }//GEN-LAST:event_jTProdutosMouseClicked

    private void btnBuscarPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPizzaActionPerformed
        // TODO add your handling code here:
        
        readJTablePizzas(txtBuscarPizza.getText(), 1);
        
    }//GEN-LAST:event_btnBuscarPizzaActionPerformed

    private void btnExcluirPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPizzaActionPerformed
        // TODO add your handling code here:
        if (jTProdutos.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setId((int) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0));

            dao.delete(p);

            txtNome.setText("");
            txtTamanho.setText("");
            txtPreco.setText("");

            readJTablePizza(1);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
    }//GEN-LAST:event_btnExcluirPizzaActionPerformed

    private void btnAtualizarPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarPizzaActionPerformed
        if(txtNome.getText().trim().equals("") || txtTamanho.getText().trim().equals("") || txtPreco.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Não deixe nada em branco...");
        }else{
        if (jTProdutos.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setIdCategoria(1);
            p.setNome(txtNome.getText());
            p.setTamanho(txtTamanho.getText());
            p.setPreco(Double.parseDouble(txtPreco.getText()));
            p.setId((int) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0));
            dao.update(p);

            txtNome.setText("");
            txtTamanho.setText("");
            txtPreco.setText("");

            readJTablePizza(1);

        }
    }//GEN-LAST:event_btnAtualizarPizzaActionPerformed
    }
    private void jTProdutos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos1MouseClicked
        // TODO add your handling code here:
        if (jTProdutos1.getSelectedRow() != -1) {

            txtNome.setText(jTProdutos1.getValueAt(jTProdutos1.getSelectedRow(), 2).toString());
            txtTamanho.setText(jTProdutos1.getValueAt(jTProdutos1.getSelectedRow(), 3).toString());
            txtPreco.setText(jTProdutos1.getValueAt(jTProdutos1.getSelectedRow(), 4).toString());

        }
    }//GEN-LAST:event_jTProdutos1MouseClicked

    private void btnCadastrarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarBebidaActionPerformed
       if(txtNome.getText().trim().equals("") || txtTamanho.getText().trim().equals("") || txtPreco.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Não deixe nada em branco...");
        }else{
        Produto p = new Produto();
        ProdutoDAO dao = new ProdutoDAO();

        p.setIdCategoria(2);
        p.setNome(txtNome.getText());
        p.setTamanho(txtTamanho.getText());
        p.setPreco(Double.parseDouble(txtPreco.getText()));
        dao.create(p);

        txtNome.setText("");
        txtTamanho.setText("");
        txtPreco.setText("");

        readJTableBebida(2);
       }
    }//GEN-LAST:event_btnCadastrarBebidaActionPerformed

    private void btnBuscarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarBebidaActionPerformed
        // TODO add your handling code here:
        readJTableBebidas(txtBuscarBebida.getText(),2);
    }//GEN-LAST:event_btnBuscarBebidaActionPerformed

    private void btnExcluirBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirBebidaActionPerformed
        // TODO add your handling code here:
        if (jTProdutos1.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setId((int) jTProdutos1.getValueAt(jTProdutos1.getSelectedRow(), 0));

            dao.delete(p);

            txtNome.setText("");
            txtTamanho.setText("");
            txtPreco.setText("");

            readJTableBebida(2);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma bebida para excluir.");
        }
    }//GEN-LAST:event_btnExcluirBebidaActionPerformed

    private void btnAtualizarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarBebidaActionPerformed
        if(txtNome.getText().trim().equals("") || txtTamanho.getText().trim().equals("") || txtPreco.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Não deixe nada em branco...");
        }else{
        if (jTProdutos1.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setIdCategoria(2);
            p.setNome(txtNome.getText());
            p.setTamanho(txtTamanho.getText());
            p.setPreco(Double.parseDouble(txtPreco.getText()));
            p.setId((int) jTProdutos1.getValueAt(jTProdutos1.getSelectedRow(), 0));
            dao.update(p);

            txtNome.setText("");
            txtTamanho.setText("");
            txtPreco.setText("");

            readJTableBebida(2);

        }}
    }//GEN-LAST:event_btnAtualizarBebidaActionPerformed

    private void jTProdutos2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos2MouseClicked
        // TODO add your handling code here:
        if (jTProdutos2.getSelectedRow() != -1) {

            txtNome.setText(jTProdutos2.getValueAt(jTProdutos2.getSelectedRow(), 2).toString());
            txtTamanho.setText(jTProdutos2.getValueAt(jTProdutos2.getSelectedRow(), 3).toString());
            txtPreco.setText(jTProdutos2.getValueAt(jTProdutos2.getSelectedRow(), 4).toString());

        }
    }//GEN-LAST:event_jTProdutos2MouseClicked

    private void btnCadastrarPorcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarPorcaoActionPerformed
        if(txtNome.getText().trim().equals("") || txtTamanho.getText().trim().equals("") || txtPreco.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Não deixe nada em branco...");
        }else{
        Produto p = new Produto();
        ProdutoDAO dao = new ProdutoDAO();

        p.setIdCategoria(3);
        p.setNome(txtNome.getText());
        p.setTamanho(txtTamanho.getText());
        p.setPreco(Double.parseDouble(txtPreco.getText()));
        dao.create(p);

        txtNome.setText("");
        txtTamanho.setText("");
        txtPreco.setText("");

        readJTablePorcao(3);
        }
    }//GEN-LAST:event_btnCadastrarPorcaoActionPerformed

    private void btnBuscarPorcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPorcaoActionPerformed
        // TODO add your handling code here:
        readJTablePorcao(txtBuscarPorcao.getText(),3);
    }//GEN-LAST:event_btnBuscarPorcaoActionPerformed

    private void btnExcluirPorcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPorcaoActionPerformed
        // TODO add your handling code here:
        if (jTProdutos2.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setId((int) jTProdutos2.getValueAt(jTProdutos2.getSelectedRow(), 0));

            dao.delete(p);

            txtNome.setText("");
            txtTamanho.setText("");
            txtPreco.setText("");

            readJTablePorcao(3);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma porção para excluir.");
        }
    }//GEN-LAST:event_btnExcluirPorcaoActionPerformed

    private void btnAtualizarPorcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarPorcaoActionPerformed
        if(txtNome.getText().trim().equals("") || txtTamanho.getText().trim().equals("") || txtPreco.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Não deixe nada em branco...");
        }else{
        if (jTProdutos2.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setIdCategoria(3);
            p.setNome(txtNome.getText());
            p.setTamanho(txtTamanho.getText());
            p.setPreco(Double.parseDouble(txtPreco.getText()));
            p.setId((int) jTProdutos2.getValueAt(jTProdutos2.getSelectedRow(), 0));
            dao.update(p);

            txtNome.setText("");
            txtTamanho.setText("");
            txtPreco.setText("");

            readJTablePorcao(3);
        }}
    }//GEN-LAST:event_btnAtualizarPorcaoActionPerformed

    private void jTProdutos3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos3MouseClicked
        // TODO add your handling code here:
        if (jTProdutos3.getSelectedRow() != -1) {

            txtNome.setText(jTProdutos3.getValueAt(jTProdutos3.getSelectedRow(), 2).toString());
            txtTamanho.setText(jTProdutos3.getValueAt(jTProdutos3.getSelectedRow(), 3).toString());
            txtPreco.setText(jTProdutos3.getValueAt(jTProdutos3.getSelectedRow(), 4).toString());

        }
    }//GEN-LAST:event_jTProdutos3MouseClicked

    private void btnCadastrarSobremesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarSobremesaActionPerformed
       if(txtNome.getText().trim().equals("") || txtTamanho.getText().trim().equals("") || txtPreco.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Não deixe nada em branco...");
        }else{
        Produto p = new Produto();
        ProdutoDAO dao = new ProdutoDAO();

        p.setIdCategoria(4);
        p.setNome(txtNome.getText());
        p.setTamanho(txtTamanho.getText());
        p.setPreco(Double.parseDouble(txtPreco.getText()));
        dao.create(p);

        txtNome.setText("");
        txtTamanho.setText("");
        txtPreco.setText("");

        readJTableSobremesa(4);
       }
    }//GEN-LAST:event_btnCadastrarSobremesaActionPerformed

    private void btnBuscarSobremesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSobremesaActionPerformed
        // TODO add your handling code here:
        readJTableSobremesa(txtBuscarSobremesa.getText(),4);
    }//GEN-LAST:event_btnBuscarSobremesaActionPerformed

    private void btnExcluirSobremesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirSobremesaActionPerformed
        // TODO add your handling code here:
        if (jTProdutos3.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setId((int) jTProdutos3.getValueAt(jTProdutos3.getSelectedRow(), 0));

            dao.delete(p);

            txtNome.setText("");
            txtTamanho.setText("");
            txtPreco.setText("");

            readJTableSobremesa(4);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma sobremesa para excluir.");
        }
    }//GEN-LAST:event_btnExcluirSobremesaActionPerformed

    private void btnAtualizarSobremesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarSobremesaActionPerformed
       if(txtNome.getText().trim().equals("") || txtTamanho.getText().trim().equals("") || txtPreco.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Não deixe nada em branco...");
        }else{
        if (jTProdutos3.getSelectedRow() != -1) {

            Produto p = new Produto();
            ProdutoDAO dao = new ProdutoDAO();

            p.setIdCategoria(4);
            p.setNome(txtNome.getText());
            p.setTamanho(txtTamanho.getText());
            p.setPreco(Double.parseDouble(txtPreco.getText()));
            p.setId((int) jTProdutos3.getValueAt(jTProdutos3.getSelectedRow(), 0));
            dao.update(p);

            txtNome.setText("");
            txtTamanho.setText("");
            txtPreco.setText("");

            readJTableSobremesa(4);

        }}
    }//GEN-LAST:event_btnAtualizarSobremesaActionPerformed

    private void jTProdutos3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProdutos3MouseEntered

    private void btnSobremesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobremesaActionPerformed
        getRootPane().setDefaultButton(btnBuscarSobremesa);
        jTProdutos.removeAll();
        jTProdutos1.removeAll();
        jTProdutos2.removeAll();
        jTProdutos3.removeAll();
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "sobremesa");
        ProdutoDAO dao = new ProdutoDAO();
        readJTableSobremesa(4);
    }//GEN-LAST:event_btnSobremesaActionPerformed

    private void btnPorcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorcaoActionPerformed
        getRootPane().setDefaultButton(btnBuscarPorcao);
        jTProdutos.removeAll();
        jTProdutos1.removeAll();
        jTProdutos2.removeAll();
        jTProdutos3.removeAll();
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "porcao");
        ProdutoDAO dao = new ProdutoDAO();
        readJTablePorcao(3);
    }//GEN-LAST:event_btnPorcaoActionPerformed

    private void btnBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebidasActionPerformed
        getRootPane().setDefaultButton(btnBuscarBebida);
        jTProdutos.removeAll();
        jTProdutos1.removeAll();
        jTProdutos2.removeAll();
        jTProdutos3.removeAll();
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "bebida");
        ProdutoDAO dao = new ProdutoDAO();
        int idCat = 2;
        readJTableBebida(2);
    }//GEN-LAST:event_btnBebidasActionPerformed

    private void btnPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPizzaActionPerformed
        getRootPane().setDefaultButton(btnBuscarPizza);
        jTProdutos.removeAll();
        jTProdutos1.removeAll();
        jTProdutos2.removeAll();
        jTProdutos3.removeAll();
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "pizza");
        ProdutoDAO dao = new ProdutoDAO();
        readJTablePizza(1);
    }//GEN-LAST:event_btnPizzaActionPerformed

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
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produtos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Produtos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizarBebida;
    private javax.swing.JButton btnAtualizarPizza;
    private javax.swing.JButton btnAtualizarPorcao;
    private javax.swing.JButton btnAtualizarSobremesa;
    private javax.swing.JButton btnBebidas;
    private javax.swing.JButton btnBuscarBebida;
    private javax.swing.JButton btnBuscarPizza;
    private javax.swing.JButton btnBuscarPorcao;
    private javax.swing.JButton btnBuscarSobremesa;
    private javax.swing.JButton btnCadastrarBebida;
    private javax.swing.JButton btnCadastrarPizza;
    private javax.swing.JButton btnCadastrarPorcao;
    private javax.swing.JButton btnCadastrarSobremesa;
    private javax.swing.JButton btnExcluirBebida;
    private javax.swing.JButton btnExcluirPizza;
    private javax.swing.JButton btnExcluirPorcao;
    private javax.swing.JButton btnExcluirSobremesa;
    private javax.swing.JButton btnPizza;
    private javax.swing.JButton btnPorcao;
    private javax.swing.JButton btnSobremesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTProdutos;
    private javax.swing.JTable jTProdutos1;
    private javax.swing.JTable jTProdutos2;
    private javax.swing.JTable jTProdutos3;
    private javax.swing.JPanel panelBebidas;
    private javax.swing.JPanel panelPizza;
    private javax.swing.JPanel panelPorcao;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSobremesa;
    private javax.swing.JTextField txtBuscarBebida;
    private javax.swing.JTextField txtBuscarPizza;
    private javax.swing.JTextField txtBuscarPorcao;
    private javax.swing.JTextField txtBuscarSobremesa;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtTamanho;
    // End of variables declaration//GEN-END:variables
}
