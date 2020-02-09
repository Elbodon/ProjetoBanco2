package br.com.ifpb.cantinaonline.control;

import br.com.ifpb.cantinaonline.model.Produto;
import br.com.ifpb.cantinaonline.model.dao.ProdutoDAOBD;
import br.com.ifpb.cantinaonline.model.dao.UsuarioDAOBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/cadastroProduto")
public class CadastroProdutoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Produto produto = new Produto(req.getParameter("id"), req.getParameter("nome"), req.getParameter("preco"),
                req.getParameter("quantidade"));

        ProdutoDAOBD produtoDAOBD = new ProdutoDAOBD();

        try {

            produtoDAOBD.adicionarProduto(produto);
            System.out.println(produto);

        } catch (SQLException e) {
            System.out.println(produto.toString());
            resp.sendError(400);
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.getException();
        }
    }
}
