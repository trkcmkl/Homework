package webelements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element {
	WebDriver dr;
	@BeforeClass
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		dr= new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.switchTo();
		dr.manage().window().fullscreen();
		}
	@Test
	public void WebElementExample() {
		dr.get("https://forms.zohopublic.com/murodil/form/JobApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4_mekBNfNLIconAHvfdIk3CJSQ");
		WebElement email = dr.findElement(By.name("Email"));
		String value = email.getAttribute("value");
		String maxLength = email.getAttribute("maxlength");
		String type = email.getAttribute("type");
		String tag = email.getTagName();
		boolean b =email.isEnabled();
		System.out.println("value, "+value+"\n"+"maxlength, "+maxLength+"\n"+"type, "+type+"\n"+"tag, "+tag+"\n"+ "b, "+b);
		WebElement seleccountry =dr.findElement(By.id("Address_Country"));
		Select selection = new Select(seleccountry);
		String firstslecetd = selection.getFirstSelectedOption().getText();
		selection.selectByIndex(8);
		
		
	}
}
