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
public class Medico {
    public String especialidade;
    public String nome;

    public Medico() {
    }

    public Medico(String especialidade, String nome) {
        this.especialidade = especialidade;
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
