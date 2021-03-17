/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_ciaclinic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author guima
 */
public class ClinicaDao {
    public String consultarrr(String login, String senha) {
        String autenticado = "";
        String sql;
        try {
            Connection conn = Conecta.getConexao();

            sql = "SELECT * FROM funcionario WHERE Loguin=? and senha=?";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            

            ResultSet rs;
            rs = ps.executeQuery();

            if (rs.next()) {
                autenticado = rs.getString("situacao");
            } else {
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return autenticado;
    }
    public boolean consultarr(String login, String senha) {
        boolean autenticado = false;
        String sql;
        try {
            Connection conn = Conecta.getConexao();

            sql = "SELECT Loguin,senha FROM funcionario WHERE Loguin=? and senha=?";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);

            ResultSet rs;
            rs = ps.executeQuery();

            if (rs.next()) {
                autenticado = true;
            } else {
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return autenticado;
    }
    public String consultar(String login, String senha) {
        String autenticado = null;
        String sql;
        try {
            Connection conn = Conecta.getConexao();

            sql = "SELECT loguin,senha,cargo FROM funcionario WHERE loguin=? and senha=?";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            
            ResultSet rs;
            
            rs = ps.executeQuery();

            if (rs.next()) {
                autenticado = rs.getString("cargo");
                
                
            } else {
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return autenticado;
    }
    public String consultarnome(String login, String senha) {
        String autenticado = null;
        String sql;
        try {
            Connection conn = Conecta.getConexao();

            sql = "SELECT loguin,senha,nome FROM funcionario WHERE loguin=? and senha=?";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            
            ResultSet rs;
            
            rs = ps.executeQuery();

            if (rs.next()) {
                autenticado = rs.getString("nome");
                
                
            } else {
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return autenticado;
    }
    public String gravarEntrada(Entrada_Saida ex) {
        String resp="";
        try{
            Connection conn = Conecta.getConexao();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO funce (id,Data,nome) VALUES (?,?,(select nome from funcionario where loguin=?))");
                        
                        ps.setString(1, ex.getLogin());
                        ps.setTimestamp(2, ex.getDate());
                        ps.setString(3, ex.getLogin());
                    ps.executeUpdate();

                    ps.close();
                    conn.close();
            resp="ok";
        }catch(Exception e){
            
        }
        return resp;
    }
    public String gravarSaida(Entrada_Saida ex) {
        String resp="";
        try{
            Connection conn = Conecta.getConexao();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO funcs (id,date,nome) VALUES (?,?,(select nome from funcionario where loguin=?))");
                        ps.setString(1, ex.getLogin());
                        ps.setTimestamp(2, ex.getDate());
                        ps.setString(3, ex.getLogin());
                    ps.executeUpdate();

                    ps.close();
                    conn.close();
            resp="ok";
        }catch(Exception e){
            
        }
        return resp;
    }
    
    public ArrayList<Medico> listarFunc() {
        ArrayList lista = new ArrayList<Medico>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT especialidade  FROM  funcionario where cargo=? and situacao =?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "Medico");
            pstmt.setString(2, "Contratado");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Medico a = new Medico();
                a.setEspecialidade(rs.getString("especialidade"));
                lista.add(a);
            }
        } catch (Exception e) {
            return null;

        }
        return lista;
    }
    public ArrayList<Medico> listarFunc2() {
        ArrayList lista = new ArrayList<Medico>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT nome FROM funcionario where cargo = ? and situacao = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "Medico");
            pstmt.setString(2, "Contratado");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Medico a = new Medico();
                a.setNome(rs.getString("nome"));
                lista.add(a);
            }
        } catch (Exception e) {
            return null;

        }
        return lista;
    }
    public ArrayList<Medico> listarFunc5(String especialidade) {
        ArrayList lista = new ArrayList<Consulta>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT  nome FROM funcionario WHERE especialidade=? and cargo = ? and situacao = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, especialidade);
            pstmt.setString(2, "Medico");
            pstmt.setString(3, "Contratado");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Medico a = new Medico();
                a.setNome(rs.getString("nome"));
                lista.add(a);
            }
        } catch (Exception e) {
            return null;

        }
        return lista;
    }
    //Partes de Consultas 
    public String gravav(Consulta cp) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO consulta(RG,nome,data,hora,idade,tipo,especialidade,medico,valor) VALUES(?,?,?,?,?,?,?,?,?) ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cp.getRg());
            pstmt.setString(2, cp.getNome());
            pstmt.setString(3, cp.getData());
            pstmt.setString(4, cp.getHora());
            pstmt.setString(5, cp.getIdade());
            pstmt.setString(6, cp.getTipo());
            pstmt.setString(7, cp.getEspecialidade());
            pstmt.setString(8, cp.getMedico());
            pstmt.setFloat(9, cp.getValor());
            System.out.print(pstmt.toString());
            int retorno = pstmt.executeUpdate();
            pstmt.close();
            con.close();
            resp = "ok";
        } catch (Exception e) {
            resp = e.getMessage();

        }
        return resp;
    }
    public String updateConsulta(Consulta cp) {

        String sqlUpdate = "UPDATE consulta SET RG = ? , nome = ? , data = ? , hora = ? , idade = ? , tipo = ? , especialidade = ?, medico = ?,valor=? WHERE RG = ? ";
        String resp = "";
        try {
            Connection conn = Conecta.getConexao();
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setString(1, cp.getRg());
            pstmt.setString(2, cp.getNome());
            pstmt.setString(3, cp.getData());
            pstmt.setString(4, cp.getHora());
            pstmt.setString(5, cp.getIdade());
            pstmt.setString(6, cp.getTipo());
            pstmt.setString(7, cp.getEspecialidade());
            pstmt.setString(8, cp.getMedico());
            pstmt.setFloat(9, cp.getValor());
            pstmt.setString(10, cp.getRg());
            int rowAffected = pstmt.executeUpdate();
            resp ="ok";
            System.out.print(pstmt.toString());
            conn.commit();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {

        }
        return resp;
    }
    public ArrayList<Consulta> listarFunc6(String RG) {
        ArrayList lista = new ArrayList<Consulta>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM consulta WHERE RG = ? ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, RG);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Consulta a = new Consulta();
                a.setRg(rs.getString("RG"));
                a.setNome(rs.getString("nome"));
                a.setData(rs.getString("data"));
                a.setHora(rs.getString("hora"));
                a.setIdade(rs.getString("idade"));
                a.setTipo(rs.getString("tipo"));
                a.setEspecialidade(rs.getString("especialidade"));
                a.setMedico(rs.getString("Medico"));
                a.setValor(rs.getFloat("valor"));
                a.setId(rs.getInt("id"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
    public ArrayList<Consulta> listarFunc12() {
        ArrayList lista = new ArrayList<Consulta>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM consulta ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Consulta a = new Consulta();
                a.setRg(rs.getString("RG"));
                a.setNome(rs.getString("nome"));
                a.setData(rs.getString("data"));
                a.setHora(rs.getString("hora"));
                a.setIdade(rs.getString("idade"));
                a.setTipo(rs.getString("tipo"));
                a.setEspecialidade(rs.getString("especialidade"));
                a.setMedico(rs.getString("Medico"));
                a.setValor(rs.getFloat("valor"));
                a.setId(rs.getInt("id"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
    public ArrayList<Consulta> listarFunc7(String especialidade) {
        ArrayList lista = new ArrayList<Consulta>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM consulta WHERE especialidade = ? ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, especialidade);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Consulta a = new Consulta();
                a.setRg(rs.getString("RG"));
                a.setNome(rs.getString("nome"));
                a.setData(rs.getString("data"));
                a.setHora(rs.getString("hora"));
                a.setIdade(rs.getString("idade"));
                a.setTipo(rs.getString("tipo"));
                a.setEspecialidade(rs.getString("especialidade"));
                a.setMedico(rs.getString("Medico"));
                a.setValor(rs.getFloat("valor"));
                a.setId(rs.getInt("id"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
    public ArrayList<Consulta> listarFunc8(String Medico) {
        ArrayList lista = new ArrayList<Consulta>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM consulta WHERE Medico = ? ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Medico);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Consulta a = new Consulta();
                a.setRg(rs.getString("RG"));
                a.setNome(rs.getString("nome"));
                a.setData(rs.getString("data"));
                a.setHora(rs.getString("hora"));
                a.setIdade(rs.getString("idade"));
                a.setTipo(rs.getString("tipo"));
                a.setEspecialidade(rs.getString("especialidade"));
                a.setMedico(rs.getString("Medico"));
                a.setValor(rs.getFloat("valor"));
                a.setId(rs.getInt("id"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
    public float valores(String especialidade) {
        float autenticado = 0f;
        String sql;
        try {
            Connection conn = Conecta.getConexao();

            sql = "SELECT valor FROM valores WHERE especialidade= ?";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, especialidade);
            
            
            ResultSet rs;
            
            rs = ps.executeQuery();
    
            if (rs.next()) {
                autenticado = rs.getFloat("valor");
                
                
            } else {
                ps.close();
                System.out.print(autenticado);
                return autenticado;
               
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return autenticado;
    }
    public String deletev(String id) {
        String sql = "DELETE FROM consulta WHERE id = ?";
        String resp = "";
        try (Connection conn = Conecta.getConexao();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
            resp = "ok";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resp;
    }
    //Tela medico
    public String gravap(Paciente cp) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO paciente(RG,nome,idade,alergia,descricao,sexo,doenca,medico,especialidade) VALUES(?,?,?,?,?,?,?,?,?) ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cp.getRg());
            pstmt.setString(2, cp.getNome());
            pstmt.setString(3, cp.getIdade());
            pstmt.setString(4, cp.getAlergia());
            pstmt.setString(5, cp.getDescricao());
            pstmt.setString(6, cp.getSexo());
            pstmt.setString(7, cp.getDiagnostico());
            pstmt.setString(8, cp.getMedico());
            pstmt.setString(9, cp.getEspecialidade());
            System.out.print(pstmt.toString());
            int retorno = pstmt.executeUpdate();
            pstmt.close();
            con.close();
            resp = "ok";
        } catch (Exception e) {
            resp = e.getMessage();

        }
        return resp;
    }
    public ArrayList<Paciente> listarFunc9(String especialidade) {
        ArrayList lista = new ArrayList<Consulta>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM paciente WHERE especialidade = ? ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, especialidade);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Paciente a =new Paciente();
                a.setRg(rs.getString("RG"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getString("idade"));
                a.setEspecialidade(rs.getString("especialidade"));
                a.setMedico(rs.getString("Medico"));
                a.setSexo(rs.getString("sexo"));
                a.setDiagnostico(rs.getString("doenca"));
                a.setAlergia(rs.getString("alergia"));
                 a.setDescricao(rs.getString("descricao"));
                
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
    public ArrayList<Paciente> listarFunc10(String Medico) {
        ArrayList lista = new ArrayList<Consulta>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM paciente WHERE Medico = ? ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, Medico);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Paciente a =new Paciente();
                a.setRg(rs.getString("RG"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getString("idade"));
                a.setEspecialidade(rs.getString("especialidade"));
                a.setMedico(rs.getString("Medico"));
                a.setSexo(rs.getString("sexo"));
                a.setDiagnostico(rs.getString("doenca"));
                a.setAlergia(rs.getString("alergia"));
                 a.setDescricao(rs.getString("descricao"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
    public ArrayList<Paciente> listarFunc11(String RG) {
        ArrayList lista = new ArrayList<Consulta>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM paciente WHERE RG = ? ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, RG);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Paciente a =new Paciente();
                a.setRg(rs.getString("RG"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getString("idade"));
                a.setEspecialidade(rs.getString("especialidade"));
                a.setMedico(rs.getString("Medico"));
                a.setSexo(rs.getString("sexo"));
                a.setDiagnostico(rs.getString("doenca"));
                a.setAlergia(rs.getString("alergia"));
                 a.setDescricao(rs.getString("descricao"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
    //Tela gerente
    public String gravae(String espec,float valor) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO valores(especialidade,valor) VALUES(?,?) ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, espec);
            pstmt.setFloat(2, valor);
            System.out.print(pstmt.toString());
            int retorno = pstmt.executeUpdate();
            pstmt.close();
            con.close();
            resp = "ok";
        } catch (Exception e) {
            resp = e.getMessage();

        }
        return resp;
    }
     public String gravaf(Funcionario f,String situacao) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO funcionario(rg,nome,idade,loguin,senha,salario,email,numeroTel,numeroCarteira,sexo,cargo,especialidade,situacao) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, f.getRg());
            pstmt.setString(2, f.getNome());
            pstmt.setString(3, f.getIdade());
            pstmt.setString(4, f.getLogin());
            pstmt.setString(5, f.getSenha());
            pstmt.setFloat(6, f.getSalario());
            pstmt.setString(7, f.getEmail());
            pstmt.setString(8, f.getNumero());
            pstmt.setString(9, f.getNumerocart());
            pstmt.setString(10, f.getSexo());
            pstmt.setString(11, f.getCargo());
            pstmt.setString(12, f.getEspecialidade());
            pstmt.setString(13, situacao);
            System.out.print(pstmt.toString());
            int retorno = pstmt.executeUpdate();
            pstmt.close();
            con.close();
            resp = "ok";
        } catch (Exception e) {
            resp = e.getMessage();

        }
        return resp;
    }
     public String gravaes(String espc,String nome) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO especialidade(especialidade,nome) VALUES(?,?) ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, espc);
            pstmt.setString(2, nome);
            System.out.print(pstmt.toString());
            int retorno = pstmt.executeUpdate();
            pstmt.close();
            con.close();
            resp = "ok";
        } catch (Exception e) {
            resp = e.getMessage();

        }
        return resp;
    }
     public ArrayList<Medico> listarFunc13() {
        ArrayList lista = new ArrayList<Medico>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT especialidade  FROM  valores";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Medico a = new Medico();
                a.setEspecialidade(rs.getString("especialidade"));
                lista.add(a);
            }
        } catch (Exception e) {
            return null;

        }
        return lista;
    }
     public ArrayList<Funcionario> listarFunc14(String RG) {
        ArrayList lista = new ArrayList<Funcionario>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM funcionario WHERE RG = ? and situacao=?  ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, RG);
            pstmt.setString(2, "Contratado");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Funcionario a = new Funcionario();
                a.setRg(rs.getString("RG"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getString("idade"));
                a.setLogin(rs.getString("loguin"));
                a.setSenha(rs.getString("senha"));
                a.setSalario(rs.getFloat("salario"));
                a.setEmail(rs.getString("email"));
                a.setNumero(rs.getString("numeroTel"));
                a.setNumerocart(rs.getString("numeroCarteira"));
                a.setSexo(rs.getString("sexo"));
                a.setCargo(rs.getString("cargo"));
                a.setEspecialidade(rs.getString("especialidade"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
     public ArrayList<Funcionario> listarFunc21() {
        ArrayList lista = new ArrayList<Funcionario>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM Funcionario where situacao=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
             pstmt.setString(1, "Contratado");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Funcionario a = new Funcionario();
                a.setRg(rs.getString("RG"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getString("idade"));
                a.setLogin(rs.getString("loguin"));
                a.setSenha(rs.getString("senha"));
                a.setSalario(rs.getFloat("salario"));
                a.setEmail(rs.getString("email"));
                a.setNumero(rs.getString("numeroTel"));
                a.setNumerocart(rs.getString("numeroCarteira"));
                a.setSexo(rs.getString("sexo"));
                a.setCargo(rs.getString("cargo"));
                a.setEspecialidade(rs.getString("especialidade"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
     public ArrayList<Funcionario> listarFunc15(String sexo) {
        ArrayList lista = new ArrayList<Funcionario>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM funcionario WHERE sexo = ? and situacao=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, sexo);
            pstmt.setString(2, "Contratado");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Funcionario a = new Funcionario();
                a.setRg(rs.getString("RG"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getString("idade"));
                a.setLogin(rs.getString("loguin"));
                a.setSenha(rs.getString("senha"));
                a.setSalario(rs.getFloat("salario"));
                a.setEmail(rs.getString("email"));
                a.setNumero(rs.getString("numeroTel"));
                a.setNumerocart(rs.getString("numeroCarteira"));
                a.setSexo(rs.getString("sexo"));
                a.setCargo(rs.getString("cargo"));
                a.setEspecialidade(rs.getString("especialidade"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
     public ArrayList<Funcionario> listarFunc16(String cargo) {
        ArrayList lista = new ArrayList<Funcionario>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM funcionario WHERE cargo= ? and situacao=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cargo);
            pstmt.setString(2, "Contratado");
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Funcionario a = new Funcionario();
                a.setRg(rs.getString("RG"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getString("idade"));
                a.setLogin(rs.getString("loguin"));
                a.setSenha(rs.getString("senha"));
                a.setSalario(rs.getFloat("salario"));
                a.setEmail(rs.getString("email"));
                a.setNumero(rs.getString("numeroTel"));
                a.setNumerocart(rs.getString("numeroCarteira"));
                a.setSexo(rs.getString("sexo"));
                a.setCargo(rs.getString("cargo"));
                a.setEspecialidade(rs.getString("especialidade"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
     public String deleteF(String id) {
        String sql = "UPDATE funcionario SET situacao = ? WHERE rg = ? ";
        String resp = "";
        try (Connection conn = Conecta.getConexao();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, "Demitido");
            pstmt.setString(2, id);
            // execute the delete statement
            pstmt.executeUpdate();
            resp = "ok";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resp;
    }
     public String consultarcargo(String rg) {
        String autenticado = null;
        String sql;
        try {
            Connection conn = Conecta.getConexao();

            sql = "SELECT * FROM funcionario WHERE rg=? ";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, rg);
            
            
            ResultSet rs;
            
            rs = ps.executeQuery();

            if (rs.next()) {
                autenticado = rs.getString("cargo");
                
                
            } else {
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return autenticado;
    }
     //Estoque
     public String gravaprodu(String id,String nome,String categoria) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO produto(id,Nome,Categoria) VALUES(?,?,?) ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, nome);
             pstmt.setString(3, categoria);
           
            System.out.print(pstmt.toString());
            int retorno = pstmt.executeUpdate();
            pstmt.close();
            con.close();
            resp = "ok";
        } catch (Exception e) {
            resp = e.getMessage();

        }
        return resp;
    }
     public ArrayList<Produtos> listarFunc17() {
        ArrayList lista = new ArrayList<Produtos>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM produto ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Produtos a = new Produtos();
                a.setId(rs.getString("id"));
                a.setNome(rs.getString("nome"));
                a.setCategoria(rs.getString("categoria"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
     public String gravadecla(String id,String nome,String categoria,int qtd,String mes,float preco) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO declaracao(id,Nome,Categoria,quantidade,mes,preco) VALUES(?,?,?,?,?,?) ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, nome);
             pstmt.setString(3, categoria);
             pstmt.setInt(4, qtd);
            pstmt.setString(5, mes);
             pstmt.setFloat(6, preco);
           
            System.out.print(pstmt.toString());
            int retorno = pstmt.executeUpdate();
            pstmt.close();
            con.close();
            resp = "ok";
        } catch (Exception e) {
            resp = e.getMessage();

        }
        return resp;
    }
     public String gravaestoque(String id,String nome,String categoria,int qtd) {
        String resp = "";
        try {
            Connection con = Conecta.getConexao();
            String sql = "INSERT INTO estoque(id,Nome,Categoria,quantidade) VALUES(?,?,?,?) ";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, nome);
             pstmt.setString(3, categoria);
             pstmt.setInt(4, qtd);
           
            System.out.print(pstmt.toString());
            int retorno = pstmt.executeUpdate();
            pstmt.close();
            con.close();
            resp = "ok";
        } catch (Exception e) {
            resp = e.getMessage();

        }
        return resp;
    }
     public String updateestado(String id, int qtd,String nome) {

        String sqlUpdate = "UPDATE estoque SET quantidade = ? WHERE id = ? and nome =  ? ";
        String resp = "";
        try {
            Connection conn = Conecta.getConexao();
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setInt(1, qtd);
            pstmt.setString(2, id);
            pstmt.setString(3, nome);
            
            
            int rowAffected = pstmt.executeUpdate();
            System.out.print(pstmt.toString());
            conn.commit();
            pstmt.close();
            conn.close();
            resp =  "ok";
        } catch (SQLException ex) {

        }
        return resp;
    }
     public int pegar(String id,String nome) {
        int autenticado = 0;
        String sql;
        try {
            Connection conn = Conecta.getConexao();

            sql = "SELECT quantidade FROM estoque WHERE id= ? and nome = ?";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, nome);
            

            ResultSet rs;
            rs = ps.executeQuery();
            if (rs.next()) {
                autenticado = rs.getInt("quantidade");
            } else {
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return autenticado;
    }
     public ArrayList<Produtos> listarFunc18(String id) {
        ArrayList lista = new ArrayList<Produtos>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM estoque where id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
             pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Produtos a = new Produtos();
                a.setId(rs.getString("id"));
                a.setNome(rs.getString("nome"));
                a.setCategoria(rs.getString("categoria"));
                a.setQuantidade(rs.getInt("quantidade"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
      public ArrayList<Produtos> listarFunc22(String mes) {
        ArrayList lista = new ArrayList<Produtos>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM declaracao where mes = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
             pstmt.setString(1, mes);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Produtos a = new Produtos();
                a.setId(rs.getString("id"));
                a.setPreco(rs.getFloat("preco"));
                a.setNome(rs.getString("nome"));
                a.setMes(rs.getString("mes"));
                a.setQuantidade(rs.getInt("quantidade"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
     //controle de entrada e saida
     public ArrayList<Entrada_Saida> listarFunc19() {
        ArrayList lista = new ArrayList<Entrada_Saida>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM funcE";
            PreparedStatement pstmt = con.prepareStatement(sql);
             
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Entrada_Saida a = new Entrada_Saida();
                a.setLogin(rs.getString("id"));
                a.setDate(rs.getTimestamp("Data"));
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
     public ArrayList<Entrada_Saida> listarFunc20() {
        ArrayList lista = new ArrayList<Entrada_Saida>();

        try {
            Connection con = Conecta.getConexao();
            String sql = "SELECT * FROM funcS";
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Entrada_Saida a = new Entrada_Saida();
                a.setLogin(rs.getString("id"));
                a.setDate(rs.getTimestamp("date"));
                
                
                lista.add(a);
            }
        } catch (Exception e) {
             System.out.print(e.toString());
            return null;
        }
        return lista;
    }
     public float pegar2() {
        int autenticado = 0;
        String sql;
        try {
            Connection conn = Conecta.getConexao();

            sql = "SELECT sum(salario) FROM funcionario where situacao=?";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, "Contratado");

            ResultSet rs;
            rs = ps.executeQuery();
            if (rs.next()) {
                autenticado = rs.getInt("sum(salario)");
            } else {
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return autenticado;
    }
     public float pegar3(String mes) {
        float autenticado = 0f;
        String sql;
        try {
            Connection conn = Conecta.getConexao();

            sql = "SELECT sum(preco) FROM declaracao WHERE mes= ?";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, mes);
            

            ResultSet rs;
            rs = ps.executeQuery();
            if (rs.next()) {
                autenticado = rs.getFloat("Sum(preco)");
            } else {
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return autenticado;
    }
     public float pegar4() {
        float autenticado = 0f;
        String sql;
        try {
            Connection conn = Conecta.getConexao();

            sql = "SELECT sum(valor) FROM consulta";
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            
            

            ResultSet rs;
            rs = ps.executeQuery();
            if (rs.next()) {
                autenticado = rs.getFloat("Sum(valor)");
            } else {
                ps.close();
                return autenticado;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return autenticado;
    }
     public String updateStatus(String rg,String nome,String situacao) {
        String sql = "UPDATE funcionario SET situacao = ? WHERE rg = ? and nome = ?";
        String resp = "";
        try (Connection conn = Conecta.getConexao();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, situacao);
            pstmt.setString(2, rg);
            pstmt.setString(3, nome);
            // execute the delete statement
            pstmt.executeUpdate();
            resp = "ok";

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resp;
    }
}
