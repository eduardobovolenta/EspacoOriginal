/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.ItensPedido;
import model.bean.Produto;
import model.dao.ItensPedidoDAO;
import model.dao.MesaDAO;
import model.dao.PedidoDAO;
import model.dao.ProdutoDAO;


/**
 *
 * @author eduar
 */
public class Mesas extends javax.swing.JFrame {

    public String varNomeMesa;
    public int idPizzaMesa;
    public String nomeMeio;
    public String metodPag;
    
    public String procurarBanco, preco;
    static double valorTotal = 0;
    public int idmesa;


    public String nome1, nome2, tamanho;
    int quantidade, categoria;
    static int t;
    public ArrayList<Integer> arrayID = new ArrayList<>();
    public ArrayList<String> arrayPreço = new ArrayList<>();

    static void setT() {
        Menu.t += 1;
    }

    static int getT() {
        return t;
    }
     

    /**
     * Creates new form Mesas
     */
    public Mesas() {
        initComponents();
        setLocationRelativeTo(null);
        //Ordena os valores da tabela
        categoria = 4;
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 30, 1);
        jSQuantidadeBebidas.setModel(model);
        jSQuantidadePizzas.setModel(model);
        jSQuantidadePorcao.setModel(model);
        jSQuantidadeSobremesa.setModel(model);
        jTProdutos.setRowSorter(new TableRowSorter(modelo));

        setLocationRelativeTo(null);
        //seta valores no comboTamanho
        

        jComboBebidas.removeAllItems();
        jComboBebidas.addItem("Selecione");
        
        comboPizzas1.addItem("Pizzas");
        comboPizzas2.addItem("Pizzas");
        
