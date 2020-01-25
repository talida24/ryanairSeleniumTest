package Pages.Pages;

import org.openqa.selenium.*;

import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FirstPage {
    public WebDriver driver;

    public FirstPage(WebDriver driver){
        this.driver = driver;
    }

    public void setReturnTicket(){
        driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget/div/hp-flight-search-widget-container/hp-flight-search-widget/hp-trip-type-container/hp-trip-type/hp-trip-type-button[1]/button/label")).click();
    }
    public void setOneWayTicket(){
        driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget/div/hp-flight-search-widget-container/hp-flight-search-widget/hp-trip-type-container/hp-trip-type/hp-trip-type-button[2]/button/icon")).click();
    }

    @FindBy(id="input-button__departure")
    WebElement fromCity;
    @FindBy(id="input-button__destination")
    WebElement toCity;

    public void setFrom(String fromCity){
       WebElement from = driver.findElement(By.id("input-button__departure"));
       from.click();
       from.sendKeys(Keys.chord(Keys.CONTROL, "a"));
       from.sendKeys(Keys.BACK_SPACE);
       from.sendKeys(fromCity);
       driver.findElement(By.id("input-button__destination")).click();
    }
    public void setTo(String toCity){
        driver.findElement(By.id("input-button__destination")).sendKeys(toCity);
        driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget/div/hp-flight-search-widget-container/hp-flight-search-widget/hp-trip-type-container/hp-trip-type/hp-trip-type-button[1]/button/label")).click();
    }

    public void setDepartureDate() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget/div/hp-flight-search-widget-container/hp-flight-search-widget/div[1]/hp-flight-search-widget-controls-container/hp-flight-search-widget-controls/div[2]/div/hp-input-button[1]/div/div[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ry-tooltip-9\"]/div[2]/hp-lazy-controls-tooltips/hp-app-controls-tooltips/hp-controls-tooltips-container/hp-controls-tooltips/hp-datepicker-container/hp-datepicker/ry-datepicker-desktop/month-toggle/div/div[2]/div/div[3]/div[2]")).click();
        driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget/div/hp-flight-search-widget-container/hp-flight-search-widget/div[1]/hp-flight-search-widget-controls-container/hp-flight-search-widget-controls/div[2]/div/hp-input-button[1]/div")).click();
        driver.findElement(By.xpath("/html/body/ry-tooltip/div[2]/hp-lazy-controls-tooltips/hp-app-controls-tooltips/hp-controls-tooltips-container/hp-controls-tooltips/hp-datepicker-container/hp-datepicker/ry-datepicker-desktop/div/calendar[2]/calendar-body/div[5]/div[10]/div")).click();
    }

    public void setReturningDate(){
        driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-search-widget/div/hp-flight-search-widget-container/hp-flight-search-widget/div[1]/hp-flight-search-widget-controls-container/hp-flight-search-widget-controls/div[2]/div/hp-input-button[2]/div")).click();
        driver.findElement(By.xpath("/html/body/ry-tooltip/div[2]/hp-lazy-controls-tooltips/hp-app-controls-tooltips/hp-controls-tooltips-container/hp-controls-tooltips/hp-datepicker-container/hp-datepicker/ry-datepicker-desktop/div/calendar[1]/calendar-body/div[5]/div[19]/div")).click();
    }

    public void searchFlight(String fromCity, String to) throws InterruptedException {
        setFrom(fromCity);
        Thread.sleep(3000);
        setTo(to);
        Thread.sleep(3000);
        setDepartureDate();
        Thread.sleep(3000);
        setReturningDate();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".flight-search-widget__start-search")).click();
    }



}
