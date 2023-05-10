package org.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IciciPojo extends BaseClass {
	public IciciPojo() {
      PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login-btn")
	private WebElement login;
    @FindBy(xpath="//p[text()='Personal']")
    private WebElement personal;
  @FindBy(xpath="//input[@class='login-input mode-select-userid']")
    private WebElement usid;
    @FindBy(id="DUMMY23")
    private WebElement pass;
  
	public WebElement getLogin() {
		return login;
	}
	public WebElement getPersonal() {
		return personal;
	}
public WebElement getUsid() {		
	return usid;
	}
	public WebElement getPass() {
		return pass;
	}
	
}
