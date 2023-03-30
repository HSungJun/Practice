import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class exam01 {
	public static void main(String[] args) {
		
		// UI test (웹 자동화 기술)
		// 페이지의 UI 오류 테스트 (파일럿 테스트)
		// API 라이브러리 사용가능. (naver: guitar 웹자동화 기술)
		// selenium은 라이브러리 및 툴(choromedriver)이 필요함.
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.naver.com");
		
		//return 값 webdriver 
		WebElement inputSearch = driver.findElement(By.id("query"));
		
		inputSearch.sendKeys("KH정보교육원");
		
		WebElement inputbtn = driver.findElement(By.id("search_btn"));
		inputbtn.click();
		
	}
}
