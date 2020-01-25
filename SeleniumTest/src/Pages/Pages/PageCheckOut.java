package Pages.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageCheckOut {
    WebDriver driver;

    public PageCheckOut(WebDriver driver){
        this.driver = driver;
    }

    public void setCheckOut(){
        driver.findElement(By.xpath("//*[@id=\"ry-tooltip-0\"]/div[2]/trip-basket-tooltip/div/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"ry-tooltip-5\"]/div[2]/ry-price-breakdown-container/ry-price-breakdown-footer/div/div/ry-basket-continue-flow-container/ry-basket-continue-flow/button")).click();
    }

    public void setPhone() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[1]/contact-details/div/div/div[1]/div[2]/ry-dropdown/div[2]/button/div/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[1]/contact-details/div/div/div[1]/div[2]/ry-dropdown/div[2]/div/div/ry-dropdown-item[69]/button/div/div[1]")).click();
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[1]/contact-details/div/div/div[1]/div[2]/ry-input-d/div/input")).sendKeys("737872669");
    }

    public void setInssurance(){
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[2]/insurance/div/div[1]/div/div[1]/ry-checkbox/label/div/div[1]")).click();
    }
    public void setNoInssurance(){
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[2]/insurance/div/div[3]/div[1]/ry-checkbox/label/div/div[1]")).click();
    }

    public void setCard(String zipCode, String cardNumber, String expiryDate, String CVV, String address, String city, String cardholderName) throws InterruptedException {
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 870)");

        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[1]/div[2]/card-details/form/ry-input-d[1]/div/input")).click();
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[1]/div[2]/card-details/form/ry-input-d[1]/div/input")).sendKeys(cardNumber);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[1]/div[2]/card-details/form/expiry-date/label/span[2]/input")).click();
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[1]/div[2]/card-details/form/expiry-date/label/span[2]/input")).sendKeys(expiryDate);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[1]/div[2]/card-details/form/verification-code/div/ry-input-d/div/input")).click();
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[1]/div[2]/card-details/form/verification-code/div/ry-input-d/div/input")).sendKeys(CVV);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-input-d[1]/div/input")).click();
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-input-d[1]/div/input")).sendKeys(address);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-input-d[3]/div/input")).click();
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-input-d[3]/div/input")).sendKeys(city);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-dropdown/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-dropdown/div[2]/div/div/ry-dropdown-item[161]/button/div/div[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-input-d[4]/div/input")).click();
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[2]/billing-address/address-form/form/ry-input-d[4]/div/input")).sendKeys(zipCode);
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[1]/div[2]/card-details/form/ry-input-d[2]/div/input")).click();
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/ry-tabs/div[2]/add-method-modal/form/div/div/div[1]/div[2]/card-details/form/ry-input-d[2]/div/input")).sendKeys(cardholderName);

    }

    public void setCurrency() throws InterruptedException {
        JavascriptExecutor js;
        js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/currency-converter/form/div/div/div[2]/ry-dropdown/div[2]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[5]/payment-methods/div/div/currency-converter/form/div/div/div[2]/ry-dropdown/div[2]/div/div/ry-dropdown-item[1]/button/div/div[1]")).click();
    }

    public void pay(){
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[8]/div/terms-and-conditions/div/div/ry-checkbox/label/div/div[1]")).click();
        driver.findElement(By.xpath("/html/body/app-root/ng-component/ry-spinner/div/payment-form/form/div[8]/div/pay-button/div/button")).click();
    }
}
