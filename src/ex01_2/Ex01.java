package ex01_2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ex01 {
	
	@Disabled
	@Test
	void testEx01() throws Exception{
		System.setProperty("webdriver.chrome.driver",	"./exe/chromedriver.exe");
		WebDriver	driver	=	new	ChromeDriver();//ChromeDriverの作成
		driver.get("http://www.google.com/xhtml");	//get()でブラウザ起動
		Thread.sleep(1000);//処理を停止(動作確認の為)
		WebElement	searchBox	=	driver.findElement(By.name("q"));
		searchBox.sendKeys("selenium");
		searchBox.submit();
		Thread.sleep(1000);
		WebElement firstLink = driver.findElement(By.cssSelector("div.yuRUbf > a > h3"));
		System.out.println(firstLink.getText());
	}
	
	
	@Test
	void testEx02() throws Exception{
		System.setProperty("webdriver.chrome.driver",	"./exe/chromedriver.exe");
		WebDriver	driver	=	new	ChromeDriver();//ChromeDriverの作成
		driver.get("https://rakuplus.jp/");	//get()でブラウザ起動
		Thread.sleep(1000);
		WebElement inputUserName = driver.findElement(By.id("user_login"));
		inputUserName.sendKeys("asumi.miyazaki@rakus-partners.co.jp");
		WebElement inputPass = driver.findElement(By.id("user_pass"));
		inputPass.sendKeys("asumi.miyazaki@rakus-partners.co.jp");
		WebElement element = driver.findElement(By.id("wp-submit"));
		Thread.sleep(1000);
		element.click();
		Thread.sleep(1000);
	}

}
