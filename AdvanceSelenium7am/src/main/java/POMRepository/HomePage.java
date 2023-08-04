package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
//initilization
	public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}	
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductLink;
	
	//gettermethod
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}
	
	public WebElement getProductLink() {
		return ProductLink;
	}
	/**
	 * This method is used to click on OranizationLink
	 */
	public void clickOrganizationLink()
	{
		OrganizationLink.click();
	}
	public void clickProductLink()
	{
		ProductLink.click();
	}
}
