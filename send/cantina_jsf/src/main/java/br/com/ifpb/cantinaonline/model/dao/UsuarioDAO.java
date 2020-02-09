package br.com.ifpb.cantinaonline.model.dao;

import br.com.ifpb.cantinaonline.model.Acesso;
import br.com.ifpb.cantinaonline.model.Usuario;

import java.sql.SQLException;

public interface UsuarioDAO {
    boolean adicionar(Usuario usuario) throws SQLException, ClassNotFoundException;
    boolean remover(Usuario usuario) throws SQLException, ClassNotFoundException;
    Acesso buscar(Acesso acesso) throws SQLException, ClassNotFoundException;
}
