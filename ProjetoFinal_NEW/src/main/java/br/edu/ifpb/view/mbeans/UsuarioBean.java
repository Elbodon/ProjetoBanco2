package br.edu.ifpb.view.mbeans;


import br.edu.ifpb.model.dao.UsuarioDAOBD;
import br.edu.ifpb.model.impl.Usuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

;


@ManagedBean
@ViewScoped

public class UsuarioBean implements Serializable{
    public enum UsuarioState { LIST, CREATE, UPDATE, REMOVE }

    private UsuarioDAOBD usuarioDAOBD;

    private List<Usuario> usuarios;

    private List<SelectItem> usuariosDisponiveis;

    private Usuario usuario;

    private UsuarioState currentState;

    @ManagedProperty("#{loginBean.nomeUsuario}")
    private String nomeUsuario;

    public void list() throws SQLException, ClassNotFoundException {
        this.usuarios = usuarioDAOBD.listarUsuario();
        this.usuariosDisponiveis = this.usuarios.stream().map( item -> new SelectItem(item, item.getNomeUsuario())).collect(Collectors.toList());
        this.currentState = UsuarioState.LIST;

    }
    public void prepareCreate() {
        this.currentState = UsuarioState.CREATE;
        this.usuario = new Usuario();
    }
    public void prepareRemove() {
        this.currentState = UsuarioState.REMOVE;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
