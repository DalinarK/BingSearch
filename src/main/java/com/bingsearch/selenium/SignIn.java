package com.bingsearch.selenium;

/**
 * Created by djdin on 9/2/2016.
 */
import org.openqa.selenium.By;

public class SignIn {

    // sign in button
    public static final By Loc_BTN_SIGNIN = By.linkText("Sign in");
    // connect button
    public static final String LOC_LNK_CONNECT = "ul#b_idProviders li";
//    public static final String Loc_LNK_SIGNIN = "li#msn a[href$='http://www.msn.com/']";

//    email text entry
    public static final String LOC_TXT_EMAILINPUT = "input#i0116";

//    password text entry
    public static final String LOC_TXT_PASSWORD ="input#i0118";

//    sign in button
    public static final String LOC_BTN_SUBMITLOGIN = "input[id='idSIButton9']";

//    Display name of signed in person
    public static final String LOC_LNK_USERSIGNEDIN = "span#id_n";

}


