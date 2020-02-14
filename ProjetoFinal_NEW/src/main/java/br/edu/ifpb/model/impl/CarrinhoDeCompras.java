package br.edu.ifpb.model.impl;

import java.io.Serializable;

public class CarrinhoDeCompras implements Serializable {

    private int codigo;
    private int quantidade;
    private double total;

    public CarrinhoDeCompras() { }

    public CarrinhoDeCompras(int codigo, int quantidade, double total) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.total = total;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
