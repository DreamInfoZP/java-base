package com.zp;

import cn.hutool.core.bean.BeanUtil;
import com.zp.annottation.Filter;

import javax.sound.midi.SoundbankResource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p></p>
 *
 * @author zhoupeng
 * @date Test.java v1.0  2019/12/18 11:32 上午
 */
public class Test {

//    public static void main(String[] args) {
//        String str = "gp031_counter";
//        System.out.println(str.substring(0,str.indexOf("_")));
//    }

    //    public static void main(String[] args) {
//        String str = "1207196591792877570";
//
//        System.out.println(str.length());
//    }
    public static void main(String[] args) throws UnknownHostException {

        //获得本机IP
//        String addr = InetAddress.getLocalHost().getHostAddress();
//        System.out.println(addr);
//
//
//        Student s = new Student();
//        s.setName("张三");
//        s.setAge(12);
//
//        Student s1 = new Student();
//        s1.setName("里斯");
//
//        BeanUtil.copyProperties(s, s1);
//        System.out.println(s1);

//        String aa = "https://www.paytabs.com/apiv2/create_pay_page?merchant_emailxiaodong.wang@42pay.com&secret_key=ii5Ol0hgoEAyIB7bFW5v0y0dhDWn5Quo8zctzuKY8kwQWE2CA77BF8PXLMlRCPfLpsfYW0W4ltVh7XTI51jL99IVW4MyU2kjuzir&site_url=https://www.topay.ae&return_url=https://www.topay.ae/return&title=null&cc_first_name=Wang&cc_last_name=Xiaodong&cc_phone_number=00971&phone_number=0585668981&email=xiaodong.wang@42pay.com&products_per_title=MobilePhone%20||%20Charger%20||%20Camera&unit_price=12.123%20||%2021.345%20||%2035.678&quantity=2%20||%203%20||%201&other_charges=0&amount=58.01&discount=58.01&currency=CNY&reference_no=null&ip_customer=192.168.1.1&ip_merchant=192.168.1.1&billing_address=Flat%203021%20Manama%20Bahrain&city=Manama&state=Manama&postal_code=12345&country=BHR&shipping_first_name=Wang&shipping_last_name=Xiaodong&address_shipping=Manama&state_shipping=null&city_shipping=Manama&postal_code_shipping=1234&country_shipping=BHR&msg_lang=English&cms_with_version=1.0.0.1";
        String aa = "https://www.paytabs.com/apiv2/create_pay_page?merchant_emailxiaodong.wang@42pay.com&secret_key=ii5Ol0hgoEAyIB7bFW5v0y0dhDWn5Quo8zctzuKY8kwQWE2CA77BF8PXLMlRCPfLpsfYW0W4ltVh7XTI51jL99IVW4MyU2kjuzir&site_url=https://www.topay.ae&return_url=https://www.topay.ae/return&title=null&cc_first_name=Wang&cc_last_name=Xiaodong&cc_phone_number=00971&phone_number=0585668981&email=xiaodong.wang@42pay.com&products_per_title=MobilePhone%20||%20Charger%20||%20Camera&unit_price=12.123%20||%2021.345%20||%2035.678&quantity=2%20||%203%20||%201&other_charges=null&amount=58.01&discount=58.01&currency=CNY&reference_no=null&ip_customer=192.168.1.1&ip_merchant=192.168.1.1&billing_address=Flat%203021%20Manama%20Bahrain&city=Manama&state=Manama&postal_code=12345&country=BHR&shipping_first_name=Wang&shipping_last_name=Xiaodong&address_shipping=Manama&state_shipping=null&city_shipping=Manama&postal_code_shipping=1234&country_shipping=BHR&msg_lang=English&cms_with_version=1.0.0.1";
        String substring = aa.substring(aa.length() - 426, aa.length());
        System.out.println(substring);
    }
}
