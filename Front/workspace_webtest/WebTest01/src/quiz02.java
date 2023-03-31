import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class quiz02 {
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--blink-settings=imagesEnabled=false");

		
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().setSize(new Dimension(1600, 800));
		//¹«½Å»ç
		driver.get("https://www.musinsa.com/app/");
		
		String first = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".n-label.label-default.txt_num_rank + .ranking_item_img > a")))
					.getAttribute("href");
		driver.get(first);
		
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("header-member__login")));
		WebElement Login = driver.findElement(By.className("header-member__login"));
		Login.click();
		
		
		WebElement id = driver.findElement(By.name("id"));
		id.sendKeys(Statics.MSS_ID);
		
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys(Statics.MSS_PW);
		
		WebElement loginBtn = driver.findElement(By.className("login-button__item--black"));
		loginBtn.click();
		
		WebElement option = driver.findElement(By.name("option1"));
		option.click();
		option.sendKeys(Keys.DOWN, Keys.RETURN);
		
		WebElement buyBtn= driver.findElement(By.className("btn_black"));
		buyBtn.click();
		

		
		
	}
}
