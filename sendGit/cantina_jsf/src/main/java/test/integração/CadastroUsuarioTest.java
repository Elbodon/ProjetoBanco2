package test.integração;

import br.com.ifpb.cantinaonline.model.Endereco;
import br.com.ifpb.cantinaonline.model.Usuario;
import br.com.ifpb.cantinaonline.model.dao.UsuarioDAOBD;
import br.com.ifpb.testes.Validacao;
import br.com.ifpb.testes.ValidacaoPadrao;
import br.com.ifpb.testes.exception.UsuarioException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;

public class CadastroUsuarioTest {

    private Validacao validacao;
    private UsuarioDAOBD usuarioDAOBD;

    @Before
    public void setUp(){
       this.usuarioDAOBD = new UsuarioDAOBD();
    }

    @Test(expected = UsuarioException.class)
    public void usuarioValido() throws UsuarioException, SQLException, ClassNotFoundException {
        Usuario usuario = new Usuario("Daniel", "dnl", 20,"daniel",
                "12345678","funcionario", new Endereco("Cidade", "Bairro","Rua",10));
        //usuarioDAOBD.adicionar(usuario);
        validacao.cadastrarUsuario(usuario);
    }

    @Test(expected = UsuarioException.class)
    public void usuarioInvalido() throws UsuarioException, SQLException, ClassNotFoundException {
        Usuario usuario = new Usuario("", "das", 20,"daniel",
                "12345678","funcionario", new Endereco("Cidade", "Bairro","Rua",10));
        usuarioDAOBD.adicionar(usuario);
    }

}
