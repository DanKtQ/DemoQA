package helperMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    public void forceClick(WebElement element) {
        // Cand nu poti face click pe element (eg o reclama se suprapune) se poate folosi "ciocanul"
        // JavascriptExecutor iti permite sa faci actiuni extra
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }
}
