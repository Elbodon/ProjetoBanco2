package br.edu.ifpb.view.mbeans;

import br.edu.ifpb.model.dao.CarrinhoDAO;
import br.edu.ifpb.model.dao.CarrinhoDAOBD;
import br.edu.ifpb.model.impl.CarrinhoDeCompras;
import br.edu.ifpb.model.impl.Produto;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class CarrinhoBean {
    private CarrinhoDAO carrinhoDAO;
    private CarrinhoDeCompras carrinho;
    private List<Produto> produtos;
    private String busca;

    @PostConstruct
    public void init() throws SQLException, ClassNotFoundException {
        carrinho = new CarrinhoDeCompras();
        carrinhoDAO = new CarrinhoDAOBD();
        produtos = new ArrayList<>();
    }

    public String adicionaOutroProduto() throws SQLException, ClassNotFoundException {
        return "listagemProdutos.xhtml";
    }

    public String adicionaProduto(Produto p, int quant) throws SQLException, ClassNotFoundException {
        carrinhoDAO.addProdutoCarrinho(p,quant);
        carrinho.setProdutos(carrinhoDAO.listarProdutosCarrinho());
        return "";
    }

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    public ArrayList<Produto> listarTodos() throws SQLException {
        return carrinho.getProdutos();
    }

    public CarrinhoDeCompras removeProduto(Produto p) throws SQLException {
        carrinho.getProdutos().remove(p);
        carrinhoDAO.remProdutoCarrinho(p);
        return carrinho;
    }

    public void apagaCarrinho() throws SQLException, ClassNotFoundException { carrinhoDAO = new CarrinhoDAOBD(); }

    public String vender(CarrinhoDeCompras) throws SQLException {
        return "";
    }

}
