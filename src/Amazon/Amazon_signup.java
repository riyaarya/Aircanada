package Amazon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Amazon_signup {
	
	@Test(dataProvider = "Amazon_signup")
	
	public void Signup_Amazon(String name, String number, String email, String password) {
		
		Config_Reader cr = new Config_Reader();
	
		System.setProperty("webdriver.gecko.driver", cr.getgeckopath());
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(cr.geturl());
		driver.findElement(By.xpath("//*[@id=\"nav-link-yourAccount\"]/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"createAccountSubmit\"]")).click();
		driver.findElement(By.id("ap_customer_name")).sendKeys(name);
		driver.findElement(By.id("ap_phone_number")).sendKeys(number);//ye same hai id na dekho.ok
		
		driver.findElement(By.id("ap_email")).sendKeys(email);
		driver.findElement(By.id("ap_password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();	
		
	}
	
	@DataProvider(name = "Amazon_signup")
	
	public Object[][] passData(){
		
		Config_Reader cr = new Config_Reader();
		
		Amazon_excel ae = new Amazon_excel(cr.getepath());
		int row = ae.getrowCount();
		Object[][] arr = new Object[row][4];

		for(int i=0;i<row;i++) {
			
			arr[i][0] = ae.passData(0, i, 0);
			arr[i][1] = ae.passData(0, i, 1);
			arr[i][2] = ae.passData(0, i, 2);
			arr[i][3] = ae.passData(0, i, 3);
			
			
		}
		
		return arr;
			}

}