        comboPizzas3.addItem("Pizzas");
        comboPizzas4.addItem("Pizzas");
        ProdutoDAO dao = new ProdutoDAO();
        categoria = 2;
        dao.readProduto(categoria).forEach((b) -> {
            jComboBebidas.addItem(b.getNome());
        });
        jComboPorcao.removeAllItems();
        jComboPorcao.addItem("Selecione");
        ProdutoDAO dao1 = new ProdutoDAO();
        categoria = 3;
        dao1.readProduto(categoria).forEach((b) -> {
            jComboPorcao.addItem(b.getNome());
        });
        
        
    }

    public ImageIcon icon = new ImageIcon("src/imagens/metadeGigante1.png");
    public ImageIcon icon1 = new ImageIcon("src/imagens/metadeGiganteFixa.png");
    public ImageIcon icon2 = new ImageIcon("src/imagens/metadeGigante2.png");
    public ImageIcon icon3 = new ImageIcon("src/imagens/metadeGiganteFixa2.png");

    public ImageIcon icon4 = new ImageIcon("src/imagens/pizzaMediaFixo.png");
    public ImageIcon icon5 = new ImageIcon("src/imagens/pizzaMediaM.png");
    public ImageIcon icon6 = new ImageIcon("src/imagens/pizzaMediaFixo2.png");
    public ImageIcon icon7 = new ImageIcon("src/imagens/pizzaMediaM2.png");

    public void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        ProdutoDAO produto = new ProdutoDAO();

        produto.readPizza(categoria, nome1, tamanho, quantidade).stream().map((p) -> {
            nomeMeio = p.getNome();
            return p;
        }).map((p) -> {
            idPizzaMesa = p.getId();
            return p;
        }).map((p) -> {
            arrayID.add(p.getId());
            return p;
        }).forEachOrdered((p) -> {
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getTamanho(),
                quantidade,
                p.getPreco(),
                p.getPreco() * quantidade

            });
        });
    }

    public void readJTable2() {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        ProdutoDAO produto = new ProdutoDAO();

        produto.readMeioaMeio(categoria, nome1, nome2, tamanho, quantidade).stream().map((p) -> {
            nomeMeio = p.getNome();
            return p;
        }).map((p) -> {
            idPizzaMesa = p.getId();
            return p;
        }).map((p) -> {
            arrayID.add(p.getId());
            return p;
        }).forEachOrdered((p) -> {
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getTamanho(),
                quantidade,
                p.getPreco(),
                p.getPreco() * quantidade

            });
        });
    }
    public void readJTable4() {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        ProdutoDAO produto = new ProdutoDAO();

        produto.readMeioaMeio(categoria, nome1, nome2, tamanho, quantidade).stream().map((p) -> {
            nomeMeio = p.getNome();
            return p;
        }).map((p) -> {
            idPizzaMesa = p.getId();
            return p;
        }).map((p) -> {
            arrayID.add(p.getId());
            return p;
        }).forEachOrdered((p) -> {
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getTamanho(),
                quantidade,
                p.getPreco(),
                p.getPreco() * quantidade

            });
        });
    }
    

    public void readJTable3() {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        ProdutoDAO produto = new ProdutoDAO();

        produto.read(categoria, nome1, quantidade).stream().map((p) -> {
            nomeMeio = p.getNome();
            return p;
        }).map((p) -> {
            idPizzaMesa = p.getId();
            return p;
        }).map((p) -> {
            arrayID.add(p.getId());
            return p;
        }).forEachOrdered((p) -> {
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getTamanho(),
                quantidade,
                p.getPreco(),
                p.getPreco() * quantidade

            });
        });
    }
    
    
    public void readJTableMesa() {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        MesaDAO daoMesa = new MesaDAO();

        daoMesa.readMesa(nomeMesa.getText()).stream().map((p) -> {
            quantidade = p.getQuantidade();
            return p;
        }).forEachOrdered((p) -> {
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getTamanho(),
                p.getQuantidade(),
                p.getPreco(),
                p.getPreco() * quantidade

            });
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioPizzaTamanho = new javax.swing.ButtonGroup();
        metodoPagamento = new javax.swing.ButtonGroup();
        tamanhoDoce = new javax.swing.ButtonGroup();
        jLMesa1 = new javax.swing.JLabel();
        jLMesa2 = new javax.swing.JLabel();
        jLMesa4 = new javax.swing.JLabel();
        jLMesa3 = new javax.swing.JLabel();
        jLMesa8 = new javax.swing.JLabel();
        jLMesa7 = new javax.swing.JLabel();
        jLMesa9 = new javax.swing.JLabel();
        jLMesa10 = new javax.swing.JLabel();
        jLMesa5 = new javax.swing.JLabel();
        jLMesa6 = new javax.swing.JLabel();
        jLMesa11 = new javax.swing.JLabel();
        mesa1 = new javax.swing.JButton();
        mesa5 = new javax.swing.JButton();
        mesa9 = new javax.swing.JButton();
        mesa2 = new javax.swing.JButton();
        mesa6 = new javax.swing.JButton();
        mesa10 = new javax.swing.JButton();
        mesa3 = new javax.swing.JButton();
        mesa7 = new javax.swing.JButton();
        mesa11 = new javax.swing.JButton();
        mesa4 = new javax.swing.JButton();
        mesa8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnSobremesas = new javax.swing.JButton();
        btnPorcoes = new javax.swing.JButton();
        btnBebidas = new javax.swing.JButton();
        btnPizzas = new javax.swing.JButton();
        panelProdutos = new javax.swing.JPanel();
        panelPizza = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        comboPizzas1 = new javax.swing.JComboBox<>();
        imgGigante = new javax.swing.JLabel();
        imgGigante1 = new javax.swing.JLabel();
        comboPizzas2 = new javax.swing.JComboBox<>();
        jSQuantidadePizzas = new javax.swing.JSpinner();
        btnRegistrar = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        medio = new javax.swing.JRadioButton();
        grande = new javax.swing.JRadioButton();
        jLabel52 = new javax.swing.JLabel();
        panelBebidas = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jComboBebidas = new javax.swing.JComboBox();
        jBRegistrarBebida = new javax.swing.JButton();
        jSQuantidadeBebidas = new javax.swing.JSpinner();
        panelPorcoes = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jComboPorcao = new javax.swing.JComboBox<>();
        jBRegistrarPorcao = new javax.swing.JButton();
        jSQuantidadePorcao = new javax.swing.JSpinner();
        panelSobremesas = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        comboPizzas3 = new javax.swing.JComboBox<>();
        medio1 = new javax.swing.JRadioButton();
        grande1 = new javax.swing.JRadioButton();
        comboPizzas4 = new javax.swing.JComboBox<>();
        imgGigante2 = new javax.swing.JLabel();
        imgGigante3 = new javax.swing.JLabel();
        jSQuantidadeSobremesa = new javax.swing.JSpinner();
        jLabel55 = new javax.swing.JLabel();
        jBRegistrarSobremesa = new javax.swing.JButton();
        jLTroco = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        nomeMesa = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jPanelPedidos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();
        btnRemoverPedido = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cartao = new javax.swing.JRadioButton();
        dinheiro = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLTroco1 = new javax.swing.JLabel();
        jTDinheiro = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jLPrecoTotal = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mesas");
        setMaximumSize(new java.awt.Dimension(1366, 900));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("Mesas"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1366, 800));
        setSize(new java.awt.Dimension(1366, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLMesa1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLMesa1.setText("<html><center>Mesa <br\\> 1 </center></html>");
        getContentPane().add(jLMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 113, -1, -1));

        jLMesa2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLMesa2.setText("<html><center>Mesa <br\\> 2 </center></html>");
        getContentPane().add(jLMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 113, -1, -1));

        jLMesa4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLMesa4.setText("<html><center>Mesa <br\\> 4 </center></html>");
        getContentPane().add(jLMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 113, -1, -1));

        jLMesa3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLMesa3.setText("<html><center>Mesa <br\\> 3 </center></html>");
        getContentPane().add(jLMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 113, -1, -1));

        jLMesa8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLMesa8.setText("<html><center>Mesa <br\\> 8 </center></html>");
        getContentPane().add(jLMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 220, -1, -1));

        jLMesa7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLMesa7.setText("<html><center>Mesa <br\\> 7 </center></html>");
        jLMesa7.setToolTipText("");
        getContentPane().add(jLMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(164, 220, -1, -1));

        jLMesa9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLMesa9.setText("<html><center>Mesa <br\\> 9</center></html>");
        getContentPane().add(jLMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(384, 220, -1, -1));

        jLMesa10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLMesa10.setText("<html><center>Mesa <br\\> 10 </center></html>");
        getContentPane().add(jLMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 220, -1, -1));

        jLMesa5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLMesa5.setText("<html><center>Mesa <br\\> 5 </center></html>");
        getContentPane().add(jLMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 113, -1, -1));

        jLMesa6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLMesa6.setText("<html><center>Mesa <br\\> 6 </center></html>");
        getContentPane().add(jLMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 113, -1, -1));

        jLMesa11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLMesa11.setText("<html><center>Mesa <br\\> 11 </center></html>");
        getContentPane().add(jLMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(604, 220, -1, -1));

        mesa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaimg100px.png"))); // NOI18N
        mesa1.setBorder(null);
        mesa1.setPreferredSize(new java.awt.Dimension(10, 10));
        mesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa1ActionPerformed(evt);
            }
        });
        getContentPane().add(mesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 100, 100));

        mesa5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaimg100px.png"))); // NOI18N
        mesa5.setPreferredSize(new java.awt.Dimension(10, 10));
        mesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa5ActionPerformed(evt);
            }
        });
        getContentPane().add(mesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 100, 100));

        mesa9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaimg100px.png"))); // NOI18N
        mesa9.setPreferredSize(new java.awt.Dimension(10, 10));
        mesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa9ActionPerformed(evt);
            }
        });
        getContentPane().add(mesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 100, 100));

        mesa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaimg100px.png"))); // NOI18N
        mesa2.setPreferredSize(new java.awt.Dimension(10, 10));
        mesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa2ActionPerformed(evt);
            }
        });
        getContentPane().add(mesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 100, 100));

        mesa6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaimg100px.png"))); // NOI18N
        mesa6.setPreferredSize(new java.awt.Dimension(10, 10));
        mesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa6ActionPerformed(evt);
            }
        });
        getContentPane().add(mesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 100, 100));

        mesa10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaimg100px.png"))); // NOI18N
        mesa10.setPreferredSize(new java.awt.Dimension(10, 10));
        mesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa10ActionPerformed(evt);
            }
        });
        getContentPane().add(mesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, 100, 100));

        mesa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaimg100px.png"))); // NOI18N
        mesa3.setPreferredSize(new java.awt.Dimension(10, 10));
        mesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa3ActionPerformed(evt);
            }
        });
        getContentPane().add(mesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 100, 100));

        mesa7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaimg100px.png"))); // NOI18N
        mesa7.setPreferredSize(new java.awt.Dimension(10, 10));
        mesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa7ActionPerformed(evt);
            }
        });
        getContentPane().add(mesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 100, 100));

        mesa11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaimg100px.png"))); // NOI18N
        mesa11.setPreferredSize(new java.awt.Dimension(10, 10));
        mesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa11ActionPerformed(evt);
            }
        });
        getContentPane().add(mesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, 100, 100));

        mesa4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaimg100px.png"))); // NOI18N
        mesa4.setPreferredSize(new java.awt.Dimension(10, 10));
        mesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa4ActionPerformed(evt);
            }
        });
        getContentPane().add(mesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 100, 100));

        mesa8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaimg100px.png"))); // NOI18N
        mesa8.setPreferredSize(new java.awt.Dimension(10, 10));
        mesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa8ActionPerformed(evt);
            }
        });
        getContentPane().add(mesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 100, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mesas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 730, 110, 30));

        btnSobremesas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSobremesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sobremesaIcon50px.png"))); // NOI18N
        btnSobremesas.setText("Sobremesas");
        btnSobremesas.setMargin(new java.awt.Insets(2, -10, 2, 10));
        btnSobremesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobremesasActionPerformed(evt);
            }
        });
        getContentPane().add(btnSobremesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 160, 80));

        btnPorcoes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPorcoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/porcaoIcon50px.png"))); // NOI18N
        btnPorcoes.setText("Porções");
        btnPorcoes.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnPorcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorcoesActionPerformed(evt);
            }
        });
        getContentPane().add(btnPorcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 150, 80));

        btnBebidas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bebidaIcon50px.png"))); // NOI18N
        btnBebidas.setText("Bebidas");
        btnBebidas.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebidasActionPerformed(evt);
            }
        });
        getContentPane().add(btnBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 150, 80));

        btnPizzas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPizzas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pizzaIcon50PX.png"))); // NOI18N
        btnPizzas.setText("Pizzas");
        btnPizzas.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnPizzas.setPreferredSize(new java.awt.Dimension(123, 60));
        btnPizzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPizzasActionPerformed(evt);
            }
        });
        getContentPane().add(btnPizzas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 150, 80));

        panelProdutos.setOpaque(false);
        panelProdutos.setLayout(new java.awt.CardLayout());

        panelPizza.setOpaque(false);
        panelPizza.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pizzas");
        jLabel13.setToolTipText("");
        panelPizza.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        comboPizzas1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboPizzas1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPizzas1ItemStateChanged(evt);
            }
        });
        comboPizzas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPizzas1ActionPerformed(evt);
            }
        });
        panelPizza.add(comboPizzas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 260, 35));

        imgGigante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        imgGigante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/metadeGiganteFixa.png"))); // NOI18N
        imgGigante.setToolTipText("Escolha o sabor dessa metade.");
        imgGigante.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        imgGigante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imgGiganteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imgGiganteMouseExited(evt);
            }
        });
        panelPizza.add(imgGigante, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 101, 188));

        imgGigante1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/metadeGiganteFIxa2.png"))); // NOI18N
        imgGigante1.setToolTipText("Escolha o sabor dessa metade.");
        imgGigante1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imgGigante1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imgGigante1MouseExited(evt);
            }
        });
        panelPizza.add(imgGigante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 101, 188));

        comboPizzas2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboPizzas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPizzas2ActionPerformed(evt);
            }
        });
        panelPizza.add(comboPizzas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 260, 35));

        jSQuantidadePizzas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelPizza.add(jSQuantidadePizzas, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 56, 38));

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopcarIcon35px.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        panelPizza.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, -1));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Quantidade:");
        panelPizza.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 90, -1));

        radioPizzaTamanho.add(medio);
        medio.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        medio.setForeground(new java.awt.Color(255, 255, 255));
        medio.setText("Médio");
        medio.setOpaque(false);
        medio.setPreferredSize(new java.awt.Dimension(85, 35));
        medio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medioActionPerformed(evt);
            }
        });
        panelPizza.add(medio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        radioPizzaTamanho.add(grande);
        grande.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        grande.setForeground(new java.awt.Color(255, 255, 255));
        grande.setText("Grande");
        grande.setOpaque(false);
        grande.setPreferredSize(new java.awt.Dimension(85, 35));
        grande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grandeActionPerformed(evt);
            }
        });
        panelPizza.add(grande, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 96, -1));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Escolha o tamanho desejado:");
        panelPizza.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, 22));

        panelProdutos.add(panelPizza, "pizza");

        panelBebidas.setOpaque(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Bebidas");

        jComboBebidas.setEditable(true);
        jComboBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBebidasActionPerformed(evt);
            }
        });

        jBRegistrarBebida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBRegistrarBebida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopcarIcon35px.png"))); // NOI18N
        jBRegistrarBebida.setText("Registrar");
        jBRegistrarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarBebidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBebidasLayout = new javax.swing.GroupLayout(panelBebidas);
        panelBebidas.setLayout(panelBebidasLayout);
        panelBebidasLayout.setHorizontalGroup(
            panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBebidasLayout.createSequentialGroup()
                .addGroup(panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBebidasLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel17))
                    .addGroup(panelBebidasLayout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addGroup(panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelBebidasLayout.createSequentialGroup()
                                .addComponent(jComboBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSQuantidadeBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBebidasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jBRegistrarBebida)))))
                .addGap(214, 214, 214))
        );
        panelBebidasLayout.setVerticalGroup(
            panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBebidasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel17)
                .addGap(11, 11, 11)
                .addGroup(panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSQuantidadeBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBRegistrarBebida)
                .addContainerGap())
        );

        panelProdutos.add(panelBebidas, "bebidas");

        panelPorcoes.setOpaque(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Porções");

        jBRegistrarPorcao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBRegistrarPorcao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopcarIcon35px.png"))); // NOI18N
        jBRegistrarPorcao.setText("Registrar");
        jBRegistrarPorcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarPorcaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPorcoesLayout = new javax.swing.GroupLayout(panelPorcoes);
        panelPorcoes.setLayout(panelPorcoesLayout);
        panelPorcoesLayout.setHorizontalGroup(
            panelPorcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPorcoesLayout.createSequentialGroup()
                .addGroup(panelPorcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPorcoesLayout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel18))
                    .addGroup(panelPorcoesLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addGroup(panelPorcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBRegistrarPorcao)
                            .addGroup(panelPorcoesLayout.createSequentialGroup()
                                .addComponent(jComboPorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSQuantidadePorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(215, 215, 215))
        );
        panelPorcoesLayout.setVerticalGroup(
            panelPorcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPorcoesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPorcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboPorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSQuantidadePorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBRegistrarPorcao)
                .addContainerGap())
        );

        panelProdutos.add(panelPorcoes, "porcoes");

        panelSobremesas.setForeground(new java.awt.Color(255, 255, 255));
        panelSobremesas.setOpaque(false);
        panelSobremesas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sobremesas");
        panelSobremesas.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 0, -1, -1));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Escolha o tamanho desejado:");
        panelSobremesas.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 36, -1, 22));

        comboPizzas3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboPizzas3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPizzas3ItemStateChanged(evt);
            }
        });
        comboPizzas3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPizzas3ActionPerformed(evt);
            }
        });
        panelSobremesas.add(comboPizzas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 102, 260, 35));

        tamanhoDoce.add(medio1);
        medio1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        medio1.setForeground(new java.awt.Color(255, 255, 255));
        medio1.setText("Médio");
        medio1.setOpaque(false);
        medio1.setPreferredSize(new java.awt.Dimension(85, 35));
        medio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                medio1ActionPerformed(evt);
            }
        });
        panelSobremesas.add(medio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 60, -1, -1));

        tamanhoDoce.add(grande1);
        grande1.setFont(new java.awt.Font("Tahoma", 0, 22)); // NOI18N
        grande1.setForeground(new java.awt.Color(255, 255, 255));
        grande1.setText("Grande");
        grande1.setOpaque(false);
        grande1.setPreferredSize(new java.awt.Dimension(85, 35));
        grande1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grande1ActionPerformed(evt);
            }
        });
        panelSobremesas.add(grande1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 96, -1));

        comboPizzas4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboPizzas4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPizzas4ActionPerformed(evt);
            }
        });
        panelSobremesas.add(comboPizzas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 102, 260, 35));

        imgGigante2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/metadeGiganteFIxa2.png"))); // NOI18N
        imgGigante2.setToolTipText("Escolha o sabor dessa metade.");
        imgGigante2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imgGigante2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imgGigante2MouseExited(evt);
            }
        });
        panelSobremesas.add(imgGigante2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 110, 197));

        imgGigante3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        imgGigante3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/metadeGiganteFIxa.png"))); // NOI18N
        imgGigante3.setToolTipText("Escolha o sabor dessa metade.");
        imgGigante3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        imgGigante3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imgGigante3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imgGigante3MouseExited(evt);
            }
        });
        panelSobremesas.add(imgGigante3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 110, 197));

        jSQuantidadeSobremesa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelSobremesas.add(jSQuantidadeSobremesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 56, 38));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Quantidade:");
        panelSobremesas.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 90, -1));

        jBRegistrarSobremesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBRegistrarSobremesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopcarIcon35px.png"))); // NOI18N
        jBRegistrarSobremesa.setText("Registrar");
        jBRegistrarSobremesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarSobremesaActionPerformed(evt);
            }
        });
        panelSobremesas.add(jBRegistrarSobremesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, -1, -1));

        panelProdutos.add(panelSobremesas, "sobremesas");

        getContentPane().add(panelProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 670, 330));

        jLTroco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jLTroco, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 880, 93, 28));

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 690, 430));

        nomeMesa.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        nomeMesa.setForeground(new java.awt.Color(255, 0, 51));
        nomeMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nomeMesa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                nomeMesaPropertyChange(evt);
            }
        });
        getContentPane().add(nomeMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 590, 45));

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 690, 230));

        jPanelPedidos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanelPedidos.setOpaque(false);

        jTProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produto", "Tamanho", "Qtd.", "Preço", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTProdutos);
        if (jTProdutos.getColumnModel().getColumnCount() > 0) {
            jTProdutos.getColumnModel().getColumn(0).setPreferredWidth(300);
        }

        btnRemoverPedido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido.setText("Remover Pedido");
        btnRemoverPedido.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedidoActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir.setText("Finalizar Comanda");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Método de pagamento:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total: R$");
        jLabel4.setPreferredSize(new java.awt.Dimension(80, 20));

        metodoPagamento.add(cartao);
        cartao.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cartao.setForeground(new java.awt.Color(51, 255, 51));
        cartao.setText("Cartão");
        cartao.setOpaque(false);

        metodoPagamento.add(dinheiro);
        dinheiro.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        dinheiro.setForeground(new java.awt.Color(51, 255, 51));
        dinheiro.setText("Dinheiro:");
        dinheiro.setOpaque(false);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Troco: R$");
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 20));

        jLTroco1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLTroco1.setForeground(new java.awt.Color(255, 0, 0));
        jLTroco1.setText("00,00");
        jLTroco1.setPreferredSize(new java.awt.Dimension(80, 20));

        jTDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDinheiroActionPerformed(evt);
            }
        });

        btnCalcular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLPrecoTotal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLPrecoTotal.setForeground(new java.awt.Color(0, 204, 51));
        jLPrecoTotal.setText("00,00");

        javax.swing.GroupLayout jPanelPedidosLayout = new javax.swing.GroupLayout(jPanelPedidos);
        jPanelPedidos.setLayout(jPanelPedidosLayout);
        jPanelPedidosLayout.setHorizontalGroup(
            jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidosLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPedidosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelPedidosLayout.createSequentialGroup()
                        .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnImprimir)
                            .addComponent(btnRemoverPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelPedidosLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jLPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cartao)
                            .addGroup(jPanelPedidosLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLTroco1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelPedidosLayout.createSequentialGroup()
                                .addComponent(dinheiro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCalcular))
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26))))
        );
        jPanelPedidosLayout.setVerticalGroup(
            jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelPedidosLayout.createSequentialGroup()
                        .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(3, 3, 3)
                        .addComponent(cartao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dinheiro))
                        .addGap(1, 1, 1)
                        .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLTroco1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelPedidosLayout.createSequentialGroup()
                        .addComponent(btnRemoverPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        getContentPane().add(jPanelPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 590, 550));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/testeBack.png"))); // NOI18N
        getContentPane().add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1410, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa1ActionPerformed

        nomeMesa.setText("Mesa 1");
        jSQuantidadePizzas.setValue(1);
        
        MesaDAO daoMesa = new MesaDAO();
        daoMesa.readMesa("Mesa 1");
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setRowCount(0);
        
        readJTableMesa();
        
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
        //CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        //cl.show(panelPrincipal, "mesa1");

        //INICIO CHAMADA AO BANCO MESA 1:

    }//GEN-LAST:event_mesa1ActionPerformed

    private void mesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa2ActionPerformed

        
        nomeMesa.setText("Mesa 2");
        jSQuantidadePizzas.setValue(1);
        
        MesaDAO daoMesa = new MesaDAO();
        daoMesa.readMesa("Mesa 2");
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setRowCount(0);
        
        readJTableMesa();
        
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
        //CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        //cl.show(panelPrincipal, "mesa2");
    }//GEN-LAST:event_mesa2ActionPerformed

    private void mesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa3ActionPerformed

        nomeMesa.setText("Mesa 3");
        jSQuantidadePizzas.setValue(1);
        
        MesaDAO daoMesa = new MesaDAO();
        daoMesa.readMesa("Mesa 3");
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setRowCount(0);
        
        readJTableMesa();
        
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
    }//GEN-LAST:event_mesa3ActionPerformed

    private void mesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa4ActionPerformed

        nomeMesa.setText("Mesa 4");
        jSQuantidadePizzas.setValue(1);
        
        MesaDAO daoMesa = new MesaDAO();
        daoMesa.readMesa("Mesa 4");
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setRowCount(0);
        
        readJTableMesa();
        
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
    }//GEN-LAST:event_mesa4ActionPerformed

    private void mesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa5ActionPerformed

        nomeMesa.setText("Mesa 5");
        jSQuantidadePizzas.setValue(1);
       
        MesaDAO daoMesa = new MesaDAO();
        daoMesa.readMesa("Mesa 5");
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setRowCount(0);
        
        readJTableMesa();
        
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
    }//GEN-LAST:event_mesa5ActionPerformed

    private void mesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa6ActionPerformed

        nomeMesa.setText("Mesa 6");
        jSQuantidadePizzas.setValue(1);
        
        MesaDAO daoMesa = new MesaDAO();
        daoMesa.readMesa("Mesa 6");
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setRowCount(0);
        
        readJTableMesa();
        
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
    }//GEN-LAST:event_mesa6ActionPerformed

    private void mesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa7ActionPerformed

        nomeMesa.setText("Mesa 7");
        jSQuantidadePizzas.setValue(1);
        
        MesaDAO daoMesa = new MesaDAO();
        daoMesa.readMesa("Mesa 7");
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setRowCount(0);
        
        readJTableMesa();
        
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
    }//GEN-LAST:event_mesa7ActionPerformed

    private void mesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa8ActionPerformed

        nomeMesa.setText("Mesa 8");
        jSQuantidadePizzas.setValue(1);
        
        MesaDAO daoMesa = new MesaDAO();
        daoMesa.readMesa("Mesa 8");
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setRowCount(0);
        
        readJTableMesa();
        
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
    }//GEN-LAST:event_mesa8ActionPerformed

    private void mesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa9ActionPerformed

        nomeMesa.setText("Mesa 9");
        jSQuantidadePizzas.setValue(1);
        
        MesaDAO daoMesa = new MesaDAO();
        daoMesa.readMesa("Mesa 9");
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setRowCount(0);
        
        readJTableMesa();
    }//GEN-LAST:event_mesa9ActionPerformed

    private void mesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa10ActionPerformed

        nomeMesa.setText("Mesa 10");
        jSQuantidadePizzas.setValue(1);
        
        MesaDAO daoMesa = new MesaDAO();
        daoMesa.readMesa("Mesa 10");
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setRowCount(0);
        
        readJTableMesa();
        
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
    }//GEN-LAST:event_mesa10ActionPerformed

    private void mesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa11ActionPerformed

        nomeMesa.setText("Mesa 11");
        jSQuantidadePizzas.setValue(1);
        
        MesaDAO daoMesa = new MesaDAO();
        daoMesa.readMesa("Mesa 11");
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        modelo.setRowCount(0);
        
        readJTableMesa();
        
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
    }//GEN-LAST:event_mesa11ActionPerformed

    private void nomeMesaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_nomeMesaPropertyChange
