import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class SauceDemoTests {
    public static WebDriver driver;

   // @Test
    public void openWebsite(){
        driver.get("https://www.saucedemo.com");
        WebElement username = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[1]/input"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/div[2]/input"));
        password.sendKeys("secret_sauce");
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/form/input")).click();

        //driver.quit();


    }
    //@Test
    public void skelbiult(){
        driver = new ChromeDriver();
        driver.get("https://www.skelbiu.lt");
        driver.findElement(By.xpath("/html/body/div[10]/div[2]/div/div[1]/div/div[2]/div/button[1]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/form/div/div/input")).sendKeys("Audi");
        driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/form/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/form/div[1]/div/div[3]/i")).click();
        driver.findElement(By.xpath("/html/body/div[13]/div[2]/div[1]/div[1]/div/div[28]/label")).click();
        driver.findElement(By.xpath("/html/body/div[13]/div[2]/div[1]/div[3]/div[1]/input")).click();
        
        //driver.quit();



    }
    @Test
    public void Skelbiult()  {
        driver.get("https://www.skelbiu.lt");
        driver.findElement(By.id("searchKeyword")).sendKeys("roges");
        driver.findElement(By.id("searchButton")).click();


    }
    @Test
    public void Skelbiult2()  {
        driver.get("https://www.skelbiu.lt");
        driver.findElement(By.id("searchKeyword")).sendKeys("jogurtas");
        driver.findElement(By.id("searchButton")).click();
    }


    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }
    @AfterClass
    public void afterClass(){
        //driver.quit();
    }

    public void acceptCookies(){
        driver.get("https://www.skelbiu.lt");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }










}
