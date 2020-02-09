package br.com.ifpb.cantinaonline.model.dao;

import br.com.ifpb.cantinaonline.model.AcessoProduto;
import br.com.ifpb.cantinaonline.model.Produto;
import br.com.ifpb.cantinaonline.model.conexaoBanco.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;

public class ProdutoDAOBD implements ProdutoDAO {

    private ConnectionFactory conexao;

    public ProdutoDAOBD() {
        conexao = new ConnectionFactory();

    }

    @Override
    public boolean adicionarProduto(Produto produto) throws SQLException, ClassNotFoundException {
        try(Connection connection = conexao.getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO produto(id,nome," +
                    "preco,quantidade) VALUES(?,?,?,?)");
            statement.setString(1,produto.getId());
            statement.setString(2,produto.getNome());
            statement.setString(3,produto.getPreco());
            statement.setString(4,produto.getQuantidade());
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public boolean removerProduto(Produto produto) throws SQLException, ClassNotFoundException {
        try(Connection connection = conexao.getConnection()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM produto WHERE id = ?");
            statement.setString(1, produto.getId());
            return statement.executeUpdate()>0;
        }
    }
    @Override
    public boolean buscarProduto(Produto produto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList listarProduto() throws SQLException, ClassNotFoundException{
        try(Connection connection = conexao.getConnection()){
           PreparedStatement statement = connection.prepareStatement("SELECT * FROM produto");
           ResultSet set = statement.executeQuery();
           ArrayList arrayList = new ArrayList();

            while (set.next()){
                String id = set.getString("id");
                String nome = set.getString("nome");
                String preco = set.getString("preco");
                String quantidade = set.getString("quantidade");

                AcessoProduto acessoProduto = new AcessoProduto(id,nome,preco,quantidade);
                arrayList.add(acessoProduto);
            }

            return arrayList;

        }
    }
}
