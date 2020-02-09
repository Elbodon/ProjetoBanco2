package br.com.ifpb.cantinaonline.model.dao;

import br.com.ifpb.cantinaonline.model.Acesso;
import br.com.ifpb.cantinaonline.model.Usuario;
import br.com.ifpb.cantinaonline.model.conexaoBanco.ConnectionFactory;
import br.com.ifpb.cantinaonline.model.dao.UsuarioDAO;

import java.sql.*;


public class UsuarioDAOBD implements UsuarioDAO {

    private ConnectionFactory conexao;

    public UsuarioDAOBD() {
        conexao = new ConnectionFactory();

    }
    @Override
    public boolean adicionar(Usuario usuario) throws SQLException, ClassNotFoundException {
        try(Connection connection = conexao.getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO usuario(nomecompleto,nomeusuario," +
                    "datanascimento,email,cidade,bairro,rua,senha,telefone,funcao) VALUES(?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1,usuario.getNomeCompleto());
            statement.setString(2,usuario.getNomeUsuario());
            statement.setDate(3, Date.valueOf(usuario.getDataNascimento()));
            statement.setString(4,usuario.getEmail());
            statement.setString(5,usuario.getCidade());
            statement.setString(6,usuario.getBairro());
            statement.setString(7,usuario.getRua());
            statement.setString(8,usuario.getSenha());
            statement.setString(9,usuario.getTelefone());
            statement.setString(10, usuario.getFuncao());
            return statement.executeUpdate()>0;
        }

    }

    @Override
    public boolean remover(Usuario usuario) throws SQLException, ClassNotFoundException {
        try(Connection connection = conexao.getConnection()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM usuario WHERE id = ?");
            statement.setString(1, usuario.getNomeUsuario());
            return statement.executeUpdate()>0;
        }
    }

    @Override
    public Acesso buscar(Acesso acesso) throws SQLException, ClassNotFoundException {
        try(Connection connection = conexao.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario " +
                    "WHERE nomeUsuario =? AND senha =?");
            statement.setString(1,acesso.getNomeUsuario());
            statement.setString(2, acesso.getSenha());
            ResultSet set = statement.executeQuery();
            if(set.next()){
                Acesso acesso3 = new Acesso(set.getString("nomeusuario"),
                        set.getString("senha"),set.getString("nomecompleto"),
                        set.getString("funcao"));
                return acesso3;
            }else{
                return null;
            }
        }
    }
}
