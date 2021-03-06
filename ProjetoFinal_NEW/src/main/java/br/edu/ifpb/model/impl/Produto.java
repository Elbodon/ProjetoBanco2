package br.edu.ifpb.model.impl;

import org.bson.Document;
import java.time.ZoneId;

public class Produto {
    String id;
    String nome;
    double preco;
    Integer quantidade;

    public Produto(){

    }

    public Produto(String id, String nome, double preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }


    public Document toDocument(){
        return new Document("id", id)
                .append("nome", nome)
                .append("preco", preco)
                .append("quantidade", quantidade);
    }

    public Produto fromDocument(Document document){
        id = document.getString("cpf");
        nome = document.getString("nome");
        preco = document.getDouble("preco");
        quantidade = document.getInteger("quantidade");

        return this;
    }

}
