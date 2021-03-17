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
public class Paciente {
    public String rg;
    public String nome;
    public String idade;
    public String alergia;
    public String descricao;
    public String diagnostico;
    public String sexo;
    public String medico;
    public String especialidade;

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    

    public Paciente(String rg, String nome, String idade, String alergia, String descricao, String diagnostico, String sexo, String medico, String especialidade) {
        this.rg = rg;
        this.nome = nome;
        this.idade = idade;
        this.alergia = alergia;
        this.descricao = descricao;
        this.diagnostico = diagnostico;
        this.sexo = sexo;
        this.medico = medico;
        this.especialidade = especialidade;
    }
    

    public Paciente() {
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

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
}
