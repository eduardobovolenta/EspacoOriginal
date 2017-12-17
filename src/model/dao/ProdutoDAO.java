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
import model.bean.ItensPedido;
import model.bean.Produto;

/**
 *
 * @author Rosimeiry
 */
public class ProdutoDAO {
    Connection con;

    public ProdutoDAO() {
        con = ConnectionFactory.getConnection();
    }

    
    public List<Produto> read(int categoria, String nome1,  int quantidade) {
//Prepara o Sql
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //Declaração de um lista
        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto where idCategoria = ? AND nome = ? ");
            //Query faz as consultas no banco e coloca dentro do ResultSet
            stmt.setInt(1, categoria);
            stmt.setString(2, nome1);
            rs = stmt.executeQuery();

            //  Faz a consulta ate o ultimo valor
            while (rs.next()) {

                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setNome(rs.getString("nome") );
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
    
    
//Mostrar os produtos no JTable
    public List<Produto> readPizza(int categoria, String nome1, String tamanho, int quantidade) {
//Prepara o Sql
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //Declaração de um lista
        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE idCategoria = ? AND nome = ? AND tamanho in (?, 'Padrão')");
            //Query faz as consultas no banco e coloca dentro do ResultSet
            stmt.setInt(1, categoria);
            stmt.setString(2, nome1);
            stmt.setString(3, tamanho);
            rs = stmt.executeQuery();

            //  Faz a consulta ate o ultimo valor
            while (rs.next()) {

                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setNome(rs.getString("nome") );
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
    
    public List<Produto> readProduto(int categoria) {
//Prepara o Sql
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //Declaração de um lista
        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto where idCategoria = ?");
            stmt.setInt(1, categoria);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setNome(rs.getString("nome") );
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
    
    
    public List<Produto> readMeioaMeio(int categoria,String nome1, String nome2,String tamanho,int quantidade) {
        PreparedStatement stmt = null, stmt1 = null;
        ResultSet rs = null, rs1 = null;
        List<Produto> produtos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM produto where nome = ? AND tamanho = ? AND idCategoria = ?");
            stmt1 = con.prepareStatement("SELECT * FROM produto where nome = ? AND tamanho = ? AND idCategoria = ?");
            stmt.setString(1, nome1);
            stmt.setString(2,tamanho);
            stmt.setInt(3, categoria);
            stmt1.setString(1, nome2);
            stmt1.setString(2,tamanho);
            stmt1.setInt(3, categoria);
            rs = stmt.executeQuery();
            rs1 = stmt1.executeQuery();
            
            while (rs.next()&& rs1.next()) {
                
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome")+" / " +rs1.getString("nome"));
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

    public List<Produto> readTamanho(String tamanho) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM produto where tamanho like ?");
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
    
    
    
    public List<Produto> read() {
//Prepara o Sql
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //Declaração de um lista
        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto ");
            //Query faz as consultas no banco e coloca dentro do ResultSet
            rs = stmt.executeQuery();

            //  Faz a consulta ate o ultimo valor
            while (rs.next()) {

                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setNome(rs.getString("nome") );
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
    public void create(Produto p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO produto (idCategoria, nome,tamanho,preco)VALUES(?,?,?,?)");
            stmt.setInt(1, p.getIdCategoria());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getTamanho());
            stmt.setDouble(4, p.getPreco());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Produto> readForNome(String nome, int idCategoria) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> produtos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE nome LIKE ? and idCategoria=?");
            stmt.setString(1, "%" + nome + "%");
            stmt.setInt(2, idCategoria);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setNome(rs.getString("nome") );
                produto.setTamanho(rs.getString("tamanho"));
                produto.setPreco(rs.getDouble("preco"));
                //Add os valores dentro da lista
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return produtos;

    }

    public void update(Produto p) {

        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE produto SET nome = ?,tamanho = ?, preco = ? WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTamanho());
            stmt.setDouble(3, p.getPreco());
            stmt.setInt(4, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Produto p) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE id = ?");
            stmt.setInt(1, p.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    
}
