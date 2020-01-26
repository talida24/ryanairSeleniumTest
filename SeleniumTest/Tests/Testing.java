import Pages.FirstPage;
import Pages.LoginPage;
import Pages.SelectAdds;
import Pages.SelectFlight;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testing {

    @Test
    public void first_page() throws InterruptedException {
        String actual_title;
        String expected_title;
        String webURL = "https://www.ryanair.com/ie/en";
        System.setProperty("webdriver.chrome.driver", "C:/Users/Talida/Desktop/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(webURL);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setLogin();

        FirstPage firstPage = new FirstPage(driver);
        firstPage.setReturnTicket();
        firstPage.searchFlight("toulouse", "malta");
        Thread.sleep(3000);

        SelectFlight selectFlightPage = new SelectFlight(driver);
        selectFlightPage.setPackageValue();
        selectFlightPage.setPassanger("ms","talida","rosioru");

        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div[3]/div[2]/div/seats-actions/span[1]/ry-tooltip")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/seats-root/div/main/seats-container/div/div[3]/div[2]/div/seats-actions/span[1]/ry-tooltip")).click();

        SelectAdds selectAdds = new SelectAdds(driver);
        Thread.sleep(10000);
        selectAdds.setBags("included");
        Thread.sleep(10000);
        selectAdds.setNoAdds();


    }
}
