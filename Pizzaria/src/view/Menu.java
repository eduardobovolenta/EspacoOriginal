//  A fazer
//      Mostrar apenas o valor do botao selecionado
//      Se clicar novamente mostrar em outra linha
//      Implementar o botao Imprimir

package view;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.print.PrinterException;


import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import static view.BuscaCliente.clienteID;


public class Menu extends javax.swing.JFrame {
    public String procurarBanco , preco;
    static double valorTotal = 0;
    
    
    Vector dados[] = new Vector[4];
    public String nome1, nome2, tamanho;
    int quantidade, categoria;
    static int t;
    public ArrayList<Integer> arrayID = new ArrayList<>();
    public ArrayList<String> arrayPreço = new ArrayList<>();
    
    
    static void setT(){
        Menu.t += 1;
    }
    static int getT(){
        return t;
    }
    
    
    
    public Menu() {
        
        initComponents();
         //Ordena os valores da tabela
        categoria = 1;
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        SpinnerNumberModel model = new SpinnerNumberModel(1,1, 30,1);
        jSQuantidadeBebidas.setModel(model);
        jSQuantidadePizzas.setModel(model);
        jSQuantidadePorcao.setModel(model);
        jSQuantidadeSobremesa.setModel(model);
        jTProdutos.setRowSorter(new TableRowSorter(modelo));
        
        setLocationRelativeTo(null);
        //seta valores no comboTamanho
        //comboTamanho.addItem("Selecione");
        //comboTamanho.addItem("Medio");
        //comboTamanho.addItem("Grande");
                    
       
        
        jComboBebidas.removeAllItems();
        jComboBebidas.addItem("Selecione");
        
        
        ProdutoDAO dao = new ProdutoDAO();
         categoria = 2;
        for(Produto b : dao.readProduto(categoria)){
            
            jComboBebidas.addItem(b.getNome());
        } 
        jComboPorcao.removeAllItems();
        jComboPorcao.addItem("Selecione");
        ProdutoDAO dao1 = new ProdutoDAO();
         categoria = 3;
        for(Produto b : dao1.readProduto(categoria)){
            
            jComboPorcao.addItem(b.getNome());
        } 
        jComboSobremesa.removeAllItems();
        jComboSobremesa.addItem("Selecione");
        ProdutoDAO dao2 = new ProdutoDAO();
         categoria = 4;
        for(Produto p : dao2.readProduto(categoria)){
            
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
   
    
    
    
    
    public void readJTable(){
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        ProdutoDAO produto = new ProdutoDAO();
       
        for (Produto p : produto.readPizza(categoria,nome1,tamanho,quantidade)) {
            
                arrayID.add(p.getId());
                modelo.addRow(new Object[]{
                p.getNome(),
                p.getTamanho(), 
                quantidade,
                p.getPreco(),
                p.getPreco()*quantidade             
                
            });
                
        
    }
    }
    
    public void readJTable2(){
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        ProdutoDAO produto = new ProdutoDAO();
       
        for (Produto p : produto.readMeioaMeio(categoria, nome1, nome2, tamanho, quantidade)) {
            
                arrayID.add(p.getId());
                modelo.addRow(new Object[]{
                p.getNome(),
                p.getTamanho(), 
                quantidade,
                p.getPreco(),
                p.getPreco()*quantidade
                             
                
            });
                
        
    }
    }    
        
        
        public void readJTable3(){
        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        ProdutoDAO produto = new ProdutoDAO();
       
        for (Produto p : produto.read(categoria, nome1, quantidade)) {
            
                arrayID.add(p.getId());
                modelo.addRow(new Object[]{
                    
                p.getNome(),
                p.getTamanho(), 
                quantidade,
                p.getPreco(),
                p.getPreco()*quantidade
                             
                
            });
                
        
    }
    }
        
        
        
        
        
        
        
  
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioPizzaTamanho = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
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
        jLabel6 = new javax.swing.JLabel();
        grande = new javax.swing.JRadioButton();
        panelBebidas = new javax.swing.JPanel();
        jBRegistrarBebida = new javax.swing.JButton();
        jComboBebidas = new javax.swing.JComboBox();
        jSQuantidadeBebidas = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        panelPorcoes = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jComboPorcao = new javax.swing.JComboBox<>();
        jSQuantidadePorcao = new javax.swing.JSpinner();
        jBRegistrarPorcao = new javax.swing.JButton();
        panelSobremesas = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSQuantidadeSobremesa = new javax.swing.JSpinner();
        jComboSobremesa = new javax.swing.JComboBox();
        jBRegistrarSobremesa = new javax.swing.JButton();
        btnPizzas = new javax.swing.JButton();
        btnBebidas = new javax.swing.JButton();
        btnSobremesas = new javax.swing.JButton();
        btnPorcoes = new javax.swing.JButton();
        jPanelPedidos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnRemoverPedido = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTDinheiro = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        jLTroco = new javax.swing.JLabel();
        jLPrecoTotal = new javax.swing.JLabel();
        clienteName = new javax.swing.JLabel();
        clienteAddress = new javax.swing.JLabel();
        clienteFone = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu");
        setMaximumSize(new java.awt.Dimension(1366, 650));
        setMinimumSize(new java.awt.Dimension(1366, 650));
        setName("Menu"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1366, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 650));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        panelPrincipal.setOpaque(false);
        panelPrincipal.setLayout(new java.awt.CardLayout());

        panelPizza.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Pizzas");
        jLabel13.setToolTipText("");

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

        imgGigante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        imgGigante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/metadeGiganteFIxa.png"))); // NOI18N
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

        comboPizzas2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboPizzas2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPizzas2ActionPerformed(evt);
            }
        });

        jSQuantidadePizzas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopcarIcon35px.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Quantidade:");

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

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Escolha o tamanho desejado:");

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

        javax.swing.GroupLayout panelPizzaLayout = new javax.swing.GroupLayout(panelPizza);
        panelPizza.setLayout(panelPizzaLayout);
        panelPizzaLayout.setHorizontalGroup(
            panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPizzaLayout.createSequentialGroup()
                .addGroup(panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPizzaLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel13))
                    .addGroup(panelPizzaLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel6))
                    .addGroup(panelPizzaLayout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(medio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(grande, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPizzaLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(imgGigante, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(imgGigante1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPizzaLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSQuantidadePizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRegistrar))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelPizzaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboPizzas1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboPizzas2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPizzaLayout.setVerticalGroup(
            panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPizzaLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel13)
                .addGap(17, 17, 17)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(medio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(grande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboPizzas1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPizzas2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imgGigante, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imgGigante1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPizzaLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel50)
                        .addGap(11, 11, 11)
                        .addComponent(jSQuantidadePizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btnRegistrar))))
        );

        panelPrincipal.add(panelPizza, "pizzas");

        panelBebidas.setOpaque(false);

        jBRegistrarBebida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBRegistrarBebida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/shopcarIcon35px.png"))); // NOI18N
        jBRegistrarBebida.setText("Registrar");
        jBRegistrarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistrarBebidaActionPerformed(evt);
            }
        });

        jComboBebidas.setEditable(true);
        jComboBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBebidasActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Bebidas");

        javax.swing.GroupLayout panelBebidasLayout = new javax.swing.GroupLayout(panelBebidas);
        panelBebidas.setLayout(panelBebidasLayout);
        panelBebidasLayout.setHorizontalGroup(
            panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBebidasLayout.createSequentialGroup()
                .addGroup(panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBRegistrarBebida)
                    .addGroup(panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBebidasLayout.createSequentialGroup()
                            .addGap(260, 260, 260)
                            .addComponent(jLabel17))
                        .addGroup(panelBebidasLayout.createSequentialGroup()
                            .addGap(140, 140, 140)
                            .addComponent(jComboBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jSQuantidadeBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(184, 184, 184))
        );
        panelBebidasLayout.setVerticalGroup(
            panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBebidasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel17)
                .addGap(11, 11, 11)
                .addGroup(panelBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSQuantidadeBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBRegistrarBebida)
                .addContainerGap())
        );

        panelPrincipal.add(panelBebidas, "bebidas");

        panelPorcoes.setOpaque(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
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
                .addGroup(panelPorcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPorcoesLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel18))
                    .addGroup(panelPorcoesLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jComboPorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jSQuantidadePorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPorcoesLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBRegistrarPorcao)))
                .addGap(186, 186, 186))
        );
        panelPorcoesLayout.setVerticalGroup(
            panelPorcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPorcoesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel18)
                .addGap(11, 11, 11)
                .addGroup(panelPorcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboPorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSQuantidadePorcao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBRegistrarPorcao)
                .addContainerGap())
        );

        panelPrincipal.add(panelPorcoes, "porcoes");

        panelSobremesas.setOpaque(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
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
                .addGroup(panelSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelSobremesasLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel19))
                    .addGroup(panelSobremesasLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jComboSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jSQuantidadeSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSobremesasLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBRegistrarSobremesa)))
                .addGap(183, 183, 183))
        );
        panelSobremesasLayout.setVerticalGroup(
            panelSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSobremesasLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel19)
                .addGap(11, 11, 11)
                .addGroup(panelSobremesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSQuantidadeSobremesa, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBRegistrarSobremesa)
                .addContainerGap())
        );

        panelPrincipal.add(panelSobremesas, "sobremesas");

        getContentPane().add(panelPrincipal);
        panelPrincipal.setBounds(200, 120, 601, 420);

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
        getContentPane().add(btnPizzas);
        btnPizzas.setBounds(10, 150, 160, 60);

        btnBebidas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/bebidaIcon50px.png"))); // NOI18N
        btnBebidas.setText("Bebidas");
        btnBebidas.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBebidasActionPerformed(evt);
            }
        });
        getContentPane().add(btnBebidas);
        btnBebidas.setBounds(10, 220, 160, 59);

        btnSobremesas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSobremesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sobremesaIcon50px.png"))); // NOI18N
        btnSobremesas.setText("Sobremesas");
        btnSobremesas.setMargin(new java.awt.Insets(2, -7, 2, 10));
        btnSobremesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSobremesasActionPerformed(evt);
            }
        });
        getContentPane().add(btnSobremesas);
        btnSobremesas.setBounds(10, 290, 160, 59);

        btnPorcoes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPorcoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/porcaoIcon50px.png"))); // NOI18N
        btnPorcoes.setText("Porções");
        btnPorcoes.setMargin(new java.awt.Insets(2, 10, 2, 10));
        btnPorcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPorcoesActionPerformed(evt);
            }
        });
        getContentPane().add(btnPorcoes);
        btnPorcoes.setBounds(10, 360, 160, 59);

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
            jTProdutos.getColumnModel().getColumn(1).setMaxWidth(80);
            jTProdutos.getColumnModel().getColumn(2).setMaxWidth(60);
            jTProdutos.getColumnModel().getColumn(3).setMaxWidth(60);
            jTProdutos.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total: R$");
        jLabel1.setPreferredSize(new java.awt.Dimension(80, 20));

        btnRemoverPedido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRemoverPedido.setText("Remover Pedido");
        btnRemoverPedido.setToolTipText("Selecione a linha para remover o pedido");
        btnRemoverPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverPedidoActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Dinheiro:");

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

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Troco: R$");
        jLabel3.setPreferredSize(new java.awt.Dimension(80, 20));

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        jLTroco.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLTroco.setForeground(new java.awt.Color(255, 0, 0));
        jLTroco.setText("00,00");
        jLTroco.setPreferredSize(new java.awt.Dimension(80, 20));

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
                        .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRemoverPedido)
                            .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLTroco, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTDinheiro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(jLPrecoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addComponent(btnCalcular))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(198, 198, 198))
        );
        jPanelPedidosLayout.setVerticalGroup(
            jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPedidosLayout.createSequentialGroup()
                        .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                            .addComponent(jLPrecoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPedidosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelPedidosLayout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel2)))
                        .addGap(11, 11, 11)
                        .addGroup(jPanelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelPedidosLayout.createSequentialGroup()
                        .addComponent(btnRemoverPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );

        getContentPane().add(jPanelPedidos);
        jPanelPedidos.setBounds(830, 90, 520, 480);

        clienteName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clienteName.setForeground(new java.awt.Color(255, 255, 255));
        clienteName.setText("Nome do Cliente");
        getContentPane().add(clienteName);
        clienteName.setBounds(10, 20, 340, 30);

        clienteAddress.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clienteAddress.setForeground(new java.awt.Color(255, 255, 255));
        clienteAddress.setText("Endereço Cliente");
        getContentPane().add(clienteAddress);
        clienteAddress.setBounds(10, 50, 340, 30);

        clienteFone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clienteFone.setForeground(new java.awt.Color(255, 255, 255));
        clienteFone.setText("Telefone Cliente");
        getContentPane().add(clienteFone);
        clienteFone.setBounds(10, 80, 160, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 560, 51, 23);

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(190, 90, 620, 480);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Menu");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(660, 30, 90, 30);

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(180, 90, 1, 480);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/testeBack.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(-10, -50, 1410, 850);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String nome, endereco, telefone;
        nome = BuscaCliente.getNome();
        endereco = BuscaCliente.getEndereco();
        telefone = BuscaCliente.getTelefone();
        clienteName.setText(nome);
        clienteAddress.setText(endereco);
        clienteFone.setText(telefone);
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void jTDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTDinheiroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDinheiroActionPerformed

    private void btnRemoverPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverPedidoActionPerformed

        // TODO add your handling code here:

        if(jTProdutos.getSelectedRow() != -1){

            jLTroco.setText(null);
            valorTotal -= Double.parseDouble(jTProdutos.getValueAt(jTProdutos.getSelectedRow(), 4).toString());
            preco = String.valueOf(valorTotal);
            jLPrecoTotal.setText(preco);
            ((DefaultTableModel) jTProdutos.getModel()).removeRow(jTProdutos.getSelectedRow());
            JOptionPane.showMessageDialog(null, "Pedido Removido !");
        }

    }//GEN-LAST:event_btnRemoverPedidoActionPerformed

    private void jTProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutosMouseClicked
            
    }//GEN-LAST:event_jTProdutosMouseClicked

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

        if(medio.isSelected()){
            tamanho = "Medio";
        }else{
            tamanho = "Gigante";
        }
        
        categoria = 1;
        Menu.setT();
        quantidade = (int) jSQuantidadePizzas.getValue();

        if(comboPizzas1.getSelectedItem() != comboPizzas2.getSelectedItem()){
            nome1 = (String) comboPizzas1.getSelectedItem();
            nome2 = (String) comboPizzas2.getSelectedItem();
            ProdutoDAO pdao = new ProdutoDAO();
            pdao.readMeioaMeio(categoria,nome1 , nome2,tamanho,quantidade);

            readJTable2();

        }else{
            nome1 = (String) comboPizzas1.getSelectedItem();
            ProdutoDAO pdao = new ProdutoDAO();
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

    private void jComboBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBebidasActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBebidasActionPerformed

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

    private void btnPorcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPorcoesActionPerformed
        jSQuantidadePorcao.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "porcoes");
        categoria = 3;
    }//GEN-LAST:event_btnPorcoesActionPerformed

    private void btnSobremesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSobremesasActionPerformed
        jSQuantidadeSobremesa.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "sobremesas");
        categoria = 4;
    }//GEN-LAST:event_btnSobremesasActionPerformed

    private void btnBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBebidasActionPerformed

        jSQuantidadeBebidas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "bebidas");
        categoria = 2;

    }//GEN-LAST:event_btnBebidasActionPerformed

    private void btnPizzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPizzasActionPerformed

        jSQuantidadePizzas.setValue(1);
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        cl.show(panelPrincipal, "pizzas");
        categoria = 1;
    }//GEN-LAST:event_btnPizzasActionPerformed

    private void medioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_medioActionPerformed
        comboPizzas1.removeAllItems();
        comboPizzas2.removeAllItems();
        ProdutoDAO dao = new ProdutoDAO();

        for(Produto p : dao.readTamanho("Medio")){
            comboPizzas1.addItem(p.getNome());
            comboPizzas2.addItem(p.getNome());

        }
    }//GEN-LAST:event_medioActionPerformed

    private void grandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grandeActionPerformed
        comboPizzas1.removeAllItems();
        comboPizzas2.removeAllItems();
        ProdutoDAO dao = new ProdutoDAO();

        for(Produto p : dao.readTamanho("Grande")){
            comboPizzas1.addItem(p.getNome());
            comboPizzas2.addItem(p.getNome());

        }
    }//GEN-LAST:event_grandeActionPerformed

    
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
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
    private javax.swing.JButton btnSobremesas;
    private javax.swing.JLabel clienteAddress;
    private javax.swing.JLabel clienteFone;
    private javax.swing.JLabel clienteName;
    private javax.swing.JComboBox<Object> comboPizzas1;
    private javax.swing.JComboBox<Object> comboPizzas2;
    private javax.swing.JRadioButton grande;
    private javax.swing.JLabel imgGigante;
    private javax.swing.JLabel imgGigante1;
    private javax.swing.JButton jBRegistrarBebida;
    private javax.swing.JButton jBRegistrarPorcao;
    private javax.swing.JButton jBRegistrarSobremesa;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBebidas;
    private javax.swing.JComboBox<String> jComboPorcao;
    private javax.swing.JComboBox jComboSobremesa;
    private javax.swing.JLabel jLPrecoTotal;
    private javax.swing.JLabel jLTroco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
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
    private javax.swing.JPanel panelBebidas;
    private javax.swing.JPanel panelPizza;
    private javax.swing.JPanel panelPorcoes;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelSobremesas;
    private javax.swing.ButtonGroup radioPizzaTamanho;
    // End of variables declaration//GEN-END:variables

    
}
