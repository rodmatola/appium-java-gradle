package stepDefinitions;

import static capabilities.AppiumDriverHelper.getAppiumDriver;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import resources.Platform;
import resources.Users;
import screens.HomeScreen;
import screens.LoginScreen;

public class LoginSteps {
	
	LoginScreen loginScreen;
	AppiumDriver<MobileElement> driver;
	Platform platform = new Platform();

	@Dado("^que estou na tela de login do aplicativo$")
	public void que_estou_na_tela_de_login_do_aplicativo() throws MalformedURLException {
		
		loginScreen = new LoginScreen(getAppiumDriver(platform.getPlatform()));
	    	    
	}

	@Quando("^realizo o login \"([^\"]*)\"$")
	public void realizo_o_login(String statusLogin) {
		
		Users user = new Users();
		loginScreen.signIn(user.getUser(statusLogin), user.getPassword(statusLogin));
				
	}

	@Então("^devo visualizar a tela Home \"([^\"]*)\"$")
	public void devo_visualizar_a_tela_Home(String tipoHome) throws MalformedURLException {
	    
		HomeScreen homeScreen = new HomeScreen(getAppiumDriver(platform.getPlatform()));
	    Assert.assertEquals(tipoHome, homeScreen.type(tipoHome));
	    		
	}

	@Então("^devo visualizar uma mensagem de \"([^\"]*)\"$")
	public void devo_visualizar_uma_mensagem_de(String tipoErro) {
	    
		if ( !loginScreen.hasErrorMessageField(tipoErro) )
			fail("Nenhuma mensagem de erro está sendo exibida");
		
	}
	
}