//        setMesa(nomeMesa.getText());
    }//GEN-LAST:event_nomeMesaPropertyChange

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSobremesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobremesasActionPerformed
        getRootPane().setDefaultButton(jBRegistrarSobremesa);   
        jSQuantidadeSobremesa.setValue(1);
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) panelProdutos.getLayout();
        cl.show(panelProdutos, "sobremesas");
        categoria = 4;
    }//GEN-LAST:event_btnSobremesasActionPerformed

    private void btnPorcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorcoesActionPerformed
        getRootPane().setDefaultButton(jBRegistrarPorcao);   
        jSQuantidadePorcao.setValue(1);
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) panelProdutos.getLayout();
        cl.show(panelProdutos, "porcoes");
        categoria = 3;
    }//GEN-LAST:event_btnPorcoesActionPerformed

    private void btnBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebidasActionPerformed
        getRootPane().setDefaultButton(jBRegistrarBebida);   
        jSQuantidadeBebidas.setValue(1);
        CardLayout cl = (CardLayout) panelProdutos.getLayout();
        cl.show(panelProdutos, "bebidas");
        categoria = 2;

    }//GEN-LAST:event_btnBebidasActionPerformed

    private void btnPizzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPizzasActionPerformed
        getRootPane().setDefaultButton(btnRegistrar);
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelProdutos.getLayout();
        cl.show(panelProdutos, "pizza");
        categoria = 1;
    }//GEN-LAST:event_btnPizzasActionPerformed

    private void comboPizzas1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPizzas1ItemStateChanged
        procurarBanco = (String) comboPizzas1.getSelectedItem();
        comboPizzas2.setSelectedItem(procurarBanco);
    }//GEN-LAST:event_comboPizzas1ItemStateChanged

    private void comboPizzas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPizzas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPizzas1ActionPerformed

    private void imgGiganteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgGiganteMouseEntered
        imgGigante.setIcon(icon);
    }//GEN-LAST:event_imgGiganteMouseEntered

    private void imgGiganteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgGiganteMouseExited
        imgGigante.setIcon(icon1);
    }//GEN-LAST:event_imgGiganteMouseExited

    private void imgGigante1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgGigante1MouseEntered
        imgGigante1.setIcon(icon2);
    }//GEN-LAST:event_imgGigante1MouseEntered

    private void imgGigante1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgGigante1MouseExited
        imgGigante1.setIcon(icon3);
    }//GEN-LAST:event_imgGigante1MouseExited

    private void comboPizzas2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPizzas2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPizzas2ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        varNomeMesa = nomeMesa.getText();
        if(varNomeMesa == ""){
            JOptionPane.showMessageDialog(null, "Selecione uma mesa!");
        }else{
            
        if(medio.isSelected()){
            tamanho = "Medio";
        }if(grande.isSelected()){
            tamanho = "Grande";
        }
        mudarCorMesa();
        
        categoria = 1;
        Menu.setT();
        quantidade = (int) jSQuantidadePizzas.getValue();

        if(comboPizzas1.getSelectedItem() != comboPizzas2.getSelectedItem()){
            nome1 = (String) comboPizzas1.getSelectedItem();
            nome2 = (String) comboPizzas2.getSelectedItem();
            
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.readMeioaMeio(categoria,nome1 , nome2,tamanho,quantidade);
            readJTable2();

            MesaDAO mesa = new MesaDAO();
            mesa.createPedidoMeioMeio(nomeMesa.getText(), idPizzaMesa, quantidade, nomeMeio);
            
        }else{
            nome1 = (String) comboPizzas1.getSelectedItem();
            
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.readPizza(categoria,nome1,tamanho,quantidade);
            readJTable();

            MesaDAO mesa = new MesaDAO();
            mesa.createPedidoMeioMeio(nomeMesa.getText(), idPizzaMesa, quantidade, nomeMeio);            
        }
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){

            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jComboBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBebidasActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBebidasActionPerformed

    private void jBRegistrarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarBebidaActionPerformed
        if(varNomeMesa == ""){
            JOptionPane.showMessageDialog(null, "Selecione uma mesa!");
        }else{
        mudarCorMesa();
        categoria = 2;
        Menu.setT();
        ProdutoDAO b = new ProdutoDAO();

        quantidade = (int) jSQuantidadeBebidas.getValue();
        nome1 = jComboBebidas.getSelectedItem().toString();
        b.read(categoria,nome1,quantidade);
        readJTable3();
        
        MesaDAO mesa = new MesaDAO();
        mesa.createPedidoMeioMeio(nomeMesa.getText(), idPizzaMesa, quantidade, nomeMeio);
        
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jBRegistrarBebidaActionPerformed

    private void jBRegistrarPorcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarPorcaoActionPerformed
        categoria = 3;
        Menu.setT();
        ProdutoDAO dao = new ProdutoDAO();
        quantidade = (int) jSQuantidadePorcao.getValue();
        nome1 = jComboPorcao.getSelectedItem().toString();
        dao.read(categoria, nome1, quantidade);
        readJTable3();
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);

        // TODO add your handling code here:
    }//GEN-LAST:event_jBRegistrarPorcaoActionPerformed

    private void medioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medioActionPerformed
        comboPizzas1.removeAllItems();
        comboPizzas2.removeAllItems();
        ProdutoDAO dao = new ProdutoDAO();

        dao.readTamanho("Medio").stream().map((p) -> {
            comboPizzas1.addItem(p.getNome());
            return p;
        }).forEachOrdered((p) -> {
            comboPizzas2.addItem(p.getNome());
        });
    }//GEN-LAST:event_medioActionPerformed

    private void grandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grandeActionPerformed
        comboPizzas1.removeAllItems();
        comboPizzas2.removeAllItems();
        ProdutoDAO dao = new ProdutoDAO();

        dao.readTamanho("Grande").stream().map((p) -> {
            comboPizzas1.addItem(p.getNome());
            return p;
        }).forEachOrdered((p) -> {
            comboPizzas2.addItem(p.getNome());
        });
    }//GEN-LAST:event_grandeActionPerformed

    private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutosMouseClicked

    }//GEN-LAST:event_jTProdutosMouseClicked

    private void btnRemoverPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedidoActionPerformed
