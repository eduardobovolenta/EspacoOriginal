package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;
import model.bean.Cliente;

public class ClienteDAO {
    
   Connection con;
    
    public ClienteDAO() {
        con = ConnectionFactory.getConnection();
    }
    //CRUD - Create Read Update Delete(Criar, Ler, Atualizar, Deletar)
    public void create(Cliente c) {
        con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cliente (telefone,nome,endereco)VALUES(?,?,?)");
            stmt.setString(1, c.getTelefone());
            stmt.setString(2, c.getNome());
            stmt.setString(3, c.getEndereco());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
      public List<Cliente> readForDesc(String telefone) {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            //O like serve para buscar qualquer palavra semelhante
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE telefone LIKE ?");
            //O % serve para encontrar a palavra em qualquer lugar do texto
            stmt.setString(1, "%"+telefone+"%");
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                
              
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;

    }
      
      public boolean checkTelefone(String telefone){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        boolean check = false;

        Cliente cliente = new Cliente();
        try {
            
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE telefone LIKE ?"); 
            stmt.setString(1, "%"+telefone);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
                
                //cliente.setId(rs.getInt("id"));
                //cliente.setTelefone(rs.getString("telefone"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;
      }
      
      public void retornaCliente(String telefone){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Cliente cliente = new Cliente();
        try {
            
            stmt = con.prepareStatement("SELECT * FROM cliente WHERE telefone LIKE ?"); 
            stmt.setString(1, "%"+telefone);
            
            rs = stmt.executeQuery();

            if (rs.next()) {
                //cliente.setId(rs.getInt("id"));
                //cliente.setTelefone(rs.getString("telefone"));
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
 
      }
      
      
       public static String format(Object value) { 
        MaskFormatter mask; 
        try { 
        mask = new MaskFormatter("(##)#####-####"); 
        mask.setValueContainsLiteralCharacters(false); 
        return mask.valueToString(value); 
        } catch (ParseException e) { 
        throw new RuntimeException(e); 
        } 
    }
      
}
