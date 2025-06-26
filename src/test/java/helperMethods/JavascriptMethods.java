package helperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavascriptMethods {

    WebDriver driver;
    JavascriptExecutor javascriptExecutor;

    public JavascriptMethods(WebDriver driver) {
        this.driver = driver;
        this.javascriptExecutor = (JavascriptExecutor) driver;
    }


    public void scroll(int x, int y) {
        //facem un scroll ca sa fie elementul vizibil
        //in cazul in care nu incape pe pagina
        //JavaScriptExecutor ajuta atunci cand metodele standard din selenium nu ne ajuta
        javascriptExecutor.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void scrollDown(int y) {
        scroll(0, y);
    }

    public void scrollRight(int x) {
        scroll(x, 0);
    }

}
