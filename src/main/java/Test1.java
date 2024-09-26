
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Test1 {
    WebDriver driver;

    @BeforeSuite
    public void launchBrowser() throws InterruptedException {
        driver= new EdgeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
        public void loginPage() throws InterruptedException {

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3000);
    }

    @Test
    public void verifyLoginPageLogo() throws InterruptedException {
        WebElement logo = driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-branding > img"));
        Assert.assertTrue(logo.isDisplayed());
        Thread.sleep(3000);
    }
    @Test
    public void validLogin() throws InterruptedException {
    // Test with valid username and password
         driver.findElement(By.name("username")).sendKeys("Admin");
         driver.findElement(By.name("password")).sendKeys("admin123");
         driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")).click();
        Thread.sleep(3000);
    }

    @Test
    public void invalidLogin() throws InterruptedException {
// Test with invalid username and password.
         driver.findElement(By.name("username")).sendKeys("Administrator");
         driver.findElement(By.name("password")).sendKeys("admin");
         driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div.oxd-form-actions.orangehrm-login-action > button")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > div > div.oxd-alert.oxd-alert--error")).isDisplayed());
         Thread.sleep(3000);
    }
    @Test
    public void verifyLoginPageTitle() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");

    }
@AfterTest
    public void closeBrowser () {
        driver.quit();
    }


}






