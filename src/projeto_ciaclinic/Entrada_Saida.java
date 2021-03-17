/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_ciaclinic;

import java.sql.Timestamp;

/**
 *
 * @author guima
 */
public class Entrada_Saida {
    public String Login;
    public Timestamp date;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Entrada_Saida() {
    }

    public Entrada_Saida(String Login, Timestamp date) {
        this.Login = Login;
        this.date = date;
    }
    

   
    
    
    
}
