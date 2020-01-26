package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setLogin() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"glyphs.close\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/hp-app-root/hp-home-container/hp-home/hp-header-container/header/hp-header/ry-header/div/div[2]/div/hp-header-menu-item[4]/button/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/ry-login-signup-dialog/div/ry-login-signup-container/ry-login-signup/ry-login-container/ry-form/div[2]/form/div[1]/ry-input/label/span[2]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/ry-login-signup-dialog/div/ry-login-signup-container/ry-login-signup/ry-login-container/ry-form/div[2]/form/div[1]/ry-input/label/span[2]/input")).sendKeys("ryanair.selenium@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/ry-login-signup-dialog/div/ry-login-signup-container/ry-login-signup/ry-login-container/ry-form/div[2]/form/div[2]/ry-input/label/span[2]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/ry-login-signup-dialog/div/ry-login-signup-container/ry-login-signup/ry-login-container/ry-form/div[2]/form/div[2]/ry-input/label/span[2]/input")).sendKeys("Ryanair!2");
        driver.findElement(By.xpath("//*[@id=\"ry-modal-portal\"]/div/ry-login-signup-dialog/div/ry-login-signup-container/ry-login-signup/ry-login-container/ry-form/div[2]/form/div[6]/button")).click();
    }
}
