import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class exam03 {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 800));
		driver.get("https://www.interpark.com/");
		
		//팝업창을 띄우기 전에 핸들을 만들어 놓으면 그게 원본
		String parentHandle = driver.getWindowHandle();
		
		WebElement ankerLogin = driver.findElement(By.linkText("로그인"));
		ankerLogin.click();
		
		//팝업된 주소를 얻어올 수 있음.
		Set<String> handles = driver.getWindowHandles();
		//반환값 Set<String> = (Array)List같은것
//		System.out.println(handles); > 반환값이 2개 > 인터파크창 또는 로그인 팝업창
		
		for(String handle : handles) {
			if(!handle.equals(parentHandle)){
				//핸들 목록이 원본창과 다를때 focus를 팝업창인 handle로 이동
				driver.switchTo().window(handle);
			}
		}
		
		WebElement id = driver.findElement(By.id("userId"));
		id.sendKeys("asdf");
		
		WebElement pw = driver.findElement(By.id("userPwd"));
		pw.sendKeys("asdfasdf");
		
		
		
	}
}
