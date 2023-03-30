import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exam04 {
	public static void main(String[] args) {
		//vscode ETC exam01 연계
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		//유령모드 - 완성 후 확인할 시 브라우저를 띄우지 않고 실행하기 위한 기능.
		
		options.addArguments("--blink-settings=imagesEnabled=false");
		//이미지가 페이지를 로딩할 떄에 가장 오래 걸림
		
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("http://127.0.0.1:5500/ETC/exam01.html");
		
//		js.executeScript("pop()");
		//페이지 로드후 버튼을 누르기전에 pop() 실행. - 버튼을 눌러 함수를 실행하지않고 바로 함수를 콜 할 수도있음. 
		
		js.executeScript("test()");
		// 사용되지 않는 함수도 호출하면 실행가능.
		
		
		wait.until(ExpectedConditions.alertIsPresent()); //alert이 존재할때까지 기다려라.
		driver.switchTo().alert().accept();
		//alert창은 하나밖에 뜰수 없음. > alert이 떳을떄 이동 후 확인버튼을 통한 alert 닫기.
		
	}
}
