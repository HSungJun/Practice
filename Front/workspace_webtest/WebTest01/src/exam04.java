import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class exam04 {
	public static void main(String[] args) {
		//vscode ETC exam01 ����
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		//���ɸ�� - �ϼ� �� Ȯ���� �� �������� ����� �ʰ� �����ϱ� ���� ���.
		
		options.addArguments("--blink-settings=imagesEnabled=false");
		//�̹����� �������� �ε��� ���� ���� ���� �ɸ�
		
		WebDriver driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		driver.get("http://127.0.0.1:5500/ETC/exam01.html");
		
//		js.executeScript("pop()");
		//������ �ε��� ��ư�� ���������� pop() ����. - ��ư�� ���� �Լ��� ���������ʰ� �ٷ� �Լ��� �� �� ��������. 
		
		js.executeScript("test()");
		// ������ �ʴ� �Լ��� ȣ���ϸ� ���డ��.
		
		
		wait.until(ExpectedConditions.alertIsPresent()); //alert�� �����Ҷ����� ��ٷ���.
		driver.switchTo().alert().accept();
		//alertâ�� �ϳ��ۿ� ��� ����. > alert�� ������ �̵� �� Ȯ�ι�ư�� ���� alert �ݱ�.
		
	}
}
