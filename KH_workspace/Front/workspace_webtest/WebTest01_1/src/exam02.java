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
		//��ٸ��� �����ϴ� �ν��Ͻ�. driver���� �Ͼ�� �ϵ��� 10�ʱ��� ��ٸ���. 10�ʳ����� ������.
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com");
		
//		js.executeScript("document.getElementById('id').value=arguments[0]",Statics.NAVER_ID);
//		js.executeScript("document.getElementById('pw').value=arguments[0]",Statics.NAVER_PW);
		
		driver.findElement(By.id("log.login")).click();
		
		driver.findElement(By.id("new.dontsave")).click();
		
		driver.get("https://mail.naver.com/v2/folders/0/all");
		
		
		//�ð��� (5��)������ ���� �ε� �� ����ǵ��� ��
//		Thread.sleep(5000);
		//untill 0.5s ���� Ȯ��.
//		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("button_write_to_me")));
		wait.until(ExpectedConditions.numberOfElementsToBe(By.className("button_write_to_me"), 1));
		
		
		
		//class �� �������� ���� �� ����.
		List<WebElement> btnWriteToMe = driver.findElements(By.className("button_write_to_me"));
		// Elements �� ����Ʈ�� ��ȯ �迭�� ����
		System.out.println(btnWriteToMe.size());
		//�������� ������ �̵��ߴ��� ���α׷��� �ν���������. �������� �ε��� Ŭ�����˻��Ұ�� ã�� �� ���� ���
		
		btnWriteToMe.get(0).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("subject_title")));
		
		WebElement title = driver.findElement(By.id("subject_title"));
		title.sendKeys("test");

		
		
		//iframe ���� workseditor-content �Է¶��� �����ؼ� �Էö��� ã�� ���� xpath�� Ȱ���� 
		//iframe �Ӽ������� �˻��� ���ο�Ҹ� ã���ش�.
		
		
		
		List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
		
//		WebDriver oldDriver = driver; driver�� �ν��Ͻ� �ּҵ��� ����Ǵ°� �ƴϱ� ������
		// old�� ����� �ʿ䰡 ����.
		
		for(WebElement e :iframe) {
			if(e.getAttribute("tabindex")==null ) {continue;}
				driver.switchTo().frame(e).findElements(By.className("workseditor-content"))
				.get(0)
				.sendKeys("asdf");
			break;
		}// for���� ����� ���� ���� ���ϴ� frame���� focus ��.
		
		driver.switchTo().defaultContent();
		
		WebElement save = driver.findElement(By.className("button_write_task"));
		save.click();
		
		
		
		
//		driver.findElement(By.xpath("/html/body/div/div[1]"));
		//xpath�� �˻��ϴ� �ӵ��� ������ �߾�������. ������ ����. 
		
		
//		WebElement contents = driver.findElement(By.className("workseditor-content"));
//		contents.sendKeys("test");

		
//		WebElement inputID = driver.findElement(By.id("id"));
//		inputID.sendKeys("1234");
//		
//		WebElement inputPW = driver.findElement(By.id("pw"));
//		inputPW.sendKeys("1234");
	}
}
