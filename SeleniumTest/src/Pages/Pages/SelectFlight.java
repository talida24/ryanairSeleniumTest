package Pages.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectFlight {
    public WebDriver driver;

    public SelectFlight(WebDriver driver) {
        this.driver = driver;
    }

    public void setFlightFrom() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/flights-root/div/flights-summary-container/flights-summary/div/div[1]/journey-container/journey/flight-list/div")).click();
    }

    public void setPackageFrom(String bag){
        if(bag == "value")
            driver.findElement(By.xpath("/html/body/flights-root/div/flights-summary-container/flights-summary/div/div[1]/journey-container/journey/flight-list/div/flight-card/div/div[2]/fare-table-container/fare-table/div[2]/div[1]/fare-card/div/div/button/span")).click();
        else if(bag == "regular")
            driver.findElement(By.xpath("/html/body/flights-root/div/flights-summary-container/flights-summary/div/div[1]/journey-container/journey/flight-list/div/flight-card/div/div[2]/fare-table-container/fare-table/div[2]/div[2]/fare-card/div/div/button/span")).click();
        else if(bag == "plus")
            driver.findElement(By.xpath("/html/body/flights-root/div/flights-summary-container/flights-summary/div/div[1]/journey-container/journey/flight-list/div/flight-card/div/div[2]/fare-table-container/fare-table/div[2]/div[3]/fare-card/div/div/button/span")).click();
    }

    public void setFlightTo(){
        driver.findElement(By.xpath("/html/body/flights-root/div/flights-summary-container/flights-summary/div/div[2]/journey-container/journey/flight-list/div")).click();
    }

    public void setPackageTo(String bag){
        if(bag == "value")
            driver.findElement(By.xpath("/html/body/flights-root/div/flights-summary-container/flights-summary/div/div[2]/journey-container/journey/flight-list/div/flight-card/div/div[2]/fare-table-container/fare-table/div/div[1]/fare-card/div/div/button/span")).click();
        else if(bag == "regular")
            driver.findElement(By.xpath("/html/body/flights-root/div/flights-summary-container/flights-summary/div/div[2]/journey-container/journey/flight-list/div/flight-card/div/div[2]/fare-table-container/fare-table/div/div[2]/fare-card/div/div/button/span")).click();
        else if(bag == "plus")
            driver.findElement(By.xpath("/html/body/flights-root/div/flights-summary-container/flights-summary/div/div[2]/journey-container/journey/flight-list/div/flight-card/div/div[2]/fare-table-container/fare-table/div/div[3]/fare-card/div/div/button/span")).click();
    }

    public void setPackageValue() throws InterruptedException {
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;

        setFlightFrom();
        js.executeScript("window.scrollTo(0,837)");
        Thread.sleep(2000);
        setPackageFrom("value");
        setFlightTo();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        setPackageTo("value");
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void setPackageRegular() throws InterruptedException {
        setFlightFrom();
        setPackageFrom("regular");
        setFlightTo();
        setPackageTo("regular");
    }

    public void setPackagePlus() throws InterruptedException {
        setFlightFrom();
        setPackageFrom("plus");
        setFlightTo();
        setPackageTo("plus");
    }

    public void setPassengerTitle(String title) throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"title-0-error-message\"]/div[2]/button")).click();
        Thread.sleep(2000);
        if(title == "Mr")
            driver.findElement(By.xpath("//*[@id=\"title-0-error-message\"]/div[2]/div/div/ry-dropdown-item[1]/button")).click();
            else if(title == "Mrs")
            driver.findElement(By.xpath("//*[@id=\"title-0-error-message\"]/div[2]/div/div/ry-dropdown-item[2]/button")).click();
                else if(title == "Ms")
            driver.findElement(By.xpath("//*[@id=\"title-0-error-message\"]/div[2]/div/div/ry-dropdown-item[1]/button")).click();
    }

    public void setFirstName(String firstName){
        driver.findElement(By.xpath("//*[@id=\"formState.passengers.ADT-0.name\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"formState.passengers.ADT-0.name\"]")).sendKeys(firstName);
    }

    public void setSecondName(String secondName){
        driver.findElement(By.xpath("//*[@id=\"formState.passengers.ADT-0.surname\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"formState.passengers.ADT-0.surname\"]")).sendKeys(secondName);
    }

    public void setPassenger(String title, String firstName, String secondName) throws InterruptedException {
        setPassengerTitle(title);
        setFirstName(firstName);
        setSecondName(secondName);
        driver.findElement(By.xpath("/html/body/flights-root/div/ng-component/continue-flow-container/continue-flow/div/div/button")).click();
    }
}
