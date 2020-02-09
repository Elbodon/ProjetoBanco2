package br.com.ifpb.cantinaonline.model;

public class AcessoProduto {

    String id;
    String nome;
    String preco;
    String quantidade;

    public AcessoProduto(String id, String nome, String preco, String quantidade) {
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

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "AcessoProduto{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", preco='" + preco + '\'' +
                ", quantidade='" + quantidade + '\'' +
                '}';
    }
}
