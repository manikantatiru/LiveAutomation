package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_001 {

	@Test
	public  void VerifyRegisteringWithMandatoryFields() {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Veera Manikanta");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Tirumalasetti");
		driver.findElement(By.xpath("//input[@placeholder='E-Mail']")).sendKeys(GenerateEmail());
		driver.findElement(By.xpath("//input[@placeholder='Telephone']")).sendKeys(GenerateEmail());
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Mani2001");
		driver.findElement(By.xpath("//input[@placeholder='Password Confirm']")).sendKeys("Mani2001");
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//aside [@id='column-right']//a[text()='Logout'][1]")).isDisplayed());
		
		String Expectedheading="Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='content']//h1")).getText(),Expectedheading);
		
		String ExpectedproperDetails=driver.findElement(By.xpath("//div[@id='content']")).getText();
		
		String ActualproperDetailsOne="Congratulations! Your new account has been successfully created!";
		String ActualproperDetailsTwo="You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String ActualproperDetailsThree="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String ActualproperDetailsFour="A confirmation has been sent to the provided e-mail address. If you have not received it within the hour, please ";
		
		Assert.assertTrue(ExpectedproperDetails.contains(ActualproperDetailsOne));
		Assert.assertTrue(ExpectedproperDetails.contains(ActualproperDetailsTwo));
		Assert.assertTrue(ExpectedproperDetails.contains(ActualproperDetailsThree));
		Assert.assertTrue(ExpectedproperDetails.contains(ActualproperDetailsFour));
		driver.findElement(By.linkText("Continue")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}
	
	public  String GenerateEmail()
	{
		Date date = new Date();
		String dateString=date.toString();
		String GenerateEmail=dateString.replaceAll("\\s","").replaceAll("\\:", "");
		String Email=GenerateEmail+"@gmail.com";
		return Email;
	}

}