int id = 0; 

        if(jTProdutos.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
  
            String nomeProduto = (String) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 0);
            int qnt = (int) jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 2);
            
            MesaDAO drop = new MesaDAO();
            
            for (Produto p : drop.readProdutoSelecionado(nomeMesa.getText(), qnt, nomeProduto)) {
            id = p.getId();
            }
            
            drop.droparProduto(id, nomeMesa.getText(), qnt, nomeProduto);        
            ((DefaultTableModel) jTProdutos.getModel()).removeRow(jTProdutos.getSelectedRow());          
            
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }
    }//GEN-LAST:event_btnRemoverPedidoActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(dataSistema);
        String data = formato.format(dataSistema);

        PedidoDAO pedido = new PedidoDAO();
       
        ItensPedidoDAO itens = new ItensPedidoDAO();

        if(cartao.isSelected()){
            metodPag = "Cartão";
        }if(dinheiro.isSelected()){
            metodPag = "Dinheiro";
        }
        
        String nomemesa = nomeMesa.getText();
        
        if(nomemesa == "Mesa 1"){
            idmesa = 1;
        }
        if(nomemesa == "Mesa 2"){
            idmesa = 2;
        }
        if(nomemesa == "Mesa 3"){
            idmesa = 3;
        }
        if(nomemesa == "Mesa 4"){
            idmesa = 4;
        }
        if(nomemesa == "Mesa 8"){
            idmesa = 5;
        }
        if(nomemesa == "Mesa 6"){
            idmesa = 6;
        }
        if(nomemesa == "Mesa 7"){
            idmesa = 7;
        }
        if(nomemesa == "Mesa 8"){
            idmesa = 8;
        }
        if(nomemesa == "Mesa 9"){
            idmesa = 9;
        }
        if(nomemesa == "Mesa 10"){
            idmesa = 10;
        }
        if(nomemesa == "Mesa 11"){
            idmesa = 11;
        }
        
        mudarCorFechar();
     
        
    
        int n = arrayID.size();
        pedido.createPedido(data, idmesa, metodPag);
        
        for(int i=0; i<n; i++){
                        
            String nome = (String) jTProdutos.getValueAt(i, 0);
            int qtd = (int) jTProdutos.getValueAt(i, 2);
            Double pc = (Double) jTProdutos.getValueAt(i, 3);
            String tamanho = (String) jTProdutos.getValueAt(i, 1);
            ArrayList<ItensPedido> lista = itens.read(nome, tamanho, pc, qtd);
            itens.create(lista);
        }
        MesaDAO drop = new MesaDAO();
        drop.droparMesa(nomeMesa.getText());
        
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        

        try{
            File arquivo = new File("C:/Users/eduar/Desktop/teste/test.txt");
            if(arquivo.exists()){
                
                arquivo.delete();
                arquivo = new File("C:/Users/eduar/Desktop/teste/test.txt");
                
                try ( //se existir
                        FileWriter arquivoTxt = new FileWriter(arquivo, true)) {
                    PrintWriter linhasTxt = new PrintWriter(arquivoTxt);
                    //ACREDITO QUE SO PODE TER 42 CARACTERES
                    linhasTxt.println("===========================================");
                    linhasTxt.println("      *ESPAÇO ORIGINAL BAR E PIZZARIA*     ");
                    linhasTxt.println("===========================================");
                    linhasTxt.println("********** NAO E DOCUMENTO FISCAL *********");
                    linhasTxt.println("===========================================");
                    linhasTxt.println("PRODUTO     TAMANHO      QNTD     VALOR TOT");
                    //dados da tabela
                    for(int x = 0; x < jTProdutos.getRowCount(); x++){
                        
                        linhasTxt.print((String) jTProdutos.getModel().getValueAt(x, 0));
                        linhasTxt.print("  ");
                        linhasTxt.print((String) jTProdutos.getModel().getValueAt(x, 1));
                        linhasTxt.print("  ");
                        linhasTxt.print(Integer.toString((int) jTProdutos.getModel().getValueAt(x, 2)));
                        linhasTxt.print("  ");
                        linhasTxt.print(String.valueOf((jTProdutos.getModel().getValueAt(x, 4))));
                        linhasTxt.println();
                    }   linhasTxt.println("===========================================");
                    linhasTxt.println();
                    linhasTxt.println("===========================================");
                    linhasTxt.println("SubTotal                            " + jLPrecoTotal.getText());
                    linhasTxt.println("-------------------------------------------");
                    linhasTxt.println("===========================================");
                    linhasTxt.println("                   ÉTOIS                   ");
                    //emiteComanda();
                }
            }else{
                //se nao existir
                arquivo.createNewFile();
                //criaTxt();
            }
      }catch(IOException error){
          System.out.println("nao encontrei arquivo");
      }
        PrintService printServico = PrintServiceLookup.lookupDefaultPrintService();
        
        modelo.setRowCount(0);
        //falta imprimir
        //JOptionPane.showMessageDialog(null, "Comanda finalizada!");
        
        //Metodo para Imprimir
         /*JOptionPane.showMessageDialog(null, "Enviado para impressora");
          try {
               preco = String.valueOf(valorTotal);
                jLPrecoTotal.setText(preco);
                JLabel troco = jLTroco;
             
            
               String nome, telefone, endereco;
               nome = BuscaCliente.getNome();
               endereco = BuscaCliente.getEndereco();
               telefone = BuscaCliente.getTelefone();
                MessageFormat headerFormat1 = new MessageFormat("Pedido "+" Cliente: "+nome+" Endereço: "+
                        endereco +" Telefone: "+ telefone + " Total R$: "+ preco + " Troco R$: " + troco);
                MessageFormat bodyFormat = new MessageFormat("Cliente" );
                MessageFormat footerFormat = new MessageFormat("Pizzaria Espaço Original");
                jTProdutos.print(JTable.PrintMode.NORMAL, headerFormat1, footerFormat);
                              
            } catch (PrinterException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }*/
       

        
        
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void jTDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDinheiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDinheiroActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        
        
        double dinheiro;
        if(jTDinheiro.getText() != null){
            try{
                dinheiro = Double.parseDouble(jTDinheiro.getText());
                double a = Double.parseDouble(jLPrecoTotal.getText());
                if(a <= dinheiro){
                    String troco = String.valueOf(dinheiro-=a);
                    jLTroco.setText(troco);
                }
                else
                jLTroco.setText("Valor inválido");

            }catch(NumberFormatException e){
                jTDinheiro.setText("Digite um valor");
            }
        }
        jTDinheiro.setText(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        medio.setSelected(true);
    }//GEN-LAST:event_formWindowOpened

    private void comboPizzas3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPizzas3ItemStateChanged
        procurarBanco = (String) comboPizzas3.getSelectedItem();
        comboPizzas4.setSelectedItem(procurarBanco);
    }//GEN-LAST:event_comboPizzas3ItemStateChanged

    private void comboPizzas3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPizzas3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPizzas3ActionPerformed

    private void medio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medio1ActionPerformed
        comboPizzas3.removeAllItems();
        comboPizzas4.removeAllItems();
        MesaDAO dao = new MesaDAO();

        dao.readTamanhoDoce("Medio").stream().map((p) -> {
            comboPizzas3.addItem(p.getNome());
            return p;
        }).forEachOrdered((p) -> {
            comboPizzas4.addItem(p.getNome());
        });
    }//GEN-LAST:event_medio1ActionPerformed

    private void grande1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grande1ActionPerformed
        comboPizzas3.removeAllItems();
        comboPizzas4.removeAllItems();
        MesaDAO dao = new MesaDAO();

        dao.readTamanhoDoce("Grande").stream().map((p) -> {
            comboPizzas3.addItem(p.getNome());
            return p;
        }).forEachOrdered((p) -> {
            comboPizzas4.addItem(p.getNome());
        });
    }//GEN-LAST:event_grande1ActionPerformed

    private void comboPizzas4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPizzas4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPizzas4ActionPerformed

    private void imgGigante2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgGigante2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_imgGigante2MouseEntered

    private void imgGigante2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgGigante2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_imgGigante2MouseExited

    private void imgGigante3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgGigante3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_imgGigante3MouseEntered

    private void imgGigante3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgGigante3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_imgGigante3MouseExited

    private void jBRegistrarSobremesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarSobremesaActionPerformed
        if(medio1.isSelected()){
            tamanho = "Medio";
        }if(grande1.isSelected()){
            tamanho = "Grande";
        }

        categoria = 4;
        Menu.setT();
        quantidade = (int) jSQuantidadeSobremesa.getValue();

        if(comboPizzas3.getSelectedItem() != comboPizzas4.getSelectedItem()){
            nome1 = (String) comboPizzas3.getSelectedItem();
            nome2 = (String) comboPizzas4.getSelectedItem();
            
            //ProdutoDAO pdao = new ProdutoDAO();
            //pdao.readMeioaMeio(categoria,nome1 , nome2,tamanho,quantidade);

            readJTable2();
            MesaDAO mesa = new MesaDAO();
            mesa.createPedidoMeioMeio(nomeMesa.getText(), idPizzaMesa, quantidade, nomeMeio);
            
        }else{
            nome1 = (String) comboPizzas3.getSelectedItem();
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.readPizza(categoria,nome1,tamanho,quantidade);
            readJTable();
            MesaDAO mesa = new MesaDAO();
            mesa.createPedidoMeioMeio(nomeMesa.getText(), idPizzaMesa, quantidade, nomeMeio);
        }
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){

            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);
    }//GEN-LAST:event_jBRegistrarSobremesaActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Mesas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBebidas;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnPizzas;
    private javax.swing.JButton btnPorcoes;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRemoverPedido;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSobremesas;
    private javax.swing.JRadioButton cartao;
    private javax.swing.JComboBox<Object> comboPizzas1;
    private javax.swing.JComboBox<Object> comboPizzas2;
    private javax.swing.JComboBox<Object> comboPizzas3;
    private javax.swing.JComboBox<Object> comboPizzas4;
    private javax.swing.JRadioButton dinheiro;
    private javax.swing.JRadioButton grande;
    private javax.swing.JRadioButton grande1;
    private javax.swing.JLabel imgGigante;
    private javax.swing.JLabel imgGigante1;
    private javax.swing.JLabel imgGigante2;
    private javax.swing.JLabel imgGigante3;
    private javax.swing.JButton jBRegistrarBebida;
    private javax.swing.JButton jBRegistrarPorcao;
    private javax.swing.JButton jBRegistrarSobremesa;
    private javax.swing.JComboBox jComboBebidas;
    private javax.swing.JComboBox<String> jComboPorcao;
    private javax.swing.JLabel jLMesa1;
    private javax.swing.JLabel jLMesa10;
    private javax.swing.JLabel jLMesa11;
    private javax.swing.JLabel jLMesa2;
    private javax.swing.JLabel jLMesa3;
    private javax.swing.JLabel jLMesa4;
    private javax.swing.JLabel jLMesa5;
    private javax.swing.JLabel jLMesa6;
    private javax.swing.JLabel jLMesa7;
    private javax.swing.JLabel jLMesa8;
    private javax.swing.JLabel jLMesa9;
    private javax.swing.JLabel jLPrecoTotal;
    private javax.swing.JLabel jLTroco;
    private javax.swing.JLabel jLTroco1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanelPedidos;
    private javax.swing.JSpinner jSQuantidadeBebidas;
    private javax.swing.JSpinner jSQuantidadePizzas;
    private javax.swing.JSpinner jSQuantidadePorcao;
    private javax.swing.JSpinner jSQuantidadeSobremesa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTDinheiro;
    private javax.swing.JTable jTProdutos;
    private javax.swing.JRadioButton medio;
    private javax.swing.JRadioButton medio1;
    private javax.swing.JButton mesa1;
    private javax.swing.JButton mesa10;
    private javax.swing.JButton mesa11;
    private javax.swing.JButton mesa2;
    private javax.swing.JButton mesa3;
    private javax.swing.JButton mesa4;
    private javax.swing.JButton mesa5;
    private javax.swing.JButton mesa6;
    private javax.swing.JButton mesa7;
    private javax.swing.JButton mesa8;
    private javax.swing.JButton mesa9;
    private javax.swing.ButtonGroup metodoPagamento;
    private javax.swing.JLabel nomeMesa;
    private javax.swing.JPanel panelBebidas;
    private javax.swing.JPanel panelPizza;
    private javax.swing.JPanel panelPorcoes;
    private javax.swing.JPanel panelProdutos;
    private javax.swing.JPanel panelSobremesas;
    private javax.swing.ButtonGroup radioPizzaTamanho;
    private javax.swing.ButtonGroup tamanhoDoce;
    // End of variables declaration//GEN-END:variables

    public void mudarCorMesa(){
        if(nomeMesa.getText() == "Mesa 1"){
            jLMesa1.setForeground(new Color(50,205,50));
        }
        if(nomeMesa.getText() == "Mesa 2"){
            jLMesa2.setForeground(new Color(50,205,50));
        }  
        if(nomeMesa.getText() == "Mesa 3"){
            jLMesa3.setForeground(new Color(50,205,50));
        }  
        if(nomeMesa.getText() == "Mesa 4"){
            jLMesa4.setForeground(new Color(50,205,50));
        }  
        if(nomeMesa.getText() == "Mesa 5"){
            jLMesa5.setForeground(new Color(50,205,50));
        }  
        if(nomeMesa.getText() == "Mesa 6"){
            jLMesa6.setForeground(new Color(50,205,50));
        }  
        if(nomeMesa.getText() == "Mesa 7"){
            jLMesa7.setForeground(new Color(50,205,50));
        }  
        if(nomeMesa.getText() == "Mesa 8"){
            jLMesa8.setForeground(new Color(50,205,50));
        }  
        if(nomeMesa.getText() == "Mesa 9"){
            jLMesa9.setForeground(new Color(50,205,50));
        }  
        if(nomeMesa.getText() == "Mesa 10"){
            jLMesa10.setForeground(new Color(50,205,50));
        }
        if(nomeMesa.getText() == "Mesa 11"){
            jLMesa11.setForeground(new Color(50,205,50));
        }
    }
    public void mudarCorFechar(){
        if(nomeMesa.getText() == "Mesa 1"){
            jLMesa1.setForeground(Color.BLACK);
        }
        if(nomeMesa.getText() == "Mesa 2"){
            jLMesa2.setForeground(Color.BLACK);
        }  
        if(nomeMesa.getText() == "Mesa 3"){
            jLMesa3.setForeground(Color.BLACK);
        }  
        if(nomeMesa.getText() == "Mesa 4"){
            jLMesa4.setForeground(Color.BLACK);
        }  
        if(nomeMesa.getText() == "Mesa 5"){
            jLMesa5.setForeground(Color.BLACK);
        }  
        if(nomeMesa.getText() == "Mesa 6"){
            jLMesa6.setForeground(Color.BLACK);
        }  
        if(nomeMesa.getText() == "Mesa 7"){
            jLMesa7.setForeground(Color.BLACK);
        }  
        if(nomeMesa.getText() == "Mesa 8"){
            jLMesa8.setForeground(Color.BLACK);
        }  
        if(nomeMesa.getText() == "Mesa 9"){
            jLMesa9.setForeground(Color.BLACK);
        }  
        if(nomeMesa.getText() == "Mesa 10"){
            jLMesa10.setForeground(Color.BLACK);
        }
        if(nomeMesa.getText() == "Mesa 11"){
            jLMesa11.setForeground(Color.BLACK);
        }
    }
    

}
