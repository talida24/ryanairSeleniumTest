package Webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SelectAddsPage {
    WebDriver driver;
    JavascriptExecutor js;

    public SelectAddsPage(WebDriver driver){
        this.driver = driver;
    }

    public void setRandomSeats() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        try {
            if(driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/seats-modal/ry-message-dialog/ry-dialog/div/div[2]/div[2]/button")) != null)
                driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/seats-modal/ry-message-dialog/ry-dialog/div/div[2]/div[2]/button")).click();
        } catch (NoSuchElementException e) {
            System.out.println("No random 1");
        }

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(5000);
        try {
            if (driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div/div[2]/div/seats-actions/span[1]/ry-tooltip")) != null)
                driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div/div[2]/div/seats-actions/span[1]/ry-tooltip")).click();
        } catch (NoSuchElementException e) {
            System.out.println("No random 2");
            driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div/div[1]/div/seats-prompt/ry-action-sheet/div/div/div[1]/div/div/div[2]/button[2]")).click();
        }

        try {
            if (driver.findElement(By.xpath("/html/body/seats-root/ry-message-renderer/hero-loader-with-data/ng-component/ry-default-takeover/div/div[2]/button[2]")) != null) {
                driver.findElement(By.xpath("/html/body/seats-root/ry-message-renderer/hero-loader-with-data/ng-component/ry-default-takeover/div/div[2]/button[2]")).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("No random 4");
        }

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(5000);
        try{
            if(driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div/div[2]/div/seats-actions/span[1]/ry-tooltip")).isDisplayed()) {
                driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div/div[2]/div/seats-actions/span[1]/ry-tooltip")).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("No random 4");
            //driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div/div[1]/div/seats-prompt/ry-action-sheet/div/div/div[1]/div/div/div[2]/button[2]")).click();
        }
    }

    public void setBags(String x, int noPassengers) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        Thread.sleep(5000);

        if (noPassengers == 1) {
            if (x == "included")
                driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container/bags-cabin-bag-row/bags-cabin-bag-products-container/bags-cabin-bag-product[1]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
            else if (x == "priority")
                driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container/bags-cabin-bag-row/bags-cabin-bag-products-container/bags-cabin-bag-product[2]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }
        else {
            for(int i=1;i<=noPassengers;i++) {
                if (x == "included") {
                    driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container[1]/bags-cabin-bag-row[" + i + "]/bags-cabin-bag-products-container/bags-cabin-bag-product[1]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
                    driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container[2]/bags-cabin-bag-row[" + i + "]/bags-cabin-bag-products-container/bags-cabin-bag-product[1]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
                } else if (x == "priority") {
                    driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container[1]/bags-cabin-bag-row[" + i + "]/bags-cabin-bag-products-container/bags-cabin-bag-product[2]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
                    driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container[2]/bags-cabin-bag-row[" + i + "]/bags-cabin-bag-products-container/bags-cabin-bag-product[2]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
                }
                js.executeScript("window.scrollTo(0, 500)");
            }
        }

        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[6]/bags-continue-flow-container/bags-continue-flow/button")).click();
    }

    public void setNoAdds() throws InterruptedException {
        Thread.sleep(5000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("/html/body/app-root/ng-component/main/products-list-container/products-list/div/div/div[2]/div[2]/div[2]/button")).click();
    }
}
