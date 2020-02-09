package br.com.ifpb.cantinaonline.control;

import br.com.ifpb.cantinaonline.model.dao.ProdutoDAOBD;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/mostrarCli")
public class MostrarProdutosCli extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("html/produtos.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProdutoDAOBD produtoDAOBD = new ProdutoDAOBD();
        try {
            HttpSession session = req.getSession(true);
            //produtoDAOBD = (ProdutoDAOBD) session.getAttribute("itens");

            ArrayList list = produtoDAOBD.listarProduto();
            session.setAttribute("itens", list);
            //req.setAttribute("itens", produtoDAOBD.listarProduto());
            resp.sendRedirect("html/produtos.jsp");
            //req.getRequestDispatcher("html/produtos.jsp").forward(req, resp);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
