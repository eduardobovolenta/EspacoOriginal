/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.ItensPedido;

/**
 *
 * @author Rosimeiry
 */
public class ItensPedidoDAO {
    Connection con;
    
    public ItensPedidoDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    
    public void create(ArrayList<ItensPedido> lista) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO itenspedido (cod,codPedido,nomeProduto,quantidade,preco, tamanho)VALUES(NULL,?,?,?,?,?)");
            
            stmt.setInt(1, lista.get(0).getCodPedido());
            stmt.setString(2, lista.get(0).getNomeProduto());
            stmt.setInt(3, lista.get(0).getQuantidade());
            stmt.setDouble(4, lista.get(0).getPreco());
            stmt.setString(5, lista.get(0).getTamanho());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
      
    
    public ArrayList<ItensPedido> read(String nome, String tamanho, double pc, int qtd) {
//Prepara o Sql
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt1 = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
         ArrayList<ItensPedido> itens = new ArrayList<>();

        try {
            stmt1 = con.prepareStatement("SELECT max(cod) as max_id from pedido"); 
            rs1 = stmt1.executeQuery() ;
           
            //  Faz a consulta ate o ultimo valor
            while (rs1.next()) {
              ItensPedido iten = new ItensPedido();
              iten.setNomeProduto(nome);
              iten.setCodPedido(rs1.getInt("max_id"));
              iten.setPreco(pc*qtd);
              iten.setQuantidade(qtd);
              iten.setTamanho(tamanho);
              itens.add(iten);
              
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Fechar a conexão, e stmt e rs
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return itens;
      
    }
    
    
    public ArrayList<ItensPedido> readVendasMes(String mes) {
//Prepara o Sql
         con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
         ArrayList<ItensPedido> pedido = new ArrayList<>();
        

        try {
            stmt = con.prepareStatement("select cl.nome as 'nome cliente',i.nomeProduto as 'nome da pizza', i.tamanho, i.quantidade, i.preco, pe.metodPag as 'metodo de pagamento', pe.data from itenspedido i inner join pedido pe on i.codPedido = pe.cod inner join cliente cl on pe.idCliente = cl.id where data like ?;");   
            stmt.setString(1,"%-" + mes + "-%"); 
            rs = stmt.executeQuery();
            
           
            //  Faz a consulta ate o ultimo valor
            while (rs.next()) {
              ItensPedido iten = new ItensPedido();
              iten.setNomeCliente(rs.getString("nome cliente"));
              iten.setNomePizza(rs.getString("nome da pizza"));
              iten.setTamanho(rs.getString("tamanho"));
              iten.setQuantidade(rs.getInt("quantidade"));
              iten.setPreco(rs.getDouble("preco"));
              iten.setMetodPag(rs.getString("metodo de pagamento"));
              iten.setData(rs.getString("data"));
              pedido.add(iten);
              
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Fechar a conexão, e stmt e rs
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pedido;
      
    }
    
    public ArrayList<ItensPedido> readVendasDia(String data) {
//Prepara o Sql
         con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
         ArrayList<ItensPedido> pedido = new ArrayList<>();
        

        try {
            stmt = con.prepareStatement("select cl.nome as 'nome cliente',i.nomeProduto as 'nome da pizza', i.tamanho, i.quantidade, i.preco, pe.metodPag as 'metodo de pagamento', pe.data from itenspedido i inner join pedido pe on i.codPedido = pe.cod inner join cliente cl on pe.idCliente = cl.id where data like ?");   
            stmt.setString(1, data);
            
            //Query faz as consultas no banco e coloca dentro do ResultSet
            rs = stmt.executeQuery();
            
           
            //  Faz a consulta ate o ultimo valor
            while (rs.next()) {
              ItensPedido iten = new ItensPedido();
              iten.setNomeCliente(rs.getString("nome cliente"));
              iten.setNomePizza(rs.getString("nome da pizza"));
              iten.setTamanho(rs.getString("tamanho"));
              iten.setQuantidade(rs.getInt("quantidade"));
              iten.setPreco(rs.getDouble("preco"));
              iten.setMetodPag(rs.getString("metodo de pagamento"));
              iten.setData(rs.getString("data"));
              pedido.add(iten);
              
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Fechar a conexão, e stmt e rs
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pedido;
      
    }
    
    public ArrayList<ItensPedido> readVendas() {
//Prepara o Sql
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
        ArrayList<ItensPedido> pedido = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select cl.nome as 'nome cliente',i.nomeProduto as 'nome da pizza', i.tamanho, i.quantidade, i.preco, pe.metodPag as 'metodo de pagamento', pe.data from itenspedido i inner join pedido pe on i.codPedido = pe.cod inner join cliente cl on pe.idCliente = cl.id;");   

            rs = stmt.executeQuery();

            while (rs.next()) {
              ItensPedido iten = new ItensPedido();
              iten.setNomeCliente(rs.getString("nome cliente"));
              iten.setNomePizza(rs.getString("nome da pizza"));
              iten.setTamanho(rs.getString("tamanho"));
              iten.setQuantidade(rs.getInt("quantidade"));
              iten.setPreco(rs.getDouble("preco"));
              iten.setMetodPag(rs.getString("metodo de pagamento"));
              iten.setData(rs.getString("data"));
              pedido.add(iten);              
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Fechar a conexão, e stmt e rs
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pedido;
      
    }
    
    
}
