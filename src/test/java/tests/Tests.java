package tests;

import data.factory.UserModelFactory;
import models.UserModel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

/**
 * Author: Bastian Silva
 */
@Listeners(listeners.TestNGListeners.class)
public class Tests extends BaseTest {

    @Test
    public void transferenciaEntreCuentas() {

        UserModel userModel = UserModelFactory.loginUser();

        HomePage homePage = new HomePage();
        homePage.login(userModel.getEmail(), userModel.getPassword());

        MainMenuPage mainMenu = new MainMenuPage();
        String title = mainMenu.getTitle();
        Assert.assertEquals(title, "Hello John Smith");

        mainMenu.clickOptionMenu();
    }


}
