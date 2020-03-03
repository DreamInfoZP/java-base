package com.zp.paytabs;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.UnsupportedEncodingException;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date CreatePageAPI.java v1.0  2020/1/13 11:30 上午
 */
public class CreatePageAPI {

    public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
        PayTabs paytabsss = new PayTabs();
        /*
         *   API authentication
         */
        String response = paytabsss.authentication_request("");
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(response);
        System.out.println(json.get("response_code") + "\n");

        /*
         *   API Create Pay Page request
         */
        String urlParameters;
//        urlParameters =
//                "&cc_first_name=" + URLEncoder.encode("John", "UTF-8")
//                        + "&cc_last_name=" + URLEncoder.encode("Doe", "UTF-8")
//                        + "&cc_phone_number=" + URLEncoder.encode("00973", "UTF-8")
//                        + "&phone_number=" + URLEncoder.encode("33878768", "UTF-8")
//                        + "&billing_address=" + URLEncoder.encode("juffair manama bahrain", "UTF-8")
//                        + "&city=" + URLEncoder.encode("manama", "UTF-8")
//                        + "&state=" + URLEncoder.encode("manama", "UTF-8")
//                        + "&postal_code=" + URLEncoder.encode("00973", "UTF-8")
//                        + "&country=" + URLEncoder.encode("BHR", "UTF-8")
//                        + "&address_shipping=" + URLEncoder.encode("juffair manama bahrain", "UTF-8")
//                        + "&city_shipping=" + URLEncoder.encode("manama", "UTF-8")
//                        + "&state_shipping=" + URLEncoder.encode("manama", "UTF-8")
//                        + "&postal_code_shipping=" + URLEncoder.encode("00973", "UTF-8")
//                        + "&country_shipping=" + URLEncoder.encode("BHR", "UTF-8")
//                        + "&email=" + URLEncoder.encode("mustafeez@paytabs.com", "UTF-8")
//                        + "&amount=" + URLEncoder.encode("101.00", "UTF-8")
//                        + "&currency=" + URLEncoder.encode("USD", "UTF-8")
//                        + "&title=" + URLEncoder.encode("Testing Java Code", "UTF-8")
//                        + "&discount=" + URLEncoder.encode("0.0", "UTF-8")
//                        + "&msg_lang=" + URLEncoder.encode("en", "UTF-8")
//                        + "&quantity=" + URLEncoder.encode("1 || 1 || 1", "UTF-8")
//                        + "&unit_price=" + URLEncoder.encode("2 || 2 || 6", "UTF-8")
//                        + "&products_per_title=" + URLEncoder.encode("Product1 || Product 2 || Product 4", "UTF-8")
//                        + "&paypage_info=" + URLEncoder.encode("12331", "UTF-8")
//                        + "&reference_no=" + URLEncoder.encode("122333", "UTF-8")
//                        + "&site_url=" + URLEncoder.encode("http://192.168.11.104/multivendor", "UTF-8")
//                        + "&return_url=" + URLEncoder.encode("http://192.168.11.104/multivendor/return", "UTF-8")
//                        + "&cms_with_version=" + URLEncoder.encode("JavaCode1.0", "UTF-8")
//                        + "&other_charges=" + URLEncoder.encode("91.00", "UTF-8")
//                        + "&shipping_first_name=" + URLEncoder.encode("Mustafeez", "UTF-8")
//                        + "&shipping_last_name=" + URLEncoder.encode("Aslam", "UTF-8")
//                        + "&ip_customer=" + URLEncoder.encode("192.168.11.1", "UTF-8")
//                        + "&ip_merchant=" + URLEncoder.encode("192.168.11.1", "UTF-8");
        urlParameters =
                "&cc_first_name=" + "Wang"
                        + "&cc_last_name=" + "Xiaodong"
                        + "&cc_phone_number=" + "00973"
                        + "&phone_number=" + "33878768"
                        + "&billing_address=" + "juffair manama bahrain"
                        + "&city=" + "manama"
                        + "&state=" + "manama"
                        + "&postal_code=" + "00973"
                        + "&country=" + "BHR"
                        + "&address_shipping=" + "juffair manama bahrain"
                        + "&city_shipping=" + "manama"
                        + "&state_shipping=" + "manama"
                        + "&postal_code_shipping=" + "00973"
                        + "&country_shipping=" + "BHR"
                        + "&email=" + "xiaodong.wang@42pay.com"
                        + "&amount=" + "101.00"
                        + "&currency=" + "USD"
                        + "&title=" + "Testing Java Code"
                        + "&discount=" + "0.0"
                        + "&msg_lang=" + "English"
                        + "&quantity=" + "1 || 1 || 1"
                        + "&unit_price=" + "2 || 2 || 6"
                        + "&products_per_title=" + "Product1 || Product 2 || Product 4"
                        + "&paypage_info=" + "12331"
                        + "&reference_no=" + "122333"
                        + "&site_url=" + "https://www.topay.ae"
                        + "&return_url=" + "https://www.topay.ae/return"
                        + "&cms_with_version=" + "WordPress4.0-WooCommerce2.3.9"
                        + "&other_charges=" + "91.00"
                        + "&shipping_first_name=" + "Mustafeez"
                        + "&shipping_last_name=" + "Aslam"
                        + "&ip_customer=" + "192.168.11.1"
                        + "&ip_merchant=" + "192.168.11.1";
        response = paytabsss.create_paypage_request(urlParameters);
        JSONParser parser1 = new JSONParser();
        JSONObject json1 = (JSONObject) parser1.parse(response);
        System.out.println(json1.get("response_code") + "\n");
    }
}
