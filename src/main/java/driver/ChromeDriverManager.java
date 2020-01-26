package driver;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;

public class ChromeDriverManager extends DriverManager {

    private static ChromeDriverService service;

    @Override
    public void startService() {
        if (null == service) {
            try {
                service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File("chromedriver.exe"))
                        .usingAnyFreePort()
                        .build();
                service.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != service && service.isRunning())
            service.stop();
    }

    @Override
    public void createDriver() {
        startService();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("test-type");
        driver = new RemoteWebDriver(service.getUrl(), options);
        // driver = new ChromeDriver(service, new ChromeOptions());
    }
}
