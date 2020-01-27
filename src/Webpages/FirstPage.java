package Webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.ByAll;

public class FirstPage {
    public WebDriver driver;
    public int noPassengers;

    public FirstPage(WebDriver driver){
        this.driver = driver;
    }

    public void setReturnTicket() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget/div/hp-flight-search-widget-container/hp-flight-search-widget/hp-trip-type-container/hp-trip-type/hp-trip-type-button[1]/button/label")).click();
    }
    public void setOneWayTicket() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget/div/hp-flight-search-widget-container/hp-flight-search-widget/hp-trip-type-container/hp-trip-type/hp-trip-type-button[2]/button/icon")).click();
    }

    @FindBy(id="input-button__departure")
    WebElement fromCity;
    @FindBy(id="input-button__destination")
    WebElement toCity;

    public void setFrom(String fromCity) throws InterruptedException {
       WebElement from = driver.findElement(By.id("input-button__departure"));
       System.out.println(fromCity);
       Thread.sleep(2000);
       from.click();
       from.sendKeys(Keys.chord(Keys.CONTROL, "a"));
       from.sendKeys(Keys.BACK_SPACE);
       from.sendKeys(fromCity);
       Thread.sleep(2000);
       driver.findElement(By.id("input-button__destination")).click();
    }
    public void setTo(String toCity) throws InterruptedException {
        driver.findElement(By.id("input-button__destination")).sendKeys(toCity);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget/div/hp-flight-search-widget-container/hp-flight-search-widget/hp-trip-type-container/hp-trip-type/hp-trip-type-button[1]/button/label")).click();
    }

    public void setDepartureDate(String month, String day) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class,'m-toggle__month')][contains(text(),'"+ month +"')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@class, 'calendar-body__cell')][contains(text(),' "+ day +" ')]")).click();
        Thread.sleep(2000);
    }

    public void setReturningDate(String month, String day) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[contains(@class,'m-toggle__month')][contains(text(),'"+ month +"')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@class, 'calendar-body__cell')][contains(text(),' "+ day +" ')]")).click();
        Thread.sleep(2000);
    }

    public void search() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".flight-search-widget__start-search")).click();
    }

    public int setNumberPassengers(int adults, int children, int teens, int infants) throws InterruptedException {
        int noPassengers = adults + children + teens + infants;
       driver.findElement(By.xpath("//*[contains(@class, 'passengers-picker__counter-main-label')]")).click();
        adults--;
        while (adults>0) {
            driver.findElement(By.xpath("//*[@id=\'ry-tooltip-10\']/div[2]/hp-lazy-controls-tooltips/hp-app-controls-tooltips/hp-controls-tooltips-container/hp-controls-tooltips/hp-passengers-container/hp-passengers/hp-passengers-picker/ry-counter[1]/div[2]/div[3]")).click();
            adults--;
            Thread.sleep(2000);
        }
        while (teens>0) {
            driver.findElement(By.xpath("//*[@id=\'ry-tooltip-10\']/div[2]/hp-lazy-controls-tooltips/hp-app-controls-tooltips/hp-controls-tooltips-container/hp-controls-tooltips/hp-passengers-container/hp-passengers/hp-passengers-picker/ry-counter[2]/div[2]/div[3]")).click();
            teens--;
            Thread.sleep(2000);
        }
        while (children>0) {
            driver.findElement(By.xpath("//*[@id=\'ry-tooltip-10\']/div[2]/hp-lazy-controls-tooltips/hp-app-controls-tooltips/hp-controls-tooltips-container/hp-controls-tooltips/hp-passengers-container/hp-passengers/hp-passengers-picker/ry-counter[3]/div[2]/div[3]")).click();
            children--;
            Thread.sleep(2000);
        }
        while (infants>0) {
            driver.findElement(By.xpath("//*[@id=\"ry-tooltip-9\"]/div[2]/hp-lazy-controls-tooltips/hp-app-controls-tooltips/hp-controls-tooltips-container/hp-controls-tooltips/hp-passengers-container/hp-passengers/hp-passengers-picker/ry-counter[4]/div[2]/div[3]")).click();
            infants--;
            Thread.sleep(2000);
        }
        return noPassengers;
    }

    public int searchFlight(String fromCity, String to, int adults, int teens, int children, int infants, String monthF, String dayF, String monthR, String dayR) throws InterruptedException {
        setFrom(fromCity);
        setTo(to);
        setDepartureDate(monthF, dayF);
        setReturningDate(monthR, dayR);
        noPassengers = setNumberPassengers(adults, children, teens, infants);
        search();
        return noPassengers;
    }



}
