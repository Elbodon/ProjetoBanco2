package br.edu.ifpb.view.mbeans;


import br.edu.ifpb.model.dao.ProdutoDAOBD;
import br.edu.ifpb.model.dao.ProdutoDAOMongo;
import br.edu.ifpb.model.impl.Produto;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable{

    public enum ProdutoState { LIST, CREATE, UPDATE, REMOVE }
    private ProdutoState currentState;

    private Produto produto;
    private List<Produto> produtos = new ArrayList<>();
    ProdutoDAOBD produtoDAOBD = new ProdutoDAOBD();
    ProdutoDAOMongo produtoDAOMongo = new ProdutoDAOMongo();
    private List<SelectItem> produtosDisponiveis;

    @PostConstruct
    public void init() {
        try {
            this.produtos = produtoDAOBD.listarProduto();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.produtosDisponiveis = this.produtos.stream()
                .map( item -> new SelectItem(item, item.getId()))
                .collect(Collectors.toList());
        this.currentState = ProdutoState.LIST;
    }


    public void list() throws SQLException, ClassNotFoundException {
        this.produtos = produtoDAOBD.listarProduto();
        this.produtosDisponiveis = this.produtos.stream().map( item -> new SelectItem(item, item.getId())).collect(Collectors.toList());
        this.currentState = ProdutoState.LIST;
    }
    public void prepareCreate() {
        this.currentState = ProdutoState.CREATE;
        this.produto = new Produto();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
