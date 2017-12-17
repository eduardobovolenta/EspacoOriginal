package model.dao;

import connection.ConnectionFactory;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Cliente;
import model.bean.ItensPedido;
import model.bean.Pedido;

public class PedidoDAO {
    
   Connection con;
    
    public PedidoDAO() {
        con = ConnectionFactory.getConnection();
    }
    //CRUD - Create Read Update Delete(Criar, Ler, Atualizar, Deletar)
    
    
    public void createPedido(String data, int idCliente) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;   
        ItensPedido iten = new ItensPedido();
        try {
            stmt = con.prepareStatement("INSERT INTO pedido (idCliente, data) values(?, ?)");
            stmt.setInt(1, idCliente);
            stmt.setString(2, data);
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();
                 iten.setCodPedido(resultSet.getInt("select max(cod) from pedido"));
            

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    
    
}
