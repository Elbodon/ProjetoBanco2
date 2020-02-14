package br.edu.ifpb.view.mbeans;


import br.edu.ifpb.model.dao.ProdutoDAOBD;
import br.edu.ifpb.model.impl.Produto;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class BuscaBean {
    private ProdutoDAOBD produtoDAOBD;
    private List<Produto> produtos;
    private String busca;

    @PostConstruct
    public void init() {

        produtoDAOBD = new ProdutoDAOBD();

        produtos = new ArrayList<>();

    }

    public String buscaProdutos() throws SQLException, ClassNotFoundException {


        produtos = produtoDAOBD.buscarProduto(busca);
        return "buscaProduto.xhtml";
    }

    public ProdutoDAOBD getProdutoDAOBD() {
        return produtoDAOBD;
    }

    public void setProdutoDAOBD(ProdutoDAOBD produtoDAOBD) {
        this.produtoDAOBD = produtoDAOBD;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }
}