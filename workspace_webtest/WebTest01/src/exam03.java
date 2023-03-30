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
		
		//�˾�â�� ���� ���� �ڵ��� ����� ������ �װ� ����
		String parentHandle = driver.getWindowHandle();
		
		WebElement ankerLogin = driver.findElement(By.linkText("�α���"));
		ankerLogin.click();
		
		//�˾��� �ּҸ� ���� �� ����.
		Set<String> handles = driver.getWindowHandles();
		//��ȯ�� Set<String> = (Array)List������
//		System.out.println(handles); > ��ȯ���� 2�� > ������ũâ �Ǵ� �α��� �˾�â
		
		for(String handle : handles) {
			if(!handle.equals(parentHandle)){
				//�ڵ� ����� ����â�� �ٸ��� focus�� �˾�â�� handle�� �̵�
				driver.switchTo().window(handle);
			}
		}
		
		WebElement id = driver.findElement(By.id("userId"));
		id.sendKeys("asdf");
		
		WebElement pw = driver.findElement(By.id("userPwd"));
		pw.sendKeys("asdfasdf");
		
		
		
	}
}
