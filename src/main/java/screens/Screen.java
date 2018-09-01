package screens;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Screen {
	
	public AppiumDriver<MobileElement> driver;
	
	public Screen(AppiumDriver<MobileElement> appiumDriver) {
	       PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	       this.driver = appiumDriver;

	  }
}
