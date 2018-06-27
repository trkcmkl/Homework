package webelements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webelements {
	WebDriver dr;
	List<String> list = new ArrayList<>();

	@BeforeClass
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dr.switchTo();
		dr.manage().window().fullscreen();
	}

//	@Test
//	public void mylinks() {
//		dr.get("https://github.com");
//		List<WebElement> links = dr.findElements(By.tagName("a"));
//		for (WebElement link : links) {
//			System.out.println(link.getText());
//		}
//		System.out.println("=======jskahakshd====");
//		for (int i = 0; i < links.size(); i++) {
//			if (!links.get(i).getText().isEmpty()) {
//				list.add(links.get(i).getText() + "\n");
//			}
//		}
//		System.out.println(list);
//	}
	@Test
	public void seleniumWebelementForm() {
		dr.get("https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");
		List<WebElement> inputboxes = dr.findElements(By.xpath("//input[@type='text']"));
		List<WebElement> dropdown = dr.findElements(By.xpath("//select"));
		List<WebElement> checkbox = dr.findElements(By.xpath("//input[@type='checkbox']"));
		List<WebElement> radiobox = dr.findElements(By.xpath("//input[@type='radio']"));
		List<WebElement> button = dr.findElements(By.xpath("//button[@value='submit']"));
		System.out.println(inputboxes.size()+","+dropdown.size()+","+checkbox.size()+","+radiobox.size()+" ,"+button.size());
		Assert.assertEquals(inputboxes.size(), 2);
		Assert.assertEquals(dropdown.size(), 3);
		Assert.assertEquals(checkbox.size(), 9);
		Assert.assertEquals(radiobox.size(), 9);
		Assert.assertEquals(button.size(), 1);
		
		
	}
	
}
