package br.edu.ifpb.view.mbeans;



import br.edu.ifpb.model.dao.UsuarioDAOBD;
import br.edu.ifpb.model.impl.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.sql.SQLException;

@ManagedBean
@ViewScoped
public class CadastroBean {
    public enum EtapaCadastro {
        DADOS_PESSOAIS, ENDERECO
    }

    private EtapaCadastro etapaCadastro = EtapaCadastro.DADOS_PESSOAIS;

    UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();

    private Usuario usuario = new Usuario();

    public void salvarDadosPessoais() {
        System.out.println("Nome do usuário = "+usuario.getNomeCompleto());
        System.out.println("Idade do usuário = "+usuario.getNomeUsuario());
        System.out.println("E-mail do usuário = "+usuario.getFuncao());
        System.out.println("Login do usuário = "+usuario.getTelefone());
        System.out.println("Senha do usuário = "+usuario.getSenha());
        this.etapaCadastro = EtapaCadastro.ENDERECO;
    }

    public String salvarEndereco() {
        System.out.println("Usuário = "+ usuario.getNomeCompleto());
        System.out.println("Rua = "+ usuario.getEndereco().getRua());
        System.out.println("Número = "+ usuario.getEndereco().getNumero());
        System.out.println("Bairro = "+ usuario.getEndereco().getBairro());
        System.out.println("Cidade = "+ usuario.getEndereco().getCidade());

        try {
            usuarioDAOBD.adicionar(usuario);

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "usuario.xhtml";
    }

    public void voltar() {
        this.etapaCadastro = EtapaCadastro.DADOS_PESSOAIS;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EtapaCadastro getEtapaCadastro() {
        return etapaCadastro;
    }

    public void setEtapaCadastro(EtapaCadastro etapaCadastro) {
        this.etapaCadastro = etapaCadastro;
    }
}
