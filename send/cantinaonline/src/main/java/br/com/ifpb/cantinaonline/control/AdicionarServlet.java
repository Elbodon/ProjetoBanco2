package br.com.ifpb.cantinaonline.control;

import br.com.ifpb.cantinaonline.model.Carrinho;
import br.com.ifpb.cantinaonline.model.Produto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/adicionar")
public class AdicionarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //System.out.println("****************ENTROU NO SERVLET****************");
        Carrinho carrinho = new Carrinho();
        String id = req.getParameter("id");
        String nome = req.getParameter("nome");
        String preco = req.getParameter("preco");
        String quantidade = req.getParameter("quantidade");

        Produto produto = new Produto(id,nome,preco,quantidade);
        carrinho.adiciona(produto);

        System.out.println(carrinho.toString());

        HttpSession session = req.getSession(true);
        session.setAttribute("toCarrinho", carrinho.getQuantidade());
        resp.sendRedirect("html/produtos.jsp");



    }
}
