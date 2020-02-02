package step_definitions.utils;

import com.google.inject.Guice;
import com.google.inject.Injector;
import cucumber.runtime.java.guice.ScenarioScoped;
import guice.AppModule;
import pages.HomePage;
import pages.LoginPage;
import pages.Register;

@ScenarioScoped
public class StepUtil {

    private Injector injector;

    public StepUtil() {
        injector = Guice.createInjector(new AppModule());
    }

    public Injector getInjector() {
        return injector;
    }

    public LoginPage getLoginPage() {
        return getInjector().getInstance(LoginPage.class);
    }

    public HomePage getHomePage() {
        return getInjector().getInstance(HomePage.class);
    }

    public Register getRegisterPage() {
        return getInjector().getInstance(Register.class);
    }
}
