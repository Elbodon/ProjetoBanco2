package br.edu.ifpb.view.mbeans;



import br.edu.ifpb.model.dao.UsuarioDAOBD;
import br.edu.ifpb.model.impl.Acesso;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@ManagedBean
@SessionScoped
public class LoginBean {
    private String nomeUsuario;
    private String senha;

    private Acesso usuarioLogado;

    public String efetuarLogin() throws SQLException, ClassNotFoundException {
        this.usuarioLogado = new Acesso(nomeUsuario,senha,"","");
        UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();

        if(usuarioDAOBD.buscar(usuarioLogado) != null){
            System.out.println(usuarioDAOBD.buscar(usuarioLogado));
            return "usuario.xhtml";
        } else {
            FacesMessage message = new FacesMessage("Login ou Senha incorretos", "Login ou Senha incorretos");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "";
        }

    }

    public String retornar() throws Exception{
        return "template.xhtml";
        
    }

    public String fazerLogout() {
        HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "login.xhtml";
    }

    public Acesso getUsuarioLogado(){
        return  usuarioLogado;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
