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
public class Consulta {
    public String rg;
    public String nome;
    public String data;
    public String hora;
    public String idade;
    public String tipo;
    public String especialidade;
    public String medico;
    public float valor;
    public int id;
    public Consulta() {
    }

    public Consulta(String rg, String nome, String data, String hora, String idade, String tipo, String especialidade, String medico, float valor, int id) {
        this.rg = rg;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.idade = idade;
        this.tipo = tipo;
        this.especialidade = especialidade;
        this.medico = medico;
        this.valor = valor;
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }
    
}
