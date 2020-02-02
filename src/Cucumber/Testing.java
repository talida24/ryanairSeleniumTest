package Cucumber;

import Webpages.*;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Testing {

    public static WebDriver createWebDriver() {
        String driver = System.getProperty("browser", "chrome");
        switch(driver) {
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                return new ChromeDriver();
            default:
                throw new RuntimeException("Unsupported webdriver: " + driver);
        }
    }

    WebDriver driver = createWebDriver();
    JavascriptExecutor js;
    String webURL = "https://www.ryanair.com/ie/en";

    @Test
    public void testTwoAdultsOneKid() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;

        /***** variables for pages *****/
        FirstPage firstPage = new FirstPage(driver);
        SelectFlightPage selectFlightPage = new SelectFlightPage(driver);
        SelectAddsPage selectAdds = new SelectAddsPage(driver);
        CheckOutPage checkOut = new CheckOutPage(driver);

        driver.get(webURL);

        /***** login *****/
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin("ryanair.selenium@gmail.com", "Ryanair!2");

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
        selectAdds.setBags("included", 3);
        selectAdds.setNoAdds();

        /***** Payment *****/
        checkOut.setCheckOut();
        checkOut.setPhone();
        checkOut.setNoInsurance();
        checkOut.setCard("112500","5555555555555555", "09/21", "456","str. Victoriei", "Costesti", "Talida Rosioru");
        checkOut.setCurrency();
        checkOut.pay();
        checkOut.checkError();

        driver.quit();
    }

    @Test
    public void testOneAdult() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        js = (JavascriptExecutor) driver;

        /***** variables for pages *****/
        FirstPage firstPage = new FirstPage(driver);
        SelectFlightPage selectFlightPage = new SelectFlightPage(driver);
        SelectAddsPage selectAdds = new SelectAddsPage(driver);
        CheckOutPage checkOut = new CheckOutPage(driver);

        driver.get(webURL);

        /***** login *****/
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin("ryanair.selenium@gmail.com", "Ryanair!2");
        //loginPage.setLogout();

        /***** Search flight *****/
        //firstPage.setReturnTicket();
        int noPassengers = firstPage.searchFlight("toulouse", "malta", 1,0,0,0, "Apr", "23", "Apr", "26");

        /***** Select flights for a passenger *****/
        selectFlightPage.setPackageValue();
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 900)");
        selectFlightPage.setPassenger("Mr","paul","oprea", 0, 'A');
        selectFlightPage.next();

        /***** Select no extras *****/
        selectAdds.setRandomSeats();
        selectAdds.setBags("included", 1);
        selectAdds.setNoAdds();

        /***** Payment *****/
        checkOut.setCheckOut();
        checkOut.setPhone();
        checkOut.setNoInsurance();
        checkOut.setCard("112500","5555555555555555", "09/21", "456","str. Victoriei", "Costesti", "Talida Rosioru");
        checkOut.setCurrency();
        checkOut.pay();
        checkOut.checkError();

        driver.quit();
    }

}
