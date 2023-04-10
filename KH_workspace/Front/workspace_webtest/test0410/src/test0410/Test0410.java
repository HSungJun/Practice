package test0410;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test0410 {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));		
		
		driver.get("https://www.iei.or.kr/main/main.kh");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#head_top_nav > div.head_top_right > a:nth-child(1)")));
		WebElement login = driver.findElement(By.cssSelector("#head_top_nav > div.head_top_right > a:nth-child(1)"));
		login.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement id = driver.findElement(By.id("id"));
		id.sendKeys("sungjun960");
		WebElement pw = driver.findElement(By.id("password"));
		pw.sendKeys("tnwls960@");
		
		
		WebElement loginbtn = driver.findElement(By.linkText("로그인"));
		loginbtn.click();
		
		
		
		wait.until(ExpectedConditions.titleIs("KH정보교육원 - 마이페이지"));		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"right_nav_e\"]/ul[2]/li[1]")));
		WebElement board = driver.findElement(By.xpath("//*[@id=\"right_nav_e\"]/ul[2]/li[1]"));
		board.click();
		
		wait.until(ExpectedConditions.titleIs("KH정보교육원 - 우리반 게시판"));		
		
		WebElement write = driver.findElement(By.xpath("//*[@id=\"content_sub_wrap\"]/div[2]/div[3]/a"));
		write.click();
		
		
		
		WebElement title = driver.findElement(By.id("title"));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.id("title"), 1));
		title.sendKeys("시험문제 답안 작성 중 입니다. 홍성준");
		
		
//		WebElement frame = driver.findElement(By.className("tx-content-container"));
//		frame.sendKeys("시험문제 답안 작성 중 입니다. 내용 - frame 처리");
		
		
		WebElement send = driver.findElement(By.className("common_btn1"));
		send.click();
		
		wait.until(ExpectedConditions.alertIsPresent()).accept();
		
		
	
		
		
		
	}
}
