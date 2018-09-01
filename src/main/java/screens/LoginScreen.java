package screens;

import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

	

public class LoginScreen extends Screen {
	
	Map<String, String> errors = new HashMap<String, String>();
	
	public LoginScreen(AppiumDriver<MobileElement> appiumDriver) {
		super(appiumDriver);
	}
	
	@AndroidFindBy(id="etCpf")
	@iOSFindBy(id="CPF")
	private MobileElement inputUsername;
	
	@AndroidFindBy(id="etPassword")
	@iOSFindBy(id="Senha")
	private MobileElement inputPassword;
	
	@AndroidFindBy(id="btLogin")
	@iOSFindBy(id="ENTRAR")
	private MobileElement btnEntrar;
	
	@AndroidFindBy(id="snackbar_text")
	@iOSFindBy(id="Erro")
	private MobileElement errorField;
	
	@iOSFindBy(id="Toolbar Done Button")
	private MobileElement iosKeyboardDone;
	
	public void signIn(String username, String password){
		inputUsername.sendKeys(username);
		inputPassword.sendKeys(password);
		try {
			iosKeyboardDone.click();
		} catch (Exception e) {}
		btnEntrar.click();
	}
	
	public boolean hasErrorMessageField(String errorType) {
		if( errorField.isDisplayed() )
			return true;
		return false;
	}

}
