/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_ciaclinic;

/**
 *
 * @author guima
 */
public class Funcionario {
    public String rg;
    public String nome;
    public String idade;
    public String login;
    public String senha;
    public float salario;
    public String email;
    public String numero;
    public String numerocart;
    public String sexo;
    public String cargo;
    public String especialidade;

    public Funcionario() {
    }

    public Funcionario(String rg, String nome, String idade, String login, String senha, float salario, String email, String numero, String numerocart, String sexo, String cargo, String especialidade) {
        this.rg = rg;
        this.nome = nome;
        this.idade = idade;
        this.login = login;
        this.senha = senha;
        this.salario = salario;
        this.email = email;
        this.numero = numero;
        this.numerocart = numerocart;
        this.sexo = sexo;
        this.cargo = cargo;
        this.especialidade = especialidade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumerocart() {
        return numerocart;
    }

    public void setNumerocart(String numerocart) {
        this.numerocart = numerocart;
    }
    
}
