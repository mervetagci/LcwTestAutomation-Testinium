import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FailureTestDemo2 {
    public WebDriver driver;

    @Test
    public void productProcesses() {
        //WebDriver driver = super.driver();
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