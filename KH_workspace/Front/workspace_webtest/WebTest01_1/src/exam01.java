import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class exam01 {
	public static void main(String[] args) {
		
		// UI test (�� �ڵ�ȭ ���)
		// �������� UI ���� �׽�Ʈ (���Ϸ� �׽�Ʈ)
		// API ���̺귯�� ��밡��. (naver: guitar ���ڵ�ȭ ���)
		// selenium�� ���̺귯�� �� ��(choromedriver)�� �ʿ���.
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.naver.com");
		
		//return �� webdriver 
		WebElement inputSearch = driver.findElement(By.id("query"));
		
		inputSearch.sendKeys("KH����������");
		
		WebElement inputbtn = driver.findElement(By.id("search_btn"));
		inputbtn.click();
		
		
	}
}
