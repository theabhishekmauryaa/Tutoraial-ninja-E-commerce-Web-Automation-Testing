package endtoend;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import genericutility.Base;
import pomrepository.HomePage;

public class Logout extends Base{
	
	@Test(priority = 1)
	public void LogoutFromMyAccountDropDown() throws IOException
	{
		LoginToAccount();
		HomePage hp = new HomePage(driver);
		hp.getMyaccountdropdown().click();
		hp.getLogout().click();
		assertTrue(hp.getLoggedOut().isDisplayed());
		
	}
	
	@Test
	public void LogoutUsingRightbottomCornerOption() throws IOException
	{
		LoginToAccount();
		HomePage hp = new HomePage(driver);
		hp.getLogOutListOption().click();
		assertTrue(hp.getLoggedOut().isDisplayed());
	}
	
//	@Test
//	public void VerifyLogoutOptionWithoutLoggingIn()
//	{
//		HomePage hp = new HomePage(driver);
//		hp.getMyaccountdropdown().click();
//		assertFalse(hp.getMyacclist().equals("Login"));
//	}

}
