package PageObject;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class AccountCreationPage {
	WebDriver ldriver;
	public BaseClass baseClass=new BaseClass();

	public AccountCreationPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	
	By fName= By.xpath("//input[@id='firstname']");

	By lName= By.xpath("//input[@id='lastname']");
	
	By email= By.xpath("//input[@id='email_address']");

	By password= By.xpath("//input[@id='password']");
	
	By createAnAccountBtn= By.xpath("//button[@type='submit']/span[normalize-space()='Create an Account']");

	By confirmPassword= By.xpath("//input[@id='password-confirmation']");
	
	By accountRegistrationMsg= By.xpath("//div[@class='message-success success message']//div[contains(text(), 'Thank you for registering with Main Website Store.')]");

	By signoutArrowBtn= By.xpath("(//li[@class='customer-welcome']/span/button[@class='action switch'])[1]");

	By signOutBtn= By.xpath("(//div[@class='customer-menu']/ul/li[@class='authorization-link']/a[normalize-space()='Sign Out'])[1]");
	
	By welcomeUserName= By.xpath("(//ul[@class='header links']/li/span)[1]");
	
	By alreadyCreatedAccountMesg = By.xpath("//div[@class='page messages']/div//div/div/div[text()='There is already an account with this email address. If you are sure that it is your email address, ']");

	By enterSameValueValidationMsg =By.xpath("//div[@class='field confirmation required']/div/div[text()='Please enter the same value again.']"); 
	
	public void enterFirstName(String userfName) {
		baseClass.typeInput(ldriver.findElement(fName), userfName);
	}

	public void enterLastName(String userlName) {
		baseClass.typeInput(ldriver.findElement(lName), userlName);
	}

	public void enterEmail(String userEmail) {
		baseClass.typeInput(ldriver.findElement(email), userEmail);
	}

	public void enterPassword(String userpwd) {
		baseClass.typeInput(ldriver.findElement(password), userpwd);
	}

	public void enterConfirmPassword(String userPwd) {
		baseClass.typeInput( ldriver.findElement(confirmPassword), userPwd);
	}

	public void clickOnCreateAccountBtn() {
		WebElement accoCreatebtn = ldriver.findElement(createAnAccountBtn);
		baseClass.scrollToElement(accoCreatebtn);
		baseClass.clickOnElement(accoCreatebtn);
	}

	public void verifyRegistrationSucessfully(String accountCreationMsg) {
		boolean flag = false;
		WebElement accCreationMsg = ldriver.findElement(accountRegistrationMsg);
		baseClass.scrollToElement(accCreationMsg);
		baseClass.waitForElementDisplayed(accCreationMsg);
		System.out.println("#### Registration done :#### " + accCreationMsg.getText());
		boolean messageDisplayFlag = accCreationMsg.isDisplayed();
		if (messageDisplayFlag == true && accCreationMsg.getText().equals(accountCreationMsg)) {
			flag = true;
		} else {
			flag = false;
		}
	}

	public void clickOnSignOutBtn() throws InterruptedException {
		WebElement signOutArrow = ldriver.findElement(signoutArrowBtn);
		baseClass.scrollToElement(signOutArrow);
		baseClass.waitForElementDisplayed(signOutArrow);
		baseClass.clickOnElement(ldriver.findElement(signoutArrowBtn));
		baseClass.clickOnElement(ldriver.findElement(signOutBtn));
	}

	public void verifyAbleToSeeWelcomePage(String expectedMsg) {
		try {
			WebElement welcomeTitle = ldriver.findElement(welcomeUserName);
			if (welcomeTitle.isDisplayed()) {
				String actualMsg = welcomeTitle.getText();
				System.out.println("login sucessfully : " + actualMsg);
				if (expectedMsg.contains(actualMsg)) {
					System.out.println("user logged in sucessfully");
				}
			} else {
				System.out.println("element not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateAlreadyCreatedAccountMsg(String expectedMsg) {
		WebElement alreadyCreAccountMsg = ldriver.findElement(alreadyCreatedAccountMesg);
		if (alreadyCreAccountMsg.isDisplayed()) {
			String actualMsg =alreadyCreAccountMsg.getText();
			if(expectedMsg.contains(actualMsg))
			{
				System.out.println(actualMsg);
			}else {
				System.out.println("Test step fail");
			}
		}
	}
	
	public void validateSameValueValidatationMsg(String expectedMsg)
	{
		WebElement alreadyCreAccountMsg = ldriver.findElement(enterSameValueValidationMsg);
		if (alreadyCreAccountMsg.isDisplayed()) {
			String actualMsg =alreadyCreAccountMsg.getText();
			if(expectedMsg.contains(actualMsg))
			{
				System.out.println(actualMsg);
			}else {
				System.out.println("Test step fail");
			}
		}
	}
}
