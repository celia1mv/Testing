import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class mercuryTours {
    private WebDriver driver;

    //Indicamos los selectores
    By registerLinkLocator = By.linkText("REGISTER"); //el By.xxxx son métodos
    By registerPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
    By usernameLocator = By.id("email");
    By passwordLocator = By.name("password");
    By confirmPasswordLocator = By.cssSelector("input[name='confirmPassword']");
    By registerUser = By.name("submit");
    By loginUsername = By.name("userName");
    By findAFlight = By.xpath("//img[@src='images/hdr_findflight.gif']");

    @Before
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver_mac64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/newtours/");
    }

    @Test
    public void registerUser() throws InterruptedException {
        //1. dar clic en REGISTER
        //2. Completar campos para registrar a un usuario
        //3. Confirmar mensaje de usuario registrado

        driver.findElement(registerLinkLocator).click(); //hacemos clic en REGISTER
        Thread.sleep(4000);  //4 segundos de espera para dar tiempo a cargar la pag
        if (driver.findElement(registerPageLocator).isDisplayed()) { //nos devuelve un booleano, si es verdadero introducimos los datos, si no.....
            driver.findElement(usernameLocator).sendKeys("admin@gmail.com");
            driver.findElement(passwordLocator).sendKeys("1234");
            driver.findElement(confirmPasswordLocator).sendKeys("1234");
            driver.findElement(registerUser).click();
        } else {
            System.out.println("Register page was not found");
        }
        List<WebElement> fonts = driver.findElements(By.tagName("font")); //listamos todos los elementos de la pagina que tienen la anotacion font
        assertEquals("Note: Your user name is admin@gmail.com.", fonts.get(5).getText());
    }

    @Test
    public void loginUser() throws InterruptedException {
        Thread.sleep(20000);

        if (driver.findElement(findAFlight).isDisplayed()) {
            driver.findElement(loginUsername).sendKeys("admin@gmail.com");
            driver.findElement(passwordLocator).sendKeys("1234");
            driver.findElement(registerUser).click();
        } else {
            System.out.println("Login Failed");

            List<WebElement> fonts = driver.findElements(By.tagName("font")); //listamos todos los elementos de la pagina que tienen la anotacion font
            assertEquals("Thank you for Loggin.", fonts.get(5).getText());
        }
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
