/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.CardLayout;
import java.awt.print.PrinterException;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.ItensPedido;
import model.bean.Produto;
import model.dao.ItensPedidoDAO;
import model.dao.PedidoDAO;
import model.dao.ProdutoDAO;
import static view.Menu.valorTotal;

/**
 *
 * @author eduar
 */
public class Mesas extends javax.swing.JFrame {

    public String procurarBanco, preco;
    static double valorTotal = 0;

    Vector dados[] = new Vector[4];
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
        //Ordena os valores da tabela
        categoria = 1;
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 30, 1);
        jSQuantidadeBebidas.setModel(model);
        jSQuantidadePizzas.setModel(model);
        jSQuantidadePorcao.setModel(model);
        jSQuantidadeSobremesa.setModel(model);
        jTProdutos.setRowSorter(new TableRowSorter(modelo));

        setLocationRelativeTo(null);
        //seta valores no comboTamanho
        comboTamanho.addItem("Selecione");
        comboTamanho.addItem("Medio");
        comboTamanho.addItem("Grande");

        jComboBebidas.removeAllItems();
        jComboBebidas.addItem("Selecione");
        
        comboPizzas1.addItem("Pizzas");
        comboPizzas2.addItem("Pizzas");

        ProdutoDAO dao = new ProdutoDAO();
        categoria = 2;
        for (Produto b : dao.readProduto(categoria)) {

            jComboBebidas.addItem(b.getNome());
        }
        jComboPorcao.removeAllItems();
        jComboPorcao.addItem("Selecione");
        ProdutoDAO dao1 = new ProdutoDAO();
        categoria = 3;
        for (Produto b : dao1.readProduto(categoria)) {

            jComboPorcao.addItem(b.getNome());
        }
        jComboSobremesa.removeAllItems();
        jComboSobremesa.addItem("Selecione");
        ProdutoDAO dao2 = new ProdutoDAO();
        categoria = 4;
        for (Produto p : dao2.readProduto(categoria)) {

            jComboSobremesa.addItem(p.getNome());
        }
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

        for (Produto p : produto.readPizza(categoria, nome1, tamanho, quantidade)) {

            arrayID.add(p.getId());
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getTamanho(),
                quantidade,
                p.getPreco(),
                p.getPreco() * quantidade

            });

        }
    }

    public void readJTable2() {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        ProdutoDAO produto = new ProdutoDAO();

        for (Produto p : produto.readMeioaMeio(categoria, nome1, nome2, tamanho, quantidade)) {

            arrayID.add(p.getId());
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getTamanho(),
                quantidade,
                p.getPreco(),
                p.getPreco() * quantidade

            });

        }
    }

    public void readJTable3() {
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        ProdutoDAO produto = new ProdutoDAO();

        for (Produto p : produto.read(categoria, nome1, quantidade)) {

            arrayID.add(p.getId());
            modelo.addRow(new Object[]{
                p.getNome(),
                p.getTamanho(),
                quantidade,
                p.getPreco(),
                p.getPreco() * quantidade

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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
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
        comboTamanho = new javax.swing.JComboBox<>();
        comboPizzas1 = new javax.swing.JComboBox<>();
        imgGigante = new javax.swing.JLabel();
        imgGigante1 = new javax.swing.JLabel();
        comboPizzas2 = new javax.swing.JComboBox<>();
        jSQuantidadePizzas = new javax.swing.JSpinner();
        btnRegistrar = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
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
        jComboSobremesa = new javax.swing.JComboBox();
        jBRegistrarSobremesa = new javax.swing.JButton();
        jSQuantidadeSobremesa = new javax.swing.JSpinner();
        jLTroco = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        panelPrincipal = new javax.swing.JPanel();
        panelMesa2 = new javax.swing.JPanel();
        btnRemoverPedido1 = new javax.swing.JButton();
        btnImprimir1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTProdutos1 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTDinheiro1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLTroco2 = new javax.swing.JLabel();
        btnCalcular1 = new javax.swing.JButton();
        panelMesa3 = new javax.swing.JPanel();
        btnRemoverPedido2 = new javax.swing.JButton();
        btnImprimir2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTProdutos2 = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTDinheiro2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLTroco3 = new javax.swing.JLabel();
        btnCalcular2 = new javax.swing.JButton();
        panelMesa4 = new javax.swing.JPanel();
        btnRemoverPedido3 = new javax.swing.JButton();
        btnImprimir3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTProdutos3 = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTDinheiro3 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLTroco4 = new javax.swing.JLabel();
        btnCalcular3 = new javax.swing.JButton();
        panelMesa5 = new javax.swing.JPanel();
        btnRemoverPedido4 = new javax.swing.JButton();
        btnImprimir4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTProdutos4 = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTDinheiro4 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLTroco5 = new javax.swing.JLabel();
        btnCalcular4 = new javax.swing.JButton();
        panelMesa6 = new javax.swing.JPanel();
        btnRemoverPedido5 = new javax.swing.JButton();
        btnImprimir5 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTProdutos5 = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTDinheiro5 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLTroco6 = new javax.swing.JLabel();
        btnCalcular5 = new javax.swing.JButton();
        panelMesa7 = new javax.swing.JPanel();
        btnRemoverPedido6 = new javax.swing.JButton();
        btnImprimir6 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTProdutos6 = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTDinheiro6 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLTroco7 = new javax.swing.JLabel();
        btnCalcular6 = new javax.swing.JButton();
        panelMesa8 = new javax.swing.JPanel();
        btnRemoverPedido7 = new javax.swing.JButton();
        btnImprimir7 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTProdutos7 = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTDinheiro7 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLTroco8 = new javax.swing.JLabel();
        btnCalcular7 = new javax.swing.JButton();
        panelMesa9 = new javax.swing.JPanel();
        btnRemoverPedido8 = new javax.swing.JButton();
        btnImprimir8 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTProdutos8 = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jTDinheiro8 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLTroco9 = new javax.swing.JLabel();
        btnCalcular8 = new javax.swing.JButton();
        panelMesa10 = new javax.swing.JPanel();
        btnRemoverPedido9 = new javax.swing.JButton();
        btnImprimir9 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTProdutos9 = new javax.swing.JTable();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jTDinheiro9 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLTroco10 = new javax.swing.JLabel();
        btnCalcular9 = new javax.swing.JButton();
        panelMesa11 = new javax.swing.JPanel();
        btnRemoverPedido10 = new javax.swing.JButton();
        btnImprimir10 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTProdutos10 = new javax.swing.JTable();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jTDinheiro10 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLTroco11 = new javax.swing.JLabel();
        btnCalcular10 = new javax.swing.JButton();
        panelMesa1 = new javax.swing.JPanel();
        btnRemoverPedido = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();
        jLTroco1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTDinheiro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        jLPrecoTotal = new javax.swing.JLabel();
        nomeMesa = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel51 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mesas");
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("Mesas"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1366, 768));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("<html><center>Mesa <br\\> 1 </center></html>");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 113, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("<html><center>Mesa <br\\> 2 </center></html>");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 113, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("<html><center>Mesa <br\\> 4 </center></html>");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 113, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("<html><center>Mesa <br\\> 3 </center></html>");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 113, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("<html><center>Mesa <br\\> 8 </center></html>");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("<html><center>Mesa <br\\> 7 </center></html>");
        jLabel7.setToolTipText("");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 222, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("<html><center>Mesa <br\\> 9</center></html>");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 222, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("<html><center>Mesa <br\\> 10 </center></html>");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 222, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("<html><center>Mesa <br\\> 5 </center></html>");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 113, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("<html><center>Mesa <br\\> 6 </center></html>");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(654, 113, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("<html><center>Mesa <br\\> 11 </center></html>");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 222, -1, -1));

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
        getContentPane().add(mesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 100, 100));

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
        getContentPane().add(mesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 100, 100));

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
        getContentPane().add(mesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 100, 100));

        mesa11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mesaimg100px.png"))); // NOI18N
        mesa11.setPreferredSize(new java.awt.Dimension(10, 10));
        mesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa11ActionPerformed(evt);
            }
        });
        getContentPane().add(mesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 100, 100));

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
        getContentPane().add(mesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 100, 100));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mesas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 160, -1));

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
        btnSobremesas.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnSobremesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobremesasActionPerformed(evt);
            }
        });
        getContentPane().add(btnSobremesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 160, 80));

        btnPorcoes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPorcoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/porcaoIcon50px.png"))); // NOI18N
        btnPorcoes.setText("Porções");
        btnPorcoes.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnPorcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorcoesActionPerformed(evt);
            }
        });
        getContentPane().add(btnPorcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 150, 80));

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
        panelPizza.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        comboTamanho.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboTamanho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboTamanhoMouseClicked(evt);
            }
        });
        comboTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTamanhoActionPerformed(evt);
            }
        });
        panelPizza.add(comboTamanho, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 139, 30));

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
        panelPizza.add(comboPizzas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 220, 35));

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
        panelPizza.add(imgGigante, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 101, 188));

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
        panelPizza.add(imgGigante1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 101, 188));

        comboPizzas2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboPizzas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPizzas2ActionPerformed(evt);
            }
        });
        panelPizza.add(comboPizzas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 220, 35));

        jSQuantidadePizzas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        panelPizza.add(jSQuantidadePizzas, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, 56, 38));

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopcarIcon35px.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        panelPizza.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, -1));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Quantidade:");
        panelPizza.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 90, -1));

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

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Sobremesas");

        jBRegistrarSobremesa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBRegistrarSobremesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopcarIcon35px.png"))); // NOI18N
        jBRegistrarSobremesa.setText("Registrar");
        jBRegistrarSobremesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarSobremesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSobremesasLayout = new javax.swing.GroupLayout(panelSobremesas);
        panelSobremesas.setLayout(panelSobremesasLayout);
        panelSobremesasLayout.setHorizontalGroup(
            panelSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSobremesasLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel19)
                .addGap(231, 231, 231))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSobremesasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBRegistrarSobremesa)
                    .addGroup(panelSobremesasLayout.createSequentialGroup()
                        .addComponent(jComboSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSQuantidadeSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(171, 171, 171))
        );
        panelSobremesasLayout.setVerticalGroup(
            panelSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSobremesasLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addGroup(panelSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSQuantidadeSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBRegistrarSobremesa)
                .addContainerGap())
        );

        panelProdutos.add(panelSobremesas, "sobremesas");

        getContentPane().add(panelProdutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, 330));

        jLTroco.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jLTroco, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 880, 93, 28));

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 690, 430));

        panelPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        panelPrincipal.setOpaque(false);
        panelPrincipal.setLayout(new java.awt.CardLayout());

        panelMesa2.setOpaque(false);

        btnRemoverPedido1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido1.setText("Remover Pedido");
        btnRemoverPedido1.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedido1ActionPerformed(evt);
            }
        });

        btnImprimir1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir1.setText("Imprimir");
        btnImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir1ActionPerformed(evt);
            }
        });

        jTProdutos1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTProdutos1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTProdutos1);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Total: R$");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Dinheiro:");

        jTDinheiro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDinheiro1ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Troco: R$");

        jLTroco2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTroco2.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcular1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular1.setText("Calcular");
        btnCalcular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMesa2Layout = new javax.swing.GroupLayout(panelMesa2);
        panelMesa2.setLayout(panelMesa2Layout);
        panelMesa2Layout.setHorizontalGroup(
            panelMesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesa2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane2))
            .addGroup(panelMesa2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelMesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverPedido1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(panelMesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addGroup(panelMesa2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(11, 11, 11)
                        .addComponent(jLTroco2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa2Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(15, 15, 15)
                        .addComponent(jTDinheiro1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(btnCalcular1)))
                .addGap(30, 30, 30))
        );
        panelMesa2Layout.setVerticalGroup(
            panelMesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesa2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesa2Layout.createSequentialGroup()
                        .addComponent(btnRemoverPedido1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnImprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jTDinheiro1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular1))
                        .addGap(11, 11, 11)
                        .addGroup(panelMesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel22))
                            .addComponent(jLTroco2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelMesa2, "mesa2");

        panelMesa3.setOpaque(false);

        btnRemoverPedido2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido2.setText("Remover Pedido");
        btnRemoverPedido2.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedido2ActionPerformed(evt);
            }
        });

        btnImprimir2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir2.setText("Imprimir");
        btnImprimir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir2ActionPerformed(evt);
            }
        });

        jTProdutos2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTProdutos2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTProdutos2);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Total: R$");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Dinheiro:");

        jTDinheiro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDinheiro2ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Troco: R$");

        jLTroco3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTroco3.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcular2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular2.setText("Calcular");
        btnCalcular2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMesa3Layout = new javax.swing.GroupLayout(panelMesa3);
        panelMesa3.setLayout(panelMesa3Layout);
        panelMesa3Layout.setHorizontalGroup(
            panelMesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesa3Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
            .addGroup(panelMesa3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelMesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverPedido2))
                .addGap(32, 32, 32)
                .addGroup(panelMesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addGroup(panelMesa3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelMesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa3Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(11, 11, 11)
                                .addComponent(jLTroco3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMesa3Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(15, 15, 15)
                                .addComponent(jTDinheiro2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnCalcular2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMesa3Layout.setVerticalGroup(
            panelMesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesa3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesa3Layout.createSequentialGroup()
                        .addComponent(btnRemoverPedido2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa3Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jTDinheiro2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular2))
                        .addGap(11, 11, 11)
                        .addGroup(panelMesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel25))
                            .addComponent(jLTroco3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        panelPrincipal.add(panelMesa3, "mesa3");

        panelMesa4.setOpaque(false);

        btnRemoverPedido3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido3.setText("Remover Pedido");
        btnRemoverPedido3.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedido3ActionPerformed(evt);
            }
        });

        btnImprimir3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir3.setText("Imprimir");
        btnImprimir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir3ActionPerformed(evt);
            }
        });

        jTProdutos3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTProdutos3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTProdutos3);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Total: R$");

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Dinheiro:");

        jTDinheiro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDinheiro3ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Troco: R$");

        jLTroco4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTroco4.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcular3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular3.setText("Calcular");
        btnCalcular3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMesa4Layout = new javax.swing.GroupLayout(panelMesa4);
        panelMesa4.setLayout(panelMesa4Layout);
        panelMesa4Layout.setHorizontalGroup(
            panelMesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesa4Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
            .addGroup(panelMesa4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelMesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverPedido3))
                .addGap(47, 47, 47)
                .addGroup(panelMesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addGroup(panelMesa4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelMesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa4Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(11, 11, 11)
                                .addComponent(jLTroco4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMesa4Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(15, 15, 15)
                                .addComponent(jTDinheiro3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnCalcular3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMesa4Layout.setVerticalGroup(
            panelMesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesa4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesa4Layout.createSequentialGroup()
                        .addComponent(btnRemoverPedido3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa4Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jTDinheiro3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular3))
                        .addGap(11, 11, 11)
                        .addGroup(panelMesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel28))
                            .addComponent(jLTroco4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        panelPrincipal.add(panelMesa4, "mesa4");

        panelMesa5.setOpaque(false);

        btnRemoverPedido4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido4.setText("Remover Pedido");
        btnRemoverPedido4.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedido4ActionPerformed(evt);
            }
        });

        btnImprimir4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir4.setText("Imprimir");
        btnImprimir4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir4ActionPerformed(evt);
            }
        });

        jTProdutos4.setModel(new javax.swing.table.DefaultTableModel(
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
        jTProdutos4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTProdutos4);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Total: R$");

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Dinheiro:");

        jTDinheiro4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDinheiro4ActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Troco: R$");

        jLTroco5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTroco5.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcular4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular4.setText("Calcular");
        btnCalcular4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMesa5Layout = new javax.swing.GroupLayout(panelMesa5);
        panelMesa5.setLayout(panelMesa5Layout);
        panelMesa5Layout.setHorizontalGroup(
            panelMesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesa5Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
            .addGroup(panelMesa5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelMesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverPedido4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(panelMesa5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelMesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa5Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(11, 11, 11)
                                .addComponent(jLTroco5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMesa5Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(15, 15, 15)
                                .addComponent(jTDinheiro4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnCalcular4)))))
                .addGap(41, 41, 41))
        );
        panelMesa5Layout.setVerticalGroup(
            panelMesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesa5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesa5Layout.createSequentialGroup()
                        .addComponent(btnRemoverPedido4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa5Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jTDinheiro4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular4))
                        .addGap(11, 11, 11)
                        .addGroup(panelMesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa5Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel31))
                            .addComponent(jLTroco5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        panelPrincipal.add(panelMesa5, "mesa5");

        panelMesa6.setOpaque(false);

        btnRemoverPedido5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido5.setText("Remover Pedido");
        btnRemoverPedido5.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedido5ActionPerformed(evt);
            }
        });

        btnImprimir5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir5.setText("Imprimir");
        btnImprimir5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir5ActionPerformed(evt);
            }
        });

        jTProdutos5.setModel(new javax.swing.table.DefaultTableModel(
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
        jTProdutos5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTProdutos5);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Total: R$");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Dinheiro:");

        jTDinheiro5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDinheiro5ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Troco: R$");

        jLTroco6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTroco6.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcular5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular5.setText("Calcular");
        btnCalcular5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMesa6Layout = new javax.swing.GroupLayout(panelMesa6);
        panelMesa6.setLayout(panelMesa6Layout);
        panelMesa6Layout.setHorizontalGroup(
            panelMesa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesa6Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
            .addGroup(panelMesa6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelMesa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverPedido5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMesa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addGroup(panelMesa6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelMesa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa6Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(11, 11, 11)
                                .addComponent(jLTroco6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMesa6Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addGap(15, 15, 15)
                                .addComponent(jTDinheiro5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnCalcular5)))))
                .addGap(42, 42, 42))
        );
        panelMesa6Layout.setVerticalGroup(
            panelMesa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesa6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesa6Layout.createSequentialGroup()
                        .addComponent(btnRemoverPedido5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa6Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMesa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jTDinheiro5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular5))
                        .addGap(11, 11, 11)
                        .addGroup(panelMesa6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel34))
                            .addComponent(jLTroco6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        panelPrincipal.add(panelMesa6, "mesa6");

        panelMesa7.setOpaque(false);

        btnRemoverPedido6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido6.setText("Remover Pedido");
        btnRemoverPedido6.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedido6ActionPerformed(evt);
            }
        });

        btnImprimir6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir6.setText("Imprimir");
        btnImprimir6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir6ActionPerformed(evt);
            }
        });

        jTProdutos6.setModel(new javax.swing.table.DefaultTableModel(
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
        jTProdutos6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos6MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTProdutos6);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Total: R$");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Dinheiro:");

        jTDinheiro6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDinheiro6ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Troco: R$");

        jLTroco7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTroco7.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcular6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular6.setText("Calcular");
        btnCalcular6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMesa7Layout = new javax.swing.GroupLayout(panelMesa7);
        panelMesa7.setLayout(panelMesa7Layout);
        panelMesa7Layout.setHorizontalGroup(
            panelMesa7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesa7Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
            .addGroup(panelMesa7Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panelMesa7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnImprimir6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverPedido6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMesa7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addGroup(panelMesa7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelMesa7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa7Layout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(11, 11, 11)
                                .addComponent(jLTroco7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMesa7Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(15, 15, 15)
                                .addComponent(jTDinheiro6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnCalcular6)))))
                .addGap(32, 32, 32))
        );
        panelMesa7Layout.setVerticalGroup(
            panelMesa7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesa7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesa7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesa7Layout.createSequentialGroup()
                        .addComponent(btnRemoverPedido6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa7Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMesa7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jTDinheiro6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular6))
                        .addGap(11, 11, 11)
                        .addGroup(panelMesa7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa7Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel37))
                            .addComponent(jLTroco7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        panelPrincipal.add(panelMesa7, "mesa7");

        panelMesa8.setOpaque(false);

        btnRemoverPedido7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido7.setText("Remover Pedido");
        btnRemoverPedido7.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedido7ActionPerformed(evt);
            }
        });

        btnImprimir7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir7.setText("Imprimir");
        btnImprimir7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir7ActionPerformed(evt);
            }
        });

        jTProdutos7.setModel(new javax.swing.table.DefaultTableModel(
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
        jTProdutos7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos7MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTProdutos7);

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Total: R$");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Dinheiro:");

        jTDinheiro7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDinheiro7ActionPerformed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Troco: R$");

        jLTroco8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTroco8.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcular7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular7.setText("Calcular");
        btnCalcular7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMesa8Layout = new javax.swing.GroupLayout(panelMesa8);
        panelMesa8.setLayout(panelMesa8Layout);
        panelMesa8Layout.setHorizontalGroup(
            panelMesa8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesa8Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
            .addGroup(panelMesa8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(panelMesa8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverPedido7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMesa8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addGroup(panelMesa8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelMesa8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa8Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(11, 11, 11)
                                .addComponent(jLTroco8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMesa8Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(15, 15, 15)
                                .addComponent(jTDinheiro7, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnCalcular7)))))
                .addGap(38, 38, 38))
        );
        panelMesa8Layout.setVerticalGroup(
            panelMesa8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesa8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesa8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesa8Layout.createSequentialGroup()
                        .addComponent(btnRemoverPedido7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel38)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMesa8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel39)
                            .addComponent(jTDinheiro7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular7))
                        .addGap(11, 11, 11)
                        .addGroup(panelMesa8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa8Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel40))
                            .addComponent(jLTroco8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        panelPrincipal.add(panelMesa8, "mesa8");

        panelMesa9.setOpaque(false);

        btnRemoverPedido8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido8.setText("Remover Pedido");
        btnRemoverPedido8.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedido8ActionPerformed(evt);
            }
        });

        btnImprimir8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir8.setText("Imprimir");
        btnImprimir8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir8ActionPerformed(evt);
            }
        });

        jTProdutos8.setModel(new javax.swing.table.DefaultTableModel(
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
        jTProdutos8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos8MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTProdutos8);

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Total: R$");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Dinheiro:");

        jTDinheiro8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDinheiro8ActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Troco: R$");

        jLTroco9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTroco9.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcular8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular8.setText("Calcular");
        btnCalcular8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMesa9Layout = new javax.swing.GroupLayout(panelMesa9);
        panelMesa9.setLayout(panelMesa9Layout);
        panelMesa9Layout.setHorizontalGroup(
            panelMesa9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesa9Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
            .addGroup(panelMesa9Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelMesa9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnImprimir8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverPedido8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMesa9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addGroup(panelMesa9Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelMesa9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa9Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(11, 11, 11)
                                .addComponent(jLTroco9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMesa9Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(15, 15, 15)
                                .addComponent(jTDinheiro8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnCalcular8)))))
                .addGap(40, 40, 40))
        );
        panelMesa9Layout.setVerticalGroup(
            panelMesa9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesa9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesa9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesa9Layout.createSequentialGroup()
                        .addComponent(btnRemoverPedido8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMesa9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jTDinheiro8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular8))
                        .addGap(11, 11, 11)
                        .addGroup(panelMesa9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa9Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel43))
                            .addComponent(jLTroco9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        panelPrincipal.add(panelMesa9, "mesa9");

        panelMesa10.setOpaque(false);

        btnRemoverPedido9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido9.setText("Remover Pedido");
        btnRemoverPedido9.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedido9ActionPerformed(evt);
            }
        });

        btnImprimir9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir9.setText("Imprimir");
        btnImprimir9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir9ActionPerformed(evt);
            }
        });

        jTProdutos9.setModel(new javax.swing.table.DefaultTableModel(
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
        jTProdutos9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos9MouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(jTProdutos9);

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("Total: R$");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("Dinheiro:");

        jTDinheiro9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDinheiro9ActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Troco: R$");

        jLTroco10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTroco10.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcular9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular9.setText("Calcular");
        btnCalcular9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMesa10Layout = new javax.swing.GroupLayout(panelMesa10);
        panelMesa10.setLayout(panelMesa10Layout);
        panelMesa10Layout.setHorizontalGroup(
            panelMesa10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesa10Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
            .addGroup(panelMesa10Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelMesa10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnImprimir9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverPedido9))
                .addGap(39, 39, 39)
                .addGroup(panelMesa10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addGroup(panelMesa10Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelMesa10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa10Layout.createSequentialGroup()
                                .addComponent(jLabel46)
                                .addGap(11, 11, 11)
                                .addComponent(jLTroco10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMesa10Layout.createSequentialGroup()
                                .addComponent(jLabel45)
                                .addGap(15, 15, 15)
                                .addComponent(jTDinheiro9, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnCalcular9)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMesa10Layout.setVerticalGroup(
            panelMesa10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesa10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesa10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesa10Layout.createSequentialGroup()
                        .addComponent(btnRemoverPedido9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel44)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMesa10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45)
                            .addComponent(jTDinheiro9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular9))
                        .addGap(11, 11, 11)
                        .addGroup(panelMesa10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa10Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel46))
                            .addComponent(jLTroco10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        panelPrincipal.add(panelMesa10, "mesa10");

        panelMesa11.setOpaque(false);

        btnRemoverPedido10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido10.setText("Remover Pedido");
        btnRemoverPedido10.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedido10ActionPerformed(evt);
            }
        });

        btnImprimir10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir10.setText("Imprimir");
        btnImprimir10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir10ActionPerformed(evt);
            }
        });

        jTProdutos10.setModel(new javax.swing.table.DefaultTableModel(
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
        jTProdutos10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutos10MouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(jTProdutos10);

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Total: R$");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Dinheiro:");

        jTDinheiro10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDinheiro10ActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Troco: R$");

        jLTroco11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTroco11.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcular10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular10.setText("Calcular");
        btnCalcular10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcular10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMesa11Layout = new javax.swing.GroupLayout(panelMesa11);
        panelMesa11.setLayout(panelMesa11Layout);
        panelMesa11Layout.setHorizontalGroup(
            panelMesa11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesa11Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
            .addGroup(panelMesa11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelMesa11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnImprimir10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverPedido10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMesa11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addGroup(panelMesa11Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelMesa11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa11Layout.createSequentialGroup()
                                .addComponent(jLabel49)
                                .addGap(11, 11, 11)
                                .addComponent(jLTroco11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMesa11Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addGap(15, 15, 15)
                                .addComponent(jTDinheiro10, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnCalcular10)))))
                .addGap(42, 42, 42))
        );
        panelMesa11Layout.setVerticalGroup(
            panelMesa11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesa11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMesa11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesa11Layout.createSequentialGroup()
                        .addComponent(btnRemoverPedido10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnImprimir10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa11Layout.createSequentialGroup()
                        .addComponent(jLabel47)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelMesa11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jTDinheiro10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular10))
                        .addGap(11, 11, 11)
                        .addGroup(panelMesa11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa11Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel49))
                            .addComponent(jLTroco11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        panelPrincipal.add(panelMesa11, "mesa11");

        panelMesa1.setOpaque(false);

        btnRemoverPedido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido.setText("Remover Pedido");
        btnRemoverPedido.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedidoActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

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

        jLTroco1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLTroco1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Total: R$");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Dinheiro:");

        jTDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTDinheiroActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Troco: R$");

        btnCalcular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLPrecoTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLPrecoTotal.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelMesa1Layout = new javax.swing.GroupLayout(panelMesa1);
        panelMesa1.setLayout(panelMesa1Layout);
        panelMesa1Layout.setHorizontalGroup(
            panelMesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesa1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelMesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemoverPedido)
                    .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(panelMesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesa1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelMesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(11, 11, 11)
                                .addComponent(jLTroco1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelMesa1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(15, 15, 15)
                                .addComponent(jTDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(btnCalcular)))))
                .addGap(18, 18, 18))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelMesa1Layout.setVerticalGroup(
            panelMesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMesa1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelMesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMesa1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnRemoverPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMesa1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLPrecoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMesa1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(panelMesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jTDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCalcular))
                        .addGap(11, 11, 11)
                        .addGroup(panelMesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMesa1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel16))
                            .addComponent(jLTroco1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPrincipal.add(panelMesa1, "mesa1");

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 180, -1, -1));

        nomeMesa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        nomeMesa.setForeground(new java.awt.Color(255, 0, 51));
        nomeMesa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                nomeMesaPropertyChange(evt);
            }
        });
        getContentPane().add(nomeMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 130, 202, 45));

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 690, 230));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/testeBack.png"))); // NOI18N
        getContentPane().add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -40, 1410, 850));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa1ActionPerformed
        nomeMesa.setText("Mesa 1");
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "mesa1");

        //INICIO CHAMADA AO BANCO MESA 1:

    }//GEN-LAST:event_mesa1ActionPerformed

    private void mesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa2ActionPerformed

        nomeMesa.setText("Mesa 2");
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "mesa2");
    }//GEN-LAST:event_mesa2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        //mesa1.setBackground(new Color(0,0,0,0));
    }//GEN-LAST:event_formWindowOpened

    private void mesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa3ActionPerformed

        nomeMesa.setText("Mesa 3");
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "mesa3");
    }//GEN-LAST:event_mesa3ActionPerformed

    private void mesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa4ActionPerformed

        nomeMesa.setText("Mesa 4");
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "mesa4");
    }//GEN-LAST:event_mesa4ActionPerformed

    private void mesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa5ActionPerformed

        nomeMesa.setText("Mesa 5");
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "mesa5");
    }//GEN-LAST:event_mesa5ActionPerformed

    private void mesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa6ActionPerformed

        nomeMesa.setText("Mesa 6");
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "mesa6");
    }//GEN-LAST:event_mesa6ActionPerformed

    private void mesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa7ActionPerformed

        nomeMesa.setText("Mesa 7");
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "mesa7");
    }//GEN-LAST:event_mesa7ActionPerformed

    private void mesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa8ActionPerformed

        nomeMesa.setText("Mesa 8");
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "mesa8");
    }//GEN-LAST:event_mesa8ActionPerformed

    private void mesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa9ActionPerformed

        nomeMesa.setText("Mesa 9");
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "mesa9");
    }//GEN-LAST:event_mesa9ActionPerformed

    private void mesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa10ActionPerformed

        nomeMesa.setText("Mesa 10");
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "mesa10");
    }//GEN-LAST:event_mesa10ActionPerformed

    private void mesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa11ActionPerformed

        nomeMesa.setText("Mesa 11");
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "mesa11");
    }//GEN-LAST:event_mesa11ActionPerformed

    private void nomeMesaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_nomeMesaPropertyChange
