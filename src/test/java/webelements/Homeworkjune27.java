package webelements;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Homeworkjune27 {
	WebDriver dr;
	List<String> list = new ArrayList<>();
	Faker f =new Faker();
	@BeforeClass
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dr.switchTo();
		dr.manage().window().fullscreen();
	}

	@Test
	public void seleniumWebelementForm() throws InterruptedException {
	dr.get("https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");
	List<WebElement> inputboxes = dr.findElements(By.xpath("//input[@type='text']"));
	List<WebElement> dropdown = dr.findElements(By.xpath("//select"));
	List<WebElement> checkbox = dr.findElements(By.xpath("//input[@type='checkbox']"));
	List<WebElement> radiobox = dr.findElements(By.xpath("//input[@elname='MatrixChoice1']"));
	List<WebElement> button = dr.findElements(By.xpath("//button[@value='submit']"));
	
	
	for (WebElement inputbox: inputboxes) {
		inputbox.sendKeys(f.name().firstName());
	}

	for (WebElement drop: dropdown) {
		Select s = new Select(drop);
		s.selectByIndex(f.number().numberBetween(1, 3));
	}
	for (WebElement check: checkbox) {
		if(f.number().numberBetween(1, 3)<2) {
			check.click();
		}
	}
	for (int i=1; i<4; i++) {
		for(int j=1; j<4; j++) {
		dr.findElement(By.xpath("//input[@id='MatrixChoice1_row"+i+"_column"+j+"']")).click();
		Thread.sleep(1000);
		}
	}
	dr.findElement(By.xpath("//button[@elname='submit']")).click();
	System.out.println(button.size());	

}
/*
 * Homework: Loop through each inputbox and enter random names Loop through each
 * dropDown and randomly select by index Loop through each checkBoxes and select
 * each one Loop through each radioButton and click one by one by waiting one
 * second intervals click all buttons
 */
}
