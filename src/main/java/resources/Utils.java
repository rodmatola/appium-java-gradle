package resources;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Allure;


public class Utils {
	
	private Utils(){
	}

	public static File takeScreenshot(AppiumDriver<MobileElement> driver) {
	       try {
	           return driver
	                   .getScreenshotAs( OutputType.FILE );
	       } catch (Exception e) {
	           e.printStackTrace();
	       }

	       return null;
	   }
	
	public static void embedScreenshot( File file, String description) {
	       Path content = Paths.get( file.getPath() );
	       try (InputStream is = Files.newInputStream( content )) {
	           Allure.addAttachment( description != null ? description : "", is );
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
}
