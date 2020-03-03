/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zp.paytabs;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.IOException;

/**
 * @author Mustafeez
 */
public class PayTabs {
    String paytabsUrl = "https://www.paytabs.com/apiv2/";
//    String merchantEmail = "mustafeez@extabs.com";
//    String merchantSecretKey = "bZ7U3SCxz1XC1Aeby05WCDknKQTfZ9na9v5dnHKWIIyJjNVRO1OqE9OoZIEZS1a1xffUWZRFIqp1dlT2mIt1RipR04QS60UDg9yd";

    String merchantEmail = "xiaodong.wang@42pay.com";
    String merchantSecretKey = "ii5Ol0hgoEAyIB7bFW5v0y0dhDWn5Quo8zctzuKY8kwQWE2CA77BF8PXLMlRCPfLpsfYW0W4ltVh7XTI51jL99IVW4MyU2kjuzir";


    String authentication_request(String urlParameters) throws UnsupportedEncodingException {
        urlParameters = "merchant_email=" + URLEncoder.encode(merchantEmail, "UTF-8") + "&secret_key="
                + URLEncoder.encode(merchantSecretKey, "UTF-8");
        return connection_request("validate_secret_key/", urlParameters);
    }

    String create_paypage_request(String urlParameters) {
        return connection_request("create_pay_page/", urlParameters);
    }

    String connection_request(String targetURL, String urlParameters) {
        URL url;
        HttpURLConnection connection = null;
        try {
            url = new URL(paytabsUrl + targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            String mendatoryParameters
                    = "merchant_email=" + merchantEmail + "&secret_key=" + merchantSecretKey;
            urlParameters = mendatoryParameters + urlParameters;
            System.out.println(urlParameters + " \n");
            connection.setRequestProperty("Content-Length", "" + urlParameters.getBytes().length);
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                System.out.println("Output from Server .... \n" + connection.getResponseCode());
            }

            //Get Response	
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            System.out.println("Output from Server .... \n");
            while ((line = rd.readLine()) != null) {
                return line;
            }
            rd.close();

        } catch (IOException ex) {
            System.err.println("An IOException was caught!");
            ex.printStackTrace();
        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }
        return "";
    }
}
