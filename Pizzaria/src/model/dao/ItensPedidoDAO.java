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
            stmt = con.prepareStatement("INSERT INTO itenspedido (cod,codPedido,codProduto,quantidade,preco)VALUES(NULL,?,?,?,?)");
            
            stmt.setInt(1, lista.get(0).getCodPedido());
            stmt.setInt(2, lista.get(0).getCodProduto());
            stmt.setInt(3, lista.get(0).getQuantidade());
            stmt.setDouble(4, lista.get(0).getPreco());

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
            stmt = con.prepareStatement("SELECT * FROM produto where nome = ? AND tamanho = ? AND preco = ? ");
            stmt.setString(1,nome);
            stmt.setString(2, tamanho);
            stmt.setDouble(3, pc);
            //Query faz as consultas no banco e coloca dentro do ResultSet
            
            
            rs = stmt.executeQuery();
            stmt1 = con.prepareStatement("SELECT max(cod) as max_id from pedido"); 
            rs1 = stmt1.executeQuery() ;
           
            //  Faz a consulta ate o ultimo valor
            while (rs.next()&& rs1.next()) {
              ItensPedido iten = new ItensPedido();
              iten.setCodProduto(rs.getInt("id"));
              iten.setCodPedido(rs1.getInt("max_id"));
              iten.setPreco(pc*qtd);
              iten.setQuantidade(qtd);
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
    
    
    public ArrayList<ItensPedido> readAno(String ano, String mes) {
//Prepara o Sql
         con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        ResultSet rs = null;
        
         ArrayList<ItensPedido> pedido = new ArrayList<>();
        

        try {
            stmt = con.prepareStatement("SELECT SUM(I.preco) as preco FROM itenspedido as I INNER JOIN pedido P ON P.cod = I.codPedido  WHERE data LIKE ?");   
            stmt.setString(1, "%" + ano+"-"+mes+ "%");
            
            //Query faz as consultas no banco e coloca dentro do ResultSet
            rs = stmt.executeQuery();
            
           
            //  Faz a consulta ate o ultimo valor
            while (rs.next()) {
              ItensPedido iten = new ItensPedido();
              iten.setPreco(rs.getDouble("preco"));
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
