package com.bingsearch.selenium;

import com.bingsearch.googleTopSearches.Searches;
import com.bingsearch.googleTopSearches.Sleeper;
import com.bingsearch.googleTopSearches.topSearches;
import com.google.gson.Gson;
import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;

//Jaunt
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
        setText(SignIn.LOC_TXT_EMAILINPUT, "gophertest@outlook.com");
        click(SignIn.LOC_BTN_SUBMITLOGIN);

//      Checks to make sure the password screen is available first before entering password
//      Implicit waits did not work for this site. Using explicit wait because it is a more well defined behavior rather than implicit.
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("idSIButton9")));

        setText(SignIn.LOC_TXT_PASSWORD, "testpassword1111");
        click(SignIn.LOC_BTN_SUBMITLOGIN);

//      Make sure element is loaded before checking if user is signed in. Note to self - convert from
//      basic selenium to Conductor syntax when have time.
        wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.elementToBeClickable(By.id("id_n")));

//      Make sure user is signed in
        validateText(SignIn.LOC_LNK_USERSIGNEDIN, "Dennis");


//      Look at top google searches
        Gson gson = new Gson();
        topSearches topsearches = new topSearches();
        Searches returnedResults = topsearches.parseGoogle();

//      Load sleeper class
        Sleeper sleepRand = new Sleeper();

//      Search for items
        Iterator iter = returnedResults._5.iterator();
        while(iter.hasNext()){
            sleepRand.randomSleep();
            String searchTerm = (String) iter.next();
            setText(SearchBing.LOC_TXT_SEARCHMAIN, searchTerm);
            click(SearchBing.LOC_BTN_SEARCHSUBMIT);
            //      Make sure user is signed in
            try {
                Thread.sleep(3000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }


        iter = returnedResults._3.iterator();
        while(iter.hasNext()){
            sleepRand.randomSleep();
            String searchTerm = (String) iter.next();
            setText(SearchBing.LOC_TXT_SEARCHMAIN, searchTerm);
            click(SearchBing.LOC_BTN_SEARCHSUBMIT);
            //      Make sure user is signed in
            try {
                Thread.sleep(3000);                 //1000 milliseconds is one second.
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }



        //      Make sure user is signed in
        try {
            Thread.sleep(5000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
