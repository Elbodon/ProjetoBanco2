package br.com.ifpb.cantinaonline.view.mbeans;
;

import br.com.ifpb.cantinaonline.model.Usuario;
import br.com.ifpb.cantinaonline.model.dao.UsuarioDAOBD;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;



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
