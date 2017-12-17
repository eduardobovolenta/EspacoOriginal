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
import model.bean.ItensPedido;
import model.bean.Produto;

/**
 *
 * @author eduar
 */
public class MesaDAO {
    Connection con;

    public MesaDAO(){
        con = ConnectionFactory.getConnection();
}

    public void createPedidoMesa(String nomeMesa, int idProduto, int qnt) {
            con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;   
            ItensPedido iten = new ItensPedido();
            try {
                stmt = con.prepareStatement("INSERT INTO mesa (id, nome, idProduto, quantidade) values(default, ?, ?, ?)");
                stmt.setString(1, nomeMesa);
                stmt.setInt(2, idProduto);
                stmt.setInt(3, qnt);
                stmt.executeUpdate();          

            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }
        }
    
    public void createPedidoMeioMeio(String nomeMesa, int idProduto, int qnt, String nomeMeio) {
            con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;   
            ItensPedido iten = new ItensPedido();
            try {
                stmt = con.prepareStatement("INSERT INTO mesa (id, nome, idProduto, quantidade, nomeMeioaMeio) values(default, ?, ?, ?, ?)");
                stmt.setString(1, nomeMesa);
                stmt.setInt(2, idProduto);
                stmt.setInt(3, qnt);
                stmt.setString(4, nomeMeio);
                stmt.executeUpdate();          

            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }
        }
    
    public List<Produto> readMesa(String nome) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //Declaração de um lista
        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select m.nomeMeioaMeio, p.tamanho, m.quantidade, p.preco from mesa m inner join produto p on m.idProduto = p.id where m.nome = ?");
            //Query faz as consultas no banco e coloca dentro do ResultSet
            stmt.setString(1, nome);
            rs = stmt.executeQuery();

            //  Faz a consulta ate o ultimo valor
            while (rs.next()) {

                Produto produto = new Produto();
                //produto.setId(rs.getInt("id"));
                //produto.setIdCategoria(rs.getInt("idCategoria"));
                
                produto.setNome(rs.getString("nomeMeioaMeio") );
                produto.setTamanho(rs.getString("tamanho"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Fechar a conexão, e stmt e rs
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        //Retorna os produtos
        return produtos;

    }
    
    public void droparMesa(String nomeMesa) {
            con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;   
            ItensPedido iten = new ItensPedido();
            try {
                stmt = con.prepareStatement("delete from mesa where nome = ?");
                stmt.setString(1, nomeMesa);
                stmt.executeUpdate();          

            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }
        }
    
    public void droparProduto(int id, String nomeMesa, int quantidade, String nomeProduto) {
            con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;   
            ItensPedido iten = new ItensPedido();
            try {
                stmt = con.prepareStatement("delete from mesa where id = ? and nome = ? and quantidade = ? and nomeMeioaMeio = ?;");
                stmt.setInt(1, id);
                stmt.setString(2, nomeMesa);
                stmt.setInt(3, quantidade);
                stmt.setString(4, nomeProduto);
                stmt.executeUpdate();          

            } catch (SQLException ex) {
                System.out.println(ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }
        }
    
    public List<Produto> readProdutoSelecionado(String nomeMesa, int quantidade, String nomeProduto) {
//Prepara o Sql
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //Declaração de um lista
        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("select * from mesa where nome = ? and quantidade = ? and nomeMeioaMeio = ?");
            //Query faz as consultas no banco e coloca dentro do ResultSet
            stmt.setString(1, nomeMesa);
            stmt.setInt(2, quantidade);
            stmt.setString(3, nomeProduto);
            rs = stmt.executeQuery();

            //  Faz a consulta ate o ultimo valor
            while (rs.next()) {

                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                //produto.setIdCategoria(rs.getInt("idCategoria"));
                //produto.setNome(rs.getString("nomeMeioaMeio") );
                //produto.setTamanho(rs.getString("tamanho"));
                //produto.setPreco(rs.getDouble("preco"));
                //produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Fechar a conexão, e stmt e rs
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        //Retorna os produtos
        return produtos;

    }
    
    public List<Produto> readTamanhoDoce(String tamanho) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produto where tamanho in (?,'Padrão')  and idCategoria = '4' order by nome");
            stmt.setString(1, tamanho);
            //stmt.setString(2, nome2);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setTamanho(rs.getString("tamanho"));
                produto.setPreco(rs.getDouble("preco"));
                //Add os valores dentro da lista
                produtos.add(produto);
            
              
            }

        } catch (SQLException ex) {
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //Fechar a conexão, e stmt e rs
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        //Retorna os produtos
        return produtos;

    }
    

}