//        setMesa(nomeMesa.getText());
    }//GEN-LAST:event_nomeMesaPropertyChange

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSobremesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobremesasActionPerformed
        jSQuantidadeSobremesa.setValue(1);
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) panelProdutos.getLayout();
        cl.show(panelProdutos, "sobremesas");
        categoria = 4;
    }//GEN-LAST:event_btnSobremesasActionPerformed

    private void btnPorcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorcoesActionPerformed
        jSQuantidadePorcao.setValue(1);
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) panelProdutos.getLayout();
        cl.show(panelProdutos, "porcoes");
        categoria = 3;
    }//GEN-LAST:event_btnPorcoesActionPerformed

    private void btnBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebidasActionPerformed
        // TODO add your handling code here:
        jSQuantidadeBebidas.setValue(1);
        CardLayout cl = (CardLayout) panelProdutos.getLayout();
        cl.show(panelProdutos, "bebidas");
        categoria = 2;

    }//GEN-LAST:event_btnBebidasActionPerformed

    private void btnPizzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPizzasActionPerformed
        // TODO add your handling code here:
        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelProdutos.getLayout();
        cl.show(panelProdutos, "pizza");
        categoria = 1;
    }//GEN-LAST:event_btnPizzasActionPerformed

    private void comboTamanhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTamanhoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTamanhoMouseClicked

    private void comboTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTamanhoActionPerformed
        comboPizzas1.removeAllItems();
        comboPizzas2.removeAllItems();
        ProdutoDAO dao = new ProdutoDAO();

        for(Produto p : dao.readTamanho((String) comboTamanho.getSelectedItem())){
            comboPizzas1.addItem(p.getNome());
            comboPizzas2.addItem(p.getNome());

        }
    }//GEN-LAST:event_comboTamanhoActionPerformed

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

            }catch(Exception e){
                jTDinheiro.setText("Digite um valor");
            }
        }
        jTDinheiro.setText(null);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        categoria = 1;
        Menu.setT();
        quantidade = (int) jSQuantidadePizzas.getValue();

        if(comboPizzas1.getSelectedItem() != comboPizzas2.getSelectedItem()){
            tamanho= (String) comboTamanho.getSelectedItem();
            nome1 = (String) comboPizzas1.getSelectedItem();
            nome2 = (String) comboPizzas2.getSelectedItem();
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.readMeioaMeio(categoria,nome1 , nome2,tamanho,quantidade);

            readJTable2();

        }else{
            nome1 = (String) comboPizzas1.getSelectedItem();
            ProdutoDAO pdao = new ProdutoDAO();
            tamanho= (String) comboTamanho.getSelectedItem();
            pdao.readPizza(categoria,nome1,tamanho,quantidade);
            readJTable();
        }
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){

            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);

    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnRemoverPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedidoActionPerformed

        // TODO add your handling code here:

        if(jTProdutos.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
            ((DefaultTableModel) jTProdutos.getModel()).removeRow(jTProdutos.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }else {
            JOptionPane.showMessageDialog(null, "Selecione algo para ser Removido !");
        }
    }//GEN-LAST:event_btnRemoverPedidoActionPerformed

    private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutosMouseClicked

    }//GEN-LAST:event_jTProdutosMouseClicked

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed

        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(dataSistema);
        String data = formato.format(dataSistema);

        PedidoDAO pedido = new PedidoDAO();

        ItensPedidoDAO itens = new ItensPedidoDAO();

        int clientID = BuscaCliente.getClientID();

        int n = arrayID.size();
        pedido.createPedido(data, clientID);
        for(int i=0; i<n; i++){

            String nome = (String) jTProdutos.getValueAt(i, 0);
            int qtd = (int) jTProdutos.getValueAt(i, 2);
            Double pc = (Double) jTProdutos.getValueAt(i, 3);
            String tamanho = (String) jTProdutos.getValueAt(i, 1);
            ArrayList<ItensPedido> lista = itens.read(nome, tamanho, pc, qtd);
            itens.create(lista);

        }

        JOptionPane.showMessageDialog(null, "Pedido Feito!");
        //Metodo para Imprimir
        JOptionPane.showMessageDialog(null, "Enviado para impressora");
        try {
            String nome, telefone, endereco;
            nome = BuscaCliente.getNome();
            endereco = BuscaCliente.getEndereco();
            telefone = BuscaCliente.getTelefone();
            MessageFormat headerFormat1 = new MessageFormat("Pedido "+" Cliente: "+nome+"{0} Endereço: "+
                endereco +"{1} Telefone: "+ telefone);
            MessageFormat bodyFormat = new MessageFormat("Cliente" );
            MessageFormat footerFormat = new MessageFormat("Pizzaria Espaço Original");
            jTProdutos.print(JTable.PrintMode.NORMAL, headerFormat1, footerFormat);

        } catch (PrinterException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void jComboBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBebidasActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBebidasActionPerformed

    private void jBRegistrarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarBebidaActionPerformed

        categoria = 2;
        Menu.setT();
        ProdutoDAO b = new ProdutoDAO();

        quantidade = (int) jSQuantidadeBebidas.getValue();
        nome1 = jComboBebidas.getSelectedItem().toString();
        b.read(categoria,nome1,quantidade);
        readJTable3();
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);

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

    private void jBRegistrarSobremesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistrarSobremesaActionPerformed

        categoria = 4;
        Menu.setT();
        ProdutoDAO dao = new ProdutoDAO();
        nome1 = jComboSobremesa.getSelectedItem().toString();
        quantidade = (int) jSQuantidadeSobremesa.getValue();
        dao.read(categoria,nome1, quantidade);
        readJTable3();
        valorTotal=0;
        for(int i=0; i<= jTProdutos.getRowCount()-1; i++){
            valorTotal += Double.parseDouble(jTProdutos.getValueAt(i,4).toString());
        }
        preco = String.valueOf(valorTotal);
        jLPrecoTotal.setText(preco);

        // TODO add your handling code here:
    }//GEN-LAST:event_jBRegistrarSobremesaActionPerformed

    private void btnRemoverPedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedido1ActionPerformed
        // TODO add your handling code here:
         if(jTProdutos1.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos1.getValueAt(jTProdutos1.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
            ((DefaultTableModel) jTProdutos1.getModel()).removeRow(jTProdutos1.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }else {
            JOptionPane.showMessageDialog(null, "Selecione algo para ser Removido !");
        }
    }//GEN-LAST:event_btnRemoverPedido1ActionPerformed

    private void btnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir1ActionPerformed
        // TODO add your handling code here:
        Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(dataSistema);
        String data = formato.format(dataSistema);

        PedidoDAO pedido = new PedidoDAO();

        ItensPedidoDAO itens = new ItensPedidoDAO();

        int clientID = BuscaCliente.getClientID();

        int n = arrayID.size();
        pedido.createPedido(data, clientID);
        for(int i=0; i<n; i++){

            String nome = (String) jTProdutos1.getValueAt(i, 0);
            int qtd = (int) jTProdutos1.getValueAt(i, 2);
            Double pc = (Double) jTProdutos1.getValueAt(i, 3);
            String tamanho = (String) jTProdutos1.getValueAt(i, 1);
            ArrayList<ItensPedido> lista = itens.read(nome, tamanho, pc, qtd);
            itens.create(lista);

        }

        JOptionPane.showMessageDialog(null, "Pedido Feito!");
        //Metodo para Imprimir
        JOptionPane.showMessageDialog(null, "Enviado para impressora");
        try {
            String nome, telefone, endereco;
            nome = BuscaCliente.getNome();
            endereco = BuscaCliente.getEndereco();
            telefone = BuscaCliente.getTelefone();
            MessageFormat headerFormat1 = new MessageFormat("Pedido "+" Cliente: "+nome+"{0} Endereço: "+
                endereco +"{1} Telefone: "+ telefone);
            MessageFormat bodyFormat = new MessageFormat("Cliente" );
            MessageFormat footerFormat = new MessageFormat("Pizzaria Espaço Original");
            jTProdutos1.print(JTable.PrintMode.NORMAL, headerFormat1, footerFormat);

        } catch (PrinterException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnImprimir1ActionPerformed

    private void jTProdutos1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProdutos1MouseClicked

    private void btnRemoverPedido2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedido2ActionPerformed
        // TODO add your handling code here:
         if(jTProdutos2.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos1.getValueAt(jTProdutos2.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
            ((DefaultTableModel) jTProdutos2.getModel()).removeRow(jTProdutos2.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }else {
            JOptionPane.showMessageDialog(null, "Selecione algo para ser Removido !");
        }
    }//GEN-LAST:event_btnRemoverPedido2ActionPerformed

    private void btnImprimir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir2ActionPerformed
        // TODO add your handling code here:
         Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(dataSistema);
        String data = formato.format(dataSistema);

        PedidoDAO pedido = new PedidoDAO();

        ItensPedidoDAO itens = new ItensPedidoDAO();

        int clientID = BuscaCliente.getClientID();

        int n = arrayID.size();
        pedido.createPedido(data, clientID);
        for(int i=0; i<n; i++){

            String nome = (String) jTProdutos2.getValueAt(i, 0);
            int qtd = (int) jTProdutos2.getValueAt(i, 2);
            Double pc = (Double) jTProdutos2.getValueAt(i, 3);
            String tamanho = (String) jTProdutos2.getValueAt(i, 1);
            ArrayList<ItensPedido> lista = itens.read(nome, tamanho, pc, qtd);
            itens.create(lista);

        }

        JOptionPane.showMessageDialog(null, "Pedido Feito!");
        //Metodo para Imprimir
        JOptionPane.showMessageDialog(null, "Enviado para impressora");
        try {
            String nome, telefone, endereco;
            nome = BuscaCliente.getNome();
            endereco = BuscaCliente.getEndereco();
            telefone = BuscaCliente.getTelefone();
            MessageFormat headerFormat1 = new MessageFormat("Pedido "+" Cliente: "+nome+"{0} Endereço: "+
                endereco +"{1} Telefone: "+ telefone);
            MessageFormat bodyFormat = new MessageFormat("Cliente" );
            MessageFormat footerFormat = new MessageFormat("Pizzaria Espaço Original");
            jTProdutos2.print(JTable.PrintMode.NORMAL, headerFormat1, footerFormat);

        } catch (PrinterException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnImprimir2ActionPerformed

    private void jTProdutos2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProdutos2MouseClicked

    private void btnRemoverPedido3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedido3ActionPerformed
        // TODO add your handling code here:
         if(jTProdutos3.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos3.getValueAt(jTProdutos3.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
            ((DefaultTableModel) jTProdutos3.getModel()).removeRow(jTProdutos3.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }else {
            JOptionPane.showMessageDialog(null, "Selecione algo para ser Removido !");
        }
    }//GEN-LAST:event_btnRemoverPedido3ActionPerformed

    private void btnImprimir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir3ActionPerformed
        // TODO add your handling code here:
         Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(dataSistema);
        String data = formato.format(dataSistema);

        PedidoDAO pedido = new PedidoDAO();

        ItensPedidoDAO itens = new ItensPedidoDAO();

        int clientID = BuscaCliente.getClientID();

        int n = arrayID.size();
        pedido.createPedido(data, clientID);
        for(int i=0; i<n; i++){

            String nome = (String) jTProdutos3.getValueAt(i, 0);
            int qtd = (int) jTProdutos3.getValueAt(i, 2);
            Double pc = (Double) jTProdutos3.getValueAt(i, 3);
            String tamanho = (String) jTProdutos3.getValueAt(i, 1);
            ArrayList<ItensPedido> lista = itens.read(nome, tamanho, pc, qtd);
            itens.create(lista);

        }

        JOptionPane.showMessageDialog(null, "Pedido Feito!");
        //Metodo para Imprimir
        JOptionPane.showMessageDialog(null, "Enviado para impressora");
        try {
            String nome, telefone, endereco;
            nome = BuscaCliente.getNome();
            endereco = BuscaCliente.getEndereco();
            telefone = BuscaCliente.getTelefone();
            MessageFormat headerFormat1 = new MessageFormat("Pedido "+" Cliente: "+nome+"{0} Endereço: "+
                endereco +"{1} Telefone: "+ telefone);
            MessageFormat bodyFormat = new MessageFormat("Cliente" );
            MessageFormat footerFormat = new MessageFormat("Pizzaria Espaço Original");
            jTProdutos3.print(JTable.PrintMode.NORMAL, headerFormat1, footerFormat);

        } catch (PrinterException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnImprimir3ActionPerformed

    private void jTProdutos3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProdutos3MouseClicked

    private void btnRemoverPedido4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedido4ActionPerformed
        // TODO add your handling code here:
         if(jTProdutos4.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos4.getValueAt(jTProdutos4.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
            ((DefaultTableModel) jTProdutos4.getModel()).removeRow(jTProdutos4.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }else {
            JOptionPane.showMessageDialog(null, "Selecione algo para ser Removido !");
        }
    }//GEN-LAST:event_btnRemoverPedido4ActionPerformed

    private void btnImprimir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir4ActionPerformed
        // TODO add your handling code here:
         Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(dataSistema);
        String data = formato.format(dataSistema);

        PedidoDAO pedido = new PedidoDAO();

        ItensPedidoDAO itens = new ItensPedidoDAO();

        int clientID = BuscaCliente.getClientID();

        int n = arrayID.size();
        pedido.createPedido(data, clientID);
        for(int i=0; i<n; i++){

            String nome = (String) jTProdutos4.getValueAt(i, 0);
            int qtd = (int) jTProdutos4.getValueAt(i, 2);
            Double pc = (Double) jTProdutos4.getValueAt(i, 3);
            String tamanho = (String) jTProdutos4.getValueAt(i, 1);
            ArrayList<ItensPedido> lista = itens.read(nome, tamanho, pc, qtd);
            itens.create(lista);

        }

        JOptionPane.showMessageDialog(null, "Pedido Feito!");
        //Metodo para Imprimir
        JOptionPane.showMessageDialog(null, "Enviado para impressora");
        try {
            String nome, telefone, endereco;
            nome = BuscaCliente.getNome();
            endereco = BuscaCliente.getEndereco();
            telefone = BuscaCliente.getTelefone();
            MessageFormat headerFormat1 = new MessageFormat("Pedido "+" Cliente: "+nome+"{0} Endereço: "+
                endereco +"{1} Telefone: "+ telefone);
            MessageFormat bodyFormat = new MessageFormat("Cliente" );
            MessageFormat footerFormat = new MessageFormat("Pizzaria Espaço Original");
            jTProdutos4.print(JTable.PrintMode.NORMAL, headerFormat1, footerFormat);

        } catch (PrinterException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnImprimir4ActionPerformed

    private void jTProdutos4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProdutos4MouseClicked

    private void btnRemoverPedido5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedido5ActionPerformed
        // TODO add your handling code here:
         if(jTProdutos5.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos5.getValueAt(jTProdutos5.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
            ((DefaultTableModel) jTProdutos5.getModel()).removeRow(jTProdutos5.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }else {
            JOptionPane.showMessageDialog(null, "Selecione algo para ser Removido !");
        }
    }//GEN-LAST:event_btnRemoverPedido5ActionPerformed

    private void btnImprimir5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir5ActionPerformed
        // TODO add your handling code here:
         Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(dataSistema);
        String data = formato.format(dataSistema);

        PedidoDAO pedido = new PedidoDAO();

        ItensPedidoDAO itens = new ItensPedidoDAO();

        int clientID = BuscaCliente.getClientID();

        int n = arrayID.size();
        pedido.createPedido(data, clientID);
        for(int i=0; i<n; i++){

            String nome = (String) jTProdutos5.getValueAt(i, 0);
            int qtd = (int) jTProdutos5.getValueAt(i, 2);
            Double pc = (Double) jTProdutos5.getValueAt(i, 3);
            String tamanho = (String) jTProdutos5.getValueAt(i, 1);
            ArrayList<ItensPedido> lista = itens.read(nome, tamanho, pc, qtd);
            itens.create(lista);

        }

        JOptionPane.showMessageDialog(null, "Pedido Feito!");
        //Metodo para Imprimir
        JOptionPane.showMessageDialog(null, "Enviado para impressora");
        try {
            String nome, telefone, endereco;
            nome = BuscaCliente.getNome();
            endereco = BuscaCliente.getEndereco();
            telefone = BuscaCliente.getTelefone();
            MessageFormat headerFormat1 = new MessageFormat("Pedido "+" Cliente: "+nome+"{0} Endereço: "+
                endereco +"{1} Telefone: "+ telefone);
            MessageFormat bodyFormat = new MessageFormat("Cliente" );
            MessageFormat footerFormat = new MessageFormat("Pizzaria Espaço Original");
            jTProdutos5.print(JTable.PrintMode.NORMAL, headerFormat1, footerFormat);

        } catch (PrinterException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnImprimir5ActionPerformed

    private void jTProdutos5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProdutos5MouseClicked

    private void btnRemoverPedido6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedido6ActionPerformed
        // TODO add your handling code here:
         if(jTProdutos7.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos6.getValueAt(jTProdutos6.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
            ((DefaultTableModel) jTProdutos6.getModel()).removeRow(jTProdutos6.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }else {
            JOptionPane.showMessageDialog(null, "Selecione algo para ser Removido !");
        }
    }//GEN-LAST:event_btnRemoverPedido6ActionPerformed

    private void btnImprimir6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir6ActionPerformed
        // TODO add your handling code here:
         Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(dataSistema);
        String data = formato.format(dataSistema);

        PedidoDAO pedido = new PedidoDAO();

        ItensPedidoDAO itens = new ItensPedidoDAO();

        int clientID = BuscaCliente.getClientID();

        int n = arrayID.size();
        pedido.createPedido(data, clientID);
        for(int i=0; i<n; i++){

            String nome = (String) jTProdutos6.getValueAt(i, 0);
            int qtd = (int) jTProdutos6.getValueAt(i, 2);
            Double pc = (Double) jTProdutos6.getValueAt(i, 3);
            String tamanho = (String) jTProdutos6.getValueAt(i, 1);
            ArrayList<ItensPedido> lista = itens.read(nome, tamanho, pc, qtd);
            itens.create(lista);

        }

        JOptionPane.showMessageDialog(null, "Pedido Feito!");
        //Metodo para Imprimir
        JOptionPane.showMessageDialog(null, "Enviado para impressora");
        try {
            String nome, telefone, endereco;
            nome = BuscaCliente.getNome();
            endereco = BuscaCliente.getEndereco();
            telefone = BuscaCliente.getTelefone();
            MessageFormat headerFormat1 = new MessageFormat("Pedido "+" Cliente: "+nome+"{0} Endereço: "+
                endereco +"{1} Telefone: "+ telefone);
            MessageFormat bodyFormat = new MessageFormat("Cliente" );
            MessageFormat footerFormat = new MessageFormat("Pizzaria Espaço Original");
            jTProdutos1.print(JTable.PrintMode.NORMAL, headerFormat1, footerFormat);

        } catch (PrinterException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnImprimir6ActionPerformed

    private void jTProdutos6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProdutos6MouseClicked

    private void btnRemoverPedido7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedido7ActionPerformed
        // TODO add your handling code here:
         if(jTProdutos7.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos7.getValueAt(jTProdutos7.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
            ((DefaultTableModel) jTProdutos7.getModel()).removeRow(jTProdutos7.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }else {
            JOptionPane.showMessageDialog(null, "Selecione algo para ser Removido !");
        }
    }//GEN-LAST:event_btnRemoverPedido7ActionPerformed

    private void btnImprimir7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir7ActionPerformed
        // TODO add your handling code here:
         Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(dataSistema);
        String data = formato.format(dataSistema);

        PedidoDAO pedido = new PedidoDAO();

        ItensPedidoDAO itens = new ItensPedidoDAO();

        int clientID = BuscaCliente.getClientID();

        int n = arrayID.size();
        pedido.createPedido(data, clientID);
        for(int i=0; i<n; i++){

            String nome = (String) jTProdutos7.getValueAt(i, 0);
            int qtd = (int) jTProdutos7.getValueAt(i, 2);
            Double pc = (Double) jTProdutos7.getValueAt(i, 3);
            String tamanho = (String) jTProdutos7.getValueAt(i, 1);
            ArrayList<ItensPedido> lista = itens.read(nome, tamanho, pc, qtd);
            itens.create(lista);

        }

        JOptionPane.showMessageDialog(null, "Pedido Feito!");
        //Metodo para Imprimir
        JOptionPane.showMessageDialog(null, "Enviado para impressora");
        try {
            String nome, telefone, endereco;
            nome = BuscaCliente.getNome();
            endereco = BuscaCliente.getEndereco();
            telefone = BuscaCliente.getTelefone();
            MessageFormat headerFormat1 = new MessageFormat("Pedido "+" Cliente: "+nome+"{0} Endereço: "+
                endereco +"{1} Telefone: "+ telefone);
            MessageFormat bodyFormat = new MessageFormat("Cliente" );
            MessageFormat footerFormat = new MessageFormat("Pizzaria Espaço Original");
            jTProdutos1.print(JTable.PrintMode.NORMAL, headerFormat1, footerFormat);

        } catch (PrinterException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnImprimir7ActionPerformed

    private void jTProdutos7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProdutos7MouseClicked

    private void btnRemoverPedido8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedido8ActionPerformed
        // TODO add your handling code here:
         if(jTProdutos8.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos8.getValueAt(jTProdutos8.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
            ((DefaultTableModel) jTProdutos8.getModel()).removeRow(jTProdutos8.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }else {
            JOptionPane.showMessageDialog(null, "Selecione algo para ser Removido !");
        }
    }//GEN-LAST:event_btnRemoverPedido8ActionPerformed

    private void btnImprimir8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir8ActionPerformed
        // TODO add your handling code here:
         Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(dataSistema);
        String data = formato.format(dataSistema);

        PedidoDAO pedido = new PedidoDAO();

        ItensPedidoDAO itens = new ItensPedidoDAO();

        int clientID = BuscaCliente.getClientID();

        int n = arrayID.size();
        pedido.createPedido(data, clientID);
        for(int i=0; i<n; i++){

            String nome = (String) jTProdutos8.getValueAt(i, 0);
            int qtd = (int) jTProdutos8.getValueAt(i, 2);
            Double pc = (Double) jTProdutos8.getValueAt(i, 3);
            String tamanho = (String) jTProdutos8.getValueAt(i, 1);
            ArrayList<ItensPedido> lista = itens.read(nome, tamanho, pc, qtd);
            itens.create(lista);

        }

        JOptionPane.showMessageDialog(null, "Pedido Feito!");
        //Metodo para Imprimir
        JOptionPane.showMessageDialog(null, "Enviado para impressora");
        try {
            String nome, telefone, endereco;
            nome = BuscaCliente.getNome();
            endereco = BuscaCliente.getEndereco();
            telefone = BuscaCliente.getTelefone();
            MessageFormat headerFormat1 = new MessageFormat("Pedido "+" Cliente: "+nome+"{0} Endereço: "+
                endereco +"{1} Telefone: "+ telefone);
            MessageFormat bodyFormat = new MessageFormat("Cliente" );
            MessageFormat footerFormat = new MessageFormat("Pizzaria Espaço Original");
            jTProdutos8.print(JTable.PrintMode.NORMAL, headerFormat1, footerFormat);

        } catch (PrinterException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnImprimir8ActionPerformed

    private void jTProdutos8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProdutos8MouseClicked

    private void btnRemoverPedido9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedido9ActionPerformed
        // TODO add your handling code here:
         if(jTProdutos9.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos9.getValueAt(jTProdutos9.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
            ((DefaultTableModel) jTProdutos9.getModel()).removeRow(jTProdutos9.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }else {
            JOptionPane.showMessageDialog(null, "Selecione algo para ser Removido !");
        }
    }//GEN-LAST:event_btnRemoverPedido9ActionPerformed

    private void btnImprimir9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir9ActionPerformed
        // TODO add your handling code here:
         Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(dataSistema);
        String data = formato.format(dataSistema);

        PedidoDAO pedido = new PedidoDAO();

        ItensPedidoDAO itens = new ItensPedidoDAO();

        int clientID = BuscaCliente.getClientID();

        int n = arrayID.size();
        pedido.createPedido(data, clientID);
        for(int i=0; i<n; i++){

            String nome = (String) jTProdutos9.getValueAt(i, 0);
            int qtd = (int) jTProdutos9.getValueAt(i, 2);
            Double pc = (Double) jTProdutos9.getValueAt(i, 3);
            String tamanho = (String) jTProdutos9.getValueAt(i, 1);
            ArrayList<ItensPedido> lista = itens.read(nome, tamanho, pc, qtd);
            itens.create(lista);

        }

        JOptionPane.showMessageDialog(null, "Pedido Feito!");
        //Metodo para Imprimir
        JOptionPane.showMessageDialog(null, "Enviado para impressora");
        try {
            String nome, telefone, endereco;
            nome = BuscaCliente.getNome();
            endereco = BuscaCliente.getEndereco();
            telefone = BuscaCliente.getTelefone();
            MessageFormat headerFormat1 = new MessageFormat("Pedido "+" Cliente: "+nome+"{0} Endereço: "+
                endereco +"{1} Telefone: "+ telefone);
            MessageFormat bodyFormat = new MessageFormat("Cliente" );
            MessageFormat footerFormat = new MessageFormat("Pizzaria Espaço Original");
            jTProdutos9.print(JTable.PrintMode.NORMAL, headerFormat1, footerFormat);

        } catch (PrinterException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnImprimir9ActionPerformed

    private void jTProdutos9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProdutos9MouseClicked

    private void btnRemoverPedido10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedido10ActionPerformed
        // TODO add your handling code here:
         if(jTProdutos10.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos10.getValueAt(jTProdutos10.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
            ((DefaultTableModel) jTProdutos10.getModel()).removeRow(jTProdutos10.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }else {
            JOptionPane.showMessageDialog(null, "Selecione algo para ser Removido !");
        }
    }//GEN-LAST:event_btnRemoverPedido10ActionPerformed

    private void btnImprimir10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir10ActionPerformed
        // TODO add your handling code here:
         Date dataSistema = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        formato.format(dataSistema);
        String data = formato.format(dataSistema);

        PedidoDAO pedido = new PedidoDAO();

        ItensPedidoDAO itens = new ItensPedidoDAO();

        int clientID = BuscaCliente.getClientID();

        int n = arrayID.size();
        pedido.createPedido(data, clientID);
        for(int i=0; i<n; i++){

            String nome = (String) jTProdutos10.getValueAt(i, 0);
            int qtd = (int) jTProdutos10.getValueAt(i, 2);
            Double pc = (Double) jTProdutos10.getValueAt(i, 3);
            String tamanho = (String) jTProdutos10.getValueAt(i, 1);
            ArrayList<ItensPedido> lista = itens.read(nome, tamanho, pc, qtd);
            itens.create(lista);

        }

        JOptionPane.showMessageDialog(null, "Pedido Feito!");
        //Metodo para Imprimir
        JOptionPane.showMessageDialog(null, "Enviado para impressora");
        try {
            String nome, telefone, endereco;
            nome = BuscaCliente.getNome();
            endereco = BuscaCliente.getEndereco();
            telefone = BuscaCliente.getTelefone();
            MessageFormat headerFormat1 = new MessageFormat("Pedido "+" Cliente: "+nome+"{0} Endereço: "+
                endereco +"{1} Telefone: "+ telefone);
            MessageFormat bodyFormat = new MessageFormat("Cliente" );
            MessageFormat footerFormat = new MessageFormat("Pizzaria Espaço Original");
            jTProdutos10.print(JTable.PrintMode.NORMAL, headerFormat1, footerFormat);

        } catch (PrinterException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_btnImprimir10ActionPerformed

    private void jTProdutos10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutos10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTProdutos10MouseClicked

    private void jTDinheiro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDinheiro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDinheiro1ActionPerformed

    private void btnCalcular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcular1ActionPerformed

    private void jTDinheiro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDinheiro2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDinheiro2ActionPerformed

    private void btnCalcular2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcular2ActionPerformed

    private void jTDinheiro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDinheiro3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDinheiro3ActionPerformed

    private void btnCalcular3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcular3ActionPerformed

    private void jTDinheiro4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDinheiro4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDinheiro4ActionPerformed

    private void btnCalcular4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcular4ActionPerformed

    private void jTDinheiro5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDinheiro5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDinheiro5ActionPerformed

    private void btnCalcular5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcular5ActionPerformed

    private void jTDinheiro6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDinheiro6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDinheiro6ActionPerformed

    private void btnCalcular6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcular6ActionPerformed

    private void jTDinheiro7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDinheiro7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDinheiro7ActionPerformed

    private void btnCalcular7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcular7ActionPerformed

    private void jTDinheiro8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDinheiro8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDinheiro8ActionPerformed

    private void btnCalcular8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcular8ActionPerformed

    private void jTDinheiro9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDinheiro9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDinheiro9ActionPerformed

    private void btnCalcular9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcular9ActionPerformed

    private void jTDinheiro10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDinheiro10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDinheiro10ActionPerformed

    private void btnCalcular10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcular10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcular10ActionPerformed

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
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mesas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBebidas;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCalcular1;
    private javax.swing.JButton btnCalcular10;
    private javax.swing.JButton btnCalcular2;
    private javax.swing.JButton btnCalcular3;
    private javax.swing.JButton btnCalcular4;
    private javax.swing.JButton btnCalcular5;
    private javax.swing.JButton btnCalcular6;
    private javax.swing.JButton btnCalcular7;
    private javax.swing.JButton btnCalcular8;
    private javax.swing.JButton btnCalcular9;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimir1;
    private javax.swing.JButton btnImprimir10;
    private javax.swing.JButton btnImprimir2;
    private javax.swing.JButton btnImprimir3;
    private javax.swing.JButton btnImprimir4;
    private javax.swing.JButton btnImprimir5;
    private javax.swing.JButton btnImprimir6;
    private javax.swing.JButton btnImprimir7;
    private javax.swing.JButton btnImprimir8;
    private javax.swing.JButton btnImprimir9;
    private javax.swing.JButton btnPizzas;
    private javax.swing.JButton btnPorcoes;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRemoverPedido;
    private javax.swing.JButton btnRemoverPedido1;
    private javax.swing.JButton btnRemoverPedido10;
    private javax.swing.JButton btnRemoverPedido2;
    private javax.swing.JButton btnRemoverPedido3;
    private javax.swing.JButton btnRemoverPedido4;
    private javax.swing.JButton btnRemoverPedido5;
    private javax.swing.JButton btnRemoverPedido6;
    private javax.swing.JButton btnRemoverPedido7;
    private javax.swing.JButton btnRemoverPedido8;
    private javax.swing.JButton btnRemoverPedido9;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSobremesas;
    private javax.swing.JComboBox<Object> comboPizzas1;
    private javax.swing.JComboBox<Object> comboPizzas2;
    private javax.swing.JComboBox<Object> comboTamanho;
    private javax.swing.JLabel imgGigante;
    private javax.swing.JLabel imgGigante1;
    private javax.swing.JButton jBRegistrarBebida;
    private javax.swing.JButton jBRegistrarPorcao;
    private javax.swing.JButton jBRegistrarSobremesa;
    private javax.swing.JComboBox jComboBebidas;
    private javax.swing.JComboBox<String> jComboPorcao;
    private javax.swing.JComboBox jComboSobremesa;
    private javax.swing.JLabel jLPrecoTotal;
    private javax.swing.JLabel jLTroco;
    private javax.swing.JLabel jLTroco1;
    private javax.swing.JLabel jLTroco10;
    private javax.swing.JLabel jLTroco11;
    private javax.swing.JLabel jLTroco2;
    private javax.swing.JLabel jLTroco3;
    private javax.swing.JLabel jLTroco4;
    private javax.swing.JLabel jLTroco5;
    private javax.swing.JLabel jLTroco6;
    private javax.swing.JLabel jLTroco7;
    private javax.swing.JLabel jLTroco8;
    private javax.swing.JLabel jLTroco9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSpinner jSQuantidadeBebidas;
    private javax.swing.JSpinner jSQuantidadePizzas;
    private javax.swing.JSpinner jSQuantidadePorcao;
    private javax.swing.JSpinner jSQuantidadeSobremesa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTDinheiro;
    private javax.swing.JTextField jTDinheiro1;
    private javax.swing.JTextField jTDinheiro10;
    private javax.swing.JTextField jTDinheiro2;
    private javax.swing.JTextField jTDinheiro3;
    private javax.swing.JTextField jTDinheiro4;
    private javax.swing.JTextField jTDinheiro5;
    private javax.swing.JTextField jTDinheiro6;
    private javax.swing.JTextField jTDinheiro7;
    private javax.swing.JTextField jTDinheiro8;
    private javax.swing.JTextField jTDinheiro9;
    private javax.swing.JTable jTProdutos;
    private javax.swing.JTable jTProdutos1;
    private javax.swing.JTable jTProdutos10;
    private javax.swing.JTable jTProdutos2;
    private javax.swing.JTable jTProdutos3;
    private javax.swing.JTable jTProdutos4;
    private javax.swing.JTable jTProdutos5;
    private javax.swing.JTable jTProdutos6;
    private javax.swing.JTable jTProdutos7;
    private javax.swing.JTable jTProdutos8;
    private javax.swing.JTable jTProdutos9;
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
    private javax.swing.JLabel nomeMesa;
    private javax.swing.JPanel panelBebidas;
    private javax.swing.JPanel panelMesa1;
    private javax.swing.JPanel panelMesa10;
    private javax.swing.JPanel panelMesa11;
    private javax.swing.JPanel panelMesa2;
    private javax.swing.JPanel panelMesa3;
    private javax.swing.JPanel panelMesa4;
    private javax.swing.JPanel panelMesa5;
    private javax.swing.JPanel panelMesa6;
    private javax.swing.JPanel panelMesa7;
    private javax.swing.JPanel panelMesa8;
    private javax.swing.JPanel panelMesa9;
    private javax.swing.JPanel panelPizza;
    private javax.swing.JPanel panelPorcoes;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelProdutos;
    private javax.swing.JPanel panelSobremesas;
    // End of variables declaration//GEN-END:variables
}
