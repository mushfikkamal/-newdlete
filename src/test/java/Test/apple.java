package Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Resources.Base;
import apple.Rate;

public class apple extends Base{

	
@Test
	public void login() throws IOException {
		
	driver=	initializeDriver();
	
	driver.get(prop.getProperty("url"));
	
		
	}


	@Test
	public void grabing() throws InterruptedException {
		
	Rate.st();
		
		
	}
	
	
	
}
