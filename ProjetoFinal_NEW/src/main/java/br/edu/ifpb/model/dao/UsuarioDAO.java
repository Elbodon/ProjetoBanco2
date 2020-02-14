package br.edu.ifpb.model.dao;


import br.edu.ifpb.model.impl.Acesso;
import br.edu.ifpb.model.impl.Usuario;

import java.sql.SQLException;

public interface UsuarioDAO {
    boolean adicionar(Usuario usuario) throws SQLException, ClassNotFoundException;
    boolean remover(Usuario usuario) throws SQLException, ClassNotFoundException;
    Acesso buscar(Acesso acesso) throws SQLException, ClassNotFoundException;
}
