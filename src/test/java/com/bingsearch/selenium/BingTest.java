package com.bingsearch.selenium;

import org.junit.Test;
import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Jaunt
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
@Config(
        browser = Browser.CHROME,
        url     = "http://www.bing.com/"
)
/**
 * Created by djdin on 9/2/2016.
 */
public class BingTest extends Locomotive {
    @Test
    public void logIn(){
        click(SignIn.Loc_BTN_SIGNIN);
        click(SignIn.LOC_LNK_CONNECT);
        setText(SignIn.LOC_TXT_EMAILINPUT, "djdinh@gmail.com");
        setText(SignIn.LOC_TXT_PASSWORD, "adolin4!4!");
        click(SignIn.LOC_BTN_SUBMITLOGIN);

//      Make sure element is loaded before checking if user is signed in. Note to self - convert from
//      basic selenium to Conductor syntax when have time.
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_n")));

//      Make sure user is signed in
        validateText(SignIn.LOC_LNK_USERSIGNEDIN, "Dustin");

//      Search for item
        setText(SearchBing.LOC_TXT_SEARCHMAIN, "Firefly");
        click(SearchBing.LOC_BTN_SEARCHSUBMIT);


        //      Make sure user is signed in
        try {
            Thread.sleep(5000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Test
    public void importTopSearches(){
        try {
            URL url = new URL("http://hawttrends.appspot.com/api/terms/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                System.out.println(strTemp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
