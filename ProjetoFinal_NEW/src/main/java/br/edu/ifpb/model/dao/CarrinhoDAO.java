package br.edu.ifpb.model.dao;

import br.edu.ifpb.model.impl.CarrinhoDeCompras;
import br.edu.ifpb.model.impl.Produto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CarrinhoDAO {

    boolean addProdutoCarrinho(Produto produto, int quantidade) throws SQLException;
    boolean remProdutoCarrinho(Produto p) throws SQLException;
    ArrayList listarProdutosCarrinho(int codigo) throws SQLException;

}
