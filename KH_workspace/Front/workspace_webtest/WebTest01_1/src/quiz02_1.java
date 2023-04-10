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
		//���Ż� ��ü 1�� ��ǰ �����ϱ�. (����� �� ������� ���Է� �ʿ�.)
		driver.get("https://www.musinsa.com/app/");
		
//		String first = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ranking_list > span > a")))
//					.getAttribute("href");
//		driver.get(first);
		WebElement all = driver.findElement(By.xpath("//*[@id=\"ranking_list\"]/span/a"));
		all.click();
		
		String first = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#goodsRankList > li:nth-child(1) > div.li_inner > div.list_img > a")))
					.getAttribute("href");
		driver.get(first);
		
		
		
		//�α��ν� ����. �α��� �س��� ��� �ϴ��� "����"���� �ּ�ó��
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("header-member__login")));
		WebElement Login = driver.findElement(By.className("header-member__login"));
		Login.click();
		
		
		WebElement id = driver.findElement(By.name("id"));
		id.sendKeys(/*id �Է�*/);
		
		WebElement pw = driver.findElement(By.name("pw"));
		pw.sendKeys(/*pw �Է�*/);
		
		WebElement loginBtn = driver.findElement(By.className("login-button__item--black"));
		loginBtn.click();
		//"����" ���� �α��� ���.
		 
		
		
		//���ÿɼ��� 1���� ��� �ɼǻ� �ֻ�� �ɼǼ����� ����
		WebElement option = driver.findElement(By.name("option1"));
		option.click();
		option.sendKeys(Keys.DOWN, Keys.RETURN);
		
		//�ɼ��� �����ϰ� �Ͱų� ���� ��� ����� �ɼ� ���� �κ� �� �ϴ��� ���Ź�ư�� �ּ�ó�� �� ��� �ɼǼ��� �� ���Ź�ư�� ������ ��� �ڵ�����.
		
		//��ǰ������ �� ���Ź�ư
		WebElement buyBtn= driver.findElement(By.className("btn_black"));
		buyBtn.click();
		
		//���� ������ ��ǰ���ŵ��� �� ��������
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#btn_pay")));
		WebElement optionBtn= driver.findElement(By.cssSelector("#payment_info_area > ul:nth-child(11) > li.cell_discount_detail.last > div > div.order-agree__title > div > label"));
		optionBtn.click();
		
		WebElement pay= driver.findElement(By.cssSelector("#btn_pay"));
		pay.click();
		
		//���� ���� �����ϸ� ���ſϷ�.
		
	}
}
