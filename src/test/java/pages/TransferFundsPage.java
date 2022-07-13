package pages;
import org.openqa.selenium.By;
import java.time.Duration;

public class TransferFundsPage extends Base{
    private final By fromAccount = By.id("fromAccount");
    private final By toAccount = By.id("toAccount");
    private final By transAmount = By.id("transferAmount");
    private final By btnTransfer = By.xpath("//input[contains(@value,\"Money\")]");
    private final By text = By.xpath("//span[contains(text(),\"100\")]");
    private final By signOff = By.xpath("//tr/descendant::a[contains(@id,\"Login\")]");
    public TransferFundsPage() {
        super();
    }




    public void transfer(String from, String to,String amount) throws Exception {
        if (!isDisplayed(btnTransfer)){
            throw new Exception("Elemento no Encontrado");
        }
        selectElemByValue(fromAccount, from);
        sleep(1000);
        selectElemByValue(toAccount, to);
        sleep(1000);
        type(amount, transAmount);
        sleep(500);
        click(btnTransfer);
        sleep(1000);

    }

    public String validateAmmount(){
        return getText(text);
    }

    public void logOut() throws Exception {
        if (!isDisplayed(signOff)){
            throw new Exception("Elemento no Encontrado");
        }
        click(signOff);
    }
}
