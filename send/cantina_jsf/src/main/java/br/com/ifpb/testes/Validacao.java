package br.com.ifpb.testes;

import br.com.ifpb.cantinaonline.model.Usuario;
import br.com.ifpb.testes.exception.UsuarioException;

import java.sql.SQLException;

public interface Validacao {

    Usuario cadastrarUsuario(Usuario usuario) throws UsuarioException, SQLException, ClassNotFoundException;
    Usuario nomeRepetido(Usuario usuario) throws SQLException, ClassNotFoundException, UsuarioException;
}
