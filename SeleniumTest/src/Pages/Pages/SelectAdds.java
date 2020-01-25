package Pages.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SelectAdds {
    WebDriver driver;

    public SelectAdds(WebDriver driver){
        this.driver = driver;
    }

    public void setRandomSeats() throws InterruptedException {
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,837)");
        driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div/div[2]/div/seats-actions/span[1]/ry-tooltip")).click();
        Thread.sleep(5000);
        js.executeScript("window.scrollTo(0,837)");
        driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div/div[2]/div/seats-actions/span[1]/ry-tooltip")).click();
        Thread.sleep(5000);
    }
    public void setBags(String x) throws InterruptedException {
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        if(x == "included")
            driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container/bags-cabin-bag-row/bags-cabin-bag-products-container/bags-cabin-bag-product[1]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
        else if(x == "priority")
            driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[1]/bags-cabin-bag/bags-bag-layout/div/div/div[2]/bags-cabin-bag-journey-container/bags-cabin-bag-row/bags-cabin-bag-products-container/bags-cabin-bag-product[2]/div/bags-product-selector/div/div[1]/ry-checkbox/label/div/div[1]")).click();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("/html/body/bags-root/bags-app-container/div/main/div/ry-spinner/section[6]/bags-continue-flow-container/bags-continue-flow/button")).click();
    }

    public void setNoAdds(){
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(By.xpath("/html/body/app-root/ng-component/main/products-list-container/products-list/div/div/div[2]/div[2]/div[2]/button")).click();
    }

}
