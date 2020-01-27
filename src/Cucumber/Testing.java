package Cucumber;

import Webpages.*;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Testing {

    private WebDriver driver;
    private String webURL = "https://www.ryanair.com/ie/en";

    @Test
    public void first_page() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:/Users/Talida/Desktop/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;

        /***** variables for pages *****/
        FirstPage firstPage = new FirstPage(driver);
        SelectFlight selectFlightPage = new SelectFlight(driver);
        SelectAdds selectAdds = new SelectAdds(driver);
        PageCheckOut checkOut = new PageCheckOut(driver);

        driver.get(webURL);

        /***** login *****/
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin();

        /***** Search flight *****/
        //firstPage.setReturnTicket();
        int noPassengers = firstPage.searchFlight("toulouse", "malta", 2,0,1,0, "Apr", "23", "Apr", "26");

        /***** Select flights for a passenger *****/
        int id=0;
        selectFlightPage.setPackageValue();
        js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, 900)");
        selectFlightPage.setPassenger("Mr","paul","oprea", 0, 'A');
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        selectFlightPage.setPassenger("Ms","ana","rosioru", 1, 'A');
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        selectFlightPage.setPassenger("n/a","talida","rosioru", 0, 'C');

        selectFlightPage.next();

        /***** Select no extras *****/
        selectAdds.setRandomSeats();
        selectAdds.setBags("included");
        selectAdds.setNoAdds();

        /***** Payment *****/
        checkOut.setCheckOut();
        checkOut.setPhone();
        checkOut.setNoInsurance();
        checkOut.setCard("112500","5555555555555555", "0921", "456","str. Victoriei", "Costesti", "Talida Rosioru");
        checkOut.setCurrency();
        checkOut.pay();

        driver.quit();
    }

}
