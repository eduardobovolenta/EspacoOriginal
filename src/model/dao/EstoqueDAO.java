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
import model.bean.Estoque;


/**
 *
 * @author Samuelson
 */
public class EstoqueDAO {

    Connection con;
    
    public EstoqueDAO() {
        con = ConnectionFactory.getConnection();
    }
    
    public void create(Estoque e) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO estoque (id, nome,quantidade,date)VALUES (default, ?,?,?)");
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getQuantidade());
            stmt.setString(3, e.getData());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Estoque> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Estoque> estoques = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM estoque");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Estoque estoque = new Estoque();

                estoque.setId(rs.getInt("id"));
                estoque.setNome(rs.getString("nome"));
                estoque.setQuantidade(rs.getString("quantidade"));
                estoque.setData(rs.getString("date"));
                estoques.add(estoque);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return estoques;

    }
    public List<Estoque> readForNome(String nome) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Estoque> estoques = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM estoque WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

               Estoque estoque = new Estoque();

                estoque.setId(rs.getInt("id"));
                estoque.setNome(rs.getString("nome"));
                estoque.setQuantidade(rs.getString("quantidade"));
                estoque.setData(rs.getString("date"));
                estoques.add(estoque);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstoqueDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return estoques;

    }

    public void update(Estoque e) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE estoque SET nome = ? ,quantidade = ?,date = ? WHERE id = ?");
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getQuantidade());
            stmt.setString(3, e.getData());
            stmt.setInt(4, e.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    public void delete(Estoque e) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM estoque WHERE id = ?");
            stmt.setInt(1, e.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
