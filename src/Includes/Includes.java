package Includes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Includes {
    public void Includes(){
        String webURL = "https://www.ryanair.com/ie/en";
        System.setProperty("webdriver.chrome.driver", "C:/Users/Talida/Desktop/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }
}
