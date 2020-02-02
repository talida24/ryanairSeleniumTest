package Cucumber;

import Webpages.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;

public class CucumberGlue {

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

    public static final WebDriver driver = createWebDriver();
    JavascriptExecutor js;
    String webURL = "https://www.ryanair.com/ie/en";
    FirstPage firstPage = new FirstPage(driver);
    SelectFlightPage selectFlightPage = new SelectFlightPage(driver);
    SelectAddsPage selectAdds = new SelectAddsPage(driver);
    CheckOutPage checkOut = new CheckOutPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Given("^I make a booking from \"([^\"]*)\" to \"([^\"]*)\" on \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" for (\\d+) adults and (\\d+) child$")
    public void i_make_a_booking_from_to_on_for_adults_and_child(String from, String to, String dateF, String monthF, String dateR, String monthR, int noAdults, int noChildren) throws Throwable {

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(webURL);
        driver.manage().window().maximize();
        loginPage.setLogin("ryanair.selenium@gmail.com", "Ryanair!2");
        int noPassengers = firstPage.searchFlight(from, to, noAdults,0,noChildren,0, monthF, dateF, monthR, dateR);
        selectFlightPage.setPackageValue();
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 900)");
        selectFlightPage.setPassenger("Mr","paul","oprea", 0, 'A');
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        selectFlightPage.setPassenger("Ms","ana","rosioru", 1, 'A');
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        selectFlightPage.setPassenger("n/a","talida","rosioru", 0, 'C');
        selectFlightPage.next();
        selectAdds.setRandomSeats();
        selectAdds.setBags("included", 3);
        selectAdds.setNoAdds();
    }

    @When("^I pay for booking with card details \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\",\"([^\"]*)\" and \"([^\"]*)\"$")
    public void iPayForBookingWithCardDetailsAnd(String cardNo, String CVV, String date, String cardholderName, String address, String city, String zip, String country) throws Throwable {
        checkOut.setCheckOut();
        checkOut.setNoInsurance();
        checkOut.setPhone();
        checkOut.setCard(zip,cardNo, date, CVV ,address, city, cardholderName);
        checkOut.setCurrency();
        checkOut.pay();
    }

    @Then("^I should get payment declined message$")
    public void iShouldGetPaymentDeclinedMessage() throws InterruptedException {
        checkOut.checkError();
    }

    @Given("^I make a booking from \"([^\"]*)\" to \"([^\"]*)\" on \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" for (\\d+) adults$")
    public void i_make_a_booking_from_to_on_for_adults(String from, String to, String dateF, String monthF, String dateR, String monthR, int noAdults) throws Throwable {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(webURL);
        driver.manage().window().maximize();
        loginPage.setLogin("ryanair.selenium@gmail.com", "Ryanair!2");
        int noPassengers = firstPage.searchFlight(from, to, noAdults,0,0,0, monthF, dateF, monthR, dateR);
        selectFlightPage.setPackageValue();
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 900)");
        selectFlightPage.setPassenger("Mr","paul","oprea", 0, 'A');
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        selectFlightPage.next();
        selectAdds.setRandomSeats();
        selectAdds.setBags("included", 1);
        selectAdds.setNoAdds();
    }

}
