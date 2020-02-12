package br.com.ifpb.cantinaonline.view.mbeans;



import br.com.ifpb.cantinaonline.model.Produto;
import br.com.ifpb.cantinaonline.model.dao.ProdutoDAOBD;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.sql.SQLException;

@ManagedBean
@ViewScoped
public class CadastroProdutoBean {

    ProdutoDAOBD produtoDAOBD= new ProdutoDAOBD();

    private Produto produto = new Produto();

    public String salvarProduto() {
        produto.getId();
        produto.getNome();
        produto.getPreco();
        produto.getQuantidade();

        try {
            produtoDAOBD.adicionarProduto(produto);
        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "sucesso.xhtml";
    }


    public Produto getProduto() {
        return produto;
    }

    public void setUsuario(Produto produto) {
        this.produto = produto;
    }

}
