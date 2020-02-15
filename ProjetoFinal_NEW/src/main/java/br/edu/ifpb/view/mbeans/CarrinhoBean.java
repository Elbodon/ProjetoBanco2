package br.edu.ifpb.view.mbeans;

import br.edu.ifpb.model.dao.CarrinhoDAO;
import br.edu.ifpb.model.dao.CarrinhoDAOBD;
import br.edu.ifpb.model.impl.Produto;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class CarrinhoBean {
    private CarrinhoDAO carrinhoDAO;
    private List<Produto> produtos;
    private String busca;

    @PostConstruct
    public void init() throws SQLException, ClassNotFoundException {
        carrinhoDAO = new CarrinhoDAOBD();
        produtos = new ArrayList<>();
    }

    public String adicionaProduto(Produto p, int quant) throws SQLException, ClassNotFoundException {
        carrinhoDAO.addProdutoCarrinho(p,quant);
        return "";
    }

    public CarrinhoDAO getCarrinhoDAO() {
        return carrinhoDAO;
    }

    public List<Produto> listarTodos() throws SQLException {
        return carrinhoDAO.listarProdutosCarrinho();
    }

    public CarrinhoDAO removeProduto(Produto p) throws SQLException {
        carrinhoDAO.remProdutoCarrinho(p);
        return carrinhoDAO;
    }

    public void apagaCarrinho() throws SQLException, ClassNotFoundException { carrinhoDAO = new CarrinhoDAOBD(); }

}
