import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exam02 {
	public static void main(String[] args) throws Exception{
		
		WebDriver driver = new ChromeDriver();
		//기다림을 관제하는 인스턴스. driver에서 일어나는 일들을 10초까지 기다린다. 10초넘을시 에러냄.
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com");
		
//		js.executeScript("document.getElementById('id').value=arguments[0]",Statics.NAVER_ID);
//		js.executeScript("document.getElementById('pw').value=arguments[0]",Statics.NAVER_PW);
		
		driver.findElement(By.id("log.login")).click();
		
		driver.findElement(By.id("new.dontsave")).click();
		
		driver.get("https://mail.naver.com/v2/folders/0/all");
		
		
		//시간을 (5초)딜레이 시켜 로딩 후 실행되도록 함
//		Thread.sleep(5000);
		//untill 0.5s 마다 확인.
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("button_write_to_me")));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.className("button_write_to_me"), 1));
		
		
		
		//class 는 여려개가 나올 수 있음.
		List<WebElement> btnWriteToMe = driver.findElements(By.className("button_write_to_me"));
		// Elements 라서 리스트로 반환 배열로 묶음
		System.out.println(btnWriteToMe.size());
		//브라우저가 어디까지 이동했는지 프로그램은 인식하지않음. 페이지를 로딩중 클래스검색할경우 찾을 수 없는 경우
		
		btnWriteToMe.get(0).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subject_title")));
		
		WebElement title = driver.findElement(By.id("subject_title"));
		title.sendKeys("test");

		
		
		//iframe 내에 workseditor-content 입력란이 존재해서 입련란을 찾기 위해 xpath를 활용해 
		//iframe 속성값으로 검색해 내부요소를 찾아준다.
		
		
		
		List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
		
//		WebDriver oldDriver = driver; driver의 인스턴스 주소등은 변경되는게 아니기 떄문에
		// old를 사용할 필요가 없다.
		
		for(WebElement e :iframe) {
			if(e.getAttribute("tabindex")==null ) {continue;}
				driver.switchTo().frame(e).findElements(By.className("workseditor-content"))
				.get(0)
				.sendKeys("asdf");
			break;
		}// for문을 벗어나는 순간 내가 원하는 frame으로 focus 됨.
		
		driver.switchTo().defaultContent();
		
		WebElement save = driver.findElement(By.className("button_write_task"));
		save.click();
		
		
		
		
//		driver.findElement(By.xpath("/html/body/div/div[1]"));
		//xpath는 검색하는 속도가 느려서 잘쓰지않음. 최후의 수단. 
		
		
//		WebElement contents = driver.findElement(By.className("workseditor-content"));
//		contents.sendKeys("test");

		
//		WebElement inputID = driver.findElement(By.id("id"));
//		inputID.sendKeys("1234");
//		
//		WebElement inputPW = driver.findElement(By.id("pw"));
//		inputPW.sendKeys("1234");
	}
}
