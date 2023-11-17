import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AdTests {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @Test
    public void adPositiveTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("PC777");
        driver.findElement(By.id("text")).sendKeys("Best of the best");
        driver.findElement(By.id("price")).sendKeys((int) (Math.random() * 9999) + "");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+370" + (int) (Math.random() * 99999999));
        driver.findElement(By.id("email")).sendKeys("asilas1@live.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\IT\\Pictures\\picturews\\aWlE904G_700w_0.jpg");
        driver.findElement(By.id("forward-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ul/li/div/div[3]/span")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("180 dienų"));
    }

    @Test
    public void adNoTitleTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("text")).sendKeys("Best of the best");
        driver.findElement(By.id("price")).sendKeys((int) (Math.random() * 9999) + "");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+370" + (int) (Math.random() * 99999999));
        driver.findElement(By.id("email")).sendKeys("asilas1@live.com");
        driver.findElement(By.id("submit-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/label/span")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("Įveskite skelbimo pavadinimą"));
    }

    @Test
    public void adNoDescriptionTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("PC777");
        driver.findElement(By.id("price")).sendKeys((int) (Math.random() * 9999) + "");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+370" + (int) (Math.random() * 99999999));
        driver.findElement(By.id("email")).sendKeys("asilas1@live.com");
        driver.findElement(By.id("submit-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[2]/label/span")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("Įveskite skelbimo aprašymą"));
    }

    @Test
    public void adNoPhoneNumberTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("PC777");
        driver.findElement(By.id("text")).sendKeys("Best of the best");
        driver.findElement(By.id("price")).sendKeys((int) (Math.random() * 9999) + "");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("email")).sendKeys("asilas1@live.com");
        driver.findElement(By.id("submit-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"ce\"]")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("Įveskite telefono numerį"));
    }

    @Test
    public void adNoPriceTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("PC777");
        driver.findElement(By.id("text")).sendKeys("Best of the best");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+370" + (int) (Math.random() * 99999999));
        driver.findElement(By.id("email")).sendKeys("asilas1@live.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\IT\\Pictures\\picturews\\aWlE904G_700w_0.jpg");
        driver.findElement(By.id("forward-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ul/li/div/div[3]/span")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("180 dienų"));
    }

    @Test
    public void ad10MillPriceTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("PC777");
        driver.findElement(By.id("text")).sendKeys("Best of the best");
        driver.findElement(By.id("price")).sendKeys("10000000");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+370" + (int) (Math.random() * 99999999));
        driver.findElement(By.id("email")).sendKeys("asilas1@live.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\IT\\Pictures\\picturews\\aWlE904G_700w_0.jpg");
        driver.findElement(By.id("forward-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.className("price-box")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("1"));
    }

    @Test
    public void adPhoneNumBadFormatTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("PC777");
        driver.findElement(By.id("text")).sendKeys("Best of the best");
        driver.findElement(By.id("price")).sendKeys((int) (Math.random() * 9999) + "");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("451234513!#@awd");
        driver.findElement(By.id("email")).sendKeys("asilas1@live.com");
        driver.findElement(By.id("submit-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[5]/span[2]")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("Blogas tel. numeris"));
    }

    @Test
    public void adMaxSymbolsTitleTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("sdaaaddddddddddddddddddddddddsdaaaddddddddddddddddddddddddsdaaaddddddddddddddddddddddddsdaaaddddddddddddddddddddddddsdaaaddddddddddddddddddddddddsdaaa");
        driver.findElement(By.id("text")).sendKeys("Best of the best");
        driver.findElement(By.id("price")).sendKeys((int) (Math.random() * 9999) + "");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+370" + (int) (Math.random() * 99999999));
        driver.findElement(By.id("email")).sendKeys("asilas1@live.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\IT\\Pictures\\picturews\\aWlE904G_700w_0.jpg");
        driver.findElement(By.id("forward-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ul/li/div/div[3]/span")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("180 dienų"));
    }

    @Test
    public void adBadEmailFormatTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("gg");
        driver.findElement(By.id("text")).sendKeys("Best of the best");
        driver.findElement(By.id("price")).sendKeys((int) (Math.random() * 9999) + "");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+370" + (int) (Math.random() * 99999999));
        driver.findElement(By.id("email")).sendKeys("dsadsdadsadsdasdsad");
        driver.findElement(By.id("submit-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[6]/span")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("Blogas el. pašto adresas"));
    }

    @Test
    public void adRandomLocationTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("gg");
        driver.findElement(By.id("text")).sendKeys("Best of the best");
        driver.findElement(By.id("price")).sendKeys((int) (Math.random() * 9999) + "");
        driver.findElement(By.id("location-search-box")).sendKeys("India");
        driver.findElement(By.id("phone")).sendKeys("+370" + (int) (Math.random() * 99999999));
        driver.findElement(By.id("email")).sendKeys("baaaa@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\IT\\Pictures\\picturews\\aWlE904G_700w_0.jpg");
        driver.findElement(By.id("forward-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ul/li/div/div[3]/span")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("180 dienų"));
    }

    @Test
    public void adNoPictureTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("gg");
        driver.findElement(By.id("text")).sendKeys("Best of the best");
        driver.findElement(By.id("price")).sendKeys((int) (Math.random() * 9999) + "");
        driver.findElement(By.id("location-search-box")).sendKeys("Kaunas");
        driver.findElement(By.id("phone")).sendKeys("+370" + (int) (Math.random() * 99999999));
        driver.findElement(By.id("email")).sendKeys("baaaa@gmail.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("forward-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ul/li/div/div[3]/span")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("180 dienų"));
    }

    @Test
    public void adEverythingGoesBlankTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("");
        driver.findElement(By.id("text")).sendKeys("");
        driver.findElement(By.id("price")).sendKeys("");
        driver.findElement(By.id("location-search-box")).sendKeys("");
        driver.findElement(By.id("phone")).sendKeys("");
        driver.findElement(By.id("email")).sendKeys("");
        driver.findElement(By.id("submit-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("/html/body/div[1]/div[2]/form/div[1]/label/span")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("Įveskite skelbimo pavadinimą"));
    }

    @Test
    public void adRacialInsultTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("9/11");
        driver.findElement(By.id("text")).sendKeys("Ching Chang Chong");
        driver.findElement(By.id("price")).sendKeys((int) (Math.random() * 9999) + "");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+370" + (int) (Math.random() * 99999999));
        driver.findElement(By.id("email")).sendKeys("asilas1@live.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\IT\\Pictures\\picturews\\aWlE904G_700w_0.jpg");
        driver.findElement(By.id("forward-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ul/li/div/div[3]/span")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("180 dienų"));
    }

    @Test
    public void adMorePicturesTest() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.id("title")).sendKeys("9/11");
        driver.findElement(By.id("text")).sendKeys("Ching Chang Chong");
        driver.findElement(By.id("price")).sendKeys((int) (Math.random() * 9999) + "");
        driver.findElement(By.id("location-search-box")).sendKeys("Vilnius");
        driver.findElement(By.id("phone")).sendKeys("+370" + (int) (Math.random() * 99999999));
        driver.findElement(By.id("email")).sendKeys("asilas1@live.com");
        driver.findElement(By.id("submit-button")).click();
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\IT\\Pictures\\picturews\\aWlE904G_700w_0.jpg");
        driver.findElement(By.id("inputfile")).sendKeys("C:\\Users\\IT\\Pictures\\picturews\\One_Piece_Anime_Logo.png");
        driver.findElement(By.id("forward-button")).click();
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/ul/li/div/div[3]/span")).getText();
        } catch (Exception e) {
        }
        System.out.println("|" + actual + "|");
        Assert.assertTrue(actual.contains("180 dienų"));
    }

//        if (isAlertPresent()) {
//            Assert.assertTrue(true);
//        }else {
//            Assert.fail();
//        }
//    }
//
//
//    public boolean isAlertPresent(){
//        try {
//            wait.until(ExpectedConditions.alertIsPresent());
//            return false;
//        }catch (Exception e) {
//            return false;
//        }
//    }
















    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //wait= new WebDriverWait(driver.Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    public void acceptCookies() {
        driver.get("https://elenta.lt/patalpinti/ivesti-informacija?categoryId=Kompiuterija_Kompiuteriai&actionId=Siulo&returnurl=%2F");
        driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[1]/div[2]/div[2]/button[1]")).click();
    }

}
