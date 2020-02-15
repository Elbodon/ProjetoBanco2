package br.edu.ifpb.model.dao;

import br.edu.ifpb.model.conexaobanco.RedisFactory;
import br.edu.ifpb.model.impl.CarrinhoDeCompras;
import br.edu.ifpb.model.impl.Produto;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import java.sql.SQLException;
import java.util.ArrayList;

public class CarrinhoDAOBD implements CarrinhoDAO {

    private CarrinhoDeCompras carrinho;
    private RedisFactory redis;
    private Jedis jedis;
    private Gson gson;

    public CarrinhoDAOBD() throws SQLException, ClassNotFoundException {
        redis = new RedisFactory();
        jedis = redis.conexao();
        gson = new Gson();
    }

    @Override
    public boolean addProdutoCarrinho(Produto produto, int quantidade) throws SQLException {
        ArrayList<Produto> p = new ArrayList<>();
        p.add(produto);
        carrinho = new CarrinhoDeCompras();
        carrinho.setProdutos(p);
        carrinho.setQuantidade(quantidade);
        carrinho.setTotal(produto.getPreco() * quantidade);
        String json = gson.toJson(carrinho);
        jedis.setex("" + carrinho.getCodigo(), 300, json);
        return true;
    }

    @Override
    public boolean remProdutoCarrinho(Produto p) throws SQLException {
        ArrayList<Produto> produtos = carrinho.getProdutos();
        produtos.remove(p);
        carrinho.setProdutos(produtos);

        String json = gson.toJson(carrinho);
        jedis.setex("" + carrinho.getCodigo(), 300, json);
        return true;
    }

    @Override
    public ArrayList listarProdutosCarrinho(int codigo) throws SQLException {
        String resultado = jedis.get("" + codigo);
        CarrinhoDeCompras c = gson.fromJson(resultado, CarrinhoDeCompras.class);
        return c.getProdutos();
    }

}
