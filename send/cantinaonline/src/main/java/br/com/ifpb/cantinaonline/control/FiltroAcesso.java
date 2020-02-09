package br.com.ifpb.cantinaonline.control;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FiltroAcesso implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("iniciou");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession sessao = request.getSession();
        if(sessao.getAttribute("usuarioLogado")!=null){
            System.out.println("Passei pelo filtro");
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            ((HttpServletResponse)servletResponse).sendRedirect("home.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
