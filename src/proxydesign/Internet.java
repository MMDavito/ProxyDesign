/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxydesign;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danlun2
 */
public class Internet {

    private String USER_AGENT = "Mozilla/5.0";
    private String url = "";

    public String getUSER_AGENT() {
        return USER_AGENT;
    }

    public void setUSER_AGENT(String USER_AGENT) {
        this.USER_AGENT = USER_AGENT;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String sendGet() throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        //StringBuffer response = new StringBuffer();
        String response = "";
        while ((inputLine = in.readLine()) != null) {
            response += inputLine;
        }
        in.close();

        //print result
        return response;

    }

}
