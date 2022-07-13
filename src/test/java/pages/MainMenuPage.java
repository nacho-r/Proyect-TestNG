package pages;

import org.openqa.selenium.By;

public class MainMenuPage extends Base {

    private final By helloName = By.xpath("//div/h1[contains(text(),\"Hello\")]");
    private final By transferFunds = By.id("MenuHyperLink3");


    public MainMenuPage() {
        super();
    }

    public String getTitle() {
        return getText(helloName);
    }

    public void clickOptionMenu() throws Exception {
        if (!isDisplayed(transferFunds)){
            throw new Exception("Elemento no Encontrado");
        }
        click(transferFunds);
        sleep(2000);
    }

}