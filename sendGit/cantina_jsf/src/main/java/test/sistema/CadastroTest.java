package test.sistema;

import br.com.ifpb.cantinaonline.model.dao.UsuarioDAOBD;
import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CadastroTest {

    private static ChromeDriverService service;
    private static WebDriver driver;
    private UsuarioDAOBD usuarioDAOBD;

    @BeforeClass
    public static void setUpTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/cantinaonline/cadastro.jsf");
    }

    @AfterClass
    public static void tearDownTest(){
        driver.quit();
    }

    @Test
    public void testaTituloDaPagina() throws InterruptedException {
        Thread.sleep(2000L);
        assertEquals("Cadastro de Usuario", driver.getTitle());
    }

    @Test
    public void cadastroTest() throws InterruptedException {

        WebElement element = driver.findElement(By.id("nome"));
        element.sendKeys("Daniel");
        element = driver.findElement(By.id("nomeUsuario"));
        element.sendKeys("dan");
        element = driver.findElement(By.id("idade"));
        element.sendKeys("20");
        element = driver.findElement(By.id("email"));
        element.sendKeys("daniel123@gmail.com");
        element = driver.findElement(By.id("senha"));
        element.sendKeys("123456");
        element = driver.findElement(By.id("telefone"));
        element.sendKeys("4002-8922");
        element = driver.findElement(By.id("formCadastroEtapa1"));
        element.submit();

        Thread.sleep(5000L);
        element = driver.findElement(By.name("rua"));
        element.sendKeys("Rua");
        element = driver.findElement(By.name("numero"));
        element.sendKeys("50");
        element = driver.findElement(By.name("bairro"));
        element.sendKeys("Bairro");
        element = driver.findElement(By.name("cidade"));
        element.sendKeys("Cidade");
        element = driver.findElement(By.name("formCadastroEtapa2"));
        element.submit();
        assertNotNull(element);
    }

    @Test
    public void cadastroUsuarioUsernameCdastrado(){
        WebElement element = driver.findElement(By.name("nome"));
        element.sendKeys("Joao");
        element = driver.findElement(By.id("nomeUsuario"));
        element.sendKeys("dan");
        element = driver.findElement(By.name("idade"));
        element.sendKeys("35");
        element = driver.findElement(By.name("email"));
        element.sendKeys("joao123@gmail.com");
        element = driver.findElement(By.name("senha"));
        element.sendKeys("12345");
        element = driver.findElement(By.id("telefone"));
        element.sendKeys("4002-8922");
        element = driver.findElement(By.id("btnCadastro"));
        element.submit();

        element = driver.findElement(By.id("rua"));
        element.sendKeys("Rua");
        element = driver.findElement(By.id("numero"));
        element.sendKeys("50");
        element = driver.findElement(By.id("bairro"));
        element.sendKeys("Bairro");
        element = driver.findElement(By.id("cidade"));
        element.sendKeys("Cidade");
        element = driver.findElement(By.id("btnConcluir"));
        element.submit();
        assertNotNull(element);
        //WebDriverWait wait = new WebDriverWait(driver, 3);
    }
}
