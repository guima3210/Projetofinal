/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_ciaclinic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conecta {

    /**
     * Devolve a conexão com o banco de dados
     * @return 
     */
    public static Connection getConexao() {
        Connection con = null;

        try {
            //String serverName = "25.73.32.220";
            //String serverName = "192.168.0.10";
            String serverName = "127.0.0.1";
            String mydatabase = "Clinica";

            String username = "Teste";
            String password = "root";

            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado " + e.toString());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar o Banco de Dados " + e.toString());
        }

        return con;
    }
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {

        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(Conecta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
