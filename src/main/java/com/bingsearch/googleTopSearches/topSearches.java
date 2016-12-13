package com.bingsearch.googleTopSearches;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by djdin on 9/6/2016.
 */
public class topSearches {

    public Searches parseGoogle () {

        String strTemp = "";
        Searches searches = new Searches();
        Gson gson = new Gson();
        try {
            URL url = new URL("http://hawttrends.appspot.com/api/terms/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            while (null != (strTemp = br.readLine())) {
//                System.out.println(strTemp);

                searches = gson.fromJson(strTemp, Searches.class);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        System.out.println(gson.toJson(searches, Searches.class));
        return searches;
    }
}
