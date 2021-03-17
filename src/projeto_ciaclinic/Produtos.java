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
public class Produtos {
    public String id;
    public String nome;
    public String categoria;
    public int quantidade;
    public float preco;
    public String mes;

    public Produtos() {
    }

    public Produtos(String id, String nome, String categoria, int quantidade, float preco, String mes) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
        this.mes = mes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    
}
