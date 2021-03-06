package Webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setLogin(String email, String password) throws InterruptedException {
        Thread.sleep(2000);
        try {
            driver.findElement(By.xpath("//*[@id=\"glyphs.close\"]")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-header-container/header/hp-header/ry-header/div/div[2]/div/hp-header-menu-item[4]/button/span")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/ry-login-signup-dialog/div/ry-login-signup-container/ry-login-signup/ry-login-container/ry-form/div[2]/form/div[1]/ry-input/label/span[2]/input")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/ry-login-signup-dialog/div/ry-login-signup-container/ry-login-signup/ry-login-container/ry-form/div[2]/form/div[1]/ry-input/label/span[2]/input")).sendKeys(email);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/ry-login-signup-dialog/div/ry-login-signup-container/ry-login-signup/ry-login-container/ry-form/div[2]/form/div[2]/ry-input/label/span[2]/input")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/ry-login-signup-dialog/div/ry-login-signup-container/ry-login-signup/ry-login-container/ry-form/div[2]/form/div[2]/ry-input/label/span[2]/input")).sendKeys(password);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/ry-login-signup-dialog/div/ry-login-signup-container/ry-login-signup/ry-login-container/ry-form/div[2]/form/div[6]/button")).click();

        }catch (Exception e){
            System.out.println("More than 1 test. No need of login.");
        }
    }

    public void setLogout() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-header-container/header/hp-header/ry-header/div/div[2]/div/hp-header-menu-item[3]/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ry-tooltip-8\"]/div[2]/hp-header-dropdown-user/div/div/a")).click();

    }
}
