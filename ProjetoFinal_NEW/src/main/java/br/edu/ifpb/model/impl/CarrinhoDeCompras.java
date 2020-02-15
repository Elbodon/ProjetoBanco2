package br.edu.ifpb.model.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class CarrinhoDeCompras implements Serializable {

    private int codigo;
    private int quantidade;
    private ArrayList<Produto> produtos;
    private double total;

    public CarrinhoDeCompras() { }

    public CarrinhoDeCompras(int codigo, int quantidade, ArrayList<Produto> produtos, double total) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.produtos = produtos;
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

    public ArrayList<Produto> getProdutos() { return produtos; }

    public void setProdutos(ArrayList<Produto> produtos) { this.produtos = produtos; }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarrinhoDeCompras that = (CarrinhoDeCompras) o;
        return codigo == that.codigo &&
                quantidade == that.quantidade &&
                Double.compare(that.total, total) == 0 &&
                produtos.equals(that.produtos);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + this.quantidade;
        hash = 97 * hash + this.produtos.size();
        return hash;
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "codigo=" + codigo +
                ", quantidade=" + quantidade +
                ", produtos=" + produtos +
                ", total=" + total +
                '}';
    }
}
