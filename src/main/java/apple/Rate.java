package apple;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Rate {
	
	static WebDriver driver;
	
	public static void st() throws InterruptedException {
		
		
		
		driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/c-wiz[1]/div/div/div/div[2]/div[2]/div[1]/a/span"))
		.click();

Thread.sleep(5000);


List<WebElement> pro = driver.findElements(By.xpath("//span[@class=\"dB5gr \"]"));
		


for (int i=0;i<pro.size();i++) {
	
	String name= pro.get(i).getText();
	System.out.println(name);

	
	if(name.contains("Dow Jones Industrial Average")) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='dB5gr']")));
		driver.findElement(By.xpath("//span[@class='dB5gr']")).click();
		String mushi = Keys.chord(Keys.CONTROL,Keys.ENTER);
		driver.findElement(By.xpath("//span[@class='dB5gr ']")).sendKeys(mushi);
	}
}

	}
	
	

}
