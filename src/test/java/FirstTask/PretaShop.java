package FirstTask;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class PretaShop {

    private WebDriver driver;

    @Before

    public void setUp(){

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");

    }

    @Test
    public void testing() throws InterruptedException {
        String[] products={"HUMMINGBIRD PRINTED T-SHIRT","HUMMINGBIRD NOTEBOOK","THE BEST IS YET TO COME' FRAMED POSTER","MUG THE BEST IS YET TO COME"};
        Random random = new Random();
        int number = random.nextInt(3);
        int choose=number%products.length;
        WebElement searching=driver.findElement(By.xpath("//*[@name='s']"));
        searching.clear();
        searching.sendKeys(products[choose]);
        Thread.sleep(1500);
        searching.submit();
        Thread.sleep(1500);

    }

    @After
    public void tearDown() throws Exception{
        driver.quit();
    }
}
