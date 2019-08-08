package signuptests;

import org.testng.annotations.Test;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignupForm {
	
	WebDriver driver;
	InputParameters inputParameter;
	Properties prop;
	
	
	public SignupForm(WebDriver webDriver, InputParameters inputParameter, Properties prop) {
		super();
		this.driver = webDriver;
		this.inputParameter = inputParameter;
		this.prop = prop;
	}


	@Test
	public boolean testExecution(String message, String errorXpath) throws Exception {
		String outputMessage = "";
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(inputParameter.getFirstName());
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(inputParameter.getLastName());
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(inputParameter.getRegEmailId());
		if("email".equalsIgnoreCase(inputParameter.getLoginType())) {
			System.out.println("I am here in email if");
			driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(inputParameter.getRegEmailId());
		}
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(inputParameter.getPassword());
		WebElement day = driver.findElement(By.id("day"));
		Select s = new Select(day);
		s.selectByVisibleText("17");
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByVisibleText("Sept");
		Select year = new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("1986");
       
		driver.findElement(By.xpath("//label[contains(text(),'"+inputParameter.getGender()+"' )]")).click();
		
        Thread.sleep(5);
        driver.findElement(By.name("websubmit")).click();
       
        if(errorXpath != null && errorXpath.length() > 0) {
        	Thread.sleep(2000);
        	outputMessage= driver.findElement(By.xpath(errorXpath)).getText();
        	System.out.println("The warning is " + outputMessage);
        	
        	if(message.equalsIgnoreCase(outputMessage)) {
            	return false;
            }
        }
        
        return true;
    }

}
