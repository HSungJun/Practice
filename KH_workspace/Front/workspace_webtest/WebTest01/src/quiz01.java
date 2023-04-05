import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class quiz01 {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().setSize(new Dimension(1600, 800));
		//무신사 제품 링크에서 자동구매 - 배송지입력 및 최종구매버튼의 경우 직접 클릭.
		driver.get("https://www.musinsa.com/app/goods/2608456?loc=goods_rank");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("header-member__login")));
		WebElement Login = driver.findElement(By.className("header-member__login"));
		Login.click();
		
		
		WebElement id = driver.findElement(By.name("id"));
		id.sendKeys(/*id 입력*/);
		
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys(/*pw 입력*/);
		
		WebElement loginBtn = driver.findElement(By.className("login-button__item--black"));
		loginBtn.click();
		
		WebElement option = driver.findElement(By.name("option1"));
		option.click();
		option.sendKeys(Keys.DOWN, Keys.RETURN);
		
		WebElement buyBtn= driver.findElement(By.className("btn_black"));
		buyBtn.click();
		
	}
}
