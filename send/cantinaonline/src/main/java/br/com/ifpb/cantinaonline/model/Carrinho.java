package br.com.ifpb.cantinaonline.model;

import java.util.ArrayList;
import java.util.List;


public class Carrinho {

    private List<Produto> itens = new ArrayList<>();
    protected int total = 0;
    private Integer quantidade = 0;

    public List adiciona(Produto produto){
        itens.add(produto);
        //int valor = total + Integer.parseInt(produto.getPreco());// setando o valor do carrinho;
        quantidade+=1;
        return itens;
    }

    public Integer getTotalDeItens() {
        return itens.size();
    }


    public List<Produto> getItens() {
        return itens;
    }

    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {

        this.total = total;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
}
