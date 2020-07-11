package capabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDriverHelper {
	
	private static AppiumDriver<MobileElement> driver;

    public static AppiumDriver<MobileElement> getAppiumDriver(String plataform) throws MalformedURLException {


        if (driver == null) {
            if (plataform.equals("android")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Android");
                cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
                cap.setCapability(MobileCapabilityType.VERSION, "5.0");
                cap.setCapability("platformName", "Android");
                cap.setCapability("app", new File("/Users/.../app/build/outputs/apk/alpha/debug/app-alpha-debug.apk"));
//		    	cap.setCapability("app", new File(System.getenv("ANDROID_APK")));
                cap.setCapability ("unicodeKeyboard", true);
                cap.setCapability ("resetKeyboard", true);
                driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            } else {
                if (plataform.equals("ios")) {
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8 Plus");
                    cap.setCapability(MobileCapabilityType.BROWSER_NAME, "iOS");
                    cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                    cap.setCapability(MobileCapabilityType.VERSION, "11.4");
                    cap.setCapability("platformName", "IOS");
                    cap.setCapability("app", new File("../iOS_Simulator_iPhone_8/nome.app"));
//					cap.setCapability("app", new File(System.getenv("IOS_APP")));
                    cap.setCapability("noReset", true);
                    driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

                }
            }

        }
        return driver;
    }
    
    public static void closeApp() {
    	driver.closeApp();
    }
    
    public static void openApp() {
    	driver.launchApp();
    }
    
    public static void hideKeyboard() {
    	try {
    		driver.hideKeyboard();
		} catch (Exception e) {
			
		}
    	
    }
    
}
