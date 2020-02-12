package br.com.ifpb.cantinaonline.controller;

import br.com.ifpb.cantinaonline.model.Produto;
import br.com.ifpb.cantinaonline.model.dao.ProdutoDAOBD;
import br.com.ifpb.cantinaonline.view.mbeans.ProdutoBean;

import javax.annotation.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.model.SelectItem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean
@ApplicationScoped
public class ProdutoController {
    private Produto prod = new Produto();
    private List<Produto> listaProdutos = new ArrayList<Produto>();
    private List<SelectItem> produtosDisponiveis;
    public enum ProdutoState { LIST, CREATE, UPDATE, REMOVE }
    private ProdutoBean.ProdutoState currentState;
    //private Integer id;

    public void addProduto(){
        listaProdutos.add(prod);
        this.prod = new Produto();
        prod.setQuantidade(prod.getQuantidade()-1);
    }

    public void list() throws SQLException, ClassNotFoundException {
        ProdutoDAOBD produtoDAOBD = new ProdutoDAOBD();
        this.listaProdutos = produtoDAOBD.listarProduto();
        this.produtosDisponiveis = this.listaProdutos.stream().map( item -> new SelectItem(item, item.getId())).collect(Collectors.toList());
        this.currentState = ProdutoBean.ProdutoState.LIST;
    }


    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public Produto getProd() {
        return prod;
    }

    public void setProd(Produto prod) {
        this.prod = prod;
    }

}
