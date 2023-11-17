import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class VynotekaTest {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait= new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookiesAndAge();
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    public void acceptCookiesAndAge() {
        driver.get("https://vynoteka.lt/");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/a[1]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div[3]/div/div[1]/button")).click();
    }

    @Test
    public void adPositiveTest() {
        driver.get("https://vynoteka.lt/");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"omnisend-form-63ff1f31b40d6530aba59a6d-close-action\"]/div"))).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"omnisend-form-63ff1f31b40d6530aba59a6d-close-action\"]/div"))).click();
        driver.findElement(By.xpath("//*[@id=\"app__header\"]/div[2]/div/div/div[3]/div/div/div/form/div[1]/div/input")).sendKeys("Jagermeister 1 L");
        driver.findElement(By.xpath("//*[@id=\"app__header\"]/div[2]/div/div/div[3]/div/div/div/form/div[2]/div/div[2]/div/div/div/div/div[1]/div/div/a")).click();

    }

}


























