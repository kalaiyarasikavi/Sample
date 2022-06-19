package org.pages;
import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
public class LoginPage extends BaseClass {
	// With out pagefactory
//	private WebElement getUser() {
//		WebElement txtUsername = driver.findElement(By.id("email"));
//		return txtUsername;
//
//	}
	// with pagefactory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	@CacheLookup
	@FindBys({@FindBy(id="email"), @FindBy(xpath="//input[@type='text']")})
	private List<WebElement> txtUsername;
	
	@FindAll({@FindBy(id="password"), @FindBy(xpath="//input[@name='pass']")})
	private WebElement txtPassword;
	
	@FindBy(name="login")
	private WebElement btnLogin;
	
	public List<WebElement> getTxtUsername() {
		return txtUsername;
	}
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	public WebElement getBtnLogin() {
		return btnLogin;
	}
	public void getLogin(String name,String pass) {
		sendkeys(getTxtUsername().get(0), name);

		sendkeys(getTxtPassword(), pass);
		
		buttonClick(getBtnLogin());
	}
}
