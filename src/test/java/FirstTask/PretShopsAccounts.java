package FirstTask;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;
import java.util.concurrent.ExecutionException;

public class PretShopsAccounts {

    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");

    }

    @Test
    public void testing() throws  InterruptedException {
        Random random = new Random();
        String[] firstName = {"Ania", "Krzysztof", "Marek", "Gabrysia"};
        String[] lastName = {"Latacz", "Marat", "Krol", "Kowalski"};
        int howManyusers = 4;

        for (int i = 0; i < howManyusers; i++) {
            int r = random.nextInt(1000);
            String emailAddress = "Krzysiek" + r + ".Latacz@gmail.com";
            String password = "22121" + r;
            WebElement sigUp = driver.findElement(By.xpath("//*[@class='user-info']/*"));
            sigUp.click();
            WebElement noAccount = driver.findElement(By.xpath("//*[@class='no-account']/*"));
            noAccount.click();
            WebElement createAccount = driver.findElement(By.xpath("//input[@name='id_gender']"));
            createAccount.click();
            WebElement first = driver.findElement(By.xpath("//*[@class='form-control']"));
            first.sendKeys(firstName[i]);
            Thread.sleep(1500);
            WebElement last = driver.findElement(By.xpath("//input[@name='lastname']"));
            last.sendKeys(lastName[i]);
            Thread.sleep(1500);
            WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
            email.sendKeys(emailAddress);
            Thread.sleep(1500);
            WebElement pas = driver.findElement(By.xpath("//input[@name='password']"));
            pas.sendKeys(password);
            Thread.sleep(1500);
            WebElement save = driver.findElement(By.xpath("//button[@type='submit'][contains(text(), 'Save')]"));
            save.submit();
            Thread.sleep(1500);
            WebElement logout=driver.findElement(By.xpath("//*[@class='user-info']/*"));
            logout.click();


        }
    }

    @After

    public void tearDown() throws ExecutionException{
        driver.close();
    }
}
