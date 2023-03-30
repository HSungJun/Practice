import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class quiz02_1 {
	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--blink-settings=imagesEnabled=false");

		
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.manage().window().setSize(new Dimension(1600, 800));
		//무신사 전체 1위 제품 구매하기. (배송지 및 결제방법 선입력 필요.)
		driver.get("https://www.musinsa.com/app/");
		
//		String first = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ranking_list > span > a")))
//					.getAttribute("href");
//		driver.get(first);
		WebElement all = driver.findElement(By.xpath("//*[@id=\"ranking_list\"]/span/a"));
		all.click();
		
		String first = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#goodsRankList > li:nth-child(1) > div.li_inner > div.list_img > a")))
					.getAttribute("href");
		driver.get(first);
		
		
		
		//로그인시 실행. 로그인 해놓은 경우 하단의 "여기"까지 주석처리
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("header-member__login")));
		WebElement Login = driver.findElement(By.className("header-member__login"));
		Login.click();
		
		
		WebElement id = driver.findElement(By.name("id"));
		id.sendKeys(/*id 입력*/);
		
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys(/*pw 입력*/);
		
		WebElement loginBtn = driver.findElement(By.className("login-button__item--black"));
		loginBtn.click();
		//"여기" 까지 로그인 기능.
		 
		
		
		//선택옵션이 1개인 경우 옵션상 최상단 옵션선택후 구매
		WebElement option = driver.findElement(By.name("option1"));
		option.click();
		option.sendKeys(Keys.DOWN, Keys.RETURN);
		
		//옵션을 선택하고 싶거나 없는 경우 상단의 옵션 선택 부분 및 하단의 구매버튼을 주석처리 할 경우 옵션선택 후 구매버튼을 누르는 경우 자동진행.
		
		//상품페이지 내 구매버튼
		WebElement buyBtn= driver.findElement(By.className("btn_black"));
		buyBtn.click();
		
		//결제 페이지 상품구매동의 후 결제진행
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#btn_pay")));
		WebElement optionBtn= driver.findElement(By.cssSelector("#payment_info_area > ul:nth-child(11) > li.cell_discount_detail.last > div > div.order-agree__title > div > label"));
		optionBtn.click();
		
		WebElement pay= driver.findElement(By.cssSelector("#btn_pay"));
		pay.click();
		
		//이후 결제 진행하면 구매완료.
		
	}
}
