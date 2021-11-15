package ex01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class E01 {
	
	@Test
	@Disabled
	void test1() {
		try {
			System.setProperty("webdriver.chrome.driver",	"./exe/chromedriver.exe");
			WebDriver	driver	=	new	ChromeDriver();//ChromeDriverの作成
			driver.get("http://www.google.com/xhtml");	//get()でブラウザ起動
			Thread.sleep(1000);//処理を停止(動作確認の為)
			//ブラウザの要素を指定　メソッド名がわかりやすいですよね。
			WebElement	searchBox	=	driver.findElement(By.name("q"));
			searchBox.sendKeys("selenium");
			searchBox.submit();
		 	WebElement firstLink = driver.findElement(By.cssSelector("div.yuRUbf > a > h3"));
			Thread.sleep(1000);
			String actual = firstLink.getText();
			String expected = "Seleniumブラウザー自動化プロジェクト";
			assertEquals(expected, actual);
			System.out.println(firstLink.getText());
//			driver.quit();	//ブラウザを閉じる
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	@Disabled
	void test1_2() {
		try {
			System.setProperty("webdriver.chrome.driver",	"./exe/chromedriver.exe");
			WebDriver	driver	=	new	ChromeDriver();//ChromeDriverの作成
			driver.get("http://www.google.com/xhtml");	//get()でブラウザ起動
			Thread.sleep(1000);//処理を停止(動作確認の為)
			//ブラウザの要素を指定　メソッド名がわかりやすいですよね。
			WebElement	searchBox	=	driver.findElement(By.name("q"));
			searchBox.sendKeys("selenium");
			searchBox.submit();
			WebElement firstLink = driver.findElement(By.cssSelector("div.yuRUbf > a > h3"));
			Thread.sleep(1000);
//			String actual = firstLink.getText();
//			String expected = "Seleniumブラウザー自動化プロジェクト";
//			assertEquals(expected, actual);
//			System.out.println(firstLink.getText());
//			driver.quit();	//ブラウザを閉じる
			driver.findElement(By.cssSelector("div.yuRUbf > a"));
//			assertEquals("https://www.selenium.dev/ja/documentation/", actual);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	@Disabled
	void test2() throws Exception {
			System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
			WebDriver driver = new ChromeDriver();// ChromeDriverの作成
			driver.get("https://rakuplus.jp/"); // get()でブラウザ起動
			Thread.sleep(1000);// 処理を停止(動作確認の為)
			WebElement inputUserName = driver.findElement(By.name("log"));
			WebElement inputPassword = driver.findElement(By.name("pwd"));
			inputUserName.sendKeys("");
			inputPassword.sendKeys("");
			inputPassword.submit();
			Thread.sleep(1000);
			File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Files.copy(file.toPath(), new File("C:/tmp/" + file.getName()).toPath());
	}
	
	@Test
	void test3() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./exe/chromedriver.exe");
		WebDriver driver = new ChromeDriver();// ChromeDriverの作成
		driver.get("https://www.e-procurement.metro.tokyo.jp/index.jsp"); // get()でブラウザ起動
		Thread.sleep(1000);// 処理を停止(動作確認の為)
		driver.findElement(By.cssSelector("li.cat_menu_1 > a:nth-child(1) > img")).click();
		
		Set<String> set = driver.getWindowHandles();
		for (String s : set) {
			driver.switchTo().window(s);
		}
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#topMenuBtn03 > a")).click();
		
		driver.findElement(By.name("StartDateYY")).sendKeys("3");
		driver.findElement(By.name("StartDateMM")).sendKeys("11");
		driver.findElement(By.name("StartDateDD")).sendKeys("15");

		driver.findElement(By.name("EndDateYY")).sendKeys("3");
		driver.findElement(By.name("EndDateMM")).sendKeys("11");
		driver.findElement(By.name("EndDateDD")).sendKeys("30");
		driver.findElement(By.linkText("検索")).click();
		Thread.sleep(1000);
		WebElement tables = driver.findElement(By.cssSelector("table.list-data"));
		System.out.println(tables.getText());
		List<WebElement> trList = tables.findElements(By.tagName("tr"));
		int i = 0;
		for (WebElement element : trList) {
			if (i >= 1) {
			List<WebElement> tdList = element.findElements(By.tagName("td"));
			System.out.println(tdList.get(0).getText() 
					+ "\t" + tdList.get(1).getText()
					+ "\t" + tdList.get(2).getText());
			}
			i ++;
		}
	}
}
