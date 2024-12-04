package PageObject;


import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {

	public WebDriver ldriver;
	public BaseClass baseClass=new BaseClass();
	
	public CustomerLoginPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	By fieldEmail = By.xpath("//div[@class='control']/input[@id='email']");

	By fieldPwd = By.xpath("(//div[@class='field password required']/div/input[@id='pass'])[1]");
	
	By signInBtn = By.xpath("(//div[@class='primary']/button[@id='send2'])[1]");
	
	By loginErrorMsg = By.xpath("//div[@class='page messages']/div/div/div/div[contains(text(),'The account')]");
	
	
	public void enterRegisteredUserEmail(String email) {
		WebElement fEmail = ldriver.findElement(fieldEmail);
		baseClass.typeInput(fEmail, email);
	}

	public void enterUserPassword(String pwd) {
		WebElement fPwd = ldriver.findElement(fieldPwd);
		baseClass.typeInput(fPwd, pwd);
	}

	public void clickOnSignInBtn() {
		WebElement  signIn = ldriver.findElement(signInBtn);
		baseClass.scrollToElement(signIn);
		baseClass.clickOnElement(signIn);
	}
	
	public void verifyLoginErrorMsg(String expectedMsg)
	{
		WebElement errorMsg= ldriver.findElement(loginErrorMsg);	
		if(errorMsg.isDisplayed())
		{
			String actualMsg =errorMsg.getText();
			if(expectedMsg.equals(actualMsg))
			{
				System.out.println("error validation done sucessfully on entering invalid credentials ");
			}else {
				System.out.println("user able to login Test case failed");
			}
		}else {
			System.out.println("element not present");
		}
	}
}
