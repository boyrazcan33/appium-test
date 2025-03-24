package automationt1;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public AppiumDriver driver;
    public WebDriverWait wait;
    By corpButton = By.id("mobi.appcent.apponte:id/btnInstitutional");
    By loginButton = By.id("mobi.appcent.apponte:id/ibSignIn");

    By sendCodeButton = By.id("mobi.appcent.apponte:id/btnSendCode");
    By phoneText=By.id("mobi.appcent.apponte:id/etPhoneNumber");



    @BeforeTest
    public void beforeTest() {
        try {
            DesiredCapabilities capabilities;
            capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Pixel 8 Pro API 30");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("udid", "emulator-5554");
            capabilities.setCapability("platformVersion", "11.0");
            capabilities.setCapability("appPackage", "mobi.appcent.apponte");
            capabilities.setCapability("appActivity", "mobi.appcent.apponte.ui.activity.login.LoginActivity");
            capabilities.setCapability("skipUnLock", "true");
            capabilities.setCapability("noReset", "false");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }
        catch(
                MalformedURLException malformedURLException)

        {
            System.out.println("URL error.");
        }

    }


    @Test
    public void test(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement corpSelect =driver.findElement(corpButton);
        corpSelect.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement loginSelect =driver.findElement(loginButton);
        loginSelect.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement phoneTextSelect= driver.findElement(phoneText);
        phoneTextSelect.sendKeys("12345678");


        WebElement sendCodeSelect= driver.findElement(sendCodeButton);
        sendCodeSelect.click();

    }



    @AfterTest
    public void teardown(){}
}

