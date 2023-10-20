import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class googleSearchTest {

    private WebDriver driver; //creamos un objeto con el driver

    @Before //anotación para indicar que esto se realizará siempre antes de cada test
    public void setUp() { //método setUp
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver_mac64/chromedriver"); //le decimos donde esta el archivo
        driver = new ChromeDriver(); //declaramos objeto driver del tipo chromedriver
        driver.manage().window().maximize(); //indicamos que maximice el navegador que hemos abierto
        driver.get("https://www.google.com/"); //indicamos la url que queremos abrir
    }

    @Test
    public void testGooglePage(){ //creamos método donde daremos instrucciones para completar en la pág de google
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement searchbox = driver.findElement(By.name("q")); //comando selenium para encontrar un elemento en la página (*La q es el selector)
        searchbox.clear(); //limpia cualquier texto que haya en el selector
        searchbox.sendKeys("Automatización de Pruebas con Selenium WebDriver + Java | Tutorial paso a paso"); //enviamos el texto que queramos a la caja de busqueda
        searchbox.submit(); // enviamos la información (hacemos enter)

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //10 segundos de espera una vez que hacemos enter
        assertEquals("Automatización de Pruebas con Selenium WebDriver + Java | Tutorial paso a paso - Buscar con Google", driver.getTitle()); //revisa que lo que retorne sea igual al titulo de la pagina de resultados

    }
   @After
   public void teardown(){
        driver.quit();
   } //cerrar navegador después de completar la prueba
}
