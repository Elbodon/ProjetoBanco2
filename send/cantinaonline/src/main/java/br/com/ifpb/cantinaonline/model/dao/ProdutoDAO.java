package br.com.ifpb.cantinaonline.model.dao;

import br.com.ifpb.cantinaonline.model.Produto;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProdutoDAO {
    boolean adicionarProduto(Produto produto) throws SQLException, ClassNotFoundException;
    boolean removerProduto(Produto produto) throws SQLException, ClassNotFoundException;
    boolean buscarProduto(Produto produto) throws SQLException, ClassNotFoundException;
    ArrayList listarProduto() throws SQLException, ClassNotFoundException;

}
