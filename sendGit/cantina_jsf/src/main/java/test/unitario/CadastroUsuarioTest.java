package test.unitario;

import br.com.ifpb.cantinaonline.model.Endereco;
import br.com.ifpb.cantinaonline.model.Produto;
import br.com.ifpb.cantinaonline.model.Usuario;
import br.com.ifpb.testes.Validacao;
import br.com.ifpb.testes.ValidacaoPadrao;
import br.com.ifpb.testes.exception.CampoNuloException;
import br.com.ifpb.testes.exception.UsuarioException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class CadastroUsuarioTest {

    private Validacao validacao;

    @Before
    public void iniciou() {
        validacao = new ValidacaoPadrao();
        System.out.println("Instanciou validadorCEP");
    }

    @After
    public void parou() {
        System.out.println("Terminou o método de teste");
    }

    @Test(expected = UsuarioException.class)
    public void testarNomeValido() throws CampoNuloException, SQLException, ClassNotFoundException, UsuarioException {
        Usuario usuario = new Usuario("Daniel", "daniel123", 20,"daniel",
                "123","funcionario", new Endereco("Cidade", "Bairro","Rua",10));
       validacao.cadastrarUsuario(usuario);
    }

    @Test(expected = UsuarioException.class)
    public void nomeUsuariorepetido() throws SQLException, ClassNotFoundException, UsuarioException {
        Usuario usuario = new Usuario("João", "joao123", 29, "joao","40028922",
                "cliente", new Endereco("Cidade", "bairro","Rua",10));
        validacao.nomeRepetido(usuario);
        validacao.nomeRepetido(usuario);
    }

    @Test(expected = UsuarioException.class)
    public void telefoneRepetido() throws SQLException, ClassNotFoundException, UsuarioException {
        Usuario usuario = new Usuario("João", "j3", 29, "joao123","40028922",
                "cliente", new Endereco("Cidade", "bairro","Rua",10));
        validacao.telefoneRepetido(usuario);
        validacao.telefoneRepetido(usuario);

    }

    @Test(expected = UsuarioException.class)
    public void idadeInvalida() throws SQLException, ClassNotFoundException, UsuarioException{
        Usuario usuario = new Usuario("João", "j3", 0, "joa","40028922",
                "cliente", new Endereco("Cidade", "bairro","Rua",10));
        validacao.idadeZero(usuario);
    }

    @Test(expected = UsuarioException.class)
    public void numeroRuaInvalido() throws SQLException, ClassNotFoundException, UsuarioException{
        Usuario usuario = new Usuario("João", "j3", 30, "joa","40028922",
                "cliente", new Endereco("Cidade", "bairro","Rua",0));
        validacao.numeroRua(usuario);
    }





}
