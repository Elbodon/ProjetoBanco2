package br.com.ifpb.cantinaonline.control;

import br.com.ifpb.cantinaonline.model.Acesso;
import br.com.ifpb.cantinaonline.model.Usuario;
import br.com.ifpb.cantinaonline.model.dao.UsuarioDAO;
import br.com.ifpb.cantinaonline.model.dao.UsuarioDAOBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/acessopagina")
public class AcessoPaginaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Acesso acesso = new Acesso(req.getParameter("usuario"),req.getParameter("senha"),"",
                req.getParameter("funcao"));
        UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();
        try {
            Acesso ac = usuarioDAOBD.buscar(acesso);
            if(ac!=null){
                HttpSession session = req.getSession(true);
                session.setAttribute("usuarioLogado",ac);
                //req.getRequestDispatcher("html/usuario.jsp").forward(req,resp);

                String funcaoDesempenhada = req.getParameter("funcao");
                System.out.println(funcaoDesempenhada);
                switch (funcaoDesempenhada){
                    case "Cliente":
                        resp.sendRedirect("html/usuario.jsp");
                        break;
                    case "Funcionario":
                        resp.sendRedirect("html/usuarioFunc.jsp");
                        break;
                }
                System.out.println(ac.toString());
                //resp.sendRedirect("html/usuario.jsp");
            }

            else {
                resp.sendError(400,"Objeto NULO");
            }

        } catch (SQLException | ClassNotFoundException e) {
            resp.sendError(400);
        }
    }
}
