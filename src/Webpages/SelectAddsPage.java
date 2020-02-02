package Webpages;

import gherkin.lexer.Th;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class SelectAddsPage {
    WebDriver driver;
    JavascriptExecutor js;

    public SelectAddsPage(WebDriver driver){
        this.driver = driver;
    }

    public void setRandomSeats() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        try {
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/seats-modal/ry-message-dialog/ry-dialog/div/div[2]/div[2]/button")).click();
        } catch (Exception e) {
            System.out.println("no modal");
        }

        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        try {
            driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div/div[2]/div/seats-actions/span[1]/ry-tooltip")).click();
        } catch (Exception e) {
            driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div/div[1]/div/seats-prompt/ry-action-sheet/div/div/div[1]/div/div/div[2]/button[2]")).click();
        }

        try {
            driver.findElement(By.xpath("/html/body/seats-root/ry-message-renderer/hero-loader-with-data/ng-component/ry-default-takeover/div/div[2]/button[2]")).click();
        } catch (Exception e) {
        }
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        try{
            driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div/div[2]/div/seats-actions/span[1]/ry-tooltip")).click();
        } catch (NoSuchElementException e) {
            //driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div/div[1]/div/seats-prompt/ry-action-sheet/div/div/div[1]/div/div/div[2]/button[2]")).click();
        }
    }

    public void setBags(String x, int noPassengers) throws InterruptedException {
        js = (JavascriptExecutor) driver;
        Thread.sleep(2000);

        if (noPassengers == 1) {
            if (x == "included") {
                driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container/bags-cabin-bag-row/bags-cabin-bag-products-container/bags-cabin-bag-product[1]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
                driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container[2]/bags-cabin-bag-row/bags-cabin-bag-products-container/bags-cabin-bag-product[1]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
            }
            else if (x == "priority")
                driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container/bags-cabin-bag-row/bags-cabin-bag-products-container/bags-cabin-bag-product[2]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
                driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container[2]/bags-cabin-bag-row/bags-cabin-bag-products-container/bags-cabin-bag-product[2]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
        }
        else {
            for(int i=1;i<=noPassengers;i++) {
                if (x == "included") {
                    WebElement element = driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container[1]/bags-cabin-bag-row[" + i + "]/bags-cabin-bag-products-container/bags-cabin-bag-product[1]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]"));
                    Actions actions = new Actions(driver);
                    actions.moveToElement(element).click().perform();
                    element = driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container[2]/bags-cabin-bag-row[" + i + "]/bags-cabin-bag-products-container/bags-cabin-bag-product[1]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]"));
                    actions.moveToElement(element).click().perform();
                    Thread.sleep(2000);
                } else if (x == "priority") {
                    driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container[1]/bags-cabin-bag-row[" + i + "]/bags-cabin-bag-products-container/bags-cabin-bag-product[2]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
                    driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container[2]/bags-cabin-bag-row[" + i + "]/bags-cabin-bag-products-container/bags-cabin-bag-product[2]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
                }
            }
        }
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[6]/bags-continue-flow-container/bags-continue-flow/button")).click();
    }

    public void setNoAdds() throws InterruptedException {
        Thread.sleep(5000);
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("/html/body/app-root/ng-component/main/products-list-container/products-list/div/div/div[2]/div[2]/div[2]/button")).click();
    }
}
