package AutomationFinalProject.AutomationFinalProject;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestData {
	 String TheWebSiteUrl = "http://www.almosafer.com/en";
	 WebDriver driver = new ChromeDriver();
	 String ExpectedCurrency = "SAR";
	 String ExpectedContactNumber = "+966554400000";
	 String ExpectedCheckHotelTabNotSelected = "false";
	 LocalDate date = LocalDate.now();
	 int tomorrow = date.plusDays(1).getDayOfMonth();
	 String tomorrowAsFormatedValue = String.format("%02d",tomorrow);
		int dayAftertomorrow = date.plusDays(2).getDayOfMonth();
		String [] webistes = {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};
		Random rand = new Random(); 
		
		int randomIndex = rand.nextInt(webistes.length); 
		String[] englishCities = { "dubai", "jeddah", "riyadh" };
		int randomEnglishCity = rand.nextInt(englishCities.length);
		String[] arabicCities = { "دبي", "جدة" };
		int randomArabicCity = rand.nextInt(arabicCities.length);

	 
	 
	 public void Setup () {
		   driver.get(TheWebSiteUrl);
		   
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		   driver.manage().window().maximize();
		   
		   WebElement settingButtonEn = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		   settingButtonEn.click();
		  
		   
	   }
}
