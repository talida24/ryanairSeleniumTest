package Webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SelectFlightPage {
    public WebDriver driver;
    JavascriptExecutor js;

    public SelectFlightPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFlightFrom() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/flights-root/div/flights-summary-container/flights-summary/div/div[1]/journey-container/journey/flight-list/div")).click();
    }

    public void setPackageFrom(String bag) throws InterruptedException {
        Thread.sleep(2000);
        if (bag == "value") {
            driver.findElement(By.cssSelector(".fare-card__button--selected > .ng-star-inserted")).click();
        } else if (bag == "regular") {
        driver.findElement(By.cssSelector(".fare-card--secondary > .fare-card__title")).click();
        }
    else if(bag == "plus"){
            driver.findElement(By.cssSelector(".fare-card__button--tertiary")).click();
        }
    }

    public void setFlightTo() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/flights-root/div/flights-summary-container/flights-summary/div/div[2]/journey-container/journey/flight-list/div")).click();
    }

    public void setPackageTo(String bag) throws InterruptedException {
        Thread.sleep(2000);
        if (bag == "value") {
            driver.findElement(By.cssSelector(".fare-card__button--selected")).click();
        } else if (bag == "regular"){
            driver.findElement(By.cssSelector(".ng-tns-c26-12 .card-info__cols-container")).click();
         }
        else if(bag == "plus"){
            driver.findElement(By.cssSelector(".fare-card__button--tertiary")).click();
        }
    }

    public void setPackageValue() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        setFlightFrom();
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        setPackageFrom("value");
        Thread.sleep(2000);
        setFlightTo();
        Thread.sleep(2000);
        setPackageTo("value");
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

    public void setPassengerTitle(String title, int id, char type) throws InterruptedException {
        Thread.sleep(2000);
        id = id+1;
        if(type == 'A') {
            driver.findElement(By.xpath("/html/body/flights-root/div/flights-lazy-passengers/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[" + id + "]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-dropdown/div[2]/button")).click();
            Thread.sleep(2000);
            if (title == "Mr")
                driver.findElement(By.xpath("/html/body/flights-root/div/flights-lazy-passengers/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[" + id + "]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-dropdown/div[2]/div/div/ry-dropdown-item[1]/button/div/div[1]")).click();
            else if (title == "Mrs")
                driver.findElement(By.xpath("/html/body/flights-root/div/flights-lazy-passengers/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[" + id + "]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-dropdown/div[2]/div/div/ry-dropdown-item[2]/button/div/div[1]")).click();
            else if (title == "Ms")
                driver.findElement(By.xpath("/html/body/flights-root/div/flights-lazy-passengers/pax-app-container/pax-app/ry-spinner/div/div/div[2]/pax-app-form-container/pax-app-form/form/pax-passenger-container[" + id + "]/pax-passenger/div/pax-passenger-details-container/pax-passenger-details/pax-passenger-details-form-container/pax-details-form/ry-dropdown/div[2]/div/div/ry-dropdown-item[3]/button/div/div[1]")).click();
        }
    }

    public void setFirstName(String firstName, int id, char type) throws InterruptedException {
        Thread.sleep(2000);
        if(type == 'A') {
            driver.findElement(By.xpath("//*[@id=\"formState.passengers.ADT-" + id + ".name\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"formState.passengers.ADT-" + id + ".name\"]")).sendKeys(firstName);
        }
        else if(type == 'C'){
            driver.findElement(By.xpath("//*[@id=\"formState.passengers.CHD-" + id + ".name\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"formState.passengers.CHD-" + id + ".name\"]")).sendKeys(firstName);
        }
    }

    public void setSecondName(String secondName, int id, char type) throws InterruptedException {
        Thread.sleep(2000);
        if(type == 'A') {
            driver.findElement(By.xpath("//*[@id=\"formState.passengers.ADT-" + id + ".surname\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"formState.passengers.ADT-" + id + ".surname\"]")).sendKeys(secondName);
        }
        else if(type == 'C'){
            driver.findElement(By.xpath("//*[@id=\"formState.passengers.CHD-" + id + ".surname\"]")).click();
            driver.findElement(By.xpath("//*[@id=\"formState.passengers.CHD-" + id + ".surname\"]")).sendKeys(secondName);
        }
    }

    public void setPassenger(String title, String firstName, String secondName, int id, char type) throws InterruptedException {
        Thread.sleep(2000);
        setPassengerTitle(title, id, type);
        setFirstName(firstName, id, type);
        setSecondName(secondName, id, type);
    }

    public void next() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/flights-root/div/ng-component/continue-flow-container/continue-flow/div/div/button")).click();
    }


}
