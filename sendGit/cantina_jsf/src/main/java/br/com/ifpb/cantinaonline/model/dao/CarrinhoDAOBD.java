package br.com.ifpb.cantinaonline.model.dao;

import br.com.ifpb.cantinaonline.model.Produto;
import br.com.ifpb.cantinaonline.model.conexaoBanco.RedisFactory;
import redis.clients.jedis.Jedis;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarrinhoDAOBD implements CarrinhoDAO {

    private RedisFactory redis;

    @Override
    public boolean adicionarProduto(Produto produto) throws SQLException, ClassNotFoundException {
        Jedis jedis = redis.RedisFactory();
        return false;
    }

    @Override
    public boolean removerProduto(Produto produto) throws SQLException, ClassNotFoundException {
        Jedis jedis = redis.RedisFactory();
        return false;
    }

    @Override
    public ArrayList listarProdutos() throws SQLException, ClassNotFoundException {
        Jedis jedis = redis.RedisFactory();
        return null;
    }

}
