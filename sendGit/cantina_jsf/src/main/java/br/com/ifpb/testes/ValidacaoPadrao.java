package br.com.ifpb.testes;

import br.com.ifpb.cantinaonline.model.Usuario;
import br.com.ifpb.cantinaonline.model.dao.ProdutoDAOBD;
import br.com.ifpb.cantinaonline.model.dao.UsuarioDAOBD;
import br.com.ifpb.testes.exception.UsuarioException;

import java.sql.SQLException;

public class ValidacaoPadrao implements Validacao {

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) throws UsuarioException {
        UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();
        try {
            usuarioDAOBD.adicionar(usuario);
            usuarioDAOBD.adicionar(usuario);
        } catch (ClassNotFoundException e) {
            throw new UsuarioException("Não existe conexão com a base dados", e);
        } catch (SQLException e) {
            throw new UsuarioException("Não é possível cadastrar dois usuários iguais", e);
        } catch (NullPointerException e) {
            throw new UsuarioException("Não é possível cadastrar dois usuários iguais", e);
        }
        return usuario;
    }

    @Override
    public Usuario nomeRepetido(Usuario usuario) throws UsuarioException {
        UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();
        try {
            usuarioDAOBD.adicionar(usuario);
        } catch (ClassNotFoundException | SQLException e) {
            throw new UsuarioException("Não é permitido um usuário repetido",e);
        }
        return usuario;
    }

    @Override
    public Usuario telefoneRepetido(Usuario usuario) throws UsuarioException {
        UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();
        try {
            usuarioDAOBD.adicionar(usuario);
        } catch (ClassNotFoundException | SQLException e) {
            throw new UsuarioException("Telefone Repetido",e);
        }
        return usuario;
    }

    @Override
    public Usuario idadeZero(Usuario usuario) throws SQLException, ClassNotFoundException, UsuarioException {
        UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();
        try {
            usuarioDAOBD.adicionar(usuario);
        } catch (ClassNotFoundException | SQLException e) {
            throw new UsuarioException("Não é possível cadastrar usuário com idade zero!",e);
        }
        return usuario;
    }

    @Override
    public Usuario numeroRua(Usuario usuario) throws SQLException, ClassNotFoundException, UsuarioException {
        UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();
        try {
            usuarioDAOBD.adicionar(usuario);
        } catch (ClassNotFoundException | SQLException e) {
            throw new UsuarioException("Não é possível uma rua com numero zero!",e);
        }
        return usuario;
    }

    @Override
    public Usuario usuarioValidoInt(Usuario usuario) throws SQLException, ClassNotFoundException, UsuarioException {
        UsuarioDAOBD usuarioDAOBD = new UsuarioDAOBD();
        try {
            usuarioDAOBD.adicionar(usuario);
        } catch (ClassNotFoundException e) {
            throw new UsuarioException("Não foi possivel cadastrar", e);
        }
        catch (SQLException e) {
            throw new UsuarioException("Não é possível cadastrar", e);
        }
        return usuario;
    }


}
