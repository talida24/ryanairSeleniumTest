package Cucumber;

import Webpages.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

public class CucumberRunner {

    public static WebDriver createWebDriver() {
        String driver = System.getProperty("browser", "chrome");
        switch(driver) {
            case "firefox":
                return new FirefoxDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:/Users/Talida/Desktop/chromedriver_win32/chromedriver.exe");
                return new ChromeDriver();
            default:
                throw new RuntimeException("Unsupported webdriver: " + driver);
        }
    }

    public static final WebDriver driver = createWebDriver();
    JavascriptExecutor js;
    String webURL = "https://www.ryanair.com/ie/en";
    FirstPage firstPage = new FirstPage(driver);
    SelectFlight selectFlightPage = new SelectFlight(driver);
    SelectAdds selectAdds = new SelectAdds(driver);
    PageCheckOut checkOut = new PageCheckOut(driver);

    @Given("^Open https://www\\.ryanair\\.com/ie/en$")
    public void openHttpsWwwRyanairComIeEn() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(webURL);
        driver.manage().window().maximize();
    }

    @And("^Do login$")
    public void doLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin();
    }

//    @Then("^Do flight search$")
//    public void doFlightSearch() throws InterruptedException {
//        firstPage.setReturnTicket();
//        firstPage.searchFlight("toulouse", "malta");
//    }
//
//    @Then("^Select the flights with the value package$")
//    public void selectValuePackage() throws InterruptedException {
//        selectFlightPage.setPackageValue();
//    }
//
//    @And("^Add the credentials for the passenger 'Ms\\. Talida Rosioru'$")
//    public void addTheCredentialsForThePassengerMsTalidaRosioru() throws InterruptedException {
//        selectFlightPage.setPassenger("Ms","Talida","Rosioru");
//        selectFlightPage.next();
//    }
//
//    @Given("^Select random seats for both flights$")
//    public void selectRandomSeatsForTheFirstFlight() throws InterruptedException {
//        selectAdds.setRandomSeats();
//    }
//
//    @And("^Select included bags$")
//    public void selectIncludedBags() throws InterruptedException {
//        selectAdds.setBags("included");
//    }
//
//    @And("^Don't add any extras$")
//    public void thereAreAddedNoExtras() throws InterruptedException {
//        selectAdds.setNoAdds();
//    }
//
//    @Then("^Go to basket$")
//    public void theFlightTicketIsInTheBasket() throws InterruptedException {
//        checkOut.setCheckOut();
//    }
//
//    @Given("^Enter phone number")
//    public void enterPhoneNumber() throws InterruptedException {
//        checkOut.setPhone();
//    }
//
//    @And("^Select no insurance$")
//    public void selectNoInsurance() throws InterruptedException {
//        checkOut.setNoInsurance();
//    }
//
//    @And("^Add the card information for payment$")
//    public void addTheCardInformationForPayment() throws InterruptedException {
//        checkOut.setCard("112500","5555555555555555", "0921", "456","str. Victoriei", "Costesti", "Talida Rosioru");
//    }
//
//    @When("^Select the currency of the payment$")
//    public void selectTheCurrencyOfThePayment() throws InterruptedException {
//        checkOut.setCurrency();
//    }
//
//    @Then("^Accept the terms and conditions$")
//    public void acceptTheTermsAndConditions() throws InterruptedException {
//        checkOut.pay();
//    }
//
//    @Then("^Get error message$")
//    public void getErrorMessage() throws InterruptedException {
//        js = (JavascriptExecutor) driver;
//        Thread.sleep(7000);
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        Thread.sleep(7000);
//        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/div/ry-alert/div")).isDisplayed();
//        driver.quit();
//    }

    @Given("^I make a booking from “DUB” to \"([^\"]*)\" on (\\d+)/(\\d+)/(\\d+) for (\\d+) adults and (\\d+) child$")
    public void iMakeABookingFromDUBToOnForAdultsAndChild(String arg0, int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
        /***** Search flight *****/
        firstPage.setReturnTicket();
        //firstPage.searchFlight(arg0, "malta");

        /***** Select flights for a passenger *****/
        selectFlightPage.setPackageValue();
        //selectFlightPage.setPassenger("Ms","talida","rosioru", );
        selectFlightPage.next();

        /***** Select no extras *****/
        selectAdds.setRandomSeats();
        selectAdds.setBags("included");
        selectAdds.setNoAdds();
        throw new cucumber.api.PendingException();
    }

    @When("^I pay for booking with card details \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iPayForBookingWithCardDetailsAnd(String arg0, String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("^I should get payment declined message$")
    public void iShouldGetPaymentDeclinedMessage() {
    }

    @Given("^I make a booking from \"([^\"]*)\" to \"([^\"]*)\" on <arg(\\d+)>/<arg(\\d+)>/<arg(\\d+)> for <arg(\\d+)> adults and <arg(\\d+)> child$")
    public void iMakeABookingFromToOnArgArgArgForArgAdultsAndArgChild(String arg0, String arg1, int arg2, int arg3, int arg4, int arg5, int arg6) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
