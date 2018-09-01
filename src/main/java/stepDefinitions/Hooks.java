package stepDefinitions;

import java.io.File;
import java.net.MalformedURLException;

import capabilities.AppiumDriverHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import resources.Platform;
import resources.Utils;

public class Hooks {
	
	Platform platform = new Platform();
	
	@After
	public void after(Scenario scenario) throws MalformedURLException {
	       if (scenario.isFailed()) {
	           File screenshot = Utils.takeScreenshot( AppiumDriverHelper.getAppiumDriver(platform.getPlatform()) );
	           if (screenshot != null)
	               Utils.embedScreenshot( screenshot, null );
	}
	
		AppiumDriverHelper.openApp();
	}

}
