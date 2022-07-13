package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.PropertiesFile;

/**
 * Author: Bastian Silva
 */

public class Tests extends BaseTest {

    @Test
    public void transferenciaEntreCuentas() throws Exception {

        String email = PropertiesFile.readFile().getProperty("DEFAULT_EMAIL");
        String pass = PropertiesFile.readFile().getProperty("DEFAULT_PASSWORD");

        HomePage homePage = new HomePage();
        homePage.login(email, pass);

        MainMenuPage mainMenu = new MainMenuPage();
        String title = mainMenu.getTitle();
        Assert.assertEquals(title, "Hello John Smith");

        mainMenu.clickOptionMenu();

        TransferFundsPage transferFunds = new TransferFundsPage();
        transferFunds.transfer("800003", "4539082039396288", "100");
        String count = transferFunds.validateAmmount();
        Assert.assertTrue(count.contains("100"));
        transferFunds.logOut();


    }


}
