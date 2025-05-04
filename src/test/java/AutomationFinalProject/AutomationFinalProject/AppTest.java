package AutomationFinalProject.AutomationFinalProject;


import java.util.List;
import java.util.Random;
import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class AppTest {
   String TheWebSiteUrl = "http://www.almosafer.com/en";
   
   WebDriver driver = new ChromeDriver();
   
  
   @BeforeTest
   public void mySetup () {
	   driver.get(TheWebSiteUrl);
	   
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	   driver.manage().window().maximize();
	   
	   WebElement settingButtonEn = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
	   settingButtonEn.click();
	  
	   
   }
   @Test(priority = 1,enabled = false)
	public void CheckWebSiteLanaguage(String ExpectedLanguage ) {

		String ActualLanguage = driver.findElement(By.tagName("html")).getDomAttribute("lang");
		Assert.assertEquals(ActualLanguage, ExpectedLanguage);

	}
   @Test(priority = 2,enabled = false)
   public void CheckCurrency() {
	   
	   String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
	   String ExpectedCurrency = "SAR";
	 Assert.assertEquals(ActualCurrency, ExpectedCurrency);        
	   
	   
   }
   @Test(priority = 3,enabled = false)
   public void CheckContactNumber() {
	   String ActualontactNumber = driver.findElement(By.linkText("+966554400000")).getText();
	   String ExpectedContactNumber = "+966554400000";
	   Assert.assertEquals(ActualontactNumber, ExpectedContactNumber);
   }
   @Test(priority = 4,enabled = false)
   public void CheckQitafLogo() {
	   WebElement TheFooter = driver.findElement(By.tagName("footer"));
	   boolean ActualImageIsDisplay = TheFooter.findElement(By.cssSelector(".sc-ekulBa.iOOTo")).findElement(By.cssSelector(".sc-bdVaJa.bxRSiR.sc-lcpuFF.jipXfR")).isDisplayed();
	   Assert.assertEquals(ActualImageIsDisplay, true);
	   
   }
   @Test(priority = 5,enabled = false)
   public void CheckHotelTabNotSelected() {
	   WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
	   String ActualValue = HotelTab.getDomAttribute("aria-selected");
	   String ExpectedValue = "false";
	   Assert.assertEquals(ActualValue, ExpectedValue);
   }
   @Test(priority = 6,enabled = false)
	public void FlightDepatureDate() {
		LocalDate date = LocalDate.now();
		
		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualDepatureDate = dates.get(0).getText();
		int tomorrow = date.plusDays(1).getDayOfMonth();
		String tomorrowAsFormatedValue = String.format("%02d",tomorrow);
		
		System.out.println(tomorrow);
		System.out.println(ActualDepatureDate);
		System.out.println(tomorrowAsFormatedValue);
		Assert.assertEquals(ActualDepatureDate, tomorrowAsFormatedValue);
		
	}
   @Test(priority = 7,enabled = false)
	public void FlightReturnDate() {
		LocalDate date = LocalDate.now();
		
		List<WebElement> dates = driver.findElements(By.cssSelector(".sc-dXfzlN.iPVuSG"));
		String ActualReturnDate = dates.get(1).getText();
		int dayAftertomorrow = date.plusDays(2).getDayOfMonth();
		String dayAftertomorrowAsFormatedValue = String.format("%02d",dayAftertomorrow);
		
		System.out.println(ActualReturnDate);
		System.out.println(dayAftertomorrow);
		System.out.println(dayAftertomorrowAsFormatedValue);
		Assert.assertEquals(ActualReturnDate, dayAftertomorrowAsFormatedValue);
	}
   @Test(priority = 8,invocationCount = 10)
	public void ChangeTheWebsiteLanaguage()   {
		String [] webistes = {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
		Random rand = new Random(); 
		
		int randomIndex = rand.nextInt(webistes.length); 
		
		driver.get(webistes[randomIndex]);
		
		if(driver.getCurrentUrl().contains("en")) {
			CheckWebSiteLanaguage("en");
		}else {
			CheckWebSiteLanaguage("ar");
	
		}
		
	
   }
   

   
   
   
   @AfterTest
   public void AfterMyTest() {}
   
}
