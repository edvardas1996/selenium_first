import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.UUID;
import java.time.Duration;

public class ELentaTests {
    public static WebDriver driver;

    @Test
    public void registrationPositiveTestMinsymbolsTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(3));
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("Petras123");
        driver.findElement(By.id("Password2")).sendKeys("Petras123");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Jūs sėkmingai prisiregistravote!";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/h1/b")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationSameUsernameTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys("Edvardas1");
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("Petras123");
        driver.findElement(By.id("Password2")).sendKeys("Petras123");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Vartotojas tokiu vardu jau įregistruotas. Bandykite pasirinkti kitą.";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationPositiveTestMaxsymbolsTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(70));
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("Petras123");
        driver.findElement(By.id("Password2")).sendKeys("Petras123");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Jūs sėkmingai prisiregistravote!";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/h1/b")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void registrationNoUsernameTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("Petras123");
        driver.findElement(By.id("Password2")).sendKeys("Petras123");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Įveskite vartotojo vardą.";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[1]/td[2]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationNoEmailTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys("edvardas123edvardas123edvardas123edvardas123es123edvardas123edvardas123");
        driver.findElement(By.id("Password")).sendKeys("Petras123");
        driver.findElement(By.id("Password2")).sendKeys("Petras123");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Įveskite el. pašto adresą.";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[4]/td[2]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationNoPasswordTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(9));
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password2")).sendKeys("Petras123");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Įveskite slaptažodį.";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[7]/td[2]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationNoPassword2Test() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(9));
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("Petras123");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Pakartotinai neįvedėte slaptažodžio.";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[8]/td[2]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationNegativeTest2symbols() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(2));
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("Petras123");
        driver.findElement(By.id("Password2")).sendKeys("Petras123");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Per mažas simbolių kiekis";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/h1/b")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationNegativeTest71symbols() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(71));
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("Petras123");
        driver.findElement(By.id("Password2")).sendKeys("Petras123");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Per didelis simbolių kiekis.";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/h1/b")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationNegativeTestPassword1symbol() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(9));
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("P");
        driver.findElement(By.id("Password2")).sendKeys("P");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Įvestas slaptažodis per trumpas.";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[7]/td[2]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationPasswordsNotMatchTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(9));
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("Petras123");
        driver.findElement(By.id("Password2")).sendKeys("Petras1234");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Nesutampa slaptažodžiai. Pakartokite.";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[8]/td[2]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationEmailNotValidTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(9));
        driver.findElement(By.id("Email")).sendKeys("peqwqtraes13@Ū*$@#eqwwe.rqw");
        driver.findElement(By.id("Password")).sendKeys("Petras123");
        driver.findElement(By.id("Password2")).sendKeys("Petras123");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "El. pašto adresas nėra tinkamas.";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[4]/td[2]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationEmail1symbolTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(7));
        driver.findElement(By.id("Email")).sendKeys("@");
        driver.findElement(By.id("Password")).sendKeys("Petras123");
        driver.findElement(By.id("Password2")).sendKeys("Petras123");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "El. pašto adresas nėra tinkamas.";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[4]/td[2]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationPasswordBlankTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(6));
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys(" ");
        driver.findElement(By.id("Password2")).sendKeys(" ");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Įvestas slaptažodis per trumpas.";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/form/fieldset/table/tbody/tr[7]/td[2]/span")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationPasswordAllSpecialSymbolsTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(5));
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("!!!!!!!!!!!!!!!@@@@@@@#######");
        driver.findElement(By.id("Password2")).sendKeys("!!!!!!!!!!!!!!!@@@@@@@#######");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Įvestas slaptažodis turi buti bent 8 simboliu, kurie 1 raide, 1 skaicius";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/h1/b")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationUserNameArabicSymbolsTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys("189بششجججح");
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("Asilas879");
        driver.findElement(By.id("Password2")).sendKeys("Asilas879");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Įvesti neleistini simboliai";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/h1/b")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationServerErrorTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys("Edvardsa<s");
        driver.findElement(By.id("Email")).sendKeys("asilas@live.com");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Įvestas slaptažodis per trumpas.";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("/html/body/span/h1")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationPasswordCapslockTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys("ASISISISIS");
        driver.findElement(By.id("Email")).sendKeys("ASISISISIS@live.com");
        driver.findElement(By.id("Password")).sendKeys("ASISISISIS");
        driver.findElement(By.id("Password2")).sendKeys("ASISISISIS");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Slaptazodis neatitnka standarto";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/h1/b")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void registrationStandardPasswordTest() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.id("UserName")).sendKeys(generateRandomUsername(8));
        driver.findElement(By.id("Email")).sendKeys(generateRandomEmail());
        driver.findElement(By.id("Password")).sendKeys("Edvardas1");
        driver.findElement(By.id("Password2")).sendKeys("Edvardas1");
        driver.findElement(By.xpath("/html/body/div[1]/form/fieldset/table/tbody/tr[11]/td[2]/input")).click();
        String expected = "Jūs sėkmingai prisiregistravote!";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/h1/b")).getText();
        } catch (Exception e) {
        }
        Assert.assertEquals(actual, expected);
    }
























    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

    public void acceptCookies() {
        driver.get("https://elenta.lt/registracija");
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
    }

    private String generateRandomEmail() {
        return UUID.randomUUID().toString().substring(0, 8) + "@gmail.com.com";
    }

    private String generateRandomUsername(int length) {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345678901234567890!@#$%^&*()_+-=/.,?";
        String text = "";
        for (int i = 0; i < length; i++) {
            text += symbols.charAt((int) (Math.random() * symbols.length()));
        }
        return text;
    }


}
