package ecTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EcTest {
	
	@Test
	void testEx02() throws Exception{
		System.setProperty("webdriver.chrome.driver",	"./exe/chromedriver.exe");
		WebDriver	driver	=	new	ChromeDriver();//ChromeDriverの作成
		driver.get("http://localhost:8080/ec-202110b/item/showDetail?id=4");	//get()でブラウザ起動
		Thread.sleep(1000);
//		WebElement element = driver.findElement(By.id("size2"));
		Thread.sleep(1000);
//		element.click();
		Thread.sleep(1000);
	}

}
