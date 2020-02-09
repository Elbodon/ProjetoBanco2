package br.com.ifpb.cantinaonline.control;

import br.com.ifpb.cantinaonline.model.Usuario;
import br.com.ifpb.cantinaonline.model.dao.UsuarioDAOBD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/cadastroservlet")
public class CadastroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Usuario usuario = new Usuario(req.getParameter("nomeC"),req.getParameter("nomeU"),
                LocalDate.parse(req.getParameter("data")),req.getParameter("email"),req.getParameter("cidade"),
                req.getParameter("bairro"), req.getParameter("rua"),req.getParameter("senha"),
                req.getParameter("telefone"),req.getParameter("funcao"));

        //String[] funcaoDesempenhada = req.getParameterValues("funcao");

        UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();

        try {

            usuarioDAOBD.adicionar(usuario);

        } catch (SQLException e) {
            System.out.println(usuario.toString());
            resp.sendError(400);
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.getException();
        }
    }
}
