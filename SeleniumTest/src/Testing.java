import Pages.Pages.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Testing {

    @Test
    public void first_page() throws InterruptedException {
        String actual_title;
        String expected_title;
        String webURL = "https://www.ryanair.com/ie/en";
        System.setProperty("webdriver.chrome.driver", "C:/Users/Talida/Desktop/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(webURL);
        driver.manage().window().maximize();


        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin();

        FirstPage firstPage = new FirstPage(driver);
        firstPage.setReturnTicket();
        Thread.sleep(3000);
        firstPage.searchFlight("toulouse", "malta");


        SelectFlight selectFlightPage = new SelectFlight(driver);
        selectFlightPage.setPackageValue();
        Thread.sleep(4000);
        selectFlightPage.setPassenger("Ms","talida","rosioru");

        Thread.sleep(10000);
        SelectAdds selectAdds = new SelectAdds(driver);
        selectAdds.setRandomSeats();
        selectAdds.setBags("included");
        Thread.sleep(10000);
        selectAdds.setNoAdds();
        Thread.sleep(10000);

        PageCheckOut checkOut = new PageCheckOut(driver);
        checkOut.setCheckOut();
        Thread.sleep(10000);
        checkOut.setPhone();
        Thread.sleep(10000);
        checkOut.setNoInssurance();
        checkOut.setCard("112500","5555555555555555", "0921", "456","str. Victoriei", "Costesti", "Talida Rosioru");
        checkOut.setCurrency();
        checkOut.pay();
    }
}
