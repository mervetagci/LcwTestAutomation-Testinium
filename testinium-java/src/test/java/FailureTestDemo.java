import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FailureTestDemo {

    public  WebDriver driver;
    @Before
    public void homePage(){
        System.setProperty("webdriver.chrome.driver","C:\\driver0\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        String url="https://www.lcwaikiki.com/tr-TR/TR";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loginCheck(){
        /*System.setProperty("webdriver.chrome.driver","C:\\driver0\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();
        String url="https://www.lcwaikiki.com/tr-TR/TR/giris";
        driver.get(url);*/
        System.out.println(driver);
        driver.findElement(By.cssSelector("#header-user-section")).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.id("LoginEmail")).sendKeys("testiniumlcwtest@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Ly8+2iS2");
        driver.findElement(By.id("loginLink")).click();
        //Assert.assertEquals(driver.getTitle(), "Home Page");

        driver.findElement(By.id("search_input")).click();//sendKeys("pantolan");
        driver.findElement(By.id("search_input")).sendKeys("pantolan");
        driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
        driver.findElement(By.cssSelector("[class=lazy-load-button]")).click();
        driver.findElement(By.cssSelector("[class=a_model_item]")).click();
        //Ürün fiyatı sonradan karşılaştırabilmek için alınır.
        WebElement price = driver.findElement(By.cssSelector("span.price:nth-child(2)"));
        String priceText = price.getText();
        //System.out.println(priceText);
        //Beden seçme
        driver.findElement(By.cssSelector("#option-size > a:nth-child(7)")).click();
        //Sepete ekleme
        driver.findElement(By.cssSelector("#pd_add_to_cart")).click();
        //Sepete gitme
        driver.findElement(By.cssSelector(".header-cart")).click();
        //Sepetteki ürün fiyatı
        WebElement priceCart = driver.findElement(By.cssSelector(".rd-cart-item-price"));
        String priceCartText = priceCart.getText();
        //Doğruluğu karşılaştırılacak

    }


    }

    /*@After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }*/

