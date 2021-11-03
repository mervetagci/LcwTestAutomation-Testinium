import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;
import java.util.Random;

public class Main {


    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver","C:\\driver0\\chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();

        //LC Waikiki sitesi açılır.
        //Anasayfanın açıldığı kontrol edilir.
            driver.get("https://www.lcwaikiki.com/tr-TR/TR");

        //siteye login olunur.
        driver.get("https://www.lcwaikiki.com/tr-TR/TR/giris");
            //driver.findElement(By.cssSelector("#header-user-section")).click();
            driver.findElement(By.id("LoginEmail")).sendKeys("testiniumlcwtest@gmail.com");
            driver.findElement(By.id("Password")).sendKeys("Ly8+2iS2");
            driver.findElement(By.id("loginLink")).click();
            Assert.assertEquals(driver.getTitle(), "Home Page");


        //Arama kutucuğuna pantolan kelimesi girilir.
            driver.findElement(By.id("search_input")).click();//sendKeys("pantolan");
            driver.findElement(By.id("search_input")).sendKeys("pantolan");
            driver.findElement(By.xpath("//button[@type=\"button\"]")).click();


        //Sayfanın sonuna scroll etme.
           /*js.executeScript("window.scrollBy(0,1000)");
            ((JavascriptExecutor) driver).executeScript("scroll(0,300)");//buçalışıyor*/

        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");//son bu çalışıyor


        //Daha Fazla ürün Gör butonu tıklama(Buton lazy load şeklinde, Css kodunu kullanabildim.)
            //driver.findElement(By.cssSelector("[class=lazy-load-button]")).click();

        //Sonuca göre sergilenen ürünlerden rastgele seçilir
        //WebDriver productClick= (WebDriver) driver.findElement(By.cssSelector("[class=a_model_itemmix-and-match-link]"));
        //List<WebElement> links = driver.findElement(By.cssSelector("[class=a_model_item]")).click();//a_model_itemmix-and-match-link
        //links.get(new Random().nextInt(links.size())).click();
        //driver.findElements(By.cssSelector("[class=picturebox]")).click();
        driver.findElement(By.cssSelector("[class=a_model_item]")).click();//resimetıklayan kod

        //Ürün fiyatı sonradan karşılaştırabilmek için alınır.
        WebElement price= driver.findElement(By.cssSelector("span.price:nth-child(2)"));
        String priceText= price.getText();
        //System.out.println(priceText);
        //Beden seçme
        driver.findElement(By.cssSelector("#option-size > a:nth-child(7)")).click();
        //Sepete ekleme
        driver.findElement(By.cssSelector("#pd_add_to_cart")).click();
        //Sepete gitme
        driver.findElement(By.cssSelector(".header-cart")).click();
        //Sepetteki ürün fiyatı
        WebElement priceCart = driver.findElement(By.cssSelector(".rd-cart-item-price"));
        String priceCartText= priceCart.getText();
        //System.out.println(priceCartText);
        //Doğruluğu karşılaştırılacak
        /*//Adet arttırılır
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement quantity = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#Cart_AddQuantity_697228796")));
        quantity.click();
        //driver.findElement(By.cssSelector("#Cart_AddQuantity_697228796")).click();
        //driver.findElement(By.cssSelector(".item-quantity-input.value")).sendKeys("2");*/

        //Ürün sepetten silinir.
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.cssSelector("a.cart-square-link:nth-child(1)")).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".sc-save")));
        element.click();

        //driver.findElement(By.cssSelector("#Cart_ProductFavAndDelete_697228796")).click();

    }
}
