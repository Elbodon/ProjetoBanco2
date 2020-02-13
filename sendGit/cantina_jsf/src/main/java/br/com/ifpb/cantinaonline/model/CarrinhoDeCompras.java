package br.com.ifpb.cantinaonline.model;

import java.io.Serializable;

public class CarrinhoDeCompras implements Serializable {

    private int cod_produto;
    private int quantidade;
    private double total;

    public CarrinhoDeCompras() { }

    public CarrinhoDeCompras(int cod_produto, int quantidade, double total) {
        this.cod_produto = cod_produto;
        this.quantidade = quantidade;
        this.total = total;
    }

    public int getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(int cod_produto) {
        this.cod_produto = cod_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